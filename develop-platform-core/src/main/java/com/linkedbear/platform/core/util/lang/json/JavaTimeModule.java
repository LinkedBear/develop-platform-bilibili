package com.linkedbear.platform.core.util.lang.json;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.PackageVersion;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import com.linkedbear.platform.core.util.lang.DateFormatUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * 支持jdk8日期格式化的配置
 * @author LinkedBear
 */
public class JavaTimeModule extends SimpleModule {
    
    public JavaTimeModule() {
        super(PackageVersion.VERSION);
        this.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateFormatUtils.DEFAULT_DATETIME_FORMATER));
        this.addDeserializer(LocalDate.class, new LocalDateDeserializer(DateFormatUtils.DEFAULT_DATE_FORMATTER));
        this.addDeserializer(LocalTime.class, new LocalTimeDeserializer(DateFormatUtils.DEFAULT_TIME_FORMATER));
        this.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateFormatUtils.DEFAULT_DATETIME_FORMATER));
        this.addSerializer(LocalDate.class, new LocalDateSerializer(DateFormatUtils.DEFAULT_DATE_FORMATTER));
        this.addSerializer(LocalTime.class, new LocalTimeSerializer(DateFormatUtils.DEFAULT_TIME_FORMATER));
    }
}
