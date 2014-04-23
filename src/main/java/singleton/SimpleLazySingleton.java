package singleton;
/**
 * 单例模式的懒加载策略，不在类加载的时候进行实例化，而是在第一次调用的时候进行
 */
public class SimpleLazySingleton {

	//私有构造方法
	private SimpleLazySingleton(){}
	
	//在类加载的时候，这个对象不进行实例化,volatile变量，拥有可见性
	private static volatile SimpleLazySingleton instance = null;
	
	/**
	 * @deprecated
	 * 这种会有线程安全问题，因为可能存在多线程访问这个方法，这个时候对象就有可能不是单例的
	 */
	public static SimpleLazySingleton getInstanceNotSafe(){
		if(instance == null){
			instance = new SimpleLazySingleton();
		}
		return instance;
	}
	
	/**
	 * @deprecated
	 * 做一个简单的处理，就是在getInstance的时候添加锁关键字
	 * 但是这样有个问题，就是所有的getInstance操作全部加锁，性能会下降很多
	 */
	public static synchronized SimpleLazySingleton getInstanceSyncSafe(){
		if(instance == null){
			instance = new SimpleLazySingleton();
		}
		return instance;
	}
	
	/**
	 * @deprecated
	 * 那就做锁的细化吧，把锁的处理挪到方法体内部，仅仅在instance为空的时候，再去加锁
	 */
	public static SimpleLazySingleton getInstanceSyncNotSafe(){
		if(instance == null){
			synchronized (SimpleLazySingleton.class) {
				instance = new SimpleLazySingleton();
			}
		}
		return instance;
	}
	
	/**
	 * 那就做锁的细化吧，把锁的处理挪到方法体内部，仅仅在instance为空的时候，再去加锁
	 */
	public static SimpleLazySingleton getInstance(){
		if(instance == null){
			synchronized (SimpleLazySingleton.class) {
				/**
				 * 这里称之为double-check-lock，为啥要做这不操作呢？
				 * 因为可能有多个线程进入第一个“if(instance == null)”，这个时候，线程去强占锁，
				 * 抢到锁的线程进行instance的初始化操作，完了之后释放锁，
				 * 第二个线程获得锁，这个时候进入之后，如果没有判空操作，会再一次初始化了实例，这时候就不是单例了
				 */
				if(instance == null){
					instance = new SimpleLazySingleton();
				}
			}
		}
		return instance;
	}
}
