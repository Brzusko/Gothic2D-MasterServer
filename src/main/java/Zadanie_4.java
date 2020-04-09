import java.util.Random;

public class Zadanie_4 {
    public static void Solve(){
        int[][] m1 = GenerateMatrix4x4();
        int[][] m2 = GenerateMatrix4x4();
        int[][] sum = Matrix4x4Sum(m1,m2);
    }

    public static int[][] GenerateMatrix4x4(){
        int[][] matrix4x4 = new int[4][4];
        for(int i = 0; i<matrix4x4.length; i++)
            for(int j = 0; j<matrix4x4[i].length; j++)
                matrix4x4[i][j] = new Random().nextInt(101);
        return matrix4x4;
    }

    public static int[][] Matrix4x4Sum(int[][] leftMatrix, int[][] rightMatrix){
        int[][] matrix4x4 = new int[4][4];
        for(int i = 0; i<matrix4x4.length; i++)
            for(int j = 0; j<matrix4x4[i].length; j++)
                matrix4x4[i][j] = leftMatrix[i][j] + rightMatrix[i][j];
        return matrix4x4;
    }
}
