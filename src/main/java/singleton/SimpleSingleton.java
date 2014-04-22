package singleton;
/**
 * 最简单的单例模式
 */
public class SimpleSingleton {
	
	/**
	 * 构造方法私有化，外部无法通过构造方法创建对象，这样能够屏蔽外部直接new
	 * 还有就是反射了，反射时可以使用setAccessible方法来突破private的限制，
	 * 我们需要做到第一点工作的同时，还需要在在ReflectPermission("suppressAccessChecks") 
	 * 权限下使用安全管理器（SecurityManager）的checkPermission方法来限制这种突破，
	 * 一般来说，不会真的去做这些事情，都是通过应用服务器进行后台配置实现。
	 * 再就是序列化了，序列化会在SimpleSerializableSingleton这个类中做介绍
	 */
	private SimpleSingleton(){}
	
	/**
	 * 类型是static，这样在JVM进行类加载的时候就会做类的实例化，JVM保证线程安全
	 * 根据JLS（Java Language Specification）中的规定，一个类在一个ClassLoader中只会被初始化一次，
	 * 这点是JVM本身保证的，那就把初始化实例的事情扔给JVM好了
	 */
	private static final SimpleSingleton instance = new SimpleSingleton();
	
	//通过一个静态方法，获得这个对象
	public static SimpleSingleton getInstance(){
		return instance;
	}
}
