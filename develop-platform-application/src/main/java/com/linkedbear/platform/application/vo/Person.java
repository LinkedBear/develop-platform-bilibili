package com.linkedbear.platform.application.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Person {
    
    private String name;
    
    private Date birthday;
    
}
