package com.codingfuture.erp.constant;

public interface OrderStatusConstants {
    Integer PENDING_REVIEW = 0; // 未审核
    Integer REVIEWED = 1;      // 已审核
    Integer CONFIRMED = 2;     // 已确认
    Integer STORED = 3;        // 已入库

    String PENDING_REVIEW_MSG = "未审核";
    String REVIEWED_MSG = "已审核";
    String CONFIRMED_MSG = "已确认";
    String STORED_MSG = "已入库";
}