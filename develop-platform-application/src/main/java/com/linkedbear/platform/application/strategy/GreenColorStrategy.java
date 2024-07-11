package com.linkedbear.platform.application.strategy;

import com.linkedbear.platform.core.component.strategy.StrategyHandle;

@StrategyHandle(support = "green")
public class GreenColorStrategy extends ColorStrategy {
    
    @Override
    public Integer invoke(Color value) {
        System.out.println("你绿了~");
        return value.getSize();
    }
}
