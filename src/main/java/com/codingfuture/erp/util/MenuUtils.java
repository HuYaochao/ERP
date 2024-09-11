package com.codingfuture.erp.util;

import com.codingfuture.erp.dto.MenuDTO;
import com.codingfuture.erp.entity.Menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class MenuUtils {

    /**
     * 将菜单列表转换为菜单 DTO 列表，并将子菜单正确嵌套到父菜单中
     *
     * @param menus 菜单实体对象列表
     * @return 组装后的菜单 DTO 列表
     */
    public static List<MenuDTO> convertToDtoList(List<Menu> menus) {
        // 创建映射以便快速查找父菜单
        Map<String, MenuDTO> menuMap = new HashMap<>();
        List<MenuDTO> rootMenus = new ArrayList<>();
        List<MenuDTO> nonRootMenus = new ArrayList<>();

        // 首先将所有菜单转换为 MenuDto，并根据 pid 分类
        for (Menu menu : menus) {
            MenuDTO dto = convertToDto(menu);
            if (dto != null) {
                menuMap.put(menu.getMenuId(), dto);

                if (menu.getPid() == -1) {
                    // pid 为 -1 时，默认是主页
                    dto.setJump("/");
                    rootMenus.add(dto);
                } else if (menu.getPid() == 0) {
                    // pid 为 0 时表示是根菜单
                    nonRootMenus.add(dto);
                } else {
                    // 将子菜单添加到相应的父菜单的 list 中
                    MenuDTO parentMenu = menuMap.get(menu.getPid().toString());
                    if (parentMenu != null) {
                        parentMenu.getList().add(dto);
                    }
                }
            }
        }

        // 处理 pid 为 0 的菜单，只保留有子菜单的
        for (MenuDTO menuDTO : nonRootMenus) {
            if (menuDTO.getList() != null && !menuDTO.getList().isEmpty()) {
                rootMenus.add(menuDTO);
            }
        }

        return rootMenus;
    }

    /**
     * 将单个 Menu 实体对象转换为 MenuDto 对象
     *
     * @param menu Menu 实体对象
     * @return MenuDto 对象
     */
    public static MenuDTO convertToDto(Menu menu) {
        if (menu == null) {
            return null;
        }

        MenuDTO dto = new MenuDTO();
        dto.setName(menu.getMenuId()); // 设置菜单的 ID 作为 name
        dto.setTitle(menu.getMenuName()); // 设置菜单的名称作为 title
        dto.setIcon(menu.getIcon()); // 设置菜单图标
        dto.setJump(menu.getUrl()); // 设置跳转 URL
        dto.setSpread(menu.getPid() == 0); // 如果 pid 为 0，则设置为展开

        // 初始化子菜单列表
        dto.setList(new ArrayList<>());

        return dto;
    }
}



