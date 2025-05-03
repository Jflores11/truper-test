package com.truper.prueba.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeExecutionAspect {

  private final Logger log = LoggerFactory.getLogger(this.getClass());

  private long startTime = 0;
  private long endTime = 0;

  @Before("execution(* com.truper.prueba.service..*(..))")
  public void beforeExecute(JoinPoint joinPoint) {
    startTime = System.currentTimeMillis();
    String methodName = joinPoint.getSignature().getName();
    log.info(">>>>> Iniciando ejecución del método "+ methodName + "()");
  }

  @After("execution(* com.truper.prueba.service..*(..))")
  public void afterExecute(JoinPoint joinPoint) {
    endTime = System.currentTimeMillis();
    long milis = endTime - startTime;
    double seconds = (double) milis / 1000.0;
    String methodName = joinPoint.getSignature().getName();
    log.info(">>>>> La ejecución del método: "+ methodName + "() duró " + seconds + " milisegundos.");
  }

}
