/**
 * @Package xin.xin.eshore.aop
 * @Title: UserServiceLogger
 * @Description: 用户业务日志输出
 * @Author: 5776范仲旭
 * @Date: 2018-05-16 8:56
 **/
package xin.eshore.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;

/**
 * @Title: UserServiceLogger
 * @Description: 用户业务日志输出
 * @Author: 5776范仲旭
 * @Date: 2018-05-16 8:56
 **/
public class UserServiceLogger {

    private static final Logger log = Logger.getLogger(UserServiceLogger.class);

    // 前置增强
    public void before(JoinPoint joinpoint) {
        log.info("调用" + joinpoint.getTarget() + "的" + joinpoint.getSignature().getName() + "方法。方法入参" + Arrays.toString(joinpoint.getArgs()));
    }

    // 后置增强
    public void afterReturning(JoinPoint joinpoint, Object result) {
        log.info("调用" + joinpoint.getTarget() + "的" + joinpoint.getSignature().getName() + "方法。方法返回值" + result);
    }

    // 异常抛出的方法
    public void afterThrowing(JoinPoint jp, RuntimeException e) {
        log.error(jp.getSignature().getName() + "方法发生异常:" + e);
    }

    // 最终增强
    public void afterLogger(JoinPoint jp) {
        log.info(jp.getSignature().getName() + "方法结束执行");
    }

    //环绕增强
    public Object aroundLogger(ProceedingJoinPoint pjp) throws Throwable {
        log.info("调用" + pjp.getTarget() + "的" + pjp.getSignature().getName() + "方法。方法入参" + Arrays.toString(pjp.getArgs()));
        Object result;
        try {
            result = pjp.proceed();

        } catch (Throwable e) {
            log.error(pjp.getSignature().getName() + "方法发生异常:" + e);
            throw e;
        } finally {
            log.info(pjp.getSignature().getName() + "方法结束执行");
        }
        return result;
    }

}
