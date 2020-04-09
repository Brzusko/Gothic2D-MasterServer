
import java.util.Random;

public class Zadanie_2 {
    public static void Solve(){
        int[][] table = ReturnFilledArray();
        CheckSumOfTable(table);
    }

    public static int[][] ReturnFilledArray(){
        int[][] table = new int[10][5];
        for(int i = 0; i < table.length; i++){
            for(int j = 0; j < table[i].length; j++){
                table[i][j] = new Random().nextInt(21);
            }
        }
        return table;
    }

    public static void CheckSumOfTable(int[][] tableToCheck){
        for(int i = 0; i < tableToCheck.length; i++)
        {
            String output = new String();
            int sum = 0;

            for(int j = 0; j < tableToCheck[i].length; j++) {
                int tempOutput = tableToCheck[i][j];
                output += (" " + tempOutput);
                sum += tempOutput;

                if(j == tableToCheck[i].length - 1)
                {
                    output += (" " + " suma wiersza: " + sum);
                    System.out.println(output);
                }
            }
        }
    }
}
