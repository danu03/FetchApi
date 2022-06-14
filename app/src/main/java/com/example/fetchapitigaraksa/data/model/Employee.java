package com.example.fetchapitigaraksa.data.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Employee{

    @SerializedName("Employee")
    private List<EmployeeItem> employee;

    public List<EmployeeItem> getEmployee(){
        return employee;
    }
}