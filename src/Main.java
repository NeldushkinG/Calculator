import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int romanNum(String str){
        String [] rome = {"I","II","III","IV","V","VI","VII","VIII","IX","X"};
        for (int i=0; (i<rome.length); i++) {
            if (str.equals(rome[i])) {
                return i+1;
            }
        }
        return -1;
    }
    static int arabNum(String str){
        String [] arab = {"1","2","3","4","5","6","7","8","9","10"};
        for (int i=0; (i<arab.length); i++) {
            if (str.equals(arab[i])) {
                return i+1;
            }
        }
        return -1;
    }
    static String IntegerToRomanNumeral(int input) {
        if (input < 1 || input > 3999)
            return "Invalid Roman Number Value";
        String s = "";
        while (input >= 1000) {
            s += "M";
            input -= 1000;        }
        while (input >= 900) {
            s += "CM";
            input -= 900;
        }
        while (input >= 500) {
            s += "D";
            input -= 500;
        }
        while (input >= 400) {
            s += "CD";
            input -= 400;
        }
        while (input >= 100) {
            s += "C";
            input -= 100;
        }
        while (input >= 90) {
            s += "XC";
            input -= 90;
        }
        while (input >= 50) {
            s += "L";
            input -= 50;
        }
        while (input >= 40) {
            s += "XL";
            input -= 40;
        }
        while (input >= 10) {
            s += "X";
            input -= 10;
        }
        while (input >= 9) {
            s += "IX";
            input -= 9;
        }
        while (input >= 5) {
            s += "V";
            input -= 5;
        }
        while (input >= 4) {
            s += "IV";
            input -= 4;
        }
        while (input >= 1) {
            s += "I";
            input -= 1;
        }
        return s;
    }
    public static String calc(String input) throws Exception {

        int num1;
        int num2;
        int result;
        boolean romanNum;

        String[] arrSplit = input.split(" ");

        if (arrSplit.length != 3) {             //Если передали не 3 символа
            throw new Exception();
        }

        if (romanNum(arrSplit[0])!=-1 && romanNum(arrSplit[2])!=-1) {
            num1 = romanNum(arrSplit[0]);
            num2 = romanNum(arrSplit[2]);
            romanNum = true;
        }
        else if(arabNum(arrSplit[0])!=-1 && arabNum(arrSplit[2])!=-1) {
            num1 = arabNum(arrSplit[0]);
            num2 = arabNum(arrSplit[2]);
            romanNum = false;
        }
        else{
            throw new Exception();              //Если 1 и 3 символ не цифры
        }

        if (arrSplit[1].equals("+")) {
            result = num1 + num2;
        } else if (arrSplit[1].equals("-")) {
            result = num1 - num2;
        }else if (arrSplit[1].equals("*")) {
            result = num1 * num2;
        }else if (arrSplit[1].equals("/")) {
            if (num2==0){
                throw new Exception();          //Делить на ноль нельзя
            }
            result = num1 / num2;
        }else {
            throw new Exception();              //Если это не символ операции
        }

        if (romanNum) {                         //Если Римская цифра конвертируем
            if (result<1){
                throw new Exception();          //Если результат вычисления не целое число
            }
            return IntegerToRomanNumeral(result);
        }

        return new String(String.valueOf(result));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Ведите операцию:");
            String str = scanner.nextLine();
            try {
                System.out.println(calc(str));
            } catch (Exception e) {
                System.out.println("throws Exception");
            }
        }
    }
}
