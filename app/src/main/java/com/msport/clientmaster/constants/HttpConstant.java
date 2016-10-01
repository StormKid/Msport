package com.msport.clientmaster.constants;

/**
 * Created by Administrator on 2016/7/1.
 */

public class HttpConstant {
        public final static String DOMAIN = "http://120.25.97.0:8089/msport-api-web/api/v1/";
//    public final static String DOMAIN = "http://192.168.0.101:8710/msport-api-web/api/v1/";
//    public static final String DOMAIN = "http://www.52wyd.com/msport-api-web/api/v1/";
//    public final static  String DOMAIN = "http://764abfe7.ngrok.natapp.cn/msport-api-web/api/v1/";

    /**
     * 获取热门课程
     */
    public final static String getHotEntity = "client/hotcourse";

    /**
     * 获取约球列表
     */
    public final static String getYueQiu = "client/inviteactive/{pageIndex}/list";

    /**
     * 获取约球详情
     */
    public final static String getYueQiuDetail = "client/inviteactive/detail/";


    /**
     * 添加约球
     */
    public final static String addYueQiu = "client/inviteactive/add";

    /**
     * 首页请求
     */
    public final static String home = "index";

    /**
     * 微信预支付
     */
    public final static String weiPropay = "wechat/getAppPrepayId/{billId}";

    /**
     * 微信支付
     */
    public final static String weipay = "wechat/appSign?";


    /**
     * 登陆
     */
    public static final String LOGIN_USER = "client/login?";


    /**
     * 参与约球
     */
    public static final String joinYueQiu = "client/inviteactive/attend/{memberId}/{invitationId},{number},{paymode}";

    /**
     * 查询课程详情
     */
    public static final String showCourseDetail = "client/coursedetail/{courseId}";

    /**
     * 查询所有评价标签列表
     */
    public static final String queryAllCourseList = "client/dic/list?";

    /**
     * 查看私教详情接口
     */
    public static final String coachDetail = "coach/private/detail/{coachId}";

    /**
     * 阿里支付
     */
    public static final String alipay = "alipay/create?";

    /**
     * 获得课程评论
     */
    public static final String courseReview =
            "client/course/clientcomment/{courseId},{pageIndex}";

    /**
     * 获得私教评论
     */
    public static final String coachReview = "coach/private/clientcomment/{coachId},{pageIndex}";


    /**
     * 查询比赛列表
     */
    public static final String queryBisaiList = "client/match/{pageIndex}/list";

    /**
     * 查询私教排序
     */
    public static final String categroyCoachList = "coach/private/{pageIndex}/?";

    /**
     * 查看课程类型
     */
    public static final String getCourseType = "client/course/coursetype/{parentId}";


    /**
     * 查看课程列表
     */
    public static final String getCourseLiset = "client/courselist/{pageIndex}/?";

    /**
     * 创建课程订单
     */
    public static final String createCourseOrder = "order/client/create/";

    /**
     * 获取私教时间
     */
    public static final String getCoahTime = "coach/private/schedule/{coachId}/";


    /**
     * 获取私教订单
     */
    public static final String createCoachOrder = "order/coach/private/create?";


    /**
     * 获取用户钱包
     */
    public static final String getQIANBAO = "order/client/wallet/{memberId}?";


    /**
     * 绑定钱包
     */
    public static final String bindQianbao = "order/client/wallet/update?";

    /**
     * 获取钱包列表
     */
    public static final String getQianbaoList = "order/client/wallet/detail/{memberId}/{type},{pageIndex}?";

    /**
     * 充值
     */
    public static final String chongZhi = "order/client/create/deposit/{memberId}/{extraOpenId},{billType},{amount}";


    /**
     * 提现
     */
    public static final String tiXian = "order/client/create/withdraw/{memberId}/{extraOpenId},{billType},{amount},{accountType}";


    /**
     * 消息
     */
    public static final String xiaoxi = "client/announcement/list/{pageIndex}";

    /**
     * 评论列表
     */
    public static final String reviewList = "client/clientComment/list/{memberId}/{type}";

    /**
     * 评论详情
     */
    public static final String reviewDetail = "client/clientComment/detail/{billId}";

    /**
     * 添加评论
     */
    public static final String addReview = "client/comment/add";


    /**
     * 显示订单列表
     */
    public static final String orderList = "order/client/list/{memberId}/{billType},{status},{pageIndex}?";


