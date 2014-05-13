package template;

public abstract class AbstractTepmplateMethod {
	
	//����1
	protected abstract void step1();

	//����2
	protected abstract void step2();
	
	//����3
	protected abstract void step3();
	
	//����4
	protected abstract void step4();
	
	/*
	 * ģ�巽������Ϊһ������²���Ҫ���าд����������final����
	 */
	public final void run(){
		System.out.println("start...");
		step1();
		step2();
		hookMethod();
		step3();
		step4();
		System.out.println("end...");
	}
	
	/**
	 * ���ӷ����������ṩ�˼򵥵�ʵ�֣�������Ը�д
	 */
	protected void hookMethod(){
		System.out.println("hook method");
	}
	
	/**
	 * ģ�巽�������ӻص�����
	 */
	public final void runCallback(TemplateClientCallback action){
		System.out.println("start...");
		step1();
		step2();
		hookMethod();
		step3();
		step4();
		System.out.println("end...");
		if(null != action){
			action.action();
		}
	}

}
/**
 * ���ӻص��Ĵ���ģ�巽��֧�ֻص�����
 */
abstract class TemplateClientCallback{
	//�ص����߼������� 
	public abstract void action();
}
