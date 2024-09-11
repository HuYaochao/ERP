package com.codingfuture.erp.mapper;

import com.codingfuture.erp.dto.AddInventoryQueryDTO;
import com.codingfuture.erp.dto.InventoryQueryDTO;
import com.codingfuture.erp.entity.Inventory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface InventoryMapper {

    Integer addInventory(@Param("inventory") Inventory inventory);

    List<InventoryQueryDTO> getInventoryListByPage(InventoryQueryDTO inventoryQueryDTO);

    InventoryQueryDTO getSelectone(Long id);

    Integer updateInventory(AddInventoryQueryDTO addInventoryQueryDTO);

    Boolean deleteInventory(Long id);
}
