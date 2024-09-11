package com.codingfuture.erp.service;

import com.codingfuture.erp.dto.SupplierDTO;
import com.codingfuture.erp.entity.Supplier;

import java.util.List;

public interface SupplierService {
    List<SupplierDTO> findListByPage(String type, SupplierDTO supplierDTO);

    boolean deleteById(Integer id);

    boolean updateById(SupplierDTO supplierDTO);

    SupplierDTO findById(Integer id);

    boolean add(String type, SupplierDTO supplierDTO);

    List<Supplier> findCustomers(String type);


    /**
     *
     * @author hyc
     * Date: 2024/9/5
     * @version 1.0
     */
    List<Supplier> getSuppliersByType(String type);
}
