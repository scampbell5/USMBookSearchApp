package com.sean.usmbooksearch.adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sean.usmbooksearch.R;
import com.sean.usmbooksearch.model.USM.Section;
import com.sean.usmbooksearch.ui.BookListActivity;
import com.sean.usmbooksearch.ui.SectionListActivity;

import java.util.List;

public class SectionAdapterHolder extends RecyclerView.Adapter<SectionAdapterHolder.ViewHolder> {

    private final List<Section> sectionList;
    OnItemClickListener mItemClickListener;

    public SectionAdapterHolder(SectionListActivity mActivity, List<Section> sectionList){
        this.sectionList = sectionList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent , int viewType) {
        final LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        final View sView = mInflater.inflate(R.layout.list_row, parent, false);
        return new ViewHolder(sView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder , int position) {
        holder.departmentName.setText(sectionList.get(position).getInstructor());
    }

    @Override
    public int getItemCount() {
        return sectionList.size();
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
                Intent intent = new Intent(v.getContext(),BookListActivity.class);
                intent.putExtra("section_code", sectionList.get(i).getCode());
                intent.putExtra("dept_code", sectionList.get(i).getDeptCode());
                intent.putExtra("course_code", sectionList.get(i).getCourseCode());

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
