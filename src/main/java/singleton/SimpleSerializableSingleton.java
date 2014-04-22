package singleton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * �����������ʵ�������л��ӿڣ����ʱ����Ҫ��һ�����⴦��
 */
public class SimpleSerializableSingleton implements java.io.Serializable{

	private static final long serialVersionUID = -589503673156379879L;
	
	//�����ⲿnew��ʵ���� 
	private SimpleSerializableSingleton(){}
	
	private static SimpleSerializableSingleton instance = new SimpleSerializableSingleton();
	
	public static SimpleSerializableSingleton getInstance(){
		return instance;
	}
	
	/**
	 * ������������ڷ����л����������ʱ����õ����������ô����
	 * �����л�֮��Ķ���������һ���ڴ��ַ��Ҳ����˵�����ǵ�������
	 */
	private Object readResolve() { 
		System.out.println("readResolve,��������");
        return getInstance();  
    }  
	
	public static void main(String[] args) throws Exception {
		SimpleSerializableSingleton simple = SimpleSerializableSingleton.getInstance();
		//��õ���������ڴ��ַ
		System.out.println(simple);
		//�������л�д����ļ�
		File file = new File("d:\\git\\serializable");
		//����objectOutputStream
		ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(file));
		//д�����
		outStream.writeObject(simple);
		outStream.close();
		
		//�����л�
		ObjectInputStream inStream = new ObjectInputStream(new FileInputStream(file));
		SimpleSerializableSingleton simpeFromSeria = (SimpleSerializableSingleton)inStream.readObject();
		System.out.println(simpeFromSeria);
		inStream.close();
	}

}
