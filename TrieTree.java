public class TrieTree{

	public static final int size = 26 ; //number of alphabets
	public  TrieNode rootNeighborhood = new TrieNode();
	public  TrieNode rootBank = new TrieNode();
	public static TrieTree neighborhoodNames= new TrieTree();
	public static TrieTree bankNames= new TrieTree();

	private TrieTree() {        
    }
    
    public static TrieTree getNeighborhoodNames() {
        return neighborhoodNames;
    }
    public static TrieTree banks_names() {
        return bankNames;
    }
    public void insertNeighborhood(Object neighborhood, String neighborhoodsName){

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
    public void insertBank(Object bank, String banksName){

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

    
}