package exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Exercise5 {
static class Student implements Comparable{
    String name;
    int ban;
    int no;
    int kor,eng,math;

    public Student(String name, int ban, int no, int kor, int eng, int math) {
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    int getTotal(){
        return eng+kor+math;
    }
    float getAverage(){
        return (float) ((int)(getTotal()/3.0f*10))/10;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", ban=" + ban +
                ", no=" + no +
                ", kor=" + kor +
                ", eng=" + eng +
                ", math=" + math +
                '}'
                + getTotal() +" , "+ getAverage();
    }


    @Override
    public int compareTo(Object o) {
        Student tmp=null;
        int val=0;
        if(o instanceof  Student){
            tmp  = (Student) o;}
        val = this.name.compareTo(tmp.name);
        return val;
    }
}
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(new Student("홍길동",1,1,100,100,100));
        list.add(new Student("남궁성",1,2,90,70,80));
        list.add(new Student("김자바",1,3,80,80,90));
        list.add(new Student("이자바",1,4,70,90,70));
        list.add(new Student("안자바",1,5,60,100,80));

        Collections.sort(list);
        Iterator it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
