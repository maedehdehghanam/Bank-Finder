public class TrieNode {

	public Object place;
    public TrieNode[] children = new TrieNode[TrieTree.size];
    public boolean isEndOfWord;
    public String name;

    public TrieNode(){
        isEndOfWord = false ;
        for(int i = 0 ; i < TrieTree.size ; i ++){
            children[i] = null ;
        }
    }

    public TrieNode(Object place, String name){
        isEndOfWord = false ;
        this.place = place;
        this.name = name;
        for(int i = 0 ; i < TrieTree.size ; i ++){
            children[i] = null ;
        }
    }
    public Object getPlaceName(){
    	return name;
    }
    public Object getPlace(){
    	return place;
    }
}
