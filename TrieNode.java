public class TrieNode {

	private Object place;
    private TrieNode[] children = new TrieNode[TrieTree.size];
    private boolean isWord;
    private String name;

    public TrieNode(){
        isWord = false ;
        for(int i = 0 ; i < TrieTree.size ; i ++){
            children[i] = null ;
        }
    }

    public TrieNode(Object place){
        isWord = false ;
        this.place = place;
        this.name = place.getName();
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
