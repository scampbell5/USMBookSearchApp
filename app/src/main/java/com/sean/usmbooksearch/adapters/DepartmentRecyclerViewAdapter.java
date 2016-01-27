package com.sean.usmbooksearch.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sean.usmbooksearch.R;
import com.sean.usmbooksearch.model.USM.Dept;

import java.util.List;

public class DepartmentRecyclerViewAdapter extends RecyclerView.Adapter<DepartmentListRowHolder> {

    private final List<Dept> departmentList;
    private final Context context;

    public DepartmentRecyclerViewAdapter(Context context, List<Dept> departmentList){
        this.departmentList = departmentList;
        this.context = context;
    }

    @Override
    public DepartmentListRowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);
        return new DepartmentListRowHolder(view, context);
    }

    @Override
    public void onBindViewHolder(DepartmentListRowHolder holder, int position) {
        Dept currentDept = departmentList.get(position);
        holder.departmentTitle.setText(currentDept.getName());

    }

    @Override
    public int getItemCount() {
        return (null != departmentList ? departmentList.size() : 0);
    }


}
