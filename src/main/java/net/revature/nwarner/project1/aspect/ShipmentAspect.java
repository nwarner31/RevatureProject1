package net.revature.nwarner.project1.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ShipmentAspect {

    Logger logger = Logger.getLogger(ShipmentAspect.class);

    @Before("execution(* get*Shipment*(..))")
    public void beforeGetShipment(JoinPoint jp) {
        logger.info(String.format("Executing SELECT: %s", jp.getSignature()));
    }

    @Before("execution(* addShipment*(..))")
    public void beforeAddShipment(JoinPoint jp) {
        logger.info(String.format("Executing INSERT: %s", jp.getSignature()));
    }

    @Before("execution(* updateShipment*(..))")
    public void beforeUpdateShipment(JoinPoint jp) {
        logger.info(String.format("Executing UPDATE: %s", jp.getSignature()));
    }

    @Before("execution(* deleteShipment*(..))")
    public void beforeDeleteShipment(JoinPoint jp) {
        logger.info(String.format("Executing DELETE: %s", jp.getSignature()));
    }
}
