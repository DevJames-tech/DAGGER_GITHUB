package com.example.week4day1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.week4day1.ConverteredJSON.JamesObjectification;
import com.example.week4day1.HttpURLConnection.HttpConnectionUrl;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "jamescal";
    private JamesObjectification myResponse;
    private JamesObjectification myResponse2;
    private JamesObjectification getMyImage;
    TextView viewthis;
    TextView viewthis2;
    ImageView viewImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewthis = findViewById(R.id.viewprofile);
        viewthis2 = findViewById(R.id.viewprofilepart2);
        viewImage = findViewById(R.id.imageHolder);

       // Log.d(TAG, "onCreate: hi");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Log.d(TAG, "run: hello again");
                    String jsonResult = HttpConnectionUrl.talkNiceToMe();

                    myResponse = new Gson().fromJson(jsonResult, JamesObjectification.class);
                    myResponse2 = new Gson().fromJson(jsonResult, JamesObjectification.class);
                    getMyImage = new Gson().fromJson(jsonResult, JamesObjectification.class);

                    Log.d("jamescalcdsjj", jsonResult);

                    myResponse.getItems().get(0).getLogin();
                    myResponse2.getItems().get(0).describeContents();
                    getMyImage.getItems().get(0).getAvatarUrl();

                    final String ParsedJson =  myResponse.getItems().get(0).getLogin();
                    final String ParsedJson2 = myResponse2.getItems().get(0).getFollowersUrl();
                    final String ParsedImage = getMyImage.getItems().get(0).getAvatarUrl();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            viewthis.setText(ParsedJson);
                            viewthis2.setText(ParsedJson2);
                        }
                    });

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        thread.start();

    }
}