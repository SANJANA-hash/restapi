package com.examly.springapp.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect  // ✅ Marks this class as an Aspect
@Component  // ✅ Allows Spring to detect it
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);  // ✅ Logger

        @Pointcut("execution(* com.examly.springapp.service.*.*(..))")  
            public void serviceMethods() {}

                @Before("serviceMethods()")
                    public void logBeforeMethodExecution() {
                            logger.info("Method execution started...");  // ✅ Logging statement
                                }

                                    @AfterReturning("serviceMethods()")
                                        public void logAfterMethodExecution() {
                                                logger.info("Method execution completed successfully.");  // ✅ Logging statement
                                                    }

                                                        @AfterThrowing("serviceMethods()")
                                                            public void logMethodException() {
                                                                    logger.info("An exception occurred during method execution.");  // ✅ Logging statement
                                                                        }
                                                                        }