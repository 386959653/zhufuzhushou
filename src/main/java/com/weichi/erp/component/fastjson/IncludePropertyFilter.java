package com.weichi.erp.component.fastjson;

import com.alibaba.fastjson.serializer.PropertyFilter;
import com.google.common.collect.Sets;

import java.util.Set;

public class IncludePropertyFilter implements PropertyFilter {
    protected Set<String> propIncSet = Sets.newHashSet();

    public void add(String prop) {
        propIncSet.add(prop);
    }

    @Override
    public boolean apply(Object source, String name, Object value) {
        return propIncSet.contains(name);
    }
}