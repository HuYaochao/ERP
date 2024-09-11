package com.codingfuture.erp.service;

import com.codingfuture.erp.dto.AddInventoryQueryDTO;
import com.codingfuture.erp.dto.InventoryQueryDTO;

import java.util.List;

public interface InventoryService {
    Boolean addInventory(AddInventoryQueryDTO addInventoryQueryDTO);

    List<InventoryQueryDTO> getInventoryListByPage(InventoryQueryDTO inventoryQueryDTO);


    InventoryQueryDTO getSelectone(Long id);

    Boolean updateInventory(AddInventoryQueryDTO addInventoryQueryDTO);

    Boolean deleteInventory(Long id);
}
