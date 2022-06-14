package com.example.fetchapitigaraksa.data.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class EmployeeResponse{

	@SerializedName("statuscode")
	private int statuscode;

	@SerializedName("values")
	private List<ValuesItem> values;

	@SerializedName("error")
	private boolean error;

	public int getStatuscode(){
		return statuscode;
	}

	public List<ValuesItem> getValues(){
		return values;
	}

	public boolean isError(){
		return error;
	}
}