package singleton;
/**
 * ��򵥵ĵ���ģʽ
 */
public class SimpleSingleton {
	
	/**
	 * ���췽��˽�л����ⲿ�޷�ͨ�����췽���������������ܹ������ⲿֱ��new
	 * ���о��Ƿ����ˣ�����ʱ����ʹ��setAccessible������ͻ��private�����ƣ�
	 * ������Ҫ������һ�㹤����ͬʱ������Ҫ����ReflectPermission("suppressAccessChecks") 
	 * Ȩ����ʹ�ð�ȫ��������SecurityManager����checkPermission��������������ͻ�ƣ�
	 * һ����˵���������ȥ����Щ���飬����ͨ��Ӧ�÷��������к�̨����ʵ�֡�
	 * �پ������л��ˣ����л�����SimpleSerializableSingleton�������������
	 */
	private SimpleSingleton(){}
	
	/**
	 * ������static��������JVM��������ص�ʱ��ͻ������ʵ������JVM��֤�̰߳�ȫ
	 * ����JLS��Java Language Specification���еĹ涨��һ������һ��ClassLoader��ֻ�ᱻ��ʼ��һ�Σ�
	 * �����JVM����֤�ģ��ǾͰѳ�ʼ��ʵ���������Ӹ�JVM����
	 */
	private static final SimpleSingleton instance = new SimpleSingleton();
	
	//ͨ��һ����̬����������������
	public static SimpleSingleton getInstance(){
		return instance;
	}
}
