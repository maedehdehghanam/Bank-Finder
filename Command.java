public class Undo{
	public object place;
	public string command;
	public 	Undo(Object place, String command){
		this.place = place;
		this.command = command;
	}
	public void undo(Undo c){
		if(c.command.equals("addB")){
			boolean delete =  TrieTree.searchForBank((Bank) c.place.bankName).deleteBranch((Bank) c.place);
			Node deleted = Bank.allBanksKDTree.deleteNode(Bank.allBanksKDTree.getRoot(),
				Bank.allBanksKDTree.searchTreeRecursive(Bank.allBanksKDTree.getRoot(),(Bank) c.place, 0),0 );
			TrieTree.bankNames.removeBank(TrieTree.bankNames.getRoot(),(Bank) c.place,0);
			System.out.println("hey!deleted");
		} 
	}

}