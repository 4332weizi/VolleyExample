package net.funol.volleyexample.util;

import android.content.Context;
import android.os.Build;
import android.widget.Toast;


import net.funol.util.L;
import net.funol.volleyexample.R;
import net.funol.volleyexample.widget.TipsToast;

public class ToastUtil {
    public static final int TOAST_SUCESS = 0;
    public static final int TOAST_WARING = 1;
    public static final int TOAST_FELIA = 2;
    public static final int TOAST_SMILE = 3;
    private static TipsToast tipsToast;

    /**
     * 显示toast
     *
     * @param context
     * @param text
     */
    public static void show(Context context, String text) {
        if (context != null && text != null) {
            try {
                Toast.makeText(context, text, Toast.LENGTH_LONG).show();
            } catch (NullPointerException e) {
                L.e("toast内容为空");
            }
        }

    }

    /**
     * 自定义toast
     *
     * @param iconType 类型(TOAST_SUCESS = 0;(成功) TOAST_WARING = 1(警告); TOAST_FELIA =
     *                 2(失败); TOAST_SMILE=3;(微笑))
     * @param tips     提示文字
     * @param tips
     */
    public static void showTips(Context context, int iconType, String tips) {
        if (context != null && tips != null) {

            if (tipsToast != null) {
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
                    tipsToast.cancel();
                }
            } else {
                tipsToast = TipsToast.makeText(context, tips,
                        TipsToast.LENGTH_SHORT);
            }
            tipsToast.show();
            switch (iconType) {
                case TOAST_SUCESS:
                    tipsToast.setIcon(R.drawable.ic_tips_success);
                    break;
                case TOAST_SMILE:
                    tipsToast.setIcon(R.drawable.ic_tips_smile);
                    break;
                case TOAST_WARING:
                    tipsToast.setIcon(R.drawable.ic_tips_warning);
                    break;
                case TOAST_FELIA:
                    tipsToast.setIcon(R.drawable.ic_tips_error);
                    break;
                default:
                    break;
            }

            tipsToast.setText(tips);
        }
    }
}
