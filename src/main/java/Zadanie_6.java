import java.util.Random;

public class Zadanie_6 {
    private static float _avarageOfTable = 0;
    private static int _max = 0,_min = 0, _countLowerThanAvarage = 0, _countGreaterThanAvarage = 0;
    private static int[] _intTable = new int[10];
    public static void Solve(){
        FillIntTable();
        CalculateAvarage();
        CheckLowerAndGreaterThanAvarage();
        SetGreatestAndLowestValue();

        System.out.println("Srednia jest równa: " + _avarageOfTable);
        System.out.println("Suma liczb wiekszych od sredniej: " + _countGreaterThanAvarage + " , mniejszych: " + _countLowerThanAvarage);
        System.out.println("Maximum: " + _max + " , minimum: " + _min);
        PrintBackward();
    }

    private static void FillIntTable(){
        for(int i = 0; i < _intTable.length; i++)
            _intTable[i] = new Random().nextInt(11) * (new Random().nextBoolean() ? -1 : 1);
    }

    private static void CalculateAvarage() {
        int sum = 0;
        for(int i = 0; i<_intTable.length; i++)
            sum += _intTable[i];
        _avarageOfTable = sum/_intTable.length;
    }

    private static void CheckLowerAndGreaterThanAvarage(){
        for(int i = 0; i <_intTable.length; i++){
            if(_intTable[i] > _avarageOfTable)
                _countGreaterThanAvarage++;
            else
                _countLowerThanAvarage++;
        }
    }

    private static void SetGreatestAndLowestValue(){
        _max = -20;
        _min = 20;
        for(int i = 0; i < _intTable.length; i++){
            if(_intTable[i] > _max )
                _max = _intTable[i];
            if(_intTable[i] < _min)
                _min = _intTable[i];
        }
    }

    private static void PrintBackward(){
        String output = new String("");
        for(int i = _intTable.length - 1; i >=0; i--)
            output += (_intTable[i]) + " ";
        System.out.println(output);
    }
}
