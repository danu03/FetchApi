package com.example.fetchapitigaraksa.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fetchapitigaraksa.R;
import com.example.fetchapitigaraksa.data.model.ValuesItem;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.MyViewHolder>{
    private final List<ValuesItem> employeeList;

    public EmployeeAdapter(List<ValuesItem> employeeList) {
        this.employeeList = employeeList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_employee, parent, false);
        return new MyViewHolder(mView);
    }

    @Override
    public void onBindViewHolder (MyViewHolder holder,final int position){
        holder.mTextViewId.setText(Integer.toString(employeeList.get(position).getNik()));
        holder.mTextViewName.setText(employeeList.get(position).getFirstName() + " " + employeeList.get(position).getLastName());
        holder.mTextViewAddress.setText(employeeList.get(position).getAlamat());
    }

    @Override
    public int getItemCount () {
        return employeeList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewId, mTextViewName, mTextViewAddress;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewId = (TextView) itemView.findViewById(R.id.tvNik);
            mTextViewName = (TextView) itemView.findViewById(R.id.tvName);
            mTextViewAddress = (TextView) itemView.findViewById(R.id.tvAddress);
        }
    }
}