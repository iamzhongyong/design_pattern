package template;

public class TemplateMethod extends AbstractTepmplateMethod {

	@Override
	protected void step1() {
		System.out.println("iamzhongyong 1");
	}

	@Override
	protected void step2() {
		System.out.println("iamzhongyong 2");
	}

	@Override
	protected void step3() {
		System.out.println("iamzhongyong 3");
	}

	@Override
	protected void step4() {
		System.out.println("iamzhongyong 4");
	}
	
	
	/**
	 * 钩子方法，子类重新实现
	 */
	@Override
	protected void hookMethod() {
		super.hookMethod();
		System.out.println("template method hook method...");
	}

	public static void main(String[] args) {
		TemplateMethod template = new TemplateMethod();
		
		//模板方法
		template.run();
		
		//带回调功能的模板方法
		template.runCallback(new TemplateClientCallback() {	
			@Override
			public void action() {
				System.out.println("TemplateClientCallback...");
			}
		});
	}
}
