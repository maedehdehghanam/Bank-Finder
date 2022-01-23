public class Bank {
	public Coordination coordination;
	public String name;
	public  KDTree branches;


	public Bank(Coordination coordination ,  String name){
        this.coordination = coordination ;
        this. name = name ;
        branches = new KDTree();
        TrieTree.insertBank(this, this.name);
    } 
}