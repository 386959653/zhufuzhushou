package com.weichi.erp.component.fastjson;

import com.alibaba.fastjson.serializer.NameFilter;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by Wewon on 2018/6/25.
 */
public class NamedMapeFilter implements NameFilter {

    protected Map<String, String> nameMap = Maps.newHashMap();

    public String put(String key, String value) {
        return nameMap.put(key, value);
    }

    @Override
    public String process(Object source, String name, Object value) {
        return nameMap.get(name);
    }
}
