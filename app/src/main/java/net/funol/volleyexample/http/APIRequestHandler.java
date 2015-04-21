package net.funol.volleyexample.http;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.android.volley.VolleyError;

import net.funol.volleyexample.util.ToastUtil;

public abstract class APIRequestHandler extends Handler {

    private Context context;

    public APIRequestHandler(Context context) {
        super();
        this.context = context;
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        String resultKey = msg.getData().getString("result-key");
        switch (msg.what) {
            case 0:
                APIResult result = (APIResult) APIResultQueue.getResult(resultKey);
                onSuccess(result);
                // 登录超时
                if (result.getStatus() == APIResultStatus.NEED_LOGIN) {
                    // 将登录记录设置为false
//                    AppApplication.getInstance().setLogined(false);
//                    AppApplication.getInstance().showLogin();
                }
                break;
            case 1:
                VolleyError error = (VolleyError) APIResultQueue.getResult(resultKey);
                onError(error);
                // 显示错误信息
                ToastUtil.showTips(context, ToastUtil.TOAST_FELIA, VolleyErrorHelper.getMessage(context, error));
                break;
            default:
                break;
        }
    }

    protected abstract void onSuccess(APIResult result);

    protected abstract void onError(VolleyError error);

}
