package com.linkedbear.platform.application.strategy;

import com.linkedbear.platform.core.component.strategy.StrategyHandle;

@StrategyHandle(support = "red")
public class RedColorStrategy extends ColorStrategy {
    
    @Override
    public Integer invoke(Color value) {
        System.out.println("选择了红色哈哈哈");
        return value.getSize();
    }
}
