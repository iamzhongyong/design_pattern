package singleton;
/**
 * ����ģʽ�������ز��ԣ���������ص�ʱ�����ʵ�����������ڵ�һ�ε��õ�ʱ�����
 */
public class SimpleLazySingleton {

	//˽�й��췽��
	private SimpleLazySingleton(){}
	
	//������ص�ʱ��������󲻽���ʵ����,volatile������ӵ�пɼ���
	private static volatile SimpleLazySingleton instance = null;
	
	/**
	 * @deprecated
	 * ���ֻ����̰߳�ȫ���⣬��Ϊ���ܴ��ڶ��̷߳���������������ʱ�������п��ܲ��ǵ�����
	 */
	public static SimpleLazySingleton getInstanceNotSafe(){
		if(instance == null){
			instance = new SimpleLazySingleton();
		}
		return instance;
	}
	
	/**
	 * @deprecated
	 * ��һ���򵥵Ĵ���������getInstance��ʱ��������ؼ���
	 * ���������и����⣬�������е�getInstance����ȫ�����������ܻ��½��ܶ�
	 */
	public static synchronized SimpleLazySingleton getInstanceSyncSafe(){
		if(instance == null){
			instance = new SimpleLazySingleton();
		}
		return instance;
	}
	
	/**
	 * @deprecated
	 * �Ǿ�������ϸ���ɣ������Ĵ���Ų���������ڲ���������instanceΪ�յ�ʱ����ȥ����
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
	 * �Ǿ�������ϸ���ɣ������Ĵ���Ų���������ڲ���������instanceΪ�յ�ʱ����ȥ����
	 */
	public static SimpleLazySingleton getInstance(){
		if(instance == null){
			synchronized (SimpleLazySingleton.class) {
				/**
				 * �����֮Ϊdouble-check-lock��ΪɶҪ���ⲻ�����أ�
				 * ��Ϊ�����ж���߳̽����һ����if(instance == null)�������ʱ���߳�ȥǿռ����
				 * ���������߳̽���instance�ĳ�ʼ������������֮���ͷ�����
				 * �ڶ����̻߳���������ʱ�����֮�����û���пղ���������һ�γ�ʼ����ʵ������ʱ��Ͳ��ǵ�����
				 */
				if(instance == null){
					instance = new SimpleLazySingleton();
				}
			}
		}
		return instance;
	}
}
