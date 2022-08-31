package Semana4Copia;

public class Forma {

    public Punto [] puntos;
    public Lado [] lados;
    public int num_puntos;
    public int num_lados;
    public int contPoints = 0;
    public int contEdges = 0;

    public void setNPoints(int num_puntos){
        this.num_puntos = num_puntos;
        this.puntos = new Punto[this.num_puntos];
    }

    public void setNEdges(int num_lados){
        this.num_lados = num_lados;
        this.lados = new Lado[this.num_lados];
    }

    public void addPoint(int x, int y){
        if(contPoints < num_puntos) this.puntos[contPoints++] = new Punto(x,y);
    }

    public void addEdge(int a, int b){
        if(contEdges < num_lados)  this.lados[contEdges++] = new Lado(a,b);
    }
}
