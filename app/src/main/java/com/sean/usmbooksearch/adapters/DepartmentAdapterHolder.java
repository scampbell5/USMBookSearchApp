package com.sean.usmbooksearch.adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sean.usmbooksearch.R;
import com.sean.usmbooksearch.model.USM.Dept;
import com.sean.usmbooksearch.ui.CourseListActivity;
import com.sean.usmbooksearch.ui.DepartmentListActivity;

import java.util.List;

public class DepartmentAdapterHolder extends RecyclerView.Adapter<DepartmentAdapterHolder.ViewHolder> {

    private final List<Dept> departmentList;
    OnItemClickListener mItemClickListener;

    public DepartmentAdapterHolder(DepartmentListActivity mActivity, List<Dept> departmentList){
        this.departmentList = departmentList;

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent , int viewType) {
        final LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        final View sView = mInflater.inflate(R.layout.list_row, parent, false);
        return new ViewHolder(sView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder , int position) {
        holder.departmentName.setText(departmentList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return departmentList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        final TextView departmentName;

        public ViewHolder(View view) {
            super(view);
            departmentName = (TextView) view.findViewById(R.id.departmentName);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                int i = getPosition();
                Intent intent = new Intent(v.getContext(),CourseListActivity.class);
                intent.putExtra("dept_code", departmentList.get(i).getCode());
                v.getContext().startActivity(intent);
            }
        }

    }


    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

}
