package com.robert.jvm.classloader.hcr;

import java.lang.reflect.Method;
  
  
/** 
 * ����java�����������µ��� 
 * @author xuwei 
 * Jul 9, 2008 12:02:26 PM 
 */  
public class HotInvocationHandler extends DefaultInvocationHandler {  
  
    private ClassManager manager;  
  
    public HotInvocationHandler(ClassManager manager) {  
        this.manager = manager;  
    }  
  
    /** 
     * �ڵ�����ʱ�жϸ����Ƿ����±���������������������ķ��� 
     */  
    public Object invoke(Object proxy, Method method, Object[] args)  
            throws Throwable {  
        Object targetObject = null;  
        Class c = target.getClass();  
        Class cNew = manager.reloadClass(c);  
        if (cNew == null) {  
            targetObject = target;  
        } else {  
            targetObject = cNew.newInstance();  
            this.setTarget(targetObject);  
        }  
        Object returnValue = method.invoke(targetObject, args);  
        return returnValue;  
    }  
  
}  
