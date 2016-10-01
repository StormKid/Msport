package com.msport.clientmaster.callback;


import android.content.Context;

import com.msport.clientmaster.calendar.ChooseTimeEntity;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.constants.HttpConstant;
import com.msport.clientmaster.entity.ActivityEntity;
import com.msport.clientmaster.entity.BaseEntity;
import com.msport.clientmaster.entity.BisaiListEntity;
import com.msport.clientmaster.entity.ChongZhiEntity;
import com.msport.clientmaster.entity.CoachDetailEntity;
import com.msport.clientmaster.entity.CoachListEntity;
import com.msport.clientmaster.entity.CoachOrderEntity;
import com.msport.clientmaster.entity.CourseDetailEntity;
import com.msport.clientmaster.entity.CourseListEntity;
import com.msport.clientmaster.entity.CourseOrderEntity;
import com.msport.clientmaster.entity.CourseTypeEntity;
import com.msport.clientmaster.entity.CripEntity;
import com.msport.clientmaster.entity.DetailReviewEntity;
import com.msport.clientmaster.entity.HotEntity;
import com.msport.clientmaster.entity.LocationDetailEntity;
import com.msport.clientmaster.entity.LoginEntity;
import com.msport.clientmaster.entity.MainEntity;
import com.msport.clientmaster.entity.MenPiaoDetailEntity;
import com.msport.clientmaster.entity.MenPiaoEntity;
import com.msport.clientmaster.entity.MenPiaoOrderEntity;
import com.msport.clientmaster.entity.MyCripsEntity;
import com.msport.clientmaster.entity.MyMessageEntity;
import com.msport.clientmaster.entity.OrderDetailEntity;
import com.msport.clientmaster.entity.OrderListEntity;
import com.msport.clientmaster.entity.PhotoEntity;
import com.msport.clientmaster.entity.ProyueqiuPayEntity;
import com.msport.clientmaster.entity.QianBaoEntity;
import com.msport.clientmaster.entity.QianbaoListEntity;
import com.msport.clientmaster.entity.ReViewListEntity;
import com.msport.clientmaster.entity.ReviewDetailEntity;
import com.msport.clientmaster.entity.TagListEntity;
import com.msport.clientmaster.entity.WeiPayEntity;
import com.msport.clientmaster.entity.WeiXinPayEntity;
import com.msport.clientmaster.entity.YueQiuDetaiEntity;
import com.msport.clientmaster.entity.YueQiuEntity;
import com.msport.clientmaster.intef.BaseInterf;
import com.msport.clientmaster.intef.MyViewCallback;
import com.msport.clientmaster.pay.AliPayEntity;
import com.msport.clientmaster.pay.InitPayOrderBean;
import com.msport.clientmaster.pay.ProPayBean;
import com.msport.clientmaster.requestbean.AddYueQiuBean;
import com.msport.clientmaster.requestbean.BindQianbaoRequestBean;
import com.msport.clientmaster.requestbean.CoachOrderRequestBean;
import com.msport.clientmaster.requestbean.CoachRequestBean;
import com.msport.clientmaster.requestbean.CourseOrderRequestBean;
import com.msport.clientmaster.requestbean.CourseRequestBean;
import com.msport.clientmaster.requestbean.FanKuiRequestBean;
import com.msport.clientmaster.requestbean.JiufenRequestBean;
import com.msport.clientmaster.requestbean.LoginReauestBean;
import com.msport.clientmaster.requestbean.MenPiaoAddressRequestBean;
import com.msport.clientmaster.requestbean.PropertiesRequestBean;
import com.msport.clientmaster.requestbean.RegisterRequestBean;
import com.msport.clientmaster.requestbean.ReserPwdRequestBean;
import com.msport.clientmaster.requestbean.ReviewRequestBean;
import com.msport.clientmaster.requestbean.VenueRequestBean;
import com.msport.clientmaster.util.PublicPreferencesUtils;
import com.msport.clientmaster.util.ShaUtil;
import com.msport.clientmaster.util.SignUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 网络请求总类
 */
