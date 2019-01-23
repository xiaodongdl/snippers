package com.robert.jvm.classloader.hcr;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/** 
* Ĭ�ϴ������� 
* @author Robert 
*/  
public class DefaultInvocationHandler implements InvocationHandler {  

  /** 
   * Ŀ����� 
   */  
  protected Object target;  

  public DefaultInvocationHandler() {  
    
  }  

  /** 
   * ������ 
   */  
  public Object invoke(Object proxy, Method method, Object[] args)  
          throws Throwable {  
      System.out.println("before invoke");  
      Object returnValue = method.invoke(target, args);  
      System.out.println("after invoke");  
      return returnValue;  
  }  

  public Object getTarget() {  
      return target;  
  }  

  public void setTarget(Object target) {  
      this.target = target;  
  }  
}  
