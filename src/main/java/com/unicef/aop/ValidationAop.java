package com.unicef.aop;

import com.unicef.exception.CustomValidationException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Aspect
@Component
public class ValidationAop {
    @Pointcut("@annotation(com.unicef.aop.annotation.ValidAspect)")
    private void pointCut(){}

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) throws Throwable{ //리턴할게 없어서 void
        Object[] args = joinPoint.getArgs();
        // 매개변수 하나하나를 의미한다.

        BeanPropertyBindingResult bindingResult = null;

        for(Object arg : args){
            if(arg.getClass() == BeanPropertyBindingResult.class){
                //.getClass = 현재 참조하고 있는 클래스를 확인할 수 있는 메소드
                bindingResult = (BeanPropertyBindingResult) arg;
                break;
            }
        }

        if (bindingResult.hasErrors()) { //bindingResult가 에러를 가지고 있으면 아래를 실행
            Map<String, String> errorMap = new HashMap<String, String>();

            bindingResult.getFieldErrors().forEach(error -> {
                errorMap.put(error.getField(), error.getDefaultMessage());
            });

//            log.info("ValidationAOP 에러!!!! {}", bindingResult);


            throw new CustomValidationException("Validation failed:", errorMap);
//            return ResponseEntity.badRequest().body(new CMRespDto<>(-1, "유효성 검사 실패",errorMap));
        }
//        return joinPoint.proceed();
    }

    @AfterReturning(value = "pointCut()", returning = "returnObj") //before 쓸 때 필요. 메소드로 돌아가게해줌
    public void afterReturning(JoinPoint joinPoint, Object returnObj){
        log.info("Validation success: {}", returnObj);
    }
}



