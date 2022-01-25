public class Bank {
	public int noBranches = 0;
    public static KDTree allBanksKDTree = new KDTree();
	public boolean isBranch;
	public Coordination coordination;
	public String bankName;
	public String branchName;
    public String name;
	public KDTree branches;
    public TrieTree branchesNamesTree = new TrieTree(new TrieNode());
	public Bank(Coordination coordination ,  String name){
        this.coordination = coordination ;
        this. bankName = name ;
        this.branchName = null;
        this.name = name;
        branches = new KDTree();
        isBranch = false;
    }
    public Bank(Coordination coordination ,String bankName  ,String branchname){
        this.coordination = coordination ;
        this. bankName = bankName ;
        this.branchName = branchname;
        this.name = branchname;
        branches = null;
        isBranch = true;
    }
    public static void addToKDTree(Bank bank){
        allBanksKDTree.insert(bank);
    }
    public void addBankToTriTree(Bank bank){
         TrieTree.insertBank(this, this.bankName);
    }
    public void addBranch(Bank branch){
    	branches.insert(branch);
        branchesNamesTree.insertBank(branch, branch.name);
    	this.noBranches++;
    }
    public boolean deleteBranch(Bank branch){
    	if(branchesNamesTree.searchForBranch(branchesNamesTree.getRoot(),branch.name) == null)
    		return false;
    	else{
            Node deleted = branches.deleteNode(branches.getRoot(),branches.searchTreeRecursive(branches.getRoot(),
             branch, 0),0 );
            deleted = allBanksKDTree.deleteNode(allBanksKDTree.getRoot(),
                allBanksKDTree.searchTreeRecursive(allBanksKDTree.getRoot(),branch, 0),0 );
            branchesNamesTree.removeBr(branchesNamesTree.getRoot(),branch,0);
    		this.noBranches--;
    		return true;
    	}
    }
    public void getAllBranches(){
    	branches.getAllNodes();
    }
}