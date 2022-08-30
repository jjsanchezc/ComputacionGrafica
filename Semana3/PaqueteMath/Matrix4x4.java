package PaqueteMath;

public class Matrix4x4 {
    public double mat[][] = new double[4][4];
    public double mat2[][] = new double [4][4];
    
    public Matrix4x4() {
        mat[0][0] = 3;
        mat[1][1] = 1;
        mat[2][2] = 1;
        mat[3][3] = 1;
    }

    //matriz ejemplo con la que se va a multiplicar la matriz identidad
    public Matrix4x4(double x,double y, double z,double w){
        mat2[0][0] = x;
        mat2[1][1] = y;
        mat2[2][2] = z;
        mat2[3][3] = w;
    }

    public Matrix4x4(double [][] m){
        this.mat=m;
    }
    
    public static Point4 times(Matrix4x4 mat, Point4 point) {
        //this class do 
        double tmp,x=0.0,y=0.0,z=0.0,w=0.0;
        for (int j=0;j<4;j++){
            tmp=mat.mat[0][j]*point.x+mat.mat[1][j]*point.y+mat.mat[2][j]*point.z+mat.mat[3][j]*point.w; 
            if (j==0){
                x=tmp;
            }else if (j==1){
                y=tmp;
            }else if (j==2){
                z=tmp;
            }else{
                w=tmp;
            }
        }
        return new Point4(x,y,z,w);
    }
    
    public static Matrix4x4 times(Matrix4x4 m1, Matrix4x4 m2) {
        double ans[][] = new double [4][4];
        for(int j = 0; j < 4; ++j){//ciclo para recorrer las fila
            if(j==0){
                ans[0][j]=m1.mat[0][j]*m2.mat2[0][j]+m1.mat[1][j]*m2.mat2[0][j+1]+m1.mat[2][j]*m2.mat2[0][j+2];
            }
            else if(j==1){
                ans[0][j]=m1.mat[0][j]*m2.mat2[0][j-1]+m1.mat[1][j]*m2.mat2[0][j]+m1.mat[2][j]*m2.mat2[0][j+1];
            }
            else if(j==2){
                ans[0][j]=m1.mat[0][j]*m2.mat2[0][j-2]+m1.mat[1][j]*m2.mat2[0][j-1]+m1.mat[2][j]*m2.mat2[0][j];
            }
        }
        return new Matrix4x4(ans);
    }

    public static void main(String[]args){
        Matrix4x4 m=new Matrix4x4();
        Matrix4x4 m2=new Matrix4x4(2, 3, 4,6);
        Point4 p1=new Point4(3, 4, 2,6);

        times(m,m2);
        times(m,p1);
    }
}
