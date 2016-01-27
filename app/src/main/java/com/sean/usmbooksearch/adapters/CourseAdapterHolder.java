package com.sean.usmbooksearch.adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sean.usmbooksearch.R;
import com.sean.usmbooksearch.model.USM.CourseCode;
import com.sean.usmbooksearch.ui.CourseListActivity;
import com.sean.usmbooksearch.ui.SectionListActivity;

import java.util.List;

public class CourseAdapterHolder extends RecyclerView.Adapter<CourseAdapterHolder.ViewHolder> {

    private final List<CourseCode> courseCodeList;
    OnItemClickListener mItemClickListener;

    public CourseAdapterHolder(CourseListActivity mActivity, List<CourseCode> courseCodeList){
        this.courseCodeList = courseCodeList;

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent , int viewType) {
        final LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        final View sView = mInflater.inflate(R.layout.list_row, parent, false);
        return new ViewHolder(sView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder , int position) {
        holder.departmentName.setText(courseCodeList.get(position).getDeptCode() + " " + courseCodeList.get(position).getCode());
    }

    @Override
    public int getItemCount() {
        return courseCodeList.size();
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
                Intent intent = new Intent(v.getContext(),SectionListActivity.class);
                intent.putExtra("dept_code", courseCodeList.get(i).getDeptCode());
                intent.putExtra("course_code", courseCodeList.get(i).getCode());
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