public class MainCallback {
    private MyViewCallback listener;
    /**
     * 正式版用false取消json显示
     */
    private boolean showJson = true;
    /**
     * 打印jsonLog
     */
    private final OkHttpClient okHttpClient = showJson == true ? new OkHttpClient.Builder().addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).connectTimeout(7,TimeUnit.SECONDS).build(): new OkHttpClient.Builder().connectTimeout(7,TimeUnit.SECONDS).build();
    /**
     * 发送网络请求
     */
    private final Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(HttpConstant.DOMAIN).addConverterFactory(GsonConverterFactory.create()).build();
    BaseInterf base = retrofit.create(BaseInterf.class);
    private boolean tag;
    private Context context;

    /**
     * 默认显示弹出progressbar
     *
     * @param listener
     */
    public MainCallback(MyViewCallback listener, Context context) {
        this.listener = listener;
        this.context = context;
    }

    /**
     * 获取热门课程
     */
    public void getHotCourse() {
        Call<HotEntity> listCall = base.getMethod();
        listCall.enqueue(new BaseCallback(listener, HttpConstant.getHotEntity, context));
    }

    /**
     * 获取约球列表
     *  @param pageIndex
     * @param body
     * @param b
     */
    public void getYueQiuList(String pageIndex, RequestBody body, boolean b) {
        Call<YueQiuEntity> call = base.getYueQiu(pageIndex, body);
        call.enqueue(new BaseCallback(listener, HttpConstant.getYueQiu, context,b));

    }


    /**
     * 获取约球详情
     *
     * @param inviteId
     */
    public void getYueQiuDetail(String inviteId) {
        Call<YueQiuDetaiEntity> call = base.getYueQiuDetail(inviteId);
        call.enqueue(new BaseCallback(listener, HttpConstant.getYueQiuDetail, context));
    }


    /**
     * 添加约球
     *
     * @param bean
     */
    public void addYueQiu(AddYueQiuBean bean) {
        RequestBody body = SignUtil.Urljson(bean);
        Call<BaseEntity> call = base.addYueQiu(body);
        call.enqueue(new BaseCallback(listener, HttpConstant.addYueQiu, context));
    }

    /**
     * 获取首页
     * @param homerefresh
     */
    public void HomeGet(boolean homerefresh) {
        Call<MainEntity> call = base.getHome();
        call.enqueue(new BaseCallback(listener, HttpConstant.home, context,homerefresh));
    }


    /**
     * 微信预支付
     *
     * @param billId
     */
    public void prePay(String billId) {
        Call<WeiXinPayEntity> call = base.prepayWeixin(billId);
        call.enqueue(new BaseCallback(listener, HttpConstant.weiPropay, context));
    }


    /**
     * 登陆
     *
     * @param telephone
     * @param pwd
     */
    public void login(String telephone, String pwd) {
        LoginReauestBean bean = new LoginReauestBean();
        bean.setTelephone(telephone);
        bean.setPassword(pwd);
        RequestBody urljson = SignUtil.Urljson(bean);
        Call<LoginEntity> call = base.loginUser(urljson);
        call.enqueue(new BaseCallback(listener, HttpConstant.LOGIN_USER, context));
    }


    /**
     * 获取预支付页面
     *
     * @param memberId
     * @param invidata
     * @param number
     */

    public void joinYueqiu(String memberId, String invidata, String number) {
        Map<String,String> params = new HashMap<>();
        params.put("memberId" ,memberId);
        params.put("number",number);
        params.put("invitationId",invidata);
        params.put("paymode","-1");
        Map<String, String> map = insertSignMap(params, context);
        Call<ProyueqiuPayEntity> call = base.preYueqiu(memberId, invidata, number, "-1",map);
        call.enqueue(new BaseCallback(listener, HttpConstant.joinYueQiu, context));
    }

    /**
     * 微信支付
     *
     * @param bean
     */
    public void weixinPay(ProPayBean bean) {
        Map<String, String> params = new HashMap<>();
        params.put("appId", bean.appId);
        params.put("nonceStr", bean.nonceStr);
        params.put("partnerid", bean.partnerid);
        params.put("prepay_id", bean.prepay_id);
        params.put("timeStamp", bean.timeStamp);
        params.put("type", "1");
        Call<WeiPayEntity> call = base.weiPay(params);
        call.enqueue(new BaseCallback(listener, HttpConstant.weipay, context));
    }

    /**
     * 支付宝支付
     *
     * @param bean
     * @param context
     */
    public void aliPay(InitPayOrderBean bean, Context context) {
        Map<String, String> params = new HashMap<>();
        params.put("amount", bean.getAmount());
        params.put("billid", bean.getBillid());
        params.put("name", bean.getName());
        params.put("customerAddress", bean.getCustomerAddress());
        String sign = insertSignMain(params, context);
        String raalUrl = HttpConstant.DOMAIN + HttpConstant.alipay + sign;
        RequestBody body = SignUtil.Urljson(bean);
        Call<AliPayEntity> call = base.aliPay(raalUrl, body);
        call.enqueue(new BaseCallback(listener, HttpConstant.alipay, context));
    }

    /**
     * 获取私教列表页面
     *  @param index
     * @param bean
     * @param b
     */
    public void getCoachList(String index, CoachRequestBean bean, boolean b) {
        Map<String, String> params = new HashMap<>();
        params.put("gender", bean.gender);
        params.put("highestPrice", bean.highestPrice);
        params.put("lowestPrice", bean.lowestPrice);
        params.put("major", bean.major);
        params.put("servRange", bean.servRange);
        params.put("value", bean.value);
        Call<CoachListEntity> call = base.categroyCoach(index, params);
        call.enqueue(new BaseCallback(listener, HttpConstant.categroyCoachList, context,b));
    }


    /**
     * 获取课程详情
     *
     * @param courseID
     */
    public void getCourseDetail(String courseID) {
        Call<CourseDetailEntity> call = base.courseDetai(courseID);
        call.enqueue(new BaseCallback(listener, HttpConstant.showCourseDetail, context));
    }

    /**
     * 获取整个tagList
     *
     * @param context
     */
    public void getTagListText(Context context) {
        Map<String, String> map = insertSignMap(null, context);
        Call<TagListEntity> call = base.getTagList(map);
        call.enqueue(new BaseCallback(listener, HttpConstant.queryAllCourseList, context));
    }

    /**
     * 获取私教详情
     *
     * @param coachId
     */
    public void getCoachDetail(String coachId) {
        Call<CoachDetailEntity> coachDetail = base.getCoachDetail(coachId);
        coachDetail.enqueue(new BaseCallback(listener, HttpConstant.coachDetail, context));
    }

    /**
     * 获取私教评论
     *
     * @param coachId
     * @param pageIndex
     */
    public void getCoachReview(String coachId, String pageIndex) {
        Call<DetailReviewEntity> call = base.coachReview(coachId, pageIndex);
        call.enqueue(new BaseCallback(listener, HttpConstant.coachReview, context));
    }

    /**
     * 获取课程评论
     *
     * @param courseId
     * @param pageIndex
     */
    public void getCourseReview(String courseId, String pageIndex) {
        Call<DetailReviewEntity> call = base.coachReview(courseId, pageIndex);
        call.enqueue(new BaseCallback(listener, HttpConstant.courseReview, context));
    }

    /**
     * 查询比赛列表
     *
     * @param pageIndex
     */
    public void getBisaiList(String pageIndex,boolean b) {
        Call<BisaiListEntity> call = base.getBisaiList(pageIndex);
        call.enqueue(new BaseCallback(listener, HttpConstant.queryBisaiList, context,b));
    }


    /**
     * 查询课程类型
     *
     * @param parentId
     * @param b
     */
    public void getCourseType(String parentId, boolean b) {
        Call<CourseTypeEntity> call = base.getDefaltCatagroy(parentId);
        call.enqueue(new BaseCallback(listener, HttpConstant.getCourseType, context,false));
    }

    /**
     * 查询课程列表
     *  @param requestBean
     * @param pageIndex
     * @param b
     */
    public void getCourseList(CourseRequestBean requestBean, String pageIndex, boolean b) {
        Map<String, String> params = new HashMap<>();
        params.put("coursetype", requestBean.courseType);
        params.put("highestPrice", requestBean.highestPrice);
        params.put("lowestPrice", requestBean.lowestPrice);
        params.put("servRange", requestBean.servRange);
        params.put("subCourseType", requestBean.subCourseType);
        params.put("value", requestBean.value);
        Call<CourseListEntity> call = base.getCourseList(pageIndex, params);
        call.enqueue(new BaseCallback(listener, HttpConstant.getCourseLiset, context,b));
    }


    /**
     * 获得私教时间
     *
     * @param coachId
     */
    public void getCoachTime(String coachId) {
        Call<ChooseTimeEntity> time = base.getCoachTime(coachId);
        time.enqueue(new BaseCallback(listener, HttpConstant.getCoahTime, context));
    }


    /**
     * 生成课程订单
     * order/client/create/{memberId}/{courseId},{extraOpenId},{activityId},{number},{billType},{paymentMode}
     */
    public void getCourseOrder(CourseOrderRequestBean bean, Context context) {
        Map<String, String> params = new HashMap<>();
        params.put("memberId", bean.memberId);
        params.put("courseId", bean.courseId);
        params.put("extraOpenId", bean.extraOpenId);
        params.put("activityId", bean.activityId);
        params.put("number", bean.number);
        params.put("billType", bean.billType);
        params.put("paymentMode", bean.paymentMode);
        String signMain = insertSignMain(params, context);
        String RealUrl = HttpConstant.DOMAIN + HttpConstant.createCourseOrder + bean.memberId + "/" + bean.courseId + "," + bean.extraOpenId + "," + bean.activityId + "," + bean.number + "," + bean.billType + "," + bean.paymentMode + "?" + signMain;
        Call<CourseOrderEntity> order = base.getCourseOrder(RealUrl);
        order.enqueue(new BaseCallback(listener, HttpConstant.createCourseOrder, context));
    }

    /**
     * 创建私教订单
     *
     * @param bean
     * @param context
     */
    public void getCoachOrder(CoachOrderRequestBean bean, Context context) {
        Map<String, String> params = new HashMap<>();
        params.put("amount", bean.getAmount());
        params.put("coachId", bean.getCoachId());
        params.put("customerAddress", bean.getCustomerAddress());
        params.put("payerId", bean.getPayerId());
        params.put("name", bean.getName());
        params.put("paymentmode", bean.getPaymentmode());
        params.put("qScheduleList", bean.getqScheduleList());
        params.put("aVenueId","-1");
        RequestBody body = SignUtil.Urljson(bean);
        Map<String, String> map = insertSignMap(params, context);
        Call<CoachOrderEntity> call = base.gerCoachOrder(map, body);
        call.enqueue(new BaseCallback(listener, HttpConstant.createCoachOrder, context));

    }

    /**
     * 查询钱包
     *  @param menberId
     * @param context
     * @param b
     */
    public void getQianbao(String menberId, Context context, boolean b) {
        Map<String, String> params = new HashMap<>();
        params.put("memberId", menberId);
        Map<String, String> map = insertSignMap(params, context);
        Call<QianBaoEntity> qianBao = base.getQianBao(menberId, map);
        qianBao.enqueue(new BaseCallback(listener, HttpConstant.getQIANBAO, context,b));
    }

    /**
     * 绑定錢包
     *
     * @param bindQianbaoRequestBean
     * @param context
     */
    public void bindQianbao(BindQianbaoRequestBean bindQianbaoRequestBean, Context context) {
        Map<String, String> map = new HashMap<>();
        map.put("walletId", bindQianbaoRequestBean.walletId);
        map.put("accountType", bindQianbaoRequestBean.accountType);
        map.put("account", bindQianbaoRequestBean.account);
        map.put("name", bindQianbaoRequestBean.name);
        map.put("telephone", bindQianbaoRequestBean.telephone);
        Map<String, String> main = insertSignMap(map, context);
        RequestBody body = SignUtil.Urljson(bindQianbaoRequestBean);
        Call<BaseEntity> call = base.bindQianbao(main, body);
        call.enqueue(new BaseCallback(listener, HttpConstant.bindQianbao, context));

    }

    /**
     * 钱包list
     *  @param pageIndex
     * @param type
     * @param memberId
     * @param context
     * @param b
     */
    public void getQianbaoList(String pageIndex, String type, String memberId, Context context, boolean b) {
        Map<String, String> params = new HashMap<>();
        params.put("memberId", memberId);
        params.put("pageIndex", pageIndex);
        params.put("type", type);
        Map<String, String> map = insertSignMap(params, context);
        Call<QianbaoListEntity> list = base.getQianbaoList(memberId, type, pageIndex, map);
        list.enqueue(new BaseCallback(listener, HttpConstant.getQianbaoList, context,b));
    }

    /**
     * 充值
     *
     * @param memberId
     * @param billtype
     * @param amount
     * @param context
     */
    public void goChongZhi(String memberId, String billtype, String amount, Context context) {
        Map<String, String> params = new HashMap<>();
        params.put("memberId", memberId);
        params.put("extraOpenId", "-1");
        params.put("billType", billtype);
        params.put("amount", amount);
        Map<String, String> map = insertSignMap(params, context);
        Call<ChongZhiEntity> call = base.chongZhi( memberId, "-1", billtype, amount, map);
        call.enqueue(new BaseCallback(listener, HttpConstant.chongZhi, context));
    }

    /**
     * 提现
     *  @param memberId
     * @param billtype
     * @param amount
     * @param context
     * @param accountType
     */
    public void goTiXian(String memberId, String billtype, String amount, Context context, String accountType) {
        Map<String, String> params = new HashMap<>();
        params.put("memberId", memberId);
        params.put("extraOpenId", "-1");
        params.put("billType", billtype);
        params.put("amount", amount);
        params.put("accountType",accountType);
        Map<String, String> map = insertSignMap(params, context);
        Call<ChongZhiEntity> call = base.getTixian(memberId , "-1", billtype, amount,accountType, map);
        call.enqueue(new BaseCallback(listener, HttpConstant.tiXian, context));
    }



    /**
     * 显示消息列表
     *
     * @param pageIndex
     * @param b
     */
    public void getXiaoxi(String pageIndex, boolean b) {
        Call<MyMessageEntity> xiaoxi = base.getXiaoxi(pageIndex);
        xiaoxi.enqueue(new BaseCallback(listener, HttpConstant.xiaoxi, context,b));
    }


    /**
     * 获得评论消息
     *  @param memberId
     * @param type
     * @param b
     */
    public void getReviewList(String memberId, String type, boolean b) {
        Call<ReViewListEntity> reviewList = base.getReviewList(memberId, type);
        reviewList.enqueue(new BaseCallback(listener, HttpConstant.reviewList, context,b));
    }

    /**
     * 获得评论详情
     *
     * @param billId
     */
    public void getReviewDetail(String billId) {
        Call<ReviewDetailEntity> detail = base.getReviewDetail(billId);
        detail.enqueue(new BaseCallback(listener, HttpConstant.reviewDetail, context));
    }


    /**
     * 添加评论
     *
     * @param bean
     */
    public void addReview(ReviewRequestBean bean) {
        RequestBody body = SignUtil.Urljson(bean);
        Call<BaseEntity> call = base.addReview(body);
        call.enqueue(new BaseCallback(listener, HttpConstant.addReview, context));
    }


    /**
     * 查询所有订单
     *  @param memberId
     * @param billType
     * @param status
     * @param pageIndex
     * @param context
     * @param b
     */
    public void getAllListOrder(String memberId, String billType, String status, String pageIndex, Context context, boolean b) {
        Map<String, String> params = new HashMap<>();
        params.put("memberId", memberId);
        params.put("billType", billType);
        params.put("status", status);
        params.put("pageIndex", pageIndex);
        Map<String, String> map = insertSignMap(params, context);
        Call<OrderListEntity> call = base.orderList(memberId, billType, status, pageIndex, map);
        call.enqueue(new BaseCallback(listener, HttpConstant.orderList, context,b));

    }

    /**
     * 获得订单详情
     *
     * @param billId
     * @param valueTag
     * @param context
     */
    public void getOrderDetail(String billId, String valueTag, Context context) {
        Map<String, String> params = new HashMap<>();
        params.put("tag", valueTag);
        params.put("billId", billId);
        Map<String, String> map = insertSignMap(params, context);
        Call<OrderDetailEntity> call = base.orderDetial(billId, valueTag, map);
        call.enqueue(new BaseCallback(listener, HttpConstant.orderDetail, context));
    }


    /**
     * 我的活动
     *  @param memberId
     * @param type
     * @param context
     * @param b
     */
    public void getMyActivity(String memberId, String type, Context context, boolean b) {
        Map<String, String> params = new HashMap<>();
        params.put("type", type);
        params.put("memberId", memberId);
        Map<String, String> map = insertSignMap(params, context);
        Call<ActivityEntity> call = base.getActivity(memberId, type, map);
        call.enqueue(new BaseCallback(listener, HttpConstant.myActivity, context,b));
    }

    /**
     * 添加纠纷
     *
     * @param bean
     */
    public void addJiufen(JiufenRequestBean bean) {
        RequestBody requestBody = SignUtil.Urljson(bean);
        Call<BaseEntity> call = base.addJiuFen(requestBody);
        call.enqueue(new BaseCallback(listener, HttpConstant.addJiufen, context));
    }


    /**
     * 查询门票列表
     *
     * @param pageIndex
     */
    public void queryMenpiaoList(String pageIndex, MenPiaoAddressRequestBean bean,boolean b) {
        RequestBody body = SignUtil.Urljson(bean);
        Call<MenPiaoEntity> call = base.queryMenp(pageIndex, body);
        call.enqueue(new BaseCallback(listener, HttpConstant.queryMenPiao, context,b));
    }


    /**
     * 获取场馆详情
     *
     * @param id
     */
    public void getChangGuanDetail(VenueRequestBean id) {
        Call<LocationDetailEntity> call = base.MenpDetail(id.venueId);
        call.enqueue(new BaseCallback(listener, HttpConstant.menPiaoDetail, context));
    }


    /**
     * 获取门票详情
     *
     * @param tickId
     */
    public void getMenPiaoDetail(String tickId) {
        Call<MenPiaoDetailEntity> menDetial = base.getMenDetial(tickId);
        menDetial.enqueue(new BaseCallback(listener, HttpConstant.getMenpiaoDetail, context));
    }


    /**
     * 创建门票订单
     *
     * @param memberId
     * @param ticketId
     * @param number
     * @param context
     */
    public void createMenpiaoOrder(String memberId, String ticketId, String number, Context context) {
        Map<String, String> parms = new HashMap<>();
        parms.put("memberId", memberId);
        parms.put("ticketId", ticketId);
        parms.put("number", number);
        Map<String, String> map = insertSignMap(parms, context);
        Call<MenPiaoOrderEntity> menpiaoOrder = base.createMenpiaoOrder(memberId, ticketId, number, map);
        menpiaoOrder.enqueue(new BaseCallback(listener, HttpConstant.createOrderMenpiao, context));
    }


    /**
     * 首页优惠券
     * @param b
     * @param memberId
     */
    public void getYouhuiQuan(boolean b, String memberId){
        Call<CripEntity> youhuiquan = base.getYouhuiquan(memberId);
        youhuiquan.enqueue(new BaseCallback(listener,HttpConstant.youhuilist,context,b));
    }


    /**
     * 个人中心优惠券
     * @param memberId
     */
    public void  getMyCrips(String memberId){
        Call<MyCripsEntity> youhuiquan = base.getMyyouhuiliet(memberId);
        youhuiquan.enqueue(new BaseCallback(listener,HttpConstant.getYouhuilist,context));
    }


    /**
     * 获取优惠券
     * @param memberId
     * @param coupId
     */
    public void hadCrips(String memberId, String coupId){
        Call<BaseEntity> call = base.hadCoupos(memberId, coupId);
        call.enqueue(new BaseCallback(listener,HttpConstant.hadCrips,context));
    }


    /**
     * 支付的时候获取优惠券
     * @param memberId
     * @param courseId
     * @param amount
     */
    public void getUsingTypeCrips(String memberId, String courseId, String amount){
        Call<CripEntity> usingCrips = base.getUsingCrips(memberId, courseId, amount);
        usingCrips.enqueue(new BaseCallback(listener,HttpConstant.getUsingTypeCrips,context));
    }

    /**
     * 在预支付订单的时候请求判断优惠券
     * @param memberId
     * @param couponCode
     * @param billId
     * @param actrualAmount
     */
    public void checkCoupons(String memberId, String couponCode, String billId, String actrualAmount){
        Call<BaseEntity> call = base.checkYouhuiPay(memberId, couponCode, billId, actrualAmount);
        call.enqueue(new BaseCallback(listener,HttpConstant.checkCoupons,context));
    }


    /**
     * 版本更新
     * @param b
     */
    public void getDownload(boolean b){
        Call<ResponseBody> download = base.download(HttpConstant.download);
        download.enqueue(new BaseCallback(listener,HttpConstant.checkCoupons,context,b));
    }


    /**
     * 钱包完成接口
     * @param billId
     * @param accountType
     */
    public void qianbaoFinish(String billId, String accountType){
        String password = ShaUtil.SHA1(PublicPreferencesUtils.getString(context,Constant.USER_PWD));
        String memberId = PublicPreferencesUtils.getString(context,Constant.NUTZER_ID);
        Map<String,String> params = new HashMap<>();
        params.put("password",password);
        params.put("memberId",memberId);
        params.put("billId",billId);
//        params.put("accountType",accountType);// -1 钱包支付，1 微信，2 支付宝
        Map<String, String> map = insertSignMap(params, context);
        Call<BaseEntity> call = base.qianbaoFinish(memberId, billId, password, map);
        call.enqueue(new BaseCallback(listener,HttpConstant.qianbaoFinish,context));
    }


    /**
     * 获取验证码
     * @param telephone
     */
    public void yanzhengmaGet(String telephone){
        Call<BaseEntity> call = base.yanzhengma(telephone);
        call.enqueue(new BaseCallback(listener,HttpConstant.getYanzhengma,context));
    }

    /**
     * 用户注册
     * @param bean
     */
    public void register(RegisterRequestBean bean){
        RequestBody body = SignUtil.Urljson(bean);
        Call<BaseEntity> register = base.register(body);
        register.enqueue(new BaseCallback(listener,HttpConstant.register,context));
    }


    /**
     * 绑定手机号
     * @param bean
     */
    public void registerBindTelephone(RegisterRequestBean bean){
        RequestBody body = SignUtil.Urljson(bean);
        Call<BaseEntity> register = base.phoneRegister(body);
        register.enqueue(new BaseCallback(listener,HttpConstant.register,context));
    }



    /**
     * 第三方微信登陆
     * @param openId
     * @param token
     */
    public void autoLoginWX(String openId, String token){
        Call<LoginEntity> baseEntityCall = base.userAutoLoginWX(openId, token);
        baseEntityCall.enqueue(new BaseCallback(listener,HttpConstant.userAutoLoginWx,context));
    }


    /**
     *  第三方QQ登陆
     */

    public void autoLoginQQ(String openId, String token, String type){
        Call<LoginEntity> baseEntityCall = base.userAutoLoginQQ(openId, token,type);
        baseEntityCall.enqueue(new BaseCallback(listener,HttpConstant.userAutoLoginQQ,context));
    }


    /**
     * 微信登陆获取token与openId
     */
    public void getScreate(String code){
        Map<String,String> map = new HashMap<>();
        map.put("appid",Constant.WEIXIN_APPID);
        map.put("secret",Constant.WEIXIN_APPSECRET);
        map.put("code",code);
        map.put("grant_type","authorization_code");
        String url = HttpConstant.getWxScreate+"appid="+Constant.WEIXIN_APPID+"&secret="+Constant.WEIXIN_APPSECRET+"&code="+code+"&grant_type=authorization_code";
        Call<ResponseBody> wsc = base.getWsc(url);
        wsc.enqueue(new BaseCallback(listener,HttpConstant.getWxScreate,context));

    }


    /**
     * 用户个人资料更新
     * @param bean
     */
    public void getRequestProperties(PropertiesRequestBean bean){
        RequestBody urljson = SignUtil.Urljson(bean);
        Call<BaseEntity> call = base.changeBody(urljson);
        call.enqueue(new BaseCallback(listener,HttpConstant.getUserProperties,context));

    }


    /**
     * 上传图片的链接
     * @param img
     * @param path
     */
    public void upPhoto(RequestBody img, String path){
        String url = HttpConstant.URL_FILE+PublicPreferencesUtils.getString(context,Constant.NUTZER_ID);
        Call<PhotoEntity> call = base.photoRight(url, path, img);
        call.enqueue(new BaseCallback(listener,HttpConstant.URL_FILE,context));
    }


    /**
     * 微信返回成功
     * @param billId
     * @param b
     */
    public void wxFinish(String billId, boolean b){
        Map<String , String> map = new HashMap<>();
        map.put("billId",billId);
        Map<String, String> params = insertSignMap(map, context);
        Call<BaseEntity> baseEntityCall = base.finishWX(billId,params);
        baseEntityCall.enqueue(new BaseCallback(listener,HttpConstant.finishWx,context,b));
    }

    /**
     * 意见反馈
     * @param content
     * @return
     */
    public void FanKui(String content){
        String name = PublicPreferencesUtils.getString(context, Constant.NUTZER_NAME);
        String phone = PublicPreferencesUtils.getString(context, Constant.NUTZER_TELEPHONE);
        FanKuiRequestBean fanKuiRequestBean = new FanKuiRequestBean();
        fanKuiRequestBean.content = content;
        fanKuiRequestBean.name = name;
        fanKuiRequestBean.telephone = phone;
        RequestBody body = SignUtil.Urljson(fanKuiRequestBean);
        Call<BaseEntity> fankui = base.fankui(body);
        fankui.enqueue(new BaseCallback(listener,HttpConstant.YIJIAN_FANGKUI,context));
    }


    /**
     * 找回密码的验证码
     * @param telephone
     */
    public void getRepwd(String telephone){
        Call<BaseEntity> call = base.recodePWD(telephone);
        call.enqueue(new BaseCallback(listener,HttpConstant.getSMS_pwdRecode,context));
    }


    /**
     * 找回密码
     */
    public void resetPwd(ReserPwdRequestBean bean){
        RequestBody body = SignUtil.Urljson(bean);
        Call<BaseEntity> call = base.resetPwd(body);
        call.enqueue(new BaseCallback(listener,HttpConstant.reset_pwd,context));

    }


    /**
     * 门票完成
     * @param billId
     */
    public void menpiaoFinish(String billId){
        Map<String,String> map = new HashMap<>();
        map.put("billId" , billId);
        Map<String, String> params = insertSignMap(map, context);
        Call<BaseEntity> call = base.menpiaoFinish(billId, params);
        call.enqueue(new BaseCallback(listener,HttpConstant.menpiaofinish,context));
    }




    /**
     * 加密 在接口中使用全路径复写BASEURL 拼接字符串
     */
    public String insertSignMain(Map<String, String> params, Context context) {
        String token = PublicPreferencesUtils.getString(context, Constant.NUTZER_ACCESSTOKEN);
        String secret = PublicPreferencesUtils.getString(context, Constant.NUTZER_SERCRET);
        String sign = SignUtil.getSign(secret, params);
        String result = "sign=" + sign + "&token=" + token + "&timestamp=" + System.currentTimeMillis();
        return result;
    }

    /**
     * 加密 拼接map
     *
     * @param params
     * @param context
     * @return
     */
    public Map<String, String> insertSignMap(Map<String, String> params, Context context) {
        Map<String, String> arrays = new HashMap<>();
        String token = PublicPreferencesUtils.getString(context, Constant.NUTZER_ACCESSTOKEN);
        String secret = PublicPreferencesUtils.getString(context, Constant.NUTZER_SERCRET);
        String sign = SignUtil.getSign(secret, params);
        arrays.put("sign", sign);
        arrays.put("token", token);
        arrays.put("timestamp", System.currentTimeMillis() + "");
        return arrays;
    }


}





