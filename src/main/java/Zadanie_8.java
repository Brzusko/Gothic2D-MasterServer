import java.io.IOException;
import java.util.Scanner;

public class Zadanie_8 {
    public static void Solve() throws IOException {
        int[] binaryContainer = new int[33];
        for(int i = 0; i < binaryContainer.length; i++)
            binaryContainer[i] = 0;

        int numberToConvert = 0;
        System.out.println("Podaj liczbe do wczytania: ");
        Scanner in = new Scanner(System.in);
        numberToConvert = in.nextInt();

        int znak = 0;
        if(numberToConvert < 0)
        {
            znak = 1;
            numberToConvert = numberToConvert * -1;
        }
        else
            znak = 0;

        if(numberToConvert % 2 == 0)
            binaryContainer[32] = 0;
        else
            binaryContainer[32] = 1;

        int i = 31;
        while((numberToConvert = numberToConvert / 2) >= 1)
        {
            if(numberToConvert % 2 == 0)
                binaryContainer[i] = 0;
            else
                binaryContainer[i] = 1;
            System.out.println(numberToConvert);
            i--;
        }
        binaryContainer[i] = znak;
        String output = new String("");
        for(int j = 0; j < binaryContainer.length; j++)
            output += binaryContainer[j];

        System.out.println(output);
    }
}
