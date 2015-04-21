package com.ejiaxiu.master.http;

import com.ejiaxiu.master.Constants;

public class API {

    /**
     * 登录
     */
    public static final String LOGIN = Constants.HOST + "/index.php?g=App&m=Login&a=dologin";
    /**
     * 更新地理位置
     */
    public static final String UPDATE_LOCATION = Constants.HOST + "/index.php?g=App&m=Center&a=updateLocation";
    /**
     * 更新工作状态
     */
    public static final String UPDATE_WORK_STATUS = Constants.HOST + "/index.php?g=App&m=Center&a=updateWorkstatus";
    /**
     * 查询提现账户接口
     */
    public static final String ACCOUNT_RECEIVABLES = Constants.HOST + "/index.php?g=App&m=Center&a=findMasterBank";
    /**
    * 提现申请接口
    */
    public static final String APPLY_CASH = Constants.HOST + "/index.php?g=App&m=Center&a=addCashApply";
    /**
     * 合作协议
     */
    public static final String AGREEMENT = Constants.HOST + "/index.php?g=App&m=Center&a=findAgreement";
    /**
     * 意见反馈接口
     */
    public static final String FEEDBACK = Constants.HOST + "/index.php?g=App&m=Center&a=advicePost";

    /**
     * 我的订单
     */
    public static final String ORDERS  = Constants.HOST +"/index.php?g=App&m=Center&a=orderList";

    /**
     *我的账户
     */
    public static final String MYINCOME =  Constants.HOST + "/index.php?g=App&m=Center&a=findMasterAccount";

    /**
     * 提现记录
     */
    public static final String CASHAPPLYLIST =  Constants.HOST +"/index.php?g=App&m=Center&a=cashApplyList";
    /**
     * 设备品牌接口
     */
    public static final String CATEGORY_BRAND = Constants.HOST + "/index.php?g=App&m=Device&a=findDeviceBrand";
    /**
     * 品牌接口
     */
    public static final String BRAND = Constants.HOST + "/index.php?g=App&m=Device&a=findBrand";
    /**
     * 机型接口
     */
    public static final String DEVICE = Constants.HOST + "/index.php?g=App&m=Device&a=findModel";
    /**
     * 保存师傅机型接口
     */
    public static final String DEVICE_SAVE = Constants.HOST + "/index.php?g=App&m=Device&a=setSkill";

}

