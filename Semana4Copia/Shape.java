package Semana4Copia;

public class Shape {

    public Point [] points;
    public Edge [] edges;
    public int nPoints;
    public int nEdges;
    public int contPoints = 0;
    public int contEdges = 0;

    public void setNPoints(int nPoints){
        this.nPoints = nPoints;
        this.points = new Point[this.nPoints];
    }

    public void setNEdges(int nEdges){
        this.nEdges = nEdges;
        this.edges = new Edge[this.nEdges];
    }

    public void addPoint(int x, int y){
        if(contPoints < nPoints) this.points[contPoints++] = new Point(x,y);
    }

    public void addEdge(int a, int b){
        if(contEdges < nEdges)  this.edges[contEdges++] = new Edge(a,b);
    }
}
