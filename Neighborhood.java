public class Neighborhood{
	private String name;
	private Coordination LU ;
    private Coordination LD ;
    private Coordination RU ;
    private Coordination RD ;
    public Neighborhood(Coordination LU, Coordination LD, Coordination RU, Coordination RD, String name) {
        this.LU = LU;
        this.LD = LD;
        this.RU = RU;
        this.RD = RD;
        this.name = name;
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