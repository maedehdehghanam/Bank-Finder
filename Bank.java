public class Bank {
	public boolean isBranch;
	public Coordination coordination;
	public String bankName;
	public String branchName;
	public KDTree branches;
	public Bank(Coordination coordination ,  String name){
        this.coordination = coordination ;
        this. bankName = name ;
        this.branchName = null;
        branches = new KDTree();
        TrieTree.insertBank(this, this.name);
        branches.insertNodeRecursive(new Node(coordination,this), this, 0);
        isBranch = false;
    }
    public Bank(Coordination coordination ,String bankName  ,String branchname){
        this.coordination = coordination ;
        this. bankName = bankName ;
        this.branchName = branchname;
        branches = null;
        isBranch = true;
    }
    public void addBranch(Bank branch){
    	branches.insertNodeRecursive(branches.getRoot(), branch, 0);
    }
    public boolean deleteBranch(Bank branch){
    	if(branches.searchTreeRecursive(branches.getRoot(), branch, 0) == null)
    		return false;
    	else{

    		return true;
    	}
    }
    public void getAllBranches(Node node){
    	branches.getAllNodes();

    }
}