public class Undo{
	public Object place;
	public String command;
	public 	Undo(Object place, String command){
		this.place = place;
		this.command = command;
	}
	public void undo(){
		Undo c = this;
		if(c.command.equals("addB")){
			 
		} else if(c.command.equals("addBr")){
			//here we have to delete the branch
			System.out.println("here i am");
			Bank b = (Bank) c.place;
			boolean deleted =TrieTree.searchForBank(b.bankName).deleteBranch(b);
			if(deleted)
				System.out.println( b.name + " deleted!");

		} else if(c.command.equals("delBr")){
			Bank b = (Bank) c.place;
			Bank.addToKDTree(b);
	    	TrieTree.searchForBank(b.bankName).addBranch(b);
	    	System.out.println("Branch is successfully added");


		} else if ( c.command.equals("addN")){

		}
	}

}