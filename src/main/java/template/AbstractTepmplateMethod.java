package template;

public abstract class AbstractTepmplateMethod {
	
	//步骤1
	protected abstract void step1();

	//步骤2
	protected abstract void step2();
	
	//步骤3
	protected abstract void step3();
	
	//步骤4
	protected abstract void step4();
	
	/*
	 * 模板方法，因为一般情况下不需要子类覆写，所以增加final变量
	 * 模板方法屏蔽了一些固定步骤，这样的话子类不需要关注步骤的组合，仅仅实现具体的每一个步骤即可
	 * 这个其实也是“好莱坞原则”的体现，子类可以不关心步骤的组合，仅仅调用即可
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
	 * 钩子方法，父类提供了简单的实现，子类可以覆写
	 */
	protected void hookMethod(){
		System.out.println("hook method");
	}
	
	/**
	 * 模板方法，增加回调处理,spring中ORM层中很多都是callback的处理
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
 * 增加回调的处理，模板方法支持回调处理
 */
abstract class TemplateClientCallback{
	//回调的逻辑处理方法 
	public abstract void action();
}
