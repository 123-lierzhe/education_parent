package com.sjzc.domain;

import lombok.Data;

import java.util.Date;

/**
 * @Auther liez
 * @Date 16:29 2020/12/24
 */
@Data
public class PayLog {

    private String id;
    private String orderNo;
    private Date payTime;
    private String totalFee;
    private String transactionId;
    private String tradeState;
    private String payType;
    private String attr;
    private int isDeleted;
    private Date gmtCreate;
    private Date gmtModified;
}
