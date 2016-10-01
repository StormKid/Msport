package com.msport.clientmaster.intef;


import com.msport.clientmaster.calendar.ChooseTimeEntity;
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
import com.msport.clientmaster.pay.AliPayEntity;

import java.util.Map;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by like on 2016/7/1.
 * 所有动态代理
 */

public interface BaseInterf {
    String BASEHEAD = "Content-Type: application/json";

    @Headers(BASEHEAD)
    @GET(HttpConstant.getHotEntity)
    Call<HotEntity> getMethod(
    );

    @Headers(BASEHEAD)
    @POST(HttpConstant.getYueQiu )
    Call<YueQiuEntity> getYueQiu(
            @Path("pageIndex") String pageIndex,
            @Body RequestBody body
    );

    @Headers(BASEHEAD)
    @GET(HttpConstant.getYueQiuDetail + "{inviteId}")
    Call<YueQiuDetaiEntity> getYueQiuDetail(
            @Path("inviteId") String inviteId
    );

    @Headers(BASEHEAD)
    @POST(HttpConstant.addYueQiu)
    Call<BaseEntity> addYueQiu(
            @Body RequestBody body
    );

    @Headers(BASEHEAD)
    @GET(HttpConstant.home + "")
    Call<MainEntity> getHome(
    );


    @Headers(BASEHEAD)
    @POST(HttpConstant.LOGIN_USER)
    Call<LoginEntity> loginUser(
            @Body RequestBody body
    );

    @Headers(BASEHEAD)
    @POST(HttpConstant.joinYueQiu)
    Call<ProyueqiuPayEntity> preYueqiu(
            @Path("memberId") String memberId,
            @Path("invitationId") String invitationId,
            @Path("number") String number,
            @Path("paymode") String paymode,
            @QueryMap Map<String,String> map
    );

    @Headers(BASEHEAD)
    @GET(HttpConstant.showCourseDetail)
    Call<CourseDetailEntity> courseDetai(
            @Path("courseId") String courseId
    );

    @Headers(BASEHEAD)
    @GET(HttpConstant.queryAllCourseList)
    Call<TagListEntity> getTagList(
            @QueryMap Map<String, String> map
    );

    @Headers(BASEHEAD)
    @GET(HttpConstant.coachDetail)
    Call<CoachDetailEntity> getCoachDetail(@Path("coachId") String coachId);

    @Headers(BASEHEAD)
    @GET(HttpConstant.weiPropay)
    Call<WeiXinPayEntity> prepayWeixin(
            @Path("billId") String billId
    );

    @Headers(BASEHEAD)
    @GET(HttpConstant.weipay)
    Call<WeiPayEntity> weiPay(
            @QueryMap Map<String, String> map
    );

    @Headers(BASEHEAD)
    @POST
    Call<AliPayEntity> aliPay(
            @Url String real,
            @Body RequestBody body
    );

    @Headers(BASEHEAD)
    @GET(HttpConstant.courseReview)
    Call<DetailReviewEntity> courseReview(
            @Path("courseId") String courseId,
            @Path("pageIndex") String pageIndex
    );

    @Headers(BASEHEAD)
    @GET(HttpConstant.coachReview)
    Call<DetailReviewEntity> coachReview(
            @Path("coachId") String coachId,
            @Path("pageIndex") String pageIndex
    );

    @Headers(BASEHEAD)
    @GET(HttpConstant.queryBisaiList)
    Call<BisaiListEntity> getBisaiList(
            @Path("pageIndex") String pageIndex
    );


    @Headers(BASEHEAD)
    @GET(HttpConstant.categroyCoachList)
    Call<CoachListEntity> categroyCoach(
            @Path("pageIndex") String pageIndex,
            @QueryMap Map<String, String> params

    );

    @Headers(BASEHEAD)
    @GET(HttpConstant.getCourseType)
    Call<CourseTypeEntity> getDefaltCatagroy(
            @Path("parentId") String parentId
    );


    @Headers(BASEHEAD)
    @GET(HttpConstant.getCourseLiset)
    Call<CourseListEntity> getCourseList(
            @Path("pageIndex") String pageIndex,
            @QueryMap Map<String, String> params
    );

    @Headers(BASEHEAD)
    @POST()
    Call<CourseOrderEntity> getCourseOrder(
            @Url String realUrl

    );

