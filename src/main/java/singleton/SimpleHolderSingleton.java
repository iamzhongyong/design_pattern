package singleton;

/**
 * ͨ��Holder����ʽ������,����JVM�Ļ����������̰߳�ȫ
 */
public class SimpleHolderSingleton {
	
	//˽�л�
	private SimpleHolderSingleton(){}

	//������һ��˽�е�XXXHolder�࣬�����Ϊ��static���͵ģ�������JVM�������ʱ��ͻ���ص�������INSTANCE�Ͳ���
	private static class SimpleHolderSingletonHolder{
		//�����ⲿ�������
		static final SimpleHolderSingleton INSTANCE = new SimpleHolderSingleton();
	}
	
	//�������ڵ�һ�ε��õ�ʱ����г�ʼ����������ΪINSTANCE��static�ģ����Խ�����JVM�Ļ����������̰߳�ȫ
	public static SimpleHolderSingleton getInstance(){
		return SimpleHolderSingletonHolder.INSTANCE;
	}
}
