package com.myj.designpattern.DesignPattern.Proxy.cglib;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by maoyujiao on 2019/8/29.
 *
 * 1) 静态代理和JDK代理模式都要求目标对象是实现一个接口,
 * 但是有时候目标对象只是一个单独的对象,并没有实 现任何的接口,这个时候可使用目标对象子类来实现代理-这就是 Cglib 代理
 2) Cglib 代理也叫作子类代理,它是在内存中构建一个子类对象从而实现对目标对象功能扩展, 有些书也将 Cglib 代 理归属到动态代理。
 3) Cglib 是一个强大的高性能的代码生成包,它可以在"""运行期扩展""" java 类与实现 java 接口.
 它广泛的被许多 AOP 的 框架使用,例如 Spring AOP，实现方法拦截
 4) 在AOP编程中如何选择代理模式:
     1. 目标对象需要实现接口，用 JDK 代理
     2. 目标对象不需要实现接口，用 Cglib 代理
     5) Cglib 包的底层是通过使用字节码处理框架 ASM 来转换字节码并生成新的类

 1) 需要引入cglib的jar文件
 2) 在内存中动态构建子类，注意代理的类不能为final，否则报错 java.lang.IllegalArgumentException:
 3) 目标对象的方法如果为final/static,那么就不会被拦截,即不会执行目标对象额外的业务方法.
 *
 */

public class ProxyFactory implements MethodInterceptor{

    private TeacherDao target;

    public ProxyFactory(TeacherDao target) {
        this.target = target;
    }

    public Object getProxyInstance(){
        //创建一个工具类
        //设置父类
        //设置回调函数
        //创建子类对象，即代理
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TeacherDao.class);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("代理开始");
        Object obj = method.invoke(target,objects);
        System.out.println("代理结束");
        return obj;
    }
}
