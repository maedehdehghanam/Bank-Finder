public class Coordination {

    public int  x;
    public int  y ;

    public Coordination(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    @Override
    public boolean equals(Object object) {
        Coordination sec  = (Coordination) object ;
        return this.x == sec.x && this.y == sec.y ;
    }

    //GETTER AND SETTER
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

}