package com.sean.usmbooksearch.ui;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sean.usmbooksearch.R;
import com.sean.usmbooksearch.adapters.DepartmentAdapterHolder;
import com.sean.usmbooksearch.model.USM.Departments;
import com.sean.usmbooksearch.model.USM.Dept;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;

public class DepartmentListActivity extends Activity {

    private static final String TAG = DepartmentListActivity.class.getSimpleName();
    private List<Dept> departmentList;

    private RecyclerView mRecyclerView;
    private ProgressBar progressBar;
    private final String listOfDepartmentURL = "https://secure3.sequoiars.com/ePOS?form=shared3/textbooks/json/json_depts.html&term=SP16&deptSort=ACDEPT_CODE&store=408";


    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department_list);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);

        new AsyncHttpTask().execute(listOfDepartmentURL);
    }


    public class AsyncHttpTask extends AsyncTask<String, Void, Integer>{


        @Override
        protected Integer doInBackground(String... params) {
            Integer result = 0;
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url(listOfDepartmentURL)
                    .build();
            try {
                Response respone = client.newCall(request).execute();

                if (respone.code() == HttpURLConnection.HTTP_OK){
                    ObjectMapper mapper = new ObjectMapper();
                    Departments depts = mapper.readValue(respone.body().charStream(), Departments.class);
                    //Removes "Zlast" from the list.
                    depts.getDepts().remove(depts.getDepts().size() -1);
                    departmentList = removeBlankItem(depts.getDepts());
                    result = 1; //success;
                }

            } catch (IOException e) {
                Log.e(TAG, "An unexpected error has occured: " + e.getLocalizedMessage());
                result = 0; //failed
            }
            return result;
        }

        @Override
        protected void onPostExecute(Integer result){
            progressBar.setVisibility(View.GONE);

            //If successful, load the adapter, otherwise display an error message to user.
            if (result == 1){
                DepartmentAdapterHolder adapter = new DepartmentAdapterHolder(DepartmentListActivity.this, departmentList);
                mRecyclerView.setAdapter(adapter);
                adapter.SetOnItemClickListener(new DepartmentAdapterHolder.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                    }
                });
            }else{
                Toast.makeText(DepartmentListActivity.this, "Failed to fetch department list!", Toast.LENGTH_SHORT).show();
            }

        }
    }

    private List<Dept> removeBlankItem(List<Dept> depts) {

        for (int i = 0; i < depts.size(); i++){
            if (depts.get(i).getName().isEmpty()){
                depts.remove(i);
            }
        }
        return depts;
    }


}
