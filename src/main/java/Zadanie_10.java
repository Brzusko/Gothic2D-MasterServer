import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zadanie_10 {
    private static List<String> slowa = new ArrayList<String>();
    public static void Solve() {
        String slowo = new String();
        Scanner scn = new Scanner(System.in);
        System.out.println("Podaj slowo do tablicy: ");
        while(!(slowo = scn.next()).contains("stop"))
        {
            slowa.add(slowo);
            System.out.println("Jesli chcesz zakonczyc wpisz stop, w przeciwnym raie podaj kolejne slowo");
        }

        slowa.forEach(fraza ->{
            if(fraza.endsWith("a") || fraza.contains("b"))
                System.out.println(fraza);
        });
    }
}

