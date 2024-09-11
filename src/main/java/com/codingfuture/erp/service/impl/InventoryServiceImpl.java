package com.codingfuture.erp.service.impl;

import com.codingfuture.erp.dto.AddInventoryQueryDTO;
import com.codingfuture.erp.dto.InventoryQueryDTO;
import com.codingfuture.erp.entity.Inventory;
import com.codingfuture.erp.mapper.InventoryMapper;
import com.codingfuture.erp.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryMapper inventoryMapper;
    @Override
    public Boolean addInventory(AddInventoryQueryDTO addInventoryQueryDTO) {
        Inventory inventory = new Inventory();
        inventory.setStoreUuid(addInventoryQueryDTO.getStoreuuid());
        inventory.setGoodsUuid(addInventoryQueryDTO.getGoodsuuid());
        inventory.setType(addInventoryQueryDTO.getType());
        inventory.setRemark(addInventoryQueryDTO.getRemark());
        inventory.setNum(addInventoryQueryDTO.getNum());
        inventory.setCreateTime(new Date());
        Integer num = inventoryMapper.addInventory(inventory);
        return num > 0;
    }

    @Override
    public List<InventoryQueryDTO> getInventoryListByPage(InventoryQueryDTO inventoryQueryDTO) {

        return inventoryMapper.getInventoryListByPage(inventoryQueryDTO);
    }

    @Override
    public InventoryQueryDTO getSelectone(Long id) {
        return inventoryMapper.getSelectone(id);
    }

    @Override
    public Boolean updateInventory(AddInventoryQueryDTO addInventoryQueryDTO) {
       Integer num = inventoryMapper.updateInventory(addInventoryQueryDTO);
        return num > 0;
    }

    @Override
    public Boolean deleteInventory(Long id) {
        return inventoryMapper.deleteInventory(id);
    }
}
