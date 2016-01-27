package com.sean.usmbooksearch.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.sean.usmbooksearch.R;

public class DepartmentListRowHolder extends RecyclerView.ViewHolder {

        protected final TextView departmentTitle;

    public DepartmentListRowHolder(View itemView, Context context) {
            super(itemView);
            this.departmentTitle = (TextView) itemView.findViewById(R.id.departmentName);
        }
}