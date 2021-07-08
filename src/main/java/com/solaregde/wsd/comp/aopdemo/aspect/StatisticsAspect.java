package com.solaregde.wsd.comp.aopdemo.aspect;

import com.solaregde.wsd.comp.aopdemo.dxf.Request;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect//("perthis(execution(com.solaregde.wsd.comp.aopdemo.dxf.services.ParsingService.parseDxf(..)))")
public class StatisticsAspect {

    private String dxf;

    @Before("execution(* com.solaregde.wsd.comp.aopdemo.dxf.services.ParsingService.parseDxf(..))")
    public void beforeDXF(JoinPoint jp) {
        System.out.println("Before parseDxf " + jp);
        if (dxf != null) {
            System.out.println("Error: not null");
        }
        dxf = getDxf(jp);
    }

    @Before("execution(* com.solaregde.wsd.comp.aopdemo.dxf.services.ParsingService.parseModules(..))")
    public void beforeParseModules(JoinPoint jp) {
        System.out.println("Before parseModules ..." + jp);
        if (dxf == null || !dxf.equals(getDxf(jp))) {
            System.out.println("Error: different dxf. Stored: " + dxf + ". Got " + getDxf(jp));
        }
    }

    @After("execution(* com.solaregde.wsd.comp.aopdemo.dxf.services.ParsingService.parseRoof(..))")
    public void beforeParseRoof(JoinPoint jp) {
        System.out.println("After parseRoof..." + jp);
        if (dxf == null || !dxf.equals(getDxf(jp))) {
            System.out.println("Error: different dxf. Stored: " + dxf + ". Got " + getDxf(jp));
        }
    }

    private String getDxf(JoinPoint jp) {
        Object[] args = jp.getArgs();
        if (args.length > 0) {
            Object firstArgument = args[0];
            if (firstArgument instanceof Request) {
                return ((Request) firstArgument).getDxf();
                // System.out.println("DXF parsing " + ((Request) firstArgument).getDxf());
            } else if (firstArgument instanceof String) {
                return (String) firstArgument;
            }
        }

        return null;
    }
}
