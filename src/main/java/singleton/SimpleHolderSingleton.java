package singleton;

/**
 * 通过Holder的形式来进行,利用JVM的机制来保障线程安全
 */
public class SimpleHolderSingleton {
	
	//私有化
	private SimpleHolderSingleton(){}

	//类中有一个私有的XXXHolder类，这个因为是static类型的，所以在JVM加载类的时候就会加载到，但是INSTANCE就不会
	private static class SimpleHolderSingletonHolder{
		//持有外部类的属性
		static final SimpleHolderSingleton INSTANCE = new SimpleHolderSingleton();
	}
	
	//这样会在第一次调用的时候进行初始化操作，因为INSTANCE是static的，所以借助了JVM的机制来保障线程安全
	public static SimpleHolderSingleton getInstance(){
		return SimpleHolderSingletonHolder.INSTANCE;
	}
}
