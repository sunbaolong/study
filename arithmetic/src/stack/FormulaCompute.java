package stack;

import util.StdIn;
import util.StdOut;

import java.util.Stack;

/**
 * 公式计算，通过两个stack实现计算 ( 1 + ( ( 2 * 3 ) + ( ( 3 * 5 ) + ( 5 * ( 4 + 6 ) ) ) ) ) = 72
 * 实现思路，两个stack，numStack代表数字栈，opStack代表操作符栈（+-），从左到右读每一个字符
 * 1.遇到数字则压入numStack
 * 2.遇到操作符压入opStack
 * 3.如果遇到右括号，则弹出操作符，以及操作符对应数量的数据，进行计算，计算结果再次压入numStack
 * 4.最后opStack为空，numStack剩一个数值就是最终结果
 */
public class FormulaCompute {


    public static void main(String[] args) {


        Stack<String> opStack = new Stack<>();
        Stack<Double> numStack = new Stack<>();
        while (StdIn.isNotEmpty()) {

            String s = StdIn.readString();
            System.out.println(s);
            if (s.equals("(")) {

            } else if (s.equals("+")) {
                opStack.push(s);
            } else if (s.equals("-")) {
                opStack.push(s);
            } else if (s.equals("*")) {
                opStack.push(s);
            } else if (s.equals("/")) {
                opStack.push(s);
            } else if (s.equals(")")) {
                // 如果是右括号，则弹出一个操作符，并弹出相应的操作数
                Double res = 0.0;
                String op = opStack.pop();
                if (op.equals("+")) {
                    Double a = numStack.pop();
                    res = numStack.pop() + a;
                } else if (op.equals("-")) {
                    Double a = numStack.pop();
                    res = numStack.pop() - a;
                } else if (op.equals("*")) {
                    Double a = numStack.pop();
                    res = numStack.pop() * a;
                } else if (op.equals("/")) {
                    Double a = numStack.pop();
                    res = numStack.pop() + a;
                }
                numStack.push(res);
            } else {
                numStack.push(Double.valueOf(s));
            }
        }
        StdOut.println(numStack.pop());
    }

}
