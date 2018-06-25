package com.weichi.erp.component.fastjson;

import com.alibaba.fastjson.serializer.*;
import com.weichi.erp.component.utils.DateUtils;

/**
 * Created by Wewon on 2018/6/25.
 */
public class JSONStringBuilder {

    final private Object bind;
    private String dateFmt;

    private SerializeWriter out;
    private JSONSerializer serializer;
    private IncludePropertyFilter includePropertyFilter;
    private ExcludePropertyFilter excludePropertyFilter;
    private NamedMapeFilter namedMapeFilter;

    public JSONStringBuilder(Object bind) {
        this.bind = bind;
        this.dateFmt = DateUtils.YYYY_MM_DD;
        this.out = new SerializeWriter();
        this.serializer = new JSONSerializer(out);
    }

    public JSONStringBuilder nameFilter(NameFilter nameFilter) {
        this.serializer.getNameFilters().add(nameFilter);
        return this;
    }

    public JSONStringBuilder propfilter(PropertyFilter prefilter) {
        this.serializer.getPropertyFilters().add(prefilter);
        return this;
    }

    public JSONStringBuilder include(String... props) {
        if (this.includePropertyFilter == null) {
            this.includePropertyFilter = new IncludePropertyFilter();
            this.serializer.getPropertyFilters().add(includePropertyFilter);
        }
        for (String prop : props) {
            this.includePropertyFilter.add(prop);
        }
        return this;
    }

    public JSONStringBuilder exclude(String... props) {
        if (this.excludePropertyFilter == null) {
            this.excludePropertyFilter = new ExcludePropertyFilter();
            this.serializer.getPropertyFilters().add(excludePropertyFilter);
        }
        for (String prop : props) {
            this.excludePropertyFilter.add(prop);
        }
        return this;
    }

    public JSONStringBuilder map(String prop, String toProp) {
        if (namedMapeFilter == null) {
            this.namedMapeFilter = new NamedMapeFilter();
            this.serializer.getNameFilters().add(namedMapeFilter);
        }
        this.namedMapeFilter.put(prop, toProp);
        return this;
    }

    public JSONStringBuilder dateFmt(String fmt) {
        this.dateFmt = fmt;
        return this;
    }

    @Override
    public String toString() {
        serializer.setDateFormat(dateFmt);
        serializer.config(SerializerFeature.WriteDateUseDateFormat, true);
        serializer.write(bind);
        return out.toString();
    }
}
