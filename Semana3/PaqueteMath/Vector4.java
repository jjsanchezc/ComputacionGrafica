package PaqueteMath;

import java.lang.*;
public class Vector4 {
    public double x1;
    public double y1;
    public double x2;
    public double y2;
    
    public Vector4(double x1,double y1,double x2,double y2) {
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;
    }
    
    public static Vector4 crossProduct(Vector4 v1, Vector4 v2) {
        //borrar desde aca
        double c[] = new double[3];
        c[0] = (v1.y2 * v1.y1) * (0) - (0) * (v2.y2 * v2.y1); 
        c[1] = (v1.x2 * v1.x1) * (0) - (0) * (v2.x2 * v2.x1); 
        c[2] = (v1.x2 * v1.x1) * (v2.y2 * v2.y1) - (v1.y2 * v1.y1) * (v2.x2 * v2.x1); 
        return new Vector4(c[0],c[1],c[2],0);
    }
    
    public static double dotProduct(Vector4 v1, Vector4 v2) {
        double product= 0;
        for(int i = 0; i < 2; ++i){
            product = product + ((v1.x1 * v1.x2) *-( v1.y1 *v1.y2 ) * ( (v2.x1 * v2.x2) * (v2.y1 * v2.y2)));
        }
        return product;
    }
    
    public double magnitude() {
        double ans;
            ans=Math.sqrt(Math.pow((x2-x1), 2)+Math.pow((y2-y1),2));
            System.out.println("magnitud: "+ans);
        return ans;
    }
    
    public void normalize() {
        double result[] = new double[2];
        result[0] = (x2-x1)/magnitude();
        result[1] = (y2-y1)/magnitude();
        //como lo ves ? 
    }

    public static void main(String[]args){
        Vector4 v4=new Vector4(5, 1, 1, 2);
        v4.magnitude();
    }
}
