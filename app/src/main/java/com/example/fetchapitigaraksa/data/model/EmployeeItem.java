package com.example.fetchapitigaraksa.data.model;

import com.google.gson.annotations.SerializedName;

public class EmployeeItem extends Employee {

    @SerializedName("nik")
    private int nik;

    @SerializedName("last_name")
    private String lastName;

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("aktif")
    private boolean aktif;

    @SerializedName("alamat")
    private String alamat;

    public EmployeeItem(Integer nik, String firstName, String lastName, String alamat, boolean aktif) {
        this.nik = nik;
        this.firstName = firstName;
        this.lastName = lastName;
        this.alamat = alamat;
        this.aktif = aktif;
    }

    public void setNik(int nik){
        this.nik = nik;
    }

    public int getNik(){
        return nik;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setAktif(boolean aktif){
        this.aktif = aktif;
    }

    public boolean isAktif(){
        return aktif;
    }

    public void setAlamat(String alamat){
        this.alamat = alamat;
    }

    public String getAlamat(){
        return alamat;
    }
}