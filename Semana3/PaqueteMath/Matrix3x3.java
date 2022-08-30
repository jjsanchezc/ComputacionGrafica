package PaqueteMath;

import javax.sound.sampled.Port;

/**
 *
 * @author htrefftz
 */
public class Matrix3x3 {
    public double mat[][] = new double [3][3];
    public double mat2[][] = new double [3][3];
    
    public Matrix3x3() {
        //matriz identidad 
        mat[0][0] = 1;
        mat[1][1] = 1;
        mat[2][2] = 1;
        
    }

    //matriz ejemplo con la que se va a multiplicar la matriz identidad
    public Matrix3x3(double x,double y, double z){
        mat2[0][0] = x;
        mat2[1][1] = y;
        mat2[2][2] = z;
    }
    public Matrix3x3(double[][] m){
        this.mat=m;
    }
    
    //metodo para multiplicar una matriz con un punto
    public static Point3 times(Matrix3x3 mat, Point3 point) {
        double tmp;
        double x=0;
        double y=0;
        double z=0;
        for (int j=0;j<3;j++){//recorre las filas
            tmp=mat.mat[0][j]*point.x
                +mat.mat[1][j]*point.y
                +mat.mat[2][j]*point.z; 
                if (j==0){
                    x=tmp;
                }else if (j==1){
                    y=tmp;
                }
                else{
                    z=tmp;
                }
        }
        return new Point3(x,y,z);
    }

    //metodo para multiplicar matriz con matriz
    public static Matrix3x3 times(Matrix3x3 m1, Matrix3x3 m2) {
        int i=0;
        double ans[][] = new double [3][3]; 
        for (int j=0;j<3;j++){
            if(j==0){
                ans[i][j]=m1.mat[i][j]*m2.mat2[i][j]
                    +m1.mat[i+1][j]*m2.mat2[i][j+1]
                    +m1.mat[i+2][j]*m2.mat2[i][j+2];
            }
            else if(j==1){
                ans[i][j]=m1.mat[i][j]*m2.mat2[i][j-1]
                    +m1.mat[i+1][j]*m2.mat2[i][j]
                    +m1.mat[i+2][j]*m2.mat2[i][j+1];
            }
            else if(j==2){
                ans[i][j]=m1.mat[i][j]*m2.mat2[i][j-2]
                +m1.mat[i+1][j]*m2.mat2[i][j-1]
                +m1.mat[i+2][j]*m2.mat2[i][j];
            }
        }
        return new Matrix3x3(ans);
    }

    public static void main(String[]args){
        Matrix3x3 m=new Matrix3x3();
        Matrix3x3 m2=new Matrix3x3(2, 3, 4);
        Point3 p1=new Point3(3, 4, 2);
        times(m,p1);
        times(m,m2);
    }
}