    @Headers(BASEHEAD)
    @GET(HttpConstant.getCoahTime)
    Call<ChooseTimeEntity> getCoachTime(
            @Path("coachId") String coachId
    );

    @Headers(BASEHEAD)
    @POST(HttpConstant.createCoachOrder)
    Call<CoachOrderEntity> gerCoachOrder(
            @QueryMap() Map<String, String> map,
            @Body RequestBody body
    );

    @Headers(BASEHEAD)
    @GET(HttpConstant.getQIANBAO)
    Call<QianBaoEntity> getQianBao(
            @Path("memberId") String memberId,
            @QueryMap Map<String, String> params

    );

    @Headers(BASEHEAD)
    @POST(HttpConstant.bindQianbao)
    Call<BaseEntity> bindQianbao(
            @QueryMap Map<String, String> main, @Body RequestBody body

    );

    @Headers(BASEHEAD)
    @GET(HttpConstant.getQianbaoList)
    Call<QianbaoListEntity> getQianbaoList(

            @Path("memberId") String memberId,
            @Path("type") String type,
            @Path("pageIndex") String pageIndex,
            @QueryMap Map<String, String> map
    );

    @Headers(BASEHEAD)
    @POST(HttpConstant.chongZhi)
    Call<ChongZhiEntity> chongZhi(
            @Path("memberId") String memberId,
            @Path("extraOpenId") String extraOpenId,
            @Path("billType") String billType,
            @Path("amount") String amount,
            @QueryMap Map<String, String> map
    );


    @Headers(BASEHEAD)
    @GET(HttpConstant.xiaoxi)
    Call<MyMessageEntity> getXiaoxi(
            @Path("pageIndex") String pageIndex
    );

    @Headers(BASEHEAD)
    @POST(HttpConstant.tiXian)
    Call<ChongZhiEntity> getTixian(
            @Path("memberId") String memberId,
            @Path("extraOpenId") String extraOpenId,
            @Path("billType") String billType,
            @Path("amount") String amount,
            @Path("accountType") String accountType,
            @QueryMap Map<String, String> map
    );

    @Headers(BASEHEAD)
    @GET(HttpConstant.reviewList)
    Call<ReViewListEntity> getReviewList(
            @Path("memberId") String memberId,
            @Path("type") String type
    );


    @Headers(BASEHEAD)
    @GET(HttpConstant.reviewDetail)
    Call<ReviewDetailEntity> getReviewDetail(
            @Path("billId") String billId
    );


    @Headers(BASEHEAD)
    @POST(HttpConstant.addReview)
    Call<BaseEntity> addReview(
            @Body RequestBody body
    );



    @Headers(BASEHEAD)
    @GET(HttpConstant.orderList)
    Call<OrderListEntity> orderList(
            @Path("memberId") String memberId,
            @Path("billType") String billType,
            @Path("status")String status,
            @Path("pageIndex") String pageIndex,
            @QueryMap Map<String, String> map);

    @Headers(BASEHEAD)
    @GET(HttpConstant.orderDetail)
    Call<OrderDetailEntity> orderDetial(
            @Path("billId")String billId,
            @Path("tag") String tag,
            @QueryMap() Map<String,String> map
    );


    @Headers(BASEHEAD)
    @GET(HttpConstant.myActivity)
    Call<ActivityEntity> getActivity(
            @Path("memberId") String memberId,
            @Path("type") String type,
            @QueryMap Map<String, String> map);



    @Headers(BASEHEAD)
    @POST(HttpConstant.addJiufen)
    Call<BaseEntity> addJiuFen(
            @Body RequestBody body
    );


    @Headers(BASEHEAD)
    @POST(HttpConstant.queryMenPiao)
    Call<MenPiaoEntity> queryMenp(
            @Path("pageIndex") String pageIndex,
        @Body RequestBody params
    );

    @Headers(BASEHEAD)
    @POST(HttpConstant.menPiaoDetail)
    Call<LocationDetailEntity> MenpDetail(
            @Query("venueId") String id
    );


    @Headers(BASEHEAD)
    @GET(HttpConstant.getMenpiaoDetail)
    Call<MenPiaoDetailEntity> getMenDetial(
        @Path("ticketId") String ticketId
    );


