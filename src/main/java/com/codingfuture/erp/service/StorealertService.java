package com.codingfuture.erp.service;

import com.codingfuture.erp.entity.Storealert;

import java.util.List;

public interface StorealertService {

    List<Storealert> getstorealert( Integer page, Integer rows);

    Integer getstorealertCount(Integer page, Integer rows);


}
