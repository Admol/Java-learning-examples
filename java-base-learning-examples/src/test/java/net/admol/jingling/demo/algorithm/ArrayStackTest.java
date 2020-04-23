package net.admol.jingling.demo.algorithm;

import net.admol.jingling.demo.datastructure.stack.ArrayStack;
import org.junit.Test;

import java.util.StringTokenizer;

/**
 * @author : admol
 * @Date : 2019/11/7
 */
public class ArrayStackTest{

    public static void main(String[] args){
//        ArrayStack arrayStack = new ArrayStack(5);
        ArrayStack arrayStack = new ArrayStack(true);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);
        arrayStack.push(5);
        arrayStack.push(6);
        arrayStack.push(7);
        arrayStack.push(8);
        arrayStack.push(9);
        arrayStack.push(10);
        int i = arrayStack.count();
        while(i>0){
            System.out.println(arrayStack.pop());
            i--;
        }
    }
    @Test
    public void test(){
        StringTokenizer stringTokenizer = new StringTokenizer("1+50.1*(10+90)","+-*/()",true);
        while(stringTokenizer.hasMoreTokens()){
            System.out.println("  t: "+stringTokenizer.nextToken());
        }
        System.out.println();
        while(stringTokenizer.hasMoreElements()){
            System.out.println("  e: "+stringTokenizer.nextElement());
        }
    }

    /**
     * 基于表达式求值, 栈的运用测试
     */
    @Test
    public void testExpression(){
        ArrayStack<Double> numberStack = new ArrayStack(true);
        ArrayStack<Operator> operatorStack = new ArrayStack(true);
//        StringTokenizer stringTokenizer = new StringTokenizer("1+50-20+3","+-*/()",true);
        StringTokenizer stringTokenizer = new StringTokenizer("50+5*1+50.1*(10+90*1)+10.1*(10+10*1)","+-*/()",true);
        while(stringTokenizer.hasMoreTokens()){
            String s = stringTokenizer.nextToken();
            if(isNumber(s)){
                //1.遇到数字直接将数字压入栈
                numberStack.push(Double.parseDouble(s));
            }else{
                //2.如果是运算符, 取出运算符栈顶元素, 与当前运算符比较优先级,
                // 如果比栈顶的优先级高, 取操作数栈顶的2个数, 然后进行计算, 并将计算结果压入到操作数栈, 然后继续比较
                // 如果比栈顶的优先级低, 则压入运算符栈中
                Operator operator = Operator.getOperator(s);
                Operator op = operatorStack.peek();
                if(operator.getOperator().equals(Operator.BRACKETS.getOperator())){
                    // 左括号直接入栈
                    operatorStack.push(operator);
                }else if(operator.getOperator().equals(Operator.BRACKETS_2.getOperator())){
                    // 计算左括号到右括号之间的表达式
                    // 取出右括号之前的一个运算符
                    op = operatorStack.pop();
                    while(!op.getOperator().equals(Operator.BRACKETS.getOperator())){
                        // 取出两个操作数
                        Double d1 = numberStack.pop();
                        Double d2 = numberStack.pop();
                        // 计算值并放入到操作数栈
                        double sum = op.compute(d2,d1);
                        numberStack.push(sum);
                        // 取出下一个运算符, 直到遇到左括号
                        op = operatorStack.pop();
                    }

                }else if(op != null && operator != null && comparePriority(op,operator)){
                    //栈顶的运算符优先级高的情况, 取出操作数计算结果并入栈
                    Double d1 = numberStack.pop();
                    Double d2 = numberStack.pop();
                    double result = op.compute(d2,d1);
                    operatorStack.pop();
                    numberStack.push(result);
                    //放入下一个运算符
                    operatorStack.push(operator);
                }else{
                    // 运算符入栈操作
                    operatorStack.push(operator);
                }
            }
        }

        //计算栈中剩余的表达式
        while(!operatorStack.isEmpty()){
            Double d1 = numberStack.pop();
            Double d2 = numberStack.pop();
            Operator op = operatorStack.pop();
            double result =  op.compute(d2,d1);
            numberStack.push(result);
        }
        System.out.println("计算结果:"+numberStack.peek());


    }

    /**
     * 比较运算符的优先级
     * @param op 栈顶运算符
     * @param operator 当前运算符
     * @return 栈顶运算符>=当前运算符 返回true
     */
    private boolean comparePriority(Operator op,Operator operator){
        return op.getPriority() >= operator.getPriority();
    }


    private boolean isNumber(String s){
        try{
            Double.parseDouble(s);
            return true;
        }catch(Exception e){
        }
        return false;
    }

    enum Operator{
        PLUS("+",1),
        MINUS ("-",1),
        MULTIPLY ("*",2),
        DIVIDE ("/",2),
        BRACKETS ("(",0),
        BRACKETS_2 (")",0),
        ;
        private String operator;
        private int priority;

        public static int getPriority(String op){
            for(Operator operator:Operator.values()){
                if(operator.getOperator().equals(op)){
                    return operator.getPriority();
                }
            }
            return 0;
        }

        public static Operator getOperator(String s){
            for(Operator operator:Operator.values()){
                if(operator.getOperator().equals(s)){
                    return operator;
                }
            }
            return null;
        }

        public String getOperator(){
            return operator;
        }

        public int getPriority(){
            return priority;
        }

        Operator(String operator,int priority){
            this.operator = operator;
            this.priority = priority;
        }

        public double compute(Double d2,Double d1){
            if(this.operator.equals(Operator.PLUS.operator)){
                return d2 + d1;
            }
            if(this.operator.equals(Operator.MINUS.operator)){
                return d2 - d1;
            }
            if(this.operator.equals(Operator.MULTIPLY.operator)){
                return d2 * d1;
            }
            if(this.operator.equals(Operator.DIVIDE.operator)){
                return d2 / d1;
            }
            return 0;
        }
    }

}
