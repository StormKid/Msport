package com.msport.clientmaster.pay;

import com.msport.clientmaster.entity.BaseEntity;

/**
 * Created by like on 2016/8/16.
 */

public class AliPayEntity extends BaseEntity {


    /**
     * data : partner="2088221619976476"&seller_id="weiyundong@52wyd.com"&out_trade_no="201608161642536687275775"&subject="充值订单"&body="充值订单"&total_fee="22"&notify_url="http://www.52wyd.com/msport-api-web/api/v1/alipay/getAliPayPost"&service="mobile.securitypay.pay"&payment_type="1"&_input_charset="utf-8"&it_b_pay="30m"&sign="fvH1iBtb%2B4royZMNMYbZXNgGRiRwGzj2lc%2FGpEPGQH6ZzWplFA5lZbO6O4CdZpEGlJPyv1i6zn8eLz0X05OLE8hy1sQTvOrYl%2FR9pg9xYwcfzYoCzaxg%2BG2GREE3afmhZJ64T7mwH%2FiDpIzX4ZTqp31dWky2lWESqNPRSxUwREQ%3D"&sign_type="RSA"
     */

    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