    @Headers(BASEHEAD)
    @POST(HttpConstant.createOrderMenpiao)
    Call<MenPiaoOrderEntity> createMenpiaoOrder(
           @Path("memberId") String memberId,
           @Path("ticketId") String ticketId,
           @Path("number") String number,
           @QueryMap Map<String,String> map
    );



    @Headers(BASEHEAD)
    @GET(HttpConstant.youhuilist)
    Call<CripEntity> getYouhuiquan(
            @Path("memberId") String memberId
    );



    @Headers(BASEHEAD)
    @GET(HttpConstant.getYouhuilist)
    Call<MyCripsEntity> getMyyouhuiliet(
            @Path("memberId") String memberId
    );


    @Headers(BASEHEAD)
    @POST(HttpConstant.hadCrips)
    Call<BaseEntity> hadCoupos (
            @Path("memberId") String  memberId,
            @Path("couponId") String  couponId
    );



    @Headers(BASEHEAD)
    @GET(HttpConstant.getUsingTypeCrips)
    Call<CripEntity> getUsingCrips(
            @Path("memberId") String memberId,
            @Path("courseId") String courseId,
            @Path("amount") String amount
    );


    @Headers(BASEHEAD)
    @POST(HttpConstant.checkCoupons)
    Call<BaseEntity> checkYouhuiPay(
            @Path("memberId")String memberId,
            @Path("couponCode") String couponCode,
            @Path("billId") String billId,
            @Path("actualAmount") String actualAmount
    );

    @Headers(BASEHEAD)
    @GET
    Call<ResponseBody> download(
            @Url String downUrl
    );


    @Headers(BASEHEAD)
    @POST(HttpConstant.qianbaoFinish)
    Call<BaseEntity> qianbaoFinish(
        @Path("memberId") String memberId,
        @Path("billId") String billId,
        @Path("password") String password,
        @QueryMap Map<String,String> map
    );


    @Headers(BASEHEAD)
    @POST(HttpConstant.getYanzhengma)
    Call<BaseEntity> yanzhengma(
            @Path("telephone") String telephone
    );



    @Headers(BASEHEAD)
    @POST(HttpConstant.register)
    Call<BaseEntity> register(
            @Body RequestBody body
    );


    @Headers(BASEHEAD)
    @POST(HttpConstant.registerPhone)
    Call<BaseEntity> phoneRegister(
            @Body RequestBody body
    );


    @Headers(BASEHEAD)
    @POST(HttpConstant.userAutoLoginWx)
    Call<LoginEntity> userAutoLoginWX(
            @Path("openId") String openId,
            @Path("token") String token
    );

    @Headers(BASEHEAD)
    @POST(HttpConstant.userAutoLoginQQ)
    Call<LoginEntity> userAutoLoginQQ(
            @Path("openId") String openId,
            @Path("token") String token,
            @Path("type") String type
    );

    @Headers(BASEHEAD)
    @GET()
    Call<ResponseBody> getWsc(
            @Url String url
    );

    @Headers(BASEHEAD)
    @POST(HttpConstant.getUserProperties)
    Call<BaseEntity> changeBody(
            @Body RequestBody body
    );



    @Multipart
    @POST()
    Call<PhotoEntity> photoRight(
            @Url String url,
            @Part("fileName") String description,
            @Part("file\"; filename=\"image.png\"")RequestBody imgs
    );


    @Headers(BASEHEAD)
    @POST(HttpConstant.finishWx)
    Call<BaseEntity> finishWX(
            @Path("billId") String billId,
            @QueryMap Map<String,String> params
    );


    @Headers(BASEHEAD)
    @POST(HttpConstant.YIJIAN_FANGKUI)
    Call<BaseEntity> fankui(
            @Body RequestBody body
    );


    @Headers(BASEHEAD)
    @POST(HttpConstant.getSMS_pwdRecode)
    Call<BaseEntity> recodePWD(
            @Path("telephone") String telephone
    );

    @Headers(BASEHEAD)
    @POST(HttpConstant.reset_pwd)
    Call<BaseEntity> resetPwd(
            @Body RequestBody body
    );



    @Headers(BASEHEAD)
    @POST(HttpConstant.menpiaofinish)
    Call<BaseEntity> menpiaoFinish(@Path("billId") String billId,@QueryMap Map<String,String> map);

}

