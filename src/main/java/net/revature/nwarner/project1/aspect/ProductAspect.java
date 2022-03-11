package net.revature.nwarner.project1.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ProductAspect {

    Logger logger = Logger.getLogger(ProductAspect.class);

    @Before("execution(* get*Product*(..))")
    public void beforeGetProduct(JoinPoint jp) {
        logger.info(String.format("Executing SELECT: %s", jp.getSignature()));
    }

    @Before("execution(* addProduct*(..))")
    public void beforeAddProduct(JoinPoint jp) {
        logger.info(String.format("Executing INSERT: %s", jp.getSignature()));
    }

    @Before("execution(* updateProduct*(..))")
    public void beforeUpdateProduct(JoinPoint jp) {
        logger.info(String.format("Executing UPDATE: %s", jp.getSignature()));
    }

    @Before("execution(* deleteProduct*(..))")
    public void beforeDeleteProduct(JoinPoint jp) {
        logger.info(String.format("Executing DELETE: %s", jp.getSignature()));
    }
}
