public class TrieTree{
	public static TrieTree neighborhoodNames;
	public static TrieTree bankNames;

	private TrieTree() {        
    }
    
    public static TrieTree getNeighborhoodNames() {
        if(neighborhoodNames== null) {
            neighborhoodNames = new TrieTree();
        }
        
        return neighborhoodNames;
    }
    public static TrieTree banks_names() {
        if(banksNames== null) {
            banksNames = new TrieTree();
        }
        
        return banksNames;
    }
}