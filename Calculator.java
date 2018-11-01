
import java.util.*;
import java.lang.*; 
/**
 * Write a description of class Calculator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Calculator
{
    //Checks the array for the operator b
    public static boolean OperatorChecker(String[] s, String b){
        for(int i = 0;i < s.length; i++){
            if(s[i].equals(b)){
                return true;
            }
        }
        return false;
    }

    //Inverts the current element of the num array
    public static void SignInvert(String[] op, Double[] num){
        for(int i = 0; i < op.length; i++){
            if(op[i].equals("sgn")){
                num[i] *= -1;
                Console.DeleteOp(0,op);
                Console.DisplayCurrent(num,op);
                Console.SaveParameter(Console.getStringInput(" "), op);
            }        
        }        
    }

    // Calculates the inversion of the double
    public static void Inverter(String[] op, Double[] num){
        for(int i = 0; i < op.length; i++){
            if(op[i].equals("inv")){
                num[i] = 1/num[i];
                Console.DeleteOp(0,op);
                Console.DisplayCurrent(num,op);
                Console.SaveParameter(Console.getStringInput("Enter operator"), op);
            }        
        }        
    }

    public static void MemStore(String[] op,Double[] num, Double store){
        for(int i = 0; i < op.length; i++){
            if(op[i].equals("m+")){
                store = num[i];
                Console.DeleteOp(0,op);
                Console.println(store + " is stored in memory");
                Console.SaveParameter(Console.getStringInput("Enter operator"), op);
            }
            else if(op[i].equals("mc")){
                store = 0.0;
                Console.DeleteOp(0,op);
                Console.println("MEMORY CLEARED");
                Console.SaveParameter(Console.getDoubleInput("Enter a number"), num);
            }
            else if(op[i].equals("mrc")){
                num[i] = store;
                Console.DeleteOp(0,op);
                Console.println(store + " ---> " + num[i]);
                Console.DisplayCurrent(num,op);
                Console.SaveParameter(Console.getStringInput("Enter operator"), op);
            }
        }  
    }

    public static Double factorial(Double number){

        if(number == 1){
            return number;
        }
        number *= factorial(number-1);
        return number;
    }

    public static void FactorialFinish(String[] op, Double[] num){
        for(int i = 0; i < op.length; i++){
            if(op[i].equals("!")){
                if(num[i] == 1){
                    num[i] = num[i];                    
                }
                num[i] *= factorial(num[i-1]);
                for(int j = i; j < op.length -1; j++){
                    op[j] = op[j+1];                
                }
                Console.DisplayCurrent(num,op);
                Console.SaveParameter(Console.getStringInput("Enter an Operator"), op);
            }        
        }        
    }

    public static void Trig(String[] op, Double[]num){
        for(int i = 0; i < num.length; i++){
            if(op[i].equals("sin")){
                num[i] = Math.sin(Math.toRadians(num[i]));
                Console.DeleteOp(i,op);
                Console.DisplayCurrent(num,op);
                Console.SaveParameter(Console.getStringInput("Enter an Operator"), op);
            }
            else if(op[i].equals("cos")){
                num[i] = Math.cos(Math.toRadians(num[i]));
                Console.DeleteOp(i,op);
                Console.DisplayCurrent(num,op);
                Console.SaveParameter(Console.getStringInput("Enter an Operator"), op);
            }
            else if(op[i].equals("tan")){
                num[i] = Math.tan(Math.toRadians(num[i]));
                Console.DeleteOp(i,op);
                Console.DisplayCurrent(num,op);
                Console.SaveParameter(Console.getStringInput("Enter an Operator"), op);
            }
            else{
                //Just passing through
            }
        }
    }

    public static void ClearMem(String[] op, Double[] num){
        for(int i = 0; i < op.length; i++){
            if(op[i].equals("clr")){
                Arrays.fill(num, null);
                Arrays.fill(op, "0");
                Console.DisplayCurrent(num,op);
            }        
        }        
    }

    //Does all the Basic computing in PEMDAS form.
    public static void BasicComputing(String[] op, Double[] num){
        if(Calculator.OperatorChecker(op,"=")){
            for(int check = 0; check < op.length; check++){

                for(int i = 0; i < num.length; i++){
                    if(op[i].equals("^")){
                        num[i] = Math.pow(num[i], num[i+1]);
                        Console.ArrShifter(i,op, num);
                    }

                    else if(op[i].equals("rt")){
                        num[i] = Math.pow(num[i], (1/num[i+1]));
                        Console.ArrShifter(i,op, num);
                    }
                    else{
                        //Just passing through
                    }
                }
                for(int i = 0; i < num.length; i++){
                    if(op[i].equals("*")){
                        num[i] = (num[i]  * num[i+1]);
                        Console.ArrShifter(i,op, num);
                    }

                    else if(op[i].equals("/")){
                        num[i] = (num[i]  / num[i+1]);
                        Console.ArrShifter(i,op, num);

                    }
                    else{
                        //Just passing through
                    }
                }
                for(int i = 0; i < num.length; i++){
                    if(op[i].equals("+")){
                        num[i] = (num[i]  + num[i+1]);
                        Console.ArrShifter(i,op, num);

                    }
                    else if(op[i].equals("-")){
                        num[i] = (num[i]  - num[i+1]);
                        Console.ArrShifter(i,op, num);

                    }
                    else if (op[i].equals("=")) {
                        for(int j = i; j < op.length -1; j++){
                            op[j] = op[j+1];                
                        }

                        break;
                    }
                    else{
                        //Just passing through
                    }
                    Calculator.BasicComputing(op, num);
                }
            }

        }
    }
}
