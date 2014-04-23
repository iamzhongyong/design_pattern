package singleton;

import java.lang.reflect.ReflectPermission;
import java.security.Permission;
/**
 * ��ν�ֹ�ⲿͨ����������������������л�
 */
public class SimpleReflectionSingleton {
	
	private SimpleReflectionSingleton(){}
	
	private static SimpleReflectionSingleton instance = new SimpleReflectionSingleton();
	
	public static SimpleReflectionSingleton getInstance(){
		return instance;
	}
	public static void main(String[] args) throws Exception{
		
		//����JVM�İ�ȫ���,�ڽ��з���У���ʱ���ж�һ���Ƿ��ǡ�singleton��������ǣ��ͽ�ֹ����
		System.setSecurityManager(new SecurityManager(){
			@Override
			public void checkPermission(Permission perm) {
				if (perm instanceof ReflectPermission && "suppressAccessChecks".equals(perm.getName())) {
				     for (StackTraceElement elem : Thread.currentThread().getStackTrace()) {
					      if (elem.getClassName().endsWith("Singleton")) {
					    	  throw new SecurityException();
					      }
				     }
				 }
			}
		});
		
		SimpleReflectionSingleton simple = SimpleReflectionSingleton.getInstance();
		System.out.println(simple);
		
		Class<?> clazz = SimpleReflectionSingleton.class;
		
		SimpleReflectionSingleton ref = (SimpleReflectionSingleton)clazz.newInstance();
		
		System.out.println(ref);
	}
}