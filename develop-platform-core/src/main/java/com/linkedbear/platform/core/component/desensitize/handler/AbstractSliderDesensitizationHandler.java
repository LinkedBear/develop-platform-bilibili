package com.linkedbear.platform.core.component.desensitize.handler;

import java.lang.annotation.Annotation;

/**
 * 基于滑动设计的数据脱敏处理器
 * @param <T>
 * @author LinkedBear
 */
public abstract class AbstractSliderDesensitizationHandler<T extends Annotation> implements DesensitizationHandler<T> {
    
    @Override
    public String desensitize(String origin, T annotation) {
        int prefixKeep = getPrefixKeep(annotation);
        int suffixKeep = getSuffixKeep(annotation);
        String replacer = getReplacer(annotation);
        int length = origin.length();
        
        // 1) 原始字符串长度小于等于保留长度，则原始字符串全部替换
        if (prefixKeep >= length || suffixKeep >= length) {
            return buildReplacerByLength(replacer, length);
        }
        
        // 2) 原始字符串长度小于等于前后缀保留字符串长度，则原始字符串全部替换
        if ((prefixKeep + suffixKeep) >= length) {
            return buildReplacerByLength(replacer, length);
        }
        
        // 3) 原始字符串长度大于前后缀保留字符串长度，则替换中间字符串
        int interval = length - prefixKeep - suffixKeep;
        return origin.substring(0, prefixKeep) + buildReplacerByLength(replacer, interval) + origin.substring(
                prefixKeep + interval);
    }
    
    /**
     * 根据长度循环构建替换符
     * @param replacer
     * @param length
     * @return
     */
    private String buildReplacerByLength(String replacer, int length) {
        StringBuilder builder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            builder.append(replacer);
        }
        return builder.toString();
    }
    
    /**
     * 前缀保留长度
     * @param annotation
     * @return
     */
    public abstract Integer getPrefixKeep(T annotation);
    
    /**
     * 后缀保留长度
     * @param annotation
     * @return
     */
    public abstract Integer getSuffixKeep(T annotation);
    
    /**
     * 替换符
     * @param annotation
     * @return
     */
    public abstract String getReplacer(T annotation);
}
