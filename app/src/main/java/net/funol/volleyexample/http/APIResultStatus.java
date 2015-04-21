package net.funol.volleyexample.http;

public class APIResultStatus {

    /** 0 失败（可能网络问题，暂时无相关数据) **/
    public static final int FAILD = 0;
    /** 1 成功（登陆成功，有相关数据等） **/
    public static final int SUCCESS = 1;
    /** 2 cookie失效，需要用户重新登录 **/
    public static final int NEED_LOGIN = 2;

}
