public class TrieTree{

	public static final int size = 26 ; //number of alphabets
	public static TrieNode rootNeighborhood = new TrieNode();
	public static TrieNode rootBank = new TrieNode();
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
    
}