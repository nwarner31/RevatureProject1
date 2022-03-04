package net.revature.nwarner.project1.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ProductAspect {

    Logger logger = LogManager.getLogger(ProductAspect.class);

    @Before("execution(* getAllProducts(..))")
    public void beforeGetProduct(JoinPoint jp) {
        System.out.println("In aspect");
        logger.info(String.format("Executing SELECT: %s", jp.getSignature()));
    }
}
