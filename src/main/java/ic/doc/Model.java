package ic.doc;

import java.util.Objects;
import java.util.Stack;

public class Model {
        Stack<Integer> numberList = new Stack<Integer>();
        public void addNumberToStack(int i){
            numberList.push(i);
        }
        public int findResult(String a){
            int num1 = numberList.pop();
            int num2 = numberList.pop();
            if(Objects.equals(a, "+"))
                return num1+num2;
            if(Objects.equals(a, "-"))
                return num2-num1;
            if(Objects.equals(a, "/"))
                return num2/num1;
            return num1*num2;
        }
}