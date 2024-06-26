package com.linkedbear.platform.core.enhancer.exception.extend;

import com.linkedbear.platform.core.enhancer.exception.PlatformException;

/**
 * @author LinkedBear
 */
public class RequestLimitException extends PlatformException {
    
    public RequestLimitException() {
    }
    
    public RequestLimitException(String message) {
        super(message);
    }
    
    public RequestLimitException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public RequestLimitException(Throwable cause) {
        super(cause);
    }
}
