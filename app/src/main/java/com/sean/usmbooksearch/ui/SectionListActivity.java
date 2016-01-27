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
import com.sean.usmbooksearch.adapters.SectionAdapterHolder;
import com.sean.usmbooksearch.model.USM.Section;
import com.sean.usmbooksearch.model.USM.Sections;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;

public class SectionListActivity extends Activity {

    private static final String TAG = SectionListActivity.class.getSimpleName();
    private List<Section> sectionList;

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
            String courseCode = (String) b.get("course_code");
            String listOfSectionBaseURL = "https://secure3.sequoiars.com/ePOS?form=shared3/textbooks/json/json_sections.html&term=SP16&store=408";
            courseListURL = listOfSectionBaseURL + "&department=" + deptCode + "&course=" + courseCode;
            mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

            progressBar = (ProgressBar) findViewById(R.id.progress_bar);
            progressBar.setVisibility(View.VISIBLE);

            new AsyncHttpTask().execute(courseListURL, deptCode, courseCode);
        }
    }


    public class AsyncHttpTask extends AsyncTask<String, Void, Integer>{
        @Override
        protected Integer doInBackground(String... params) {
            String courseListURL = params[0];
            String deptCode = params[1];
            String courseCode = params[2];

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
                        Sections sections = mapper.readValue(respone.body().charStream(), Sections.class);
                        //Removes "Zlast" from the list.
                        sections.getSections().remove(sections.getSections().size() - 1);
                        sectionList = removeBlankItem(sections.getSections(), deptCode, courseCode);
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
                SectionAdapterHolder adapter = new SectionAdapterHolder(SectionListActivity.this, sectionList);
                mRecyclerView.setAdapter(adapter);
                adapter.SetOnItemClickListener(new SectionAdapterHolder.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                    }
                });
            }else{
                Toast.makeText(SectionListActivity.this, "Failed to fetch section list!", Toast.LENGTH_SHORT).show();
            }

        }
    }

    private List<Section> removeBlankItem(List<Section> sections, String deptCode, String courseCode) {

        for (int i = 0; i < sections.size(); i++){
            if (sections.get(i).getCode().isEmpty()){
                sections.remove(i);
            }else{
                sections.get(i).setDeptCode(deptCode);
                sections.get(i).setCourseCode(courseCode);
            }
        }
        return sections;
    }


}
