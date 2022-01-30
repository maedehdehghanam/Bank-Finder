public class Neighborhood{
	public String name;
	public final Coordination LU ;
    public final Coordination LD ;
    public final Coordination RU ;
    public final Coordination RD ;
    public Neighborhood(Coordination LU, Coordination LD, Coordination RU, Coordination RD, String name) {
        this.LU = LU;
        this.LD = LD;
        this.RU = RU;
        this.RD = RD;
        this.name = name;
        TrieTree.insertNeighborhood(this,this.name);
    }
}