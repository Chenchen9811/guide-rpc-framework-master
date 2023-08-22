package com.rpc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class PersonProxy<T> implements InvocationHandler {
    // 持有真实类（被代理类）的实例
    private final T target;

    public PersonProxy(T target) {
        this.target = target;
    }

    // 获取代理对象。
    public <T> T getProxy(Class<?> clazz) {
        // 下面三个参数分别为：被代理类的类加载器、被代理对象实现的所有的接口的字节码数组、执行处理器，用于定义方法的增强规则
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    /**
     * proxy:代表动态代理对象
     * method：代表正在执行的方法
     * args：代表调用目标方法时传入的实参
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理执行" + method.getName() + "方法");
        Object result = method.invoke(target, args);
        System.out.println("方法执行过后:");
        return result;
    }
}
