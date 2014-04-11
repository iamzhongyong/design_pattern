package receiver;

public class CommandProcessForWindows implements CommandProcess {

	@Override
	public String doSomething() {
		System.out.println("ReceiverCmdForWindows doSomething ");
		return "iamzhongyong windows";
	}

}
