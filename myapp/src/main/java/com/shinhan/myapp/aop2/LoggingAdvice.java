package com.shinhan.myapp.aop2;

import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//보조업무(cross cutting concern)
@Component
@Aspect //AOP를 anotation으로 이용하기 @Aspect = advisor = pointcut + 보조업무(advice) 
public class LoggingAdvice{
	
	@Pointcut("execution(* add(int))" + "|| execution(* add(int, int))" + "|| execution(* selectAll())")
	public void targetMethod() {}
	
	@Pointcut("within(com.shinhan.myapp.aop2.BoardService)")
	public void targeMethod3() {}
	
	
	@Before("targetMethod3()")
	public void f_before() {
		System.out.println("----@Before---");
	}
	
	@After("targetMethod3()")
	public void f_after() {
		System.out.println("----@After---");
	}
	
	@AfterReturning("targerMethod3()")
	public void f_afterReturn() {
		System.out.println("----@AfterReturning---");;
		
	}
	
	//around시점 : target의 주업무 수행 전후
	@Around("targetMethod()") //around시점에 해당 메소드를 소환해준다.
	public Object aroundMethod(ProceedingJoinPoint jp) throws Throwable{
		System.out.println("[메서드 호출 전 : LogginAdvice around()");
		System.out.println(jp.getSignature().getName() + "메서드 호출 전"); //함수 이름을 알 수 있다.

//주업무를 수행한다. (주의!! 주업무는 꼭 수행해야한다.)
		Object object = jp.proceed();

//주업무 수행후 돌아와서 수행한다. 
		System.out.println("[메서드 호출 후 : loggingAdvice around()");
		System.out.println(jp.getSignature().getName() + "메서드 호출 후");
		return object;
	}
}