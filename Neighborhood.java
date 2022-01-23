public class Neighborhood{
	private String name;
	private final Coordination LU ;
    private final Coordination LD ;
    private final Coordination RU ;
    private final Coordination RD ;
    public Neighborhood(Coordination LU, Coordination LD, Coordination RU, Coordination RD, String name) {
        this.LU = LU;
        this.LD = LD;
        this.RU = RU;
        this.RD = RD;
        this.name = name;
        TrieTree.insertNeighborhood(this,this.name);
    }

    public Coordination getLD() {
        return LD;
    }

    public Coordination getLU() {
        return LU;
    }

    public Coordination getRD() {
        return RD;
    }

    public Coordination getRU() {
        return RU;
    }

    public String getName() {
        return name;
    }
}