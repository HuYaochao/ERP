package com.codingfuture.erp.service.impl;

import com.codingfuture.erp.dto.SupplierDTO;
import com.codingfuture.erp.entity.Supplier;
import com.codingfuture.erp.mapper.SupplierMapper;
import com.codingfuture.erp.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierMapper supplierMapper;

    @Override
    public List<SupplierDTO> findListByPage(String type, SupplierDTO supplierDTO) {
        List<SupplierDTO> result = supplierMapper.findListByPage(type, supplierDTO);
        return result;
    }

    @Override
    public boolean deleteById(Integer id) {
        return supplierMapper.deleteById(id);
    }

    @Override
    public boolean updateById(SupplierDTO supplierDTO) {
        return supplierMapper.updateById(supplierDTO);
    }

    @Override
    public SupplierDTO findById(Integer id) {
        return supplierMapper.findById(id);
    }

    @Override
    public boolean add(String type, SupplierDTO supplierDTO) {
        return supplierMapper.add(type, supplierDTO);
    }

    @Override
    public List<Supplier> findCustomers(String type) {
        return supplierMapper.findCustomers(type);

    }
    
    /**
     *
     * @author hyc
     * Date: 2024/9/5
     * @version 1.0
     */

    @Override
    public List<Supplier> getSuppliersByType(String type) {
        return supplierMapper.findSuppliersByType(type);
    }
    
}
