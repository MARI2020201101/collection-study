package queue;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QueueEx {
    static Queue q = new LinkedList();
    static final int MAX_SIZE = 5 ;

    public static void main(String[] args) {
        System.out.println("help를 입력하면 도움말을 볼 수 있습니다.");


        while (true){
            System.out.println(">>");
            try{
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine().trim();

                if("".equals(input)) continue;
                if("q".equals(input)) {System.exit(0);}
                else if("help".equalsIgnoreCase(input)){
                    System.out.println(" help ---- 도움말");
                    System.out.println(" q --- 시스템 종료");
                    System.out.println(" history --- 최근에 입력한 명령어를 " + MAX_SIZE + "만큼 출력");
                }
                else if("history".equals(input)){
                    save(input);
                    LinkedList tmp = (LinkedList) q;
                    Iterator iterator = tmp.iterator();
                    while(iterator.hasNext()){
                        Object obj = iterator.next();
                        System.out.println(obj);
                    }
                }else{
                    save(input);
                    System.out.println(" saved : "+input);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void save(String input) {
        if(!"".equals(input)) {
            q.offer(input);
        }
        if(q.size()>MAX_SIZE){
            q.remove();
        }
    }
}
