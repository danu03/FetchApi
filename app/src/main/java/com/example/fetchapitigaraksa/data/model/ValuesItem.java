package com.example.fetchapitigaraksa.data.model;

import com.google.gson.annotations.SerializedName;

public class ValuesItem{

	@SerializedName("nik")
	private int nik;

	@SerializedName("first_name")
	private String firstName;

	@SerializedName("last_name")
	private String lastName;

	@SerializedName("alamat")
	private String alamat;

	@SerializedName("aktif")
	private boolean aktif;

	public ValuesItem(Integer nik, String firstName, String lastName, String alamat, boolean aktif) {
		this.nik = nik;
		this.firstName = firstName;
		this.lastName = lastName;
		this.alamat = alamat;
		this.aktif = aktif;
	}

	public int getNik(){
		return nik;
	}

	public String getLastName(){
		return lastName;
	}

	public String getFirstName(){
		return firstName;
	}

	public boolean isAktif(){
		return aktif;
	}

	public String getAlamat(){
		return alamat;
	}
}