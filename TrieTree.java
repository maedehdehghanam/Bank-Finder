public class TrieTree{

	public static final int size = 26 ; //number of alphabets
	public static TrieNode rootNeighborhood = new TrieNode();
	public static TrieNode rootBank = new TrieNode();
	public static TrieTree neighborhoodNames= new TrieTree();
	public static TrieTree bankNames= new TrieTree();
    public TrieNode myRoot ;
	public TrieTree() {        
    }
    public TrieTree(TrieNode root){
        this.myRoot = root;
    }
    public TrieNode getRoot(){
        return myRoot;
    }
    
    public static TrieTree getNeighborhoodNames() {
        return neighborhoodNames;
    }
    public static TrieTree banks_names() {
        return bankNames;
    }
    public static void insertNeighborhood(Object neighborhood, String neighborhoodsName){

    	TrieNode current = rootNeighborhood;
    	int index = 0;
    	for (int level = 0; level < neighborhoodsName.length() ; level++)
        {
            index = neighborhoodsName.charAt(level) - 'a';
            if (current.children[index] == null)
                current.children[index] = new TrieNode();

            current= current.children[index];
        }
        current.isEndOfWord = true;
        current.name = neighborhoodsName;
        current.place= neighborhood;

    }
    public static void insertBank(Object bank, String banksName){

    	TrieNode current = rootBank;
    	int index = 0;
    	for (int level = 0; level < banksName.length() ; level++)
        {
            index = banksName.charAt(level) - 'a';
            if (current.children[index] == null)
                current.children[index] = new TrieNode();

            current= current.children[index];
        }
        current.isEndOfWord = true;
        current.name = banksName;
        current.place= bank;

    }
    
    public static Neighborhood searchForNeighborhood(String key){
        int index ;
        TrieNode current = rootNeighborhood;
        for (int level = 0; level < key.length(); level++)
        {
            index = key.charAt(level) - 'a';
            if (current.children[index] == null)
                return null;

            current= current.children[index];
        }

        if(current != null && current.isEndOfWord){
            return (Neighborhood ) current.getPlace();
        }
        return null;
    }

    public static Bank searchForBank(String key){
        int index ;
        TrieNode current = rootBank;
        for (int level = 0; level < key.length(); level++)
        {
            index = key.charAt(level) - 'a';
            if (current.children[index] == null)
                return null;

            current=  current.children[index];
        }

        if(current != null && current.isEndOfWord){
            return (Bank) current.getPlace();
        }
        return null;
    }
    /////
    public void insertBranch(TrieNode root, Object bank, String banksName){
        TrieNode current = root;
        int index = 0;
        for (int level = 0; level < banksName.length() ; level++)
        {
            index = banksName.charAt(level) - 'a';
            if (current.children[index] == null)
                current.children[index] = new TrieNode();

            current= current.children[index];
        }
        current.isEndOfWord = true;
        current.name = banksName;
        current.place= bank;
    }
    
    public Bank searchForBranch(TrieNode root, String key){
        int index ;
        TrieNode current = root;
        for (int level = 0; level < key.length(); level++)
        {
            index = key.charAt(level) - 'a';
            if (current.children[index] == null)
                return null;

            current=  current.children[index];
        }

        if(current != null && current.isEndOfWord){
            return (Bank) current.getPlace();
        }
        return null;
    }

    //////
    public TrieNode removeBr(TrieNode root, Bank br, int depth)
    {

        if (root == null)
            return null;

        if (depth == br.name.length()) {


            if (root.isEndOfWord)
                root.isEndOfWord = false;

            if (isEmpty(root)) {
                root = null;
            }

            return root;
        }


        int index = br.name.charAt(depth) - 'a';
        root.children[index] = removeBr(root.children[index] , br , depth + 1);

        if(isEmpty(root) &&  (!root.isEndOfWord) ) {
            root = null ;
        }

        return  root ;

    }
    boolean isEmpty(TrieNode root)
    {
        for (int i = 0; i < TrieTree.size; i++)
            if (root.children[i] != null)
                return false;

        return true;
    }
    /////////////
}