    /**
     * 订单详情
     */
    public static final String orderDetail = "order/client/billfinishinfo/{billId},{tag}?";


    /**
     * 我的活动
     */
    public static final String myActivity = "order/client/invitationActivity/list/{memberId}/{type}?";


    /**
     * 发起纠纷
     */
    public static final String addJiufen = "client/dispute/add";


    /**
     * 查看门票列表
     */
    public static final String queryMenPiao = "client/venueList/{pageIndex}";

    /**
     * 场馆详情
     */
    public static final String menPiaoDetail = "client/venue?";

    /**
     * 门票详情
     */
    public static final String getMenpiaoDetail = "client/ticketIndex/{ticketId}";

    /**
     * 门票订单
     */
    public static final String createOrderMenpiao = "order/ticket/createBill/{memberId}/{ticketId}/{number}?";

    /**
     * 可用优惠券列表
     */
    public static final String youhuilist = "order/client/coupon/getcouponlist/{memberId}";

    /**
     * 用户优惠券列表
     */
    public static final String getYouhuilist = "order/client/coupon/getcouponlistbymember/{memberId}";

    /**
     * 获取领取优惠券
     */
    public static final String hadCrips = "order/client/coupon/getonecoupon/{memberId}/{couponId}";


    /**
     * 支付获取优惠券列表
     */
    public static final String getUsingTypeCrips = "order/client/coupon/getcanusecoupon/{memberId}/{courseId},{amount}";


    /**
     * 判断是否是可以用的优惠券
     */
    public static final String checkCoupons = "order/client/coupon/check/{memberId}/{couponCode},{billId},{actualAmount}";



    /**
     * 下载自动更新接口
     */
//    public static final String MAIN_LOAD = "http://192.168.0.102:8080/";
//    public static final String MAIN_LOAD ="http://764abfe7.ngrok.natapp.cn/" ;
    public static final String MAIN_LOAD = "http://120.25.97.0/";
    public static final String download = MAIN_LOAD + "msport-admin/a/admin/update/appUpdate/upgrade";


    /**
     * 钱包完成接口
     */
    public static final String qianbaoFinish = "order/client/finish/wallet/{memberId}/{billId},{password}";

    /**
     * 获取验证码
     */
    public static final String getYanzhengma = "client/sms/verify/{telephone}";

    /**
     * 用户注册
     */
    public static final String registerPhone = "client/registe";


    /**
     * 绑定手机
     */
    public static final String register = "client/phoneregiste";


    /**
     * 微信登陆
     */
    public static final String userAutoLoginWx = "client/wechatlogin/{openId},{token}";

    /**
     * QQ登陆
     */
    public static final String userAutoLoginQQ = "client/qqlogin/{openId},{token},{type}";


    /**
     * 用code获取openID 与 token
     */
    public  static final String getWxScreate = "https://api.weixin.qq.com/sns/oauth2/access_token?";


    /**
     * 用户信息修改
     */
    public static final String getUserProperties = "client/member/update";


    /**
     * HTML 5 课程分享
     */
    public static final String getCourseShare = "http://www.52wyd.com/msport-api-web/courseDetails.html?id=";


    /**
     * 特殊上传url
     */
//    public static final String IMG_MAIN = "http://bb8767b.ngrok.natapp.cn/admin";
//	public static final String IMG_MAIN = "http://192.168.0.9:8080/msport-admin/";//内网
    public static final String IMG_MAIN = "http://120.25.97.0/admin/";
    public static final String URL_FILE = IMG_MAIN+"static/ckfinder/core/connector/java/connector.java?command=FILEUPLOAD&userId=";


    /**
     * 微信回调成功
     */
    public static  final String finishWx = "order/client/finish/{billId}?";

    /**
     * 意见反馈
     */
    public static final String YIJIAN_FANGKUI = "miscell/feedback";


    /**
     * 发送验证码找回密码
     */
    public static final String getSMS_pwdRecode = "client/sms/rpwdverify/{telephone}";


    /**
     * 找回密码接口
     */
    public static final String reset_pwd = "client/member/resetpwd";


    /**
     * 分享
     */
    public static final String shareUrl = "http://www.52wyd.com/msport-ui-web/share.html";


    /**
     * 门票完成接口
     */
    public static final String menpiaofinish = "order/client/finish/ticketBill/{billId}";

}
