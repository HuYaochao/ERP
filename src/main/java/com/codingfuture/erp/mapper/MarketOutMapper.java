package com.codingfuture.erp.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface MarketOutMapper {
    boolean doOutStore(@Param("uuid") Long uuid,
                       @Param("storeuuid") Long storeuuid);

    boolean doStart(@Param("id") Long id,
                    @Param("name") String name,
                    @Param("date") Date date);


}
