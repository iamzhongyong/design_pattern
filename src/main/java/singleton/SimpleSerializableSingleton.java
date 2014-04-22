package singleton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 如果单例的类实现了序列化接口，这个时候需要做一下特殊处理，
 */
public class SimpleSerializableSingleton implements java.io.Serializable{

	private static final long serialVersionUID = -589503673156379879L;
	
	//屏蔽外部new的实例化 
	private SimpleSerializableSingleton(){}
	
	private static SimpleSerializableSingleton instance = new SimpleSerializableSingleton();
	
	public static SimpleSerializableSingleton getInstance(){
		return instance;
	}
	
	/**
	 * 这个方法，会在发序列化构建对象的时候调用到，如果不这么处理
	 * 反序列化之后的对象，是另外一个内存地址，也就是说不再是单例的了
	 */
	private Object readResolve() { 
		System.out.println("readResolve,被调用了");
        return getInstance();  
    }  
	
	public static void main(String[] args) throws Exception {
		SimpleSerializableSingleton simple = SimpleSerializableSingleton.getInstance();
		//获得单例对象的内存地址
		System.out.println(simple);
		//定义序列化写入的文件
		File file = new File("d:\\git\\serializable");
		//构造objectOutputStream
		ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(file));
		//写入对象
		outStream.writeObject(simple);
		outStream.close();
		
		//反序列化
		ObjectInputStream inStream = new ObjectInputStream(new FileInputStream(file));
		SimpleSerializableSingleton simpeFromSeria = (SimpleSerializableSingleton)inStream.readObject();
		System.out.println(simpeFromSeria);
		inStream.close();
	}

}
