package com.codingfuture.erp.mapper;

import com.codingfuture.erp.entity.Storealert;

import java.util.List;

public interface StorealertMapper {

    List<Storealert> getstorealert(Integer page,Integer rows);

    Integer getstorealertCount(Integer page, Integer rows);


}
