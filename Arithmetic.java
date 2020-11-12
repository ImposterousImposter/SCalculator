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
    //ex if you press 1 + 7, line will hold "1 + 7"
    public static String getLine()
    {
        return Line;
    }
    public static void setLine(TextField value) { Line = value.getText();}//Intent is to have a method that will. Set the textbox value to Line.
    public int getLength()
    {
        return Line.length();
    }
    private static String[] tokens;
    public static void setTokens()
    {
        tokens = Line.split(" ");
    }









    public void addOperation(ArrayList calculations)
    {
        int postOp=0;
        for(int i=0;i<calculations.size();i++)
        {
            if(calculations.get(i) == "*")
            {
                postOp = Integer.parseInt((String) calculations.get(i-1)) * Integer.parseInt((String) calculations.get(i+1));
                calculations.add(i, postOp);//after adding the new value, the two iterations following postOp will be shifted up by one.
                calculations.remove(i-1);
                calculations.remove(i+1);
                calculations.remove(i+2);
            }
        }
    }

    public void subOperation(ArrayList calculations)
    {
        int postOp=0;
        for(int i=0;i<calculations.size();i++)
        {
            if(calculations.get(i) == "*")
            {
                postOp = Integer.parseInt((String) calculations.get(i-1)) * Integer.parseInt((String) calculations.get(i+1));
                calculations.add(i, postOp);//after adding the new value, the two iterations following postOp will be shifted up by one.
                calculations.remove(i-1);
                calculations.remove(i+1);
                calculations.remove(i+2);
            }
        }
    }

    public void mulOperation(ArrayList calculations)
    {
        int postOp=0;
        for(int i=0;i<calculations.size();i++)
        {
            if(calculations.get(i) == "*")
            {
                postOp = Integer.parseInt((String) calculations.get(i-1)) * Integer.parseInt((String) calculations.get(i+1));
                calculations.add(i, postOp);//after adding the new value, the two iterations following postOp will be shifted up by one.
                calculations.remove(i-1);
                calculations.remove(i+1);
                calculations.remove(i+2);
            }
        }
    }

    public void divOperation(ArrayList calculations)
    {
        int postOp=0;
        for(int i=0;i<calculations.size();i++)
        {
            if(calculations.get(i) == "*")
            {
                postOp = Integer.parseInt((String) calculations.get(i-1)) / Integer.parseInt((String) calculations.get(i+1));
                calculations.add(i, postOp);//after adding the new value, the two iterations following postOp will be shifted up by one.
                calculations.remove(i-1);
                calculations.remove(i+1);
                calculations.remove(i+2);
            }
        }
    }

    public void calculate()
    {
        ArrayList calculations = new ArrayList<String>();
        Collections.addAll(calculations, tokens);//replicate tokens in the array list calculations.
        //i want to continue to use tokens while actually placing edits within calculations.


    }

}
