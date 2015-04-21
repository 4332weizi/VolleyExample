package net.funol.volleyexample.http;

import android.os.Bundle;
import android.os.Message;

import com.android.volley.Response;
import com.android.volley.VolleyError;

/**
 * Created by 赵尉尉 on 2015/4/18.
 */
public class APIErrorListener implements Response.ErrorListener {

    private String url;
    private APIRequestHandler handler;

    public APIErrorListener(String url, APIRequestHandler handler) {
        this.url = url;
        this.handler = handler;
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        error.printStackTrace();
        Message msg = handler.obtainMessage();
        msg.what = 1;
        Bundle b = new Bundle();
        b.putString("result-key", APIResultQueue.putResult(url, error));
        msg.setData(b);
        handler.sendMessage(msg);
    }

}
