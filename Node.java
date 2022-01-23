public class Node{
	public object place ;
    public Coordination coordination ;
    public Node left = null ;
    public Node right = null ;
    public Node(Coordination coordination , object place) {
        this.place = place ;
        this.coordination = coordination ;

    }
    public String getCoordination(){
        return place.name() +": " + coordination.toString();
}