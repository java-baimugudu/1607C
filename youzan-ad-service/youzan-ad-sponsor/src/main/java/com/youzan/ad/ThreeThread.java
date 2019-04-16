package com.youzan.ad;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author Fei
 * @data 2019-04-10 下午 03:33
 */
//使用FutureTask来包装Callable对象
public class ThreeThread {
    public static void main(String[] args) {
        //创建Callable对象
        ThreeThread rt = new ThreeThread();
        //先使用Lambda表达式创建Callable<integer>对象
        FutureTask<Integer> task = new FutureTask<Integer>((Callable<Integer>)()->{
            int i = 0;
            for(i=0;i<100;i++) {
                System.out.println(Thread.currentThread().getName()+"的循环变量i的值 "+ i);
            }
            //call可以有返回值
            return i;
        });
      for (int i=0;i<100;i++){
          System.out.println(Thread.currentThread().getName() + "的循环变量i的值:"+ i);
          if(i==20){
              //实质还是以Callable对象来创建并启动线程的
              new Thread(task,"又返回值得线程").start();
          }
      }
      try {
          System.out.println("子线程的返回值" + task.get());
      }
      catch (Exception e){
          e.printStackTrace();
      }
    }
}
