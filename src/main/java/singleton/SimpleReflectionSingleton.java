package singleton;

import java.lang.reflect.ReflectPermission;
import java.security.Permission;
/**
 * 如何禁止外部通过反射来做单例对象的序列化
 */
public class SimpleReflectionSingleton {
	
	private SimpleReflectionSingleton(){}
	
	private static SimpleReflectionSingleton instance = new SimpleReflectionSingleton();
	
	public static SimpleReflectionSingleton getInstance(){
		return instance;
	}
	public static void main(String[] args) throws Exception{
		
		//启动JVM的安全检察,在进行反射校验的时候，判断一下是否是“singleton”，如果是，就禁止反射
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