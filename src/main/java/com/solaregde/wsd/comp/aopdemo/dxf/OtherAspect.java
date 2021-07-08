package com.solaregde.wsd.comp.aopdemo.dxf;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OtherAspect {

    @Before("execution(*  com.solaregde.wsd.comp.aopdemo.dxf.OtherService.calc(..))")
    public void logOther(JoinPoint jp) {
        System.out.println("other aspect");
    }
}
