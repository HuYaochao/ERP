package com.codingfuture.erp.mapper;


import com.codingfuture.erp.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * @author hyc
 * Date: 2024/8/31
 * @version 1.0
 */

@Mapper
public interface MenuMapper {

    List<Menu> findMenusByUser(@Param("username") String username);
}

