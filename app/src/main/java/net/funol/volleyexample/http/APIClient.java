package net.funol.volleyexample.http;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class APIClient {

    private static APIClient mInstance;
    private RequestQueue mRequestQueue;

    private APIClient(Context context) {
        mRequestQueue = Volley.newRequestQueue(context);
    }

    /**
     * 获取APIClient实例
     *
     * @param context 上下文
     * @return
     */
    public static APIClient getClient(Context context) {
        if (mInstance == null) {
            synchronized (APIClient.class) {
                if (mInstance == null) {
                    mInstance = new APIClient(context);
                }
            }
        }
        return mInstance;
    }

    /**
     * 发送不带有tag的post网络请求
     *
     * @param url     请求url
     * @param obj     发送的消息实体
     * @param handler 网络请求处理者
     */
    public void post(final String url, Object obj, final APIRequestHandler handler) {
        post(url, obj, new TypeToken<APIResult<String>>() {
        }.getType(), handler, null);
    }

    /**
     * 发送不带有tag的post网络请求
     *
     * @param url     请求url
     * @param obj     发送的消息实体
     * @param resultType 返回数据type
     * @param handler 网络请求处理者
     */
    public void post(final String url, Object obj, Type resultType, final APIRequestHandler handler) {
        post(url, obj, resultType, handler, null);
    }

    /**
     * 发送带有tag的post网络请求
     *
     * @param url     请求url
     * @param obj     发送的消息实体
     * @param handler 网络请求处理者
     * @param tag     该请求的tag
     */
    public void post(final String url, Object obj, final APIRequestHandler handler, Object tag) {
        post(url, obj, new TypeToken<APIResult<String>>() {
        }.getType(), handler, tag);
    }

    /**
     * 发送带有tag的post网络请求
     *
     * @param url     请求url
     * @param obj     发送的消息实体
     * @param resultType 返回数据类型
     * @param handler 网络请求处理者
     * @param tag     该请求的tag
     */
    public void post(final String url, Object obj, Type resultType, final APIRequestHandler handler, Object tag) {
        APIRequest request = new APIRequest(Request.Method.POST, url, obj, resultType,
                new APIResponseListener(url, handler),
                new APIErrorListener(url, handler));
        request.setTag(tag);
        mRequestQueue.add(request);
    }

    /**
     * 发送不带有tag的get网络请求
     *
     * @param url     请求url
     * @param obj     发送的消息实体
     * @param resultType 返回数据类型
     * @param handler 网络请求处理者
     */
    public void get(final String url, Object obj, Type resultType, final APIRequestHandler handler) {
        get(url, obj, resultType, handler, null);
    }

    /**
     * 发送不带有tag的get网络请求
     *
     * @param url     请求url
     * @param obj     发送的消息实体
     * @param handler 网络请求处理者
     */
    public void get(final String url, Object obj, final APIRequestHandler handler) {
        get(url, obj, new TypeToken<APIResult<String>>() {
        }.getType(), handler, null);
    }

    /**
     * 发送带有tag的get网络请求
     *
     * @param url     请求url
     * @param obj     发送的消息实体
     * @param resultType 返回的数据type
     * @param handler 网络请求处理者
     * @param tag     该请求的tag
     */
    public void get(final String url, Object obj, Type resultType, final APIRequestHandler handler, Object tag) {
        APIRequest<APIResult> request = new APIRequest(Request.Method.GET, url, obj, resultType,
                new APIResponseListener(url, handler),
                new APIErrorListener(url, handler));
        request.setTag(tag);
        mRequestQueue.add(request);
    }

    /**
     * 发送带有tag的get网络请求
     *
     * @param url     请求url
     * @param obj     发送的消息实体
     * @param handler 网络请求处理者
     * @param tag     该请求的tag
     */
    public void get(final String url, Object obj, final APIRequestHandler handler, Object tag) {
        get(url, obj, new TypeToken<APIResult<String>>() {
        }.getType(), handler, tag);
    }

    /**
     * 取消指定tag的网络请求
     *
     * @param tag
     */
    public void cancle(Object tag) {
        mRequestQueue.cancelAll(tag);
    }

}
