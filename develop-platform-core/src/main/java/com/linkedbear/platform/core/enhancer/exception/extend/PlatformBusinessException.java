package com.linkedbear.platform.core.enhancer.exception.extend;

import com.linkedbear.platform.core.enhancer.exception.PlatformException;

/**
 * @author LinkedBear
 */
public class PlatformBusinessException extends PlatformException {
    
    public PlatformBusinessException() {
    }
    
    public PlatformBusinessException(String message) {
        super(message);
    }
    
    public PlatformBusinessException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public PlatformBusinessException(Throwable cause) {
        super(cause);
    }
    
    public PlatformBusinessException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
