package com.erraticsolutions.sample.postboy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.erraticsolutions.postboy.Postboy;
import com.erraticsolutions.postboy.PostboyException;
import com.erraticsolutions.postboy.PostboyHeaders;
import com.erraticsolutions.postboy.PostboyListener;
import com.erraticsolutions.postboy.RequestType;

public class MainActivity extends AppCompatActivity implements PostboyListener {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Postboy postboy  = new Postboy.Builder(this,RequestType.DELETE_FORM_DATA,"https://jsonplaceholder.typicode.com/posts/1")
                .create();
        postboy.setListener(this);
        postboy.addGETValue("name","postboy");
        postboy.addPOSTValue("age","1");
        postboy.addHeader(PostboyHeaders.KEY_AUTHORIZATION,"bearer: 13546");
        postboy.call();

    }

    @Override
    public void onPostboyConnecting() throws PostboyException {
        Log.e(TAG,"onPostboyConnecting");
    }

    @Override
    public void onPostboyAsyncConnected(String json, int responseCode) throws PostboyException {
        Log.e(TAG,"onPostboyAsyncConnected: " + responseCode+ " || " + json);
    }

    @Override
    public void onPostboyConnected(String json, int responseCode) throws PostboyException {
        Log.e(TAG,"onPostboyConnected: " + responseCode+ " || " + json);
    }

    @Override
    public void onPostboyConnectionFailure() throws PostboyException {
        Log.e(TAG,"onPostboyConnectionFailure");
    }

    @Override
    public void onPostboyError(PostboyException e) {
        Log.e(TAG,"onPostboyError: " + e.toString());
    }
}
