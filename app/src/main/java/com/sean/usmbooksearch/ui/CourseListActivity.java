package com.sean.usmbooksearch.ui;

import android.app.Activity;
import android.content.Intent;
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
import com.sean.usmbooksearch.adapters.CourseAdapterHolder;
import com.sean.usmbooksearch.model.USM.CourseCode;
import com.sean.usmbooksearch.model.USM.CourseCodes;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;

public class CourseListActivity extends Activity {

    private static final String TAG = CourseListActivity.class.getSimpleName();
    private List<CourseCode> courseCodeList;

    private RecyclerView mRecyclerView;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department_list);
        String courseListURL;

        Intent inIntent = getIntent();
        Bundle b = inIntent.getExtras();

        if (b != null){
            String deptCode = (String) b.get("dept_code");
            String listOfCoursesBaseURL = "https://secure3.sequoiars.com/ePOS?form=shared3/textbooks/json/json_courses.html&term=SP16&store=408";
            courseListURL = listOfCoursesBaseURL + "&department=" + deptCode;
            mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

            progressBar = (ProgressBar) findViewById(R.id.progress_bar);
            progressBar.setVisibility(View.VISIBLE);

            new AsyncHttpTask().execute(courseListURL, deptCode );
        }
    }


    public class AsyncHttpTask extends AsyncTask<String, Void, Integer>{
        @Override
        protected Integer doInBackground(String... params) {
            String courseListURL = params[0];
            String deptCode = params[1];
            if (!courseListURL.isEmpty()) {
                Integer result = 0;
                OkHttpClient client = new OkHttpClient();

                Request request = new Request.Builder()
                        .url(courseListURL)
                        .build();
                try {
                    Response respone = client.newCall(request).execute();

                    if (respone.code() == HttpURLConnection.HTTP_OK) {
                        ObjectMapper mapper = new ObjectMapper();
                        CourseCodes courses = mapper.readValue(respone.body().charStream(), CourseCodes.class);
                        //Removes "Zlast" from the list.
                        courses.getCourseCodes().remove(courses.getCourseCodes().size() - 1);
                        courseCodeList = removeBlankItem(courses.getCourseCodes(), deptCode);
                        result = 1; //success;
                    }

                } catch (IOException e) {
                    Log.e(TAG, "An unexpected error has occured: " + e.getLocalizedMessage());
                    result = 0; //failed
                }
                return result;
            }
            return 0;
        }

        @Override
        protected void onPostExecute(Integer result){
            progressBar.setVisibility(View.GONE);

            //If successful, load the adapter, otherwise display an error message to user.
            if (result == 1){
                CourseAdapterHolder adapter = new CourseAdapterHolder(CourseListActivity.this, courseCodeList);
                mRecyclerView.setAdapter(adapter);
                adapter.SetOnItemClickListener(new CourseAdapterHolder.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                    }
                });
            }else{
                Toast.makeText(CourseListActivity.this, "Failed to fetch course list!", Toast.LENGTH_SHORT).show();
            }

        }
    }

    private List<CourseCode> removeBlankItem(List<CourseCode> courseCodes, String deptCode) {

        for (int i = 0; i < courseCodes.size(); i++){
            if (courseCodes.get(i).getCode().isEmpty()){
                courseCodes.remove(i);
            }else{
                courseCodes.get(i).setDeptCode(deptCode);
            }
        }
        return courseCodes;
    }


}
