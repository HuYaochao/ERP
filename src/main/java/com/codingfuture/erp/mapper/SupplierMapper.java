package com.codingfuture.erp.mapper;


import com.codingfuture.erp.dto.SupplierDTO;
import com.codingfuture.erp.entity.Supplier;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface SupplierMapper {

    List<SupplierDTO> findListByPage(@Param("type") String type,
                                     @Param("supplierDTO") SupplierDTO supplierDTO);

    boolean deleteById(Integer id);

    boolean updateById(SupplierDTO supplierDTO);

    SupplierDTO findById(Integer id);

    boolean add(@Param("type") String type,
            @Param("SupplierDTO") SupplierDTO SupplierDTO);

    List<Supplier> findCustomers(String type);

    /**
     *
     * @author hyc
     * Date: 2024/9/5
     * @version 1.0
     */
    
    List<Supplier> findSuppliersByType(String type);

}
