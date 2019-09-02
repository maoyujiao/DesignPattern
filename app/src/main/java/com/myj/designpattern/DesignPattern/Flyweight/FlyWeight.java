package com.myj.designpattern.DesignPattern.Flyweight;

/**
 * Created by maoyujiao on 2019/8/28.
 *
 * 基本介绍
 1) 享元模式(Flyweight Pattern) 也叫 蝇量模式: 运
 用共享技术有效地支持大量细粒度的对象
 2) 常用于系统底层开发，解决系统的性能问题。像 数据库连接池，里面都是创建好的连接对象，
 在 这些连接对象中有我们需要的则直接拿来用，避 免重新创建，如果没有我们需要的，则创建一个
 3) 享元模式能够解决重复对象的内存浪费的问题， 当系统中有大量相似对象，需要缓冲池时。
 不需 总是创建新对象，可以从缓冲池里拿。这样可以 降低系统内存，同时提高效率
 4) 享元模式经典的应用场景就是池技术了，String常
 量池、数据库连接池、缓冲池等等都是享元模式 的应用，享元模式是池技术的重要实现方式


 对原理图的说明-即(模式的角色及职责)
 1) FlyWeight 是抽象的享元角色, 他是产品的抽象类, """同时定义出对象的外部状态和内部状态(后面介绍) 的接口""""
 或实现
 2) ConcreteFlyWeight 是具体的享元角色，是具体的产品类，实现抽象角色定义相关业务
 3) UnSharedConcreteFlyWeight 是不可共享的角色，"一般不会出现在享元工厂"（应该是获取该对象后调用其方法时传入）。
 4) FlyWeightFactory 享元工厂类，用于构建一个池容器(集合)， 同时提供从池中获取对象方法

 1) 享元模式提出了两个要求:细粒度和共享对象。这里就涉及到内部状态和外部状态了，即将对象的信息分为两 个部分:内部状态和外部状态
 2) 内部状态指对象共享出来的信息，存储在享元对象内部且不会随环境的改变而改变
 3) 外部状态指对象得以依赖的一个标记，是随环境改变而改变的、不可共享的状态。

 */

public abstract class FlyWeight {
    public abstract void run(User user);
}