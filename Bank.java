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
        TrieTree.insertBank(this, this.bankName);
        branches.insertNodeRecursive(new Node(coordination,this), this, 0);
        isBranch = false;
        allBanksKDTree.insertNodeRecursive(allBanksKDTree.getRoot(),this,0);
    }
    public Bank(Coordination coordination ,String bankName  ,String branchname){
        this.coordination = coordination ;
        this. bankName = bankName ;
        this.branchName = branchname;
        this.name = branchname;
        branches = null;
        isBranch = true;
        allBanksKDTree.insertNodeRecursive(allBanksKDTree.getRoot(),this,0);
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