public class Punto {
    private double x;
    private double y;

    public Punto(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        //Mi forma:
//        double xAux = ((Punto)obj).getX();
//        double yAux = ((Punto)obj).getY();
//        return (this.x == xAux) && (this.y == yAux);
        //La forma del profe:
        if(!(obj instanceof Punto)){
            return false;
        } else {
            Punto that = (Punto) obj;
            return (this.x == that.x) && (this.y == that.y);
        }
    } //el "(Punto).obj" es castear obj como la clase Punto
}
