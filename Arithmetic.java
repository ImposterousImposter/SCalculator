import javafx.scene.control.TextField;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

//The goal is to create a simple calculator capable of calculating any number value through the four most basic math operations.
public class Arithmetic {
    /*
    Is static OK in this context?
     */
    private static String Line;//This will be the location that clicked buttons will be stored.
    private static String answer;
    //ex if you press 1 + 7, line will hold "1 + 7"
    public static String getLine()
    {
        return Line;
    }
    public static void setLine(TextField value) { Line = value.getText();}//Intent is to have a method that will. Set the textbox value to Line.
    public static String getAnswer(){ return answer;}
    public int getLength()
    {
        return Line.length();
    }
    private static String[] tokens;
    public static void setTokens()
    {
        tokens = Line.split(" ");
    }









    public static void addOperation(ArrayList calculations, int i)
    {
        int postOp=0;
        postOp = (Integer)calculations.get(i-1) * (Integer)calculations.get(i+1);//These two values will always be integers in string form.
                calculations.remove(i);
                calculations.remove(i);
                calculations.remove(i-1);
        calculations.add(i-1, postOp);//after adding the new value, the two iterations following postOp will be shifted up by one.
                i = 0;
    }

    public static void subOperation(ArrayList calculations, int i)
    {
        int postOp=0;
                postOp = (Integer)calculations.get(i-1) * (Integer)calculations.get(i+1);
        calculations.remove(i);
        calculations.remove(i);
        calculations.remove(i-1);
        calculations.add(i-1, postOp);//after adding the new value, the two iterations following postOp will be shifted up by one.
                i = 0;
    }

    public static void mulOperation(ArrayList calculations, int i)
    {
        int postOp=0;
        postOp = (Integer)calculations.get(i-1) * (Integer)calculations.get(i+1);
        calculations.remove(i);
        calculations.remove(i);
        calculations.remove(i-1);
        calculations.add(i-1, postOp);//after adding the new value, the two iterations following postOp will be shifted up by one.                i = 0;
    }

    public static void divOperation(ArrayList calculations, int i)
    {
        int postOp=0;
        postOp = (Integer)calculations.get(i-1) * (Integer)calculations.get(i+1);
        calculations.remove(i);
        calculations.remove(i);
        calculations.remove(i-1);
        calculations.add(i-1, postOp);//after adding the new value, the two iterations following postOp will be shifted up by one.
                i = 0;
    }

    public static boolean priorityOne(ArrayList calculations, int i)
    {
        for(i =0; i<calculations.size(); i++)
        {
            if(calculations.get(i).equals("*") || calculations.get(i).equals("/"))
            {
                return true;//loop through the entire array list and check for * and /.
                //if this returns true we need to follow the order of operations and resolve these first.
            }
        }
        return false;
    }

    public static boolean priorityTwo(ArrayList calculations, int i)
    {
        for(i =0; i<calculations.size(); i++)
        {
            if(calculations.get(i).equals("+") || calculations.get(i).equals("-"))
            {
                return true;//loop through the entire array list and check for * and /.
                //if this returns true we need to follow the order of operations and resolve these first.
            }
        }
        return false;
    }


    public static boolean operatorPresent(ArrayList calculations, int i)
    {
        for (i = 0; i < calculations.size(); i++) {
            if (calculations.get(i).equals("*") || calculations.get(i).equals("/") || calculations.get(i).equals("+") || calculations.get(i).equals("-")) {
                return true;
            }
        }
        return false;
    }

    public static void calculate() {
        int i = 0;
        ArrayList calculations = new ArrayList<String>();
        setTokens();
        Collections.addAll(calculations, tokens);//replicate tokens in the array list calculations.
        //i want to continue to use tokens while actually placing edits within calculations.

        while (operatorPresent(calculations, i))
        {
            //while there are operators within arraylist
            if (priorityOne(calculations, i)) {//if any operators are * and / resolve the first one you find
                        if (calculations.get(i).equals("*")) {
                            mulOperation(calculations, i);//resolve
                            continue;//restart at the top of the while loop
                        }
                            divOperation(calculations, i);
                            continue;//restart at the top of the while loop

            }


            if(priorityTwo(calculations, i)) {//only performed after all instances of * and / have been resolved
                        if(calculations.get(i).equals("+"))
                        {
                            addOperation(calculations, i);
                            continue;//restart at the top of the while loop
                        }
                            subOperation(calculations, i);
            }
        }
        //After all operations are performed there will only be one index within calculations, which will be the final answer.
        answer = calculations.get(0).toString();//The answer is converted to a string then saved within the answer variable.
    }

}
