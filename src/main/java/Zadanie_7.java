import java.util.Random;

public class Zadanie_7 {
    public static void Solve(){
        int[] table = new int[20];
        for(int i = 0; i<table.length; i++)
            table[i] = new Random().nextInt(11);

        String output = new String("");
        for(int i = 0; i < table.length; i++){
            int picked = table[i];
            int count = 0;
            for(int j = 0; j < table.length; j++)
            {
                if(picked == table[j])
                    count++;
            }
            output += "Liczba: " + picked + ", ilosc powtorzen: " + count + '\n';
        }
        System.out.println(output);
    }
}
