package net.revature.nwarner.project1.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class OrderAspect {

//    Logger logger = Logger.getLogger(OrderAspect.class);
//
//    @Before("execution(* get*Order*(..))")
//    public void beforeGetOrder(JoinPoint jp) {
//        logger.info(String.format("Executing SELECT: %s", jp.getSignature()));
//    }
//
//    @Before("execution(* addOrder*(..))")
//    public void beforeAddOrder(JoinPoint jp) {
//        logger.info(String.format("Executing INSERT: %s", jp.getSignature()));
//    }
//
//    @Before("execution(* updateOrder*(..))")
//    public void beforeUpdateOrder(JoinPoint jp) {
//        logger.info(String.format("Executing UPDATE: %s", jp.getSignature()));
//    }
//
//    @Before("execution(* deleteOrder*(..))")
//    public void beforeDeleteOrder(JoinPoint jp) {
//        logger.info(String.format("Executing DELETE: %s", jp.getSignature()));
//    }
}
