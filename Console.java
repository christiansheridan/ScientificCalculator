import java.util.*;
import java.lang.*; 
/**
 * Created by leon on 2/9/18.
 */
public class Console {
    //Saves the input in the next open slot of the array
    public static void SaveParameter(String s, String[] b){
        for(int i = 0; i < b.length; i++){
            if(b[i].equals("0")){
                b[i] = s;
                break;
            }
        }
    }

    //Saves the input in the next open slot of the array
    public static void SaveParameter(Double s, Double[] b){
        for(int i = 0; i < b.length; i++){
            if(b[i] == null){
                b[i] = s;
                break;
            }
        } 
    }

    //Shifts the elements of the array back one position starting from the i position
    public static void ArrShifter(int i , String[] op, Double[] num  ){
        for(int j = (i+1); j < num.length -1; j++){
            num[j] = num[j + 1];
        }
        for(int j = i; j < num.length -1; j++){
            op[j] = op[j + 1];
        }
    }

    public static void DeleteOp(int i, String[] op){
        for(int j = i; j < op.length -1; j++){
            op[j] = op[j + 1];
        }
    }
    //Displays the elements of the arrays in alternating order.
    public static void DisplayCurrent(Double[]num, String[]op){
        for(int i = 0; i < num.length; i++){
            if(num[i] != null){
                System.out.print(String.format("%s ",num[i]));
            }
            if(!op[i].equals("0")){
                System.out.print(String.format("%s ",op[i]));
            }
        }
        System.out.print("\n");
    }

    public static void print(String output, Object... args) {
        System.out.printf(output, args);
    }

    public static void println(String output, Object... args) {
        print(output + "\n", args);
    }

    public static String getStringInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        println(prompt);
        String userInput = scanner.nextLine();
        return userInput;
    }

    public static Integer getIntegerInput(String prompt) {
        return null;
    }

    public static Double getDoubleInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        println(prompt);
        Double userInput = scanner.nextDouble();
        return userInput;
    }
}
