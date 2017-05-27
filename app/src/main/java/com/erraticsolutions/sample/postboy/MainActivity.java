package com.erraticsolutions.sample.postboy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.erraticsolutions.postboy.PostBoy;
import com.erraticsolutions.postboy.PostBoyException;
import com.erraticsolutions.postboy.PostBoyHeaders;
import com.erraticsolutions.postboy.PostBoyListener;
import com.erraticsolutions.postboy.RequestType;

public class MainActivity extends AppCompatActivity implements PostBoyListener {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PostBoy postBoy = new PostBoy.Builder(this,RequestType.DELETE_FORM_DATA,"https://jsonplaceholder.typicode.com/posts/1")
                .create();
        postBoy.setListener(this);
        postBoy.addGETValue("name","postBoy");
        postBoy.addPOSTValue("age","1");
        postBoy.addHeader(PostBoyHeaders.KEY_AUTHORIZATION,"bearer: 13546");
        postBoy.call();

    }

    @Override
    public void onPostBoyConnecting() throws PostBoyException {
        Log.e(TAG,"onPostBoyConnecting");
    }

    @Override
    public void onPostBoyAsyncConnected(String json, int responseCode) throws PostBoyException {
        Log.e(TAG,"onPostBoyAsyncConnected: " + responseCode+ " || " + json);
    }

    @Override
    public void onPostBoyConnected(String json, int responseCode) throws PostBoyException {
        Log.e(TAG,"onPostBoyConnected: " + responseCode+ " || " + json);
    }

    @Override
    public void onPostBoyConnectionFailure() throws PostBoyException {
        Log.e(TAG,"onPostBoyConnectionFailure");
    }

    @Override
    public void onPostBoyError(PostBoyException e) {
        Log.e(TAG,"onPostBoyError: " + e.toString());
    }
}
