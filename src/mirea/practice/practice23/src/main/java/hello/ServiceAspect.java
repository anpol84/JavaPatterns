package hello;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@Slf4j
@Component
@org.aspectj.lang.annotation.Aspect
public class ServiceAspect {
    private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    @Before("execution(* hello.item.ItemService.*(..)) " +
            "|| execution(* hello.order.OrderService.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info(
                "[" + joinPoint.getSignature().getDeclaringTypeName() + "]" +
                        " Entering method \"" + joinPoint.getSignature().getName() + "\" at " +
                        dateFormat.format(new Date()));
    }
}
