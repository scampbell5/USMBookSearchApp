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
import com.sean.usmbooksearch.adapters.BookAdapterHolder;
import com.sean.usmbooksearch.model.Amazon.AMZSignedURL;
import com.sean.usmbooksearch.model.Amazon.AmazonXmlParser;
import com.sean.usmbooksearch.model.BookInfo;
import com.sean.usmbooksearch.model.USM.USMBookInfo;
import com.sean.usmbooksearch.model.USM.Courses;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

public class BookListActivity extends Activity {

    private static final String TAG = BookListActivity.class.getSimpleName();
    private List<USMBookInfo> USMBookInfoList;
    private final List<BookInfo> bookList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department_list);
        String courseInfoListURL;

        Intent inIntent = getIntent();
        Bundle b = inIntent.getExtras();

        if (b != null){
            String deptCode = (String) b.get("dept_code");
            String courseCode = (String) b.get("course_code");
            String sectionCode = (String) b.get("section_code");
            String listOfCourseInfoURL = "https://secure3.sequoiars.com/ePOS?form=shared3/textbooks/json/json_books.html&term=SP16&store=408&dti=YES&desc=YES&bSug=YES&cSug=YES&H=N";
            courseInfoListURL = listOfCourseInfoURL + "&dept=" + deptCode + "&crs=" + courseCode + "&sec=" + sectionCode;
            mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

            progressBar = (ProgressBar) findViewById(R.id.progress_bar);
            progressBar.setVisibility(View.VISIBLE);

            new AsyncHttpTask().execute(courseInfoListURL);
        }
    }


    public class AsyncHttpTask extends AsyncTask<String, Void, Integer>{

        @Override
        protected Integer doInBackground(String... params) {
            String courseInfoListURL = params[0];

            if (!courseInfoListURL.isEmpty()) {
                Integer result = 0;
                OkHttpClient client = new OkHttpClient();

                Request request = new Request.Builder()
                        .url(courseInfoListURL)
                        .build();
                try {
                    Response respone = client.newCall(request).execute();

                    if (respone.code() == HttpURLConnection.HTTP_OK) {
                        ObjectMapper mapper = new ObjectMapper();
                        Courses fullCourseInfo = mapper.readValue(respone.body().charStream(), Courses.class);
                        USMBookInfoList = fullCourseInfo.getCourse().getUSMBookInfos();

                        result = 1; //success;
                        if (USMBookInfoList.size() == 1 && USMBookInfoList.get(0).getTitle().equals("No Books Found")){
                            USMBookInfoList.remove(0);
                            result = 0;
                        }

                        getAmazonBookInfo(USMBookInfoList);

                        return result;

                    }

                } catch (IOException e) {
                    Log.e(TAG, "An unexpected error has occured: " + e.getLocalizedMessage());
                    result = 0; //failed
                }
                return result;
            }
            return 0;
        }

        private void getAmazonBookInfo(List<USMBookInfo> usmBookInfoList) {
            for (USMBookInfo currentUSMBookInfo : USMBookInfoList) {
                String amzBookInfoURL = new AMZSignedURL(currentUSMBookInfo.getIsbn()).getRequestURL();
                AmazonXmlParser amzParser = new AmazonXmlParser();

                OkHttpClient client = new OkHttpClient();

                Request request = new Request.Builder()
                        .url(amzBookInfoURL)
                        .build();

                try{
                    Response response = client.newCall(request).execute();
                    if (response.code() == HttpURLConnection.HTTP_OK){
                        AmazonXmlParser.AmazonBookInfo amzResponseInfo = amzParser.parse(response.body().byteStream());

                        String USMUsed = currentUSMBookInfo.getUsedPrice();
                        String USMNew = currentUSMBookInfo.getNewPrice();
                        String title = currentUSMBookInfo.getTitle();

                        if (amzResponseInfo != null){
                            bookList.add(new BookInfo(title, USMNew, USMUsed,
                                    amzResponseInfo.getNewPrice(), amzResponseInfo.getUsedPrice(), currentUSMBookInfo.getIsbn(), amzResponseInfo.getThumbnailURL(), amzResponseInfo.getAffiliateURL(),
                                    amzResponseInfo.getAuthors()));
                        }else{
                            List<String> tempAuthorList = new ArrayList<>();
                            tempAuthorList.add(currentUSMBookInfo.getAuthor());
                            bookList.add(new BookInfo(title, USMNew, USMUsed, "N/A", "N/A", currentUSMBookInfo.getIsbn(), null, null, tempAuthorList));
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                }
            }


        }

        @Override
        protected void onPostExecute(Integer result){
            progressBar.setVisibility(View.GONE);

            //If successful, load the adapter, otherwise display an error message to user.
            if (result == 1){
                BookAdapterHolder adapter = new BookAdapterHolder(BookListActivity.this, bookList);
                mRecyclerView.setAdapter(adapter);
                adapter.SetOnItemClickListener(new BookAdapterHolder.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                    }
                });
            }else{
                Toast.makeText(BookListActivity.this, "No books found for your course.", Toast.LENGTH_LONG).show();
                finish();
            }

        }
    }


}
