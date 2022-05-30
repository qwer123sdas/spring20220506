package study.aop.advice;

import org.aspectj.lang.annotation.AfterThrowing;
import org.springframework.aop.ThrowsAdvice;

public class LogAfterThrowingAdvice implements ThrowsAdvice{
	@AfterThrowing
}
