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
	 * ���ӷ�������������ʵ��
	 */
	@Override
	protected void hookMethod() {
		super.hookMethod();
		System.out.println("template method hook method...");
	}

	public static void main(String[] args) {
		TemplateMethod template = new TemplateMethod();
		
		//ģ�巽��
		template.run();
		
		//���ص����ܵ�ģ�巽��
		template.runCallback(new TemplateClientCallback() {	
			@Override
			public void action() {
				System.out.println("TemplateClientCallback...");
			}
		});
	}
}
