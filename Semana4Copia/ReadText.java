package Semana4Copia;

import java.io.File;
import java.util.Scanner;

public class ReadText {
    public static Shape read() throws Exception{
        File doc = new File("C:\\Users\\user\\OneDrive\\Documents\\ing.sistemas\\SEMESTRE6\\ComputacionGrafica\\Entregas\\Semana4Copia\\info.txt");
        
        Scanner obj = new Scanner(doc);
        Shape shape = new Shape();

        int flag = 0;
        while (obj.hasNextLine()){
            String line = obj.nextLine();
            if(flag == 0){
                shape.setNPoints(Integer.parseInt(line));
                flag++;
                continue;
            }
            if(flag == 1){
                int a = Integer.parseInt(line.split(" ")[0]);
                int b = Integer.parseInt(line.split(" ")[1]);
                shape.addPoint(a,b);
                if(shape.contPoints == shape.nPoints) flag = 2;
                continue;
            }
            if(flag == 2){
                shape.setNEdges(Integer.parseInt(line));
                flag++;
                continue;
            }

            if(flag == 3) {
                int a = Integer.parseInt(line.split(" ")[0]);
                int b = Integer.parseInt(line.split(" ")[1]);
                shape.addEdge(a, b);
                if (shape.contEdges == shape.nEdges) flag = 4;
            }
        }
        return shape;
    }
}

