package com.example.fetchapitigaraksa.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.fetchapitigaraksa.data.api.ApiInterface;
import com.example.fetchapitigaraksa.data.model.ValuesItem;
import com.example.fetchapitigaraksa.repository.MainRepository;

import java.util.List;

public class ListEmployeeViewModel extends AndroidViewModel {
    private MainRepository mainRepository;
    private LiveData<List<ValuesItem>> employeeLiveData;

    public ListEmployeeViewModel(@NonNull Application application) {
        super(application);
    }

    public void init() {
        mainRepository = new MainRepository();
        employeeLiveData = mainRepository.getEmployeeLiveData();
    }

    public void getEmployeeList() {
        mainRepository.getEmployee();
    }

    public LiveData<List<ValuesItem>> getEmployeeLiveData() {
        return employeeLiveData;
    }
}
