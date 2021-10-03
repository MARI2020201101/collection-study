package hashmap;

import javax.swing.text.html.HTMLDocument;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapEx2 {
    public static void main(String[] args) {
        String[] data = {"A","J","K","A","A","A","J","J","K","S"};

        HashMap map = new HashMap();

        for(int i =0 ; i < data.length ; i++){
            if(map.containsKey(data[i])){
           //     System.out.println("yes~~~");
                Integer value = (Integer) map.get(data[i]);
                map.put(data[i], value.intValue()+1);
            }else{
                map.put(data[i],1);
            }
        }
        Iterator it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry e =(Map.Entry)it.next();
            Object key = e.getKey();
            int value = (int) e.getValue();
            //System.out.println(key + "  " + value);

            System.out.println(key + " : "+ printBar('#',value) + " " + value);
        }
    }

    static String printBar(char ch, int value){
        char[] bar = new char[value];
        for(int i =0 ; i <bar.length; i++){
            bar[i] = ch;

        }return new String(bar);
    }
}
