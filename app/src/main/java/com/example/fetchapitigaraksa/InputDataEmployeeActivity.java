package com.example.fetchapitigaraksa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.fetchapitigaraksa.data.api.ApiClient;
import com.example.fetchapitigaraksa.data.api.ApiInterface;
import com.example.fetchapitigaraksa.data.model.EmployeeItem;
import com.example.fetchapitigaraksa.viewmodel.InputEmployeeViewModel;
import com.example.fetchapitigaraksa.viewmodel.ListEmployeeViewModel;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Objects;

public class InputDataEmployeeActivity extends AppCompatActivity {

    private InputEmployeeViewModel viewModel;

    TextInputLayout mNik, mFirstName, mLastName, mAddress;
    TextInputEditText mEdtNik, mEdtFirstName, mEdtLastName, mEdtAddress;
    RadioButton mActive, mNotActive;
    Button mBtnProcess;
    ApiInterface mApiInterface;
    ArrayList<EmployeeItem> employee = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data_employee);

        viewModel = new ViewModelProvider(this, getDefaultViewModelProviderFactory()).get(InputEmployeeViewModel.class);
        viewModel.init();

        mNik = findViewById(R.id.textInputNik);
        mFirstName = findViewById(R.id.textInputFirstName);
        mLastName = findViewById(R.id.textInputLastName);
        mAddress = findViewById(R.id.textInputAddress);
        mActive = findViewById(R.id.rb_active);
        mNotActive = findViewById(R.id.rb_not_active);
        mBtnProcess = findViewById(R.id.btnProcess);

        mEdtNik = findViewById(R.id.edtNik);
        mEdtFirstName = findViewById(R.id.edtFirstName);
        mEdtLastName = findViewById(R.id.edtLastName);
        mEdtAddress = findViewById(R.id.edtAddress);
        
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        setupListeners();

        mBtnProcess.setOnClickListener(view -> {
            if (isValidate()) {
                if (mActive.isChecked()) {
                    employee.add(new EmployeeItem(Integer.valueOf(mNik.getEditText().getText().toString()), mFirstName.getEditText().getText().toString(), Objects.requireNonNull(mLastName.getEditText()).getText().toString(), Objects.requireNonNull(mAddress.getEditText()).getText().toString(), true));
                } else if (mNotActive.isChecked()) {
                    employee.add(new EmployeeItem(Integer.valueOf(mNik.getEditText().getText().toString()), mFirstName.getEditText().getText().toString(), Objects.requireNonNull(mLastName.getEditText()).getText().toString(), Objects.requireNonNull(mAddress.getEditText()).getText().toString(), false));
                }
                viewModel.inputEmployee(employee);
            }
        });

        viewModel.inputEmployee().observe((LifecycleOwner) this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Intent implicit = new Intent(InputDataEmployeeActivity.this, ListEmployeeActivity.class);
                startActivity(implicit);
                finish();
            }
        });
    }

    private boolean isValidate() {
        return validateNik() && validateFirstName() && validateLastName() && validateAddress();
    }

    private void setupListeners() {
        mEdtNik.addTextChangedListener(new ValidationTextWatcher(mEdtNik));
        mEdtFirstName.addTextChangedListener(new ValidationTextWatcher(mEdtFirstName));
        mEdtLastName.addTextChangedListener(new ValidationTextWatcher(mEdtLastName));
        mEdtAddress.addTextChangedListener(new ValidationTextWatcher(mEdtAddress));
    }

    private boolean validateAddress() {
        if (mEdtAddress.getText().toString().trim().isEmpty()) {
            mAddress.setError("Required Field!");
            mEdtAddress.requestFocus();
            return false;
        } else {
            mAddress.setErrorEnabled(false);
        }
        return true;
    }

    private boolean validateLastName() {
        if (mEdtLastName.getText().toString().trim().isEmpty()) {
            mLastName.setError("Required Field!");
            mEdtLastName.requestFocus();
            return false;
        } else {
            mLastName.setErrorEnabled(false);
        }
        return true;
    }

    private boolean validateFirstName() {
        if (mEdtFirstName.getText().toString().trim().isEmpty()) {
            mFirstName.setError("Required Field!");
            mEdtFirstName.requestFocus();
            return false;
        } else {
            mFirstName.setErrorEnabled(false);
        }
        return true;
    }

    private boolean validateNik() {
        if (mEdtNik.getText().toString().trim().isEmpty()) {
            mNik.setError("Required Field!");
            mEdtNik.requestFocus();
            return false;
        } else {
            mNik.setErrorEnabled(false);
        }
        return true;
    }

    private class ValidationTextWatcher implements TextWatcher {
        private final View view;
        private ValidationTextWatcher(View view) {
            this.view = view;
        }
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }
        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.edtNik:
                    validateNik();
                    break;
                case R.id.edtFirstName:
                    validateFirstName();
                    break; 
                case R.id.edtLastName:
                    validateLastName();
                    break;
                case R.id.edtAddress:
                    validateAddress();
                    break;
            }
        }
    }
}