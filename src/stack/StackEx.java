package stack;

import java.util.Stack;

public class StackEx {
    public static Stack back = new Stack();
    public static Stack forward = new Stack();

    public static void main(String[] args) {
        goURL("1. 네이트");
        goURL("2. 다음");
        goURL("3. 구글");
        goURL("4. 네이버");

        printStatus();

        goBack();
        System.out.println("after go back...");
        printStatus();


        goBack();
        System.out.println("after go back...");
        printStatus();

        goForward();
        System.out.println("after go forward...");
        printStatus();


        goForward();
        System.out.println("after go forward...");
        printStatus();

    }
    public static void printStatus(){
        System.out.println("back : " + back);
        System.out.println("forward" +  forward);
        System.out.println("현재 화면은 "+back.peek()+" 입니다.");
        System.out.println();
    }

    public static void goURL(String url){
        back.push(url);
        if(!forward.isEmpty()){
            forward.clear();
        }
    }

    public static void goBack(){
        if(!back.isEmpty())
            forward.push(back.pop());
    }

    public static void goForward(){
        if(!forward.isEmpty())
            back.push(forward.pop());
    }
}
