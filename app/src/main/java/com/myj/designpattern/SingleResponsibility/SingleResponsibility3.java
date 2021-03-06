package com.myj.designpattern.SingleResponsibility;

/**
 * Created by maoyujiao on 2019/8/21.
 *
 * 1. 对类来说的，即一个类应该只负责一项职责。
 * 如类A负责两个不同职责:职责1，职责2。
 * 当职责1需求变更而改变A时，可能造成职责2执行错误，
 * 所以需要将类A的粒度分解为 A1，A2
 *
 * 2.优秀代码是很少有if - else 分支，分支耦合性太高，通过类和方法来减少耦合
 *
 * 单一职责原则注意事项和细节
 1) 降低类的复杂度，一个类只负责一项职责。
 2) 提高类的可读性，可维护性
 3) 降低变更引起的风险
 4) 通常情况下，我们应当遵守单一职责原则，只有逻辑足够简单，才可以在代码级违
 反单一职责原则;只有类中方法数量足够少，可以在方法级别保持单一职责原则
 */

public class SingleResponsibility3 {

    public static void main(String[] args){
        Vehicle vehicle = new Vehicle();
        vehicle.run("汽车");
        vehicle.runAir("飞机");
        vehicle.runWater("轮船");

    }

    /**
     * 1.这种修改方法改动小，只是增加方法
     * 2.未再类上遵守单一职责原则，但在方法上遵守单一职责原则
     */
     static class Vehicle{
        public void run(String vehicle){
            System.out.println(vehicle +"在公路上跑");
        }
        public void runAir(String vehicle){
            System.out.println(vehicle +"在天上跑");
        }

         public void runWater(String vehicle){
             System.out.println(vehicle +"在水上跑");
         }
     }



}
