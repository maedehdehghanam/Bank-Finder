public class Bank {
	public int noBranches = 0;
    public static KDTree allBanksKDTree = new KDTree();
	public boolean isBranch;
	public Coordination coordination;
	public String bankName;
	public String branchName;
    public String name;
	public KDTree branches;
	public Bank(Coordination coordination ,  String name){
        this.coordination = coordination ;
        this. bankName = name ;
        this.branchName = null;
        this.name = name;
        branches = new KDTree();
        branches.insertNodeRecursive(new Node(coordination,this), this, 0);
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
        allBanksKDTree.insertNodeRecursive(allBanksKDTree.getRoot(),bank,0);
    }
    public void addBankToTriTree(Bank bank){
         TrieTree.insertBank(this, this.bankName);
    }
    public void addBranch(Bank branch){
    	branches.insertNodeRecursive(branches.getRoot(), branch, 0);
    	this.noBranches++;
    }
    public boolean deleteBranch(Bank branch){
    	if(branches.searchTreeRecursive(branches.getRoot(), branch, 0) == null)
    		return false;
    	else{
    		this.noBranches--;
    		return true;
    	}
    }
    public void getAllBranches(Node node){
    	branches.getAllNodes();
    }
}