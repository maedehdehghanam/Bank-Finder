public class Node{
	public Bank place ;
    public Coordination coordination ;
    public Node left = null ;
    public Node right = null ;
    public Node(Coordination coordination , Bank place) {
        this.place = place ;
        this.coordination = coordination ;

    }
}