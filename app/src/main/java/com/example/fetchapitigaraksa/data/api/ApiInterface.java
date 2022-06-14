package com.example.fetchapitigaraksa.data.api;

import com.example.fetchapitigaraksa.data.model.Employee;
import com.example.fetchapitigaraksa.data.model.EmployeeItem;
import com.example.fetchapitigaraksa.data.model.EmployeeResponse;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @GET("api/karyawan/all")
    Call<EmployeeResponse> getEmployee();

    @POST("karyawan/insert")
    Call<ResponseBody> postEmployee(@Body List<EmployeeItem> employee);
}
