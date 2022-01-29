public class Undo{
	public Object place;
	public String command;
	public 	Undo(Object place, String command){
		this.place = place;
		this.command = command;
	}
	public void undo(Undo c){
		if(c.command.equals("addB")){
			
		} else if(c.command.equals("addBr")){
			//here we have to delete the branch
			

		} else if(c.command.equals("delBr")){

		} else if ( c.command.equals("addN")){

		}
	}

}