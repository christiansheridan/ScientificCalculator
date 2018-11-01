/**
 * Created by leon on 2/9/18.
 */
import java.util.*;

public class MainApplication {
    public static void main(String[] args) {
        System.out.println("\n ========v1 Calculator========");
        System.out.println("0");
        boolean power = true;
        Double mem = 0.0;
        Double[] operandHolder = new Double[100];
        String[] operatorHolder = new String[100];
        Arrays.fill(operatorHolder,"0");

        while(power){
            Console.SaveParameter(Console.getDoubleInput("Enter a number"), operandHolder);
            //Console.println("\n" + Arrays.toString(operandHolder));
            //Console.println(Arrays.toString(operatorHolder) + "\n");

            Console.DisplayCurrent(operandHolder,operatorHolder);

            Console.SaveParameter(Console.getStringInput("Enter an operator "), operatorHolder);

            //Console.println("\n" + Arrays.toString(operandHolder));
            //Console.println(Arrays.toString(operatorHolder) + "\n");

            Calculator.Inverter(operatorHolder, operandHolder);
            //Calculator.SignInvert(operatorHolder, operandHolder);
            Calculator.ClearMem(operatorHolder, operandHolder);
            Calculator.MemStore(operatorHolder, operandHolder, mem);
            
            power = !Calculator.OperatorChecker(operatorHolder,"end");
            
            if(Calculator.OperatorChecker(operatorHolder, "=" )){
                Calculator.BasicComputing(operatorHolder, operandHolder);
                Console.DisplayCurrent(operandHolder,operatorHolder);
                Console.SaveParameter(Console.getStringInput("Enter an operator "), operatorHolder);
            }
            
            power = !Calculator.OperatorChecker(operatorHolder,"end");
            Console.DisplayCurrent(operandHolder,operatorHolder);
        }

        //Console.println(Arrays.toString(operandHolder));
        //Console.println(Arrays.toString(operatorHolder));
    }

}

