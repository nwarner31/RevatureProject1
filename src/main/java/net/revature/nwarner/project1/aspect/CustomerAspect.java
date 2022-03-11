package net.revature.nwarner.project1.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CustomerAspect {


    Logger logger = Logger.getLogger(ProductAspect.class);

    @Before("execution(* get*Customer*(..))")
    public void beforeGetCustomer(JoinPoint jp) {
        logger.info(String.format("Executing SELECT: %s", jp.getSignature()));
    }

    @Before("execution(* addCustomer*(..))")
    public void beforeAddCustomer(JoinPoint jp) {
        logger.info(String.format("Executing INSERT: %s", jp.getSignature()));
    }

    @Before("execution(* updateCustomer*(..))")
    public void beforeUpdateCustomer(JoinPoint jp) {
        logger.info(String.format("Executing UPDATE: %s", jp.getSignature()));
    }

    @Before("execution(* deleteCustomer*(..))")
    public void beforeDeleteCustomer(JoinPoint jp) {
        logger.info(String.format("Executing DELETE: %s", jp.getSignature()));
    }
}
