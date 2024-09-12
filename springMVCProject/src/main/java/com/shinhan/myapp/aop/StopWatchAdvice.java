package com.shinhan.myapp.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;


//蹂댁“?占쏙옙占�?(Advice)...Spring?占쏙옙 蹂댁“?占쏙옙臾댐옙?? 二쇱뾽臾댁뿉 ?占쏙옙?占쏙옙占�??占쏙옙.
@Component
//@Aspect //보조업무
public class StopWatchAdvice{
	//com.shinhan.myapp.aop2.Calculator?占쏙옙?占쏙옙?占쏙옙 ?占쏙옙?占쏙옙 紐⑤뱺 硫붿꽌?占쏙옙?占쏙옙 StopWatchAdvice 蹂댁“?占쏙옙臾댐옙? ?占쏙옙?占쏙옙?占쏙옙?占쏙옙.
	//二쇱뾽占�? ?占쏙옙?占쏙옙?占쏙옙 StopWatch湲곕뒫?占쏙옙 ?占쏙옙?占쏙옙媛꾨떎.
	@Pointcut("within(com.shinhan.myapp.controller.BoardController)")
	public void pointcutTarget() {}
	
	@Around("pointcutTarget()")
	public Object aa(ProceedingJoinPoint jp) throws Throwable {
//蹂댁“?占쏙옙占�?
		String methodName = jp.getSignature().getName();
		System.out.println("******" + methodName);
		StopWatch watch = new StopWatch("aaaaa");
		watch.start();

		//占쌍억옙占쏙옙
		Object object = jp.proceed();

		
		System.out.println("*****" + methodName);
		watch.stop();
		System.out.println(watch.getTotalTimeMillis());
		System.out.println(watch.prettyPrint());//占쏙옙占쏙옙占� 占쏙옙 占싱쁘곤옙 占쏙옙占쏙옙占썽서 占시곤옙占쏙옙 占쏙옙占쏙옙 占쏙옙占�
		return object;
	}
}