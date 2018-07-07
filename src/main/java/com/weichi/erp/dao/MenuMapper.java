package com.weichi.erp.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.weichi.erp.domain.Menu;

import java.util.List;
import java.util.Map;

public interface MenuMapper extends BaseMapper<Menu> {
    List<Map<String, Object>> listMyMenu(Long userId);

}