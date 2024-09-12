package com.shinhan.myapp.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//보조?���?(cross cutting concern)
@Component
@Aspect //(�������� + pointcut) => ��� Ÿ�ֿ̹� ���������� ����ϰڴ�.
public class LoggingAdvice{
	
	@Pointcut("execution(* selectAll())") //��ü������ ��
	public void targetMethod() {}
	
	@Pointcut("within(com.shinhan.myapp.model.BoardService)") //���������� ��
	public void targetMethod3() {}
	
	
	@Before("targetMethod3()")
	public void f_before() {
		System.out.println("----@Before---");
	}
	
	@After("targetMethod3()")
	public void f_after() {
		System.out.println("----@After---");
	}
	
	@AfterReturning("targetMethod3()")
	public void f_afterReturn() {
		System.out.println("----@AfterReturning---");;
		
	}
	
	//around?��?�� : target?�� 주업�? ?��?�� ?��?��
	@Around("targetMethod()") //around?��?��?�� ?��?�� 메소?���? ?��?��?���??��.
	public Object aroundMethod(ProceedingJoinPoint jp) throws Throwable{
		System.out.println("LogginAdvice around()");
		System.out.println(jp.getSignature().getName()); //?��?�� ?��름을 ?�� ?�� ?��?��.

//주업무�?? ?��?��?��?��. (주의!! 주업무는 �? ?��?��?��?��?��?��.)
		Object object = jp.proceed();

//주업�? ?��?��?�� ?��?��???�� ?��?��?��?��. 
		System.out.println("loggingAdvice around()");
		System.out.println(jp.getSignature().getName());
		return object;
	}
}