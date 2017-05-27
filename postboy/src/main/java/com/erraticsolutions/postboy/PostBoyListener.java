package com.erraticsolutions.postboy;


import android.support.annotation.UiThread;
import android.support.annotation.WorkerThread;

public interface PostBoyListener {
    /**
     * It is called when you start connection with server. It is called on UIThread
     * @throws PostBoyException  Handle exceptions instead of crashing application
     */
    @UiThread
    void onPostboyConnecting() throws PostBoyException;


    /**
     * It is called on Working tread when you get response from server. You can do time cosuming processing in that methods. Like parsing json and saving it to local database etc.
     * @param json Response from server
     * @param responseCode Response code from server
     * @throws PostBoyException Handle exceptions instead of crashing application
     */
    @WorkerThread
    void onPostboyAsyncConnected(String json, int responseCode) throws PostBoyException;

    /**
     * It is called on UIThread. It will be called after you are done with processing in  onPostboyAsyncConnected method.
     * @param json Response from server
     * @param responseCode Response code from server
     * @throws PostBoyException  Handle exceptions instead of crashing application
     */
    @UiThread
    void onPostboyConnected(String json, int responseCode) throws PostBoyException;

    /**
     * It is called when you connection with server is failed.
     * @throws PostBoyException Handle exceptions instead of crashing application
     */
    @UiThread
    void onPostboyConnectionFailure() throws PostBoyException;

    /**
     * It is called whenever any of the methods onPostboyConnecting,  onPostboyAsyncConnected, onPostboyConnected and onPostboyConnectionFailure throws exception.
     * @param e Exception thrown by any of these methods: onPostboyConnecting,  onPostboyAsyncConnected, onPostboyConnected and onPostboyConnectionFailure.
     */
    @UiThread
    void onPostboyError(PostBoyException e);
}
