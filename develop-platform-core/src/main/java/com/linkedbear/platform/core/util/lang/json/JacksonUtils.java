package com.linkedbear.platform.core.util.lang.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.linkedbear.platform.core.enhancer.exception.PlatformException;

import java.io.IOException;

/**
 * @author LinkedBear
 */
public abstract class JacksonUtils {
    
    public static JsonNode parse(byte[] arr) {
        try {
            return new ObjectMapper().readTree(arr);
        } catch (IOException e) {
        	throw new PlatformException(e);
        }
    }
}
