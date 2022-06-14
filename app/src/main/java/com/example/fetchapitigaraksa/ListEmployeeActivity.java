package com.example.fetchapitigaraksa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.example.fetchapitigaraksa.adapter.EmployeeAdapter;
import com.example.fetchapitigaraksa.data.api.ApiClient;
import com.example.fetchapitigaraksa.data.api.ApiInterface;
import com.example.fetchapitigaraksa.data.model.ValuesItem;
import com.example.fetchapitigaraksa.viewmodel.ListEmployeeViewModel;
import java.util.List;


public class ListEmployeeActivity extends AppCompatActivity {

    private ListEmployeeViewModel viewModel;

    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static ListEmployeeActivity listEmployee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_employee);

        viewModel = new ViewModelProvider(this, getDefaultViewModelProviderFactory()).get(ListEmployeeViewModel.class);
        viewModel.init();
        viewModel.getEmployeeList();

        mRecyclerView = (RecyclerView) findViewById(R.id.rvEmployee);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        listEmployee=this;
        refresh();
    }

    public void refresh() {
        viewModel.getEmployeeLiveData().observe(this, new Observer<List<ValuesItem>>() {
            @Override
            public void onChanged(List<ValuesItem> valuesItems) {
                if (valuesItems != null) {
                    mAdapter = new EmployeeAdapter(valuesItems);
                    mRecyclerView.setAdapter(mAdapter);
                }
            }
        });
    }
}