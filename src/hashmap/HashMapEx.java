package hashmap;

import jdk.swing.interop.SwingInterOpUtils;

import javax.swing.text.html.HTMLDocument;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapEx {
    static HashMap phoneBook = new HashMap();

    public static void main(String[] args) {
        addPhoneNo("친구","이자바", "010-1111-2222");
        addPhoneNo("친구","김자바", "010-1131-2222");
        addPhoneNo("친구","칠자바", "010-1141-2222");
        addPhoneNo("회사","구자바", "010-1151-2222");
        addPhoneNo("회사","자자바", "010-1161-2222");
        addPhoneNo("회사","봉자바", "010-1161-8222");
        addPhoneNo("친구","확자바", "010-1171-2222");
        addPhoneNo("세탁","감자바", "010-1181-2222");

        printList2();
    }

    private static void addPhoneNo(String groupName, String name, String tel) {
        addGroup(groupName);
        HashMap group = (HashMap) phoneBook.get(groupName);
        group.put(tel, name);
    }

    private static void addGroup(String groupName) {
        if(!phoneBook.containsKey(groupName))
            phoneBook.put(groupName,new HashMap());
    }

    static void printList2(){
        Set set = phoneBook.entrySet();
        Iterator it = set.iterator();

        while(it.hasNext()){
            Map.Entry e = ((Map.Entry)it.next());
        }
    }

    static void printList(){
        Set set = phoneBook.entrySet();
        Iterator it = set.iterator();

        while(it.hasNext()){
            Map.Entry e = (Map.Entry) it.next();
            Set subSet = ((HashMap)e.getValue()).entrySet();//안에 있는 해쉬맵 끌어내기위해서 또 만듬
            Iterator subIt = subSet.iterator();

            System.out.println(" * " + e.getKey() + " ["+subSet.size() + "]");

            while(subIt.hasNext()){
                Map.Entry subE = (Map.Entry) subIt.next();
                String telNo = (String) subE.getKey();
                String name = (String) subE.getValue();
                System.out.println(name + " " + telNo);

            }
            System.out.println();
        }
    }
}
