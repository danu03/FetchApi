package com.example.fetchapitigaraksa.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.fetchapitigaraksa.data.model.EmployeeItem;
import com.example.fetchapitigaraksa.repository.MainRepository;

import java.util.ArrayList;
import java.util.List;

public class InputEmployeeViewModel extends AndroidViewModel {
    private MainRepository mainRepository;
    private LiveData<String> employeeLiveData;

    public InputEmployeeViewModel(@NonNull Application application) {
        super(application);
    }

    public void init() {
        mainRepository = new MainRepository();
        employeeLiveData = mainRepository.InputEmployeeLiveData();
    }

    public void inputEmployee(ArrayList<EmployeeItem> employeeItems) {
        mainRepository.inputEmployee(employeeItems);
    }

    public LiveData<String> inputEmployee() {
        return employeeLiveData;
    }
}
