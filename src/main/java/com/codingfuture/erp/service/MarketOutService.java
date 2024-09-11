package com.codingfuture.erp.service;


import java.util.Date;

public interface MarketOutService {
    boolean doOutStore(Long uuid, Long storeuuid);

    boolean doStart(Long id, String name, Date date);

}
