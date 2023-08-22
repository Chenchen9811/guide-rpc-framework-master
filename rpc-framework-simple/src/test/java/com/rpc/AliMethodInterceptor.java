package com.rpc;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class AliMethodInterceptor implements MethodInterceptor {

    /**
     *
     * @param o 被代理对象（增强的对象）
     * @param method 被拦截的方法（需要增强的方法）
     * @param objects 方法的入参
     * @param methodProxy 用于调用原始的方法
     * @return
     * @throws Throwable
     */

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        // 调用方法之前可以执行自己的操作来对被代理类的方法进行增强
        System.out.println("before method:" + method.getName());
        Object result = methodProxy.invokeSuper(o, objects);
        // 调用方法之前也可以执行自己的操作来对被代理类的方法进行增强
        System.out.println("after method:" + method.getName());
        return result;
    }
}
