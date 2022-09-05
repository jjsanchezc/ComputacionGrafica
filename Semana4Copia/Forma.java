package Semana4Copia;

public class Forma {

    public Punto [] puntos;
    public Lado [] lados;
    public int num_puntos;
    public int num_lados;
    public int contPoints = 0;
    public int contEdges = 0;

    /**
     * Setter de los numeros de puntos
     * @param num_puntos
     */
    public void setnum_puntos(int num_puntos){
        this.num_puntos = num_puntos;
        this.puntos = new Punto[this.num_puntos];
    }

    /**
     * Setter de los numeros de lados
     * @param num_lados
     */
    public void setnum_lados(int num_lados){
        this.num_lados = num_lados;
        this.lados = new Lado[this.num_lados];
    }

    /**
     * Metodo para añadir puntos
     * El metodo funciona de la sigueiente manera:
     *  Si el contador de puntos es menor al numero de puntos
     * @param x
     * @param y
     */
    public void addPoint(int x, int y){
        if(contPoints < num_puntos) this.puntos[contPoints++] = new Punto(x,y);
    }

    /**
     * Metodo para añadir lados 
     * @param a
     * @param b
     */
    public void addEdge(int a, int b){
        if(contEdges < num_lados)  this.lados[contEdges++] = new Lado(a,b);
    }
}
