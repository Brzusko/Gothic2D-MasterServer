public class Zadanie_3 {
    public static void Solve(){
        int [] table = {10,13,43,123,1443,33,11,4,5,6,1,50,31,31,43,65,32,13,543,32};

        for (int i = 0; i < table.length-1; i++)
        {
            for (int j = 0; j < table.length-i-1; j++)
            {
                if (table[j] > table[j+1])
                {
                    int temp = table[j];
                    table[j] = table[j+1];
                    table[j+1] = temp;
                }
            }
        }
    }
}
