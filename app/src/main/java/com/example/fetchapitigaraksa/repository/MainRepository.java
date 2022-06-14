package com.example.fetchapitigaraksa.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.fetchapitigaraksa.data.api.ApiClient;
import com.example.fetchapitigaraksa.data.api.ApiInterface;
import com.example.fetchapitigaraksa.data.model.EmployeeItem;
import com.example.fetchapitigaraksa.data.model.EmployeeResponse;
import com.example.fetchapitigaraksa.data.model.ValuesItem;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepository {
    public ApiInterface mApiInterface;
    private final MutableLiveData<List<ValuesItem>> employeeLiveData;
    private final MutableLiveData<String> inputEmployee;

    public MainRepository() {
        inputEmployee = new MutableLiveData<>();
        employeeLiveData = new MutableLiveData<>();
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
    }



    public void getEmployee() {
        mApiInterface.getEmployee().enqueue(new Callback<EmployeeResponse>() {
            @Override
            public void onResponse(Call<EmployeeResponse> call, Response<EmployeeResponse> response) {
                if (response.body() != null) {
                    employeeLiveData.postValue(response.body().getValues());
                }
            }

            @Override
            public void onFailure(Call<EmployeeResponse> call, Throwable t) {
                employeeLiveData.postValue(null);
            }
        });
    }

    public void inputEmployee(ArrayList<EmployeeItem> employeeItems) {
        mApiInterface.postEmployee(employeeItems).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    inputEmployee.postValue("Data Karyawan Berhasil Ditambahkan");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    public LiveData<List<ValuesItem>> getEmployeeLiveData() {
        return employeeLiveData;
    }

    public LiveData<String> InputEmployeeLiveData() {
        return inputEmployee;
    }

}
