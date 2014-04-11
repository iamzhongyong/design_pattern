package command;
//µ÷ÓÃÃüÁî
public class CommandInvoker {	
	private Command command;		
	public void action(){
		command.execute();
	}
	public void setCommand(Command command) {
		this.command = command;
	}		
}
