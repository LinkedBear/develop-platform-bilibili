package com.linkedbear.platform.application.controller;

import com.linkedbear.platform.application.service.MethodAdvisorService;
import com.linkedbear.platform.application.vo.Person;
import com.linkedbear.platform.core.component.log.annotation.OperationLog;
import com.linkedbear.platform.core.component.log.writer.BusinessLogWriter;
import com.linkedbear.platform.core.util.result.ResultVO;
import jakarta.validation.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class DemoController {
    
    @Autowired
    private MethodAdvisorService methodAdvisorService;
    
    @OperationLog("测试")
    @GetMapping("/test1")
    public Person person() {
        BusinessLogWriter.writeLog("测试动作", "一个测试动作被触发了。。。");
        return new Person("haha", new Date());
    }
    
    @OperationLog("登录")
    @PostMapping("/login")
    public ResultVO login() {
        return ResultVO.success();
    }
 
    @OperationLog("注销")
    @PostMapping("/logout")
    public ResultVO logout() {
        return ResultVO.success();
    }
    
    @GetMapping("/testValidation")
    public Person testValidation(@Email String text) {
        return new Person(text, new Date());
    }
    
    @GetMapping("/testMethodAdvisor")
    public String testMethodAdvisor() {
        methodAdvisorService.test("haha");
        return "success";
    }
}
