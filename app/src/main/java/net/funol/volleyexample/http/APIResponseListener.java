package net.funol.volleyexample.http;

import android.os.Bundle;
import android.os.Message;

import com.android.volley.Response;

/**
 * Created by 赵尉尉 on 2015/4/18.
 */
public class APIResponseListener implements Response.Listener<APIResult> {

    private String url;
    private APIRequestHandler handler;

    public APIResponseListener(String url, APIRequestHandler handler) {
        this.url = url;
        this.handler = handler;
    }

    @Override
    public void onResponse(APIResult response) {
        Message msg = handler.obtainMessage();
        msg.what = 0;
        Bundle b = new Bundle();
        b.putString("result-key", APIResultQueue.putResult(url, response));
        msg.setData(b);
        handler.sendMessage(msg);
    }
}