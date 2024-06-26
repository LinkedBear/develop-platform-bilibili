package com.linkedbear.platform.core.constant;

/**
 * 固定的常量
 * @author LinkedBear
 */
public interface PlatformConstants {
    
    String ID = "id";
    String VERSION = "version";
    String ISDEL = "del";
    String SORDER = "sorder";
    String PASSWORD = "password";
    
    String SPRING = "spring";
    
    String COUNT_STATEMENT_SUFFIX = "_Count_";
    String COUNT_QUERY_FIELD = "C";
    
    String DEFAULT_ENTITY_SUFFIX = "DO";
    
    String ROOT_ID = "00000000000000000000000000000000";
    
    // --------------------
    
    Integer EXIST = 0;
    Integer DELETED = 1;
    
    // --------------------
    
    Integer ENABLE = 1;
    Integer DISABLE = 0;
    
    // --------------------
    
    String[] EDIT_TEXT = {"修改", "更新", "编辑"};
    
    String ERROR_DATA = "errorData";
    String ERROR_MESSAGE = "errorMsg";
    String ERROR_TIME = "errorTime";
    String EXCEPTION_MESSAGE = "exceptionMsg";
    
    // --------------------
    
    String DEFAULT_APPLICATION_NAME = "Application";
}
