package exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Exercise8 {
    static class Student implements Comparable{
        String name;
        int ban;
        int no;
        int kor,eng,math;

        int total;
        int schoolRank;

        public Student(String name, int ban, int no, int kor, int eng, int math) {
            this.name = name;
            this.ban = ban;
            this.no = no;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
            this. total = eng+kor+math;

        }

        int getTotal(){
            return total;
        }
        float getAverage(){
            return ((int) ((getTotal()/3f)*10+0.5)/10f);
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
                    + getTotal() +" , "+ getAverage() +" , " + schoolRank;
        }

        @Override
        public int compareTo(Object o) {
            if(o instanceof Student){
                Student s1 = (Student) o;
                return s1.total-this.total;
            }
            return -1;
        }

    }


    public static void main(String[] args) {
        ArrayList list = new ArrayList();


        list.add(new Student("이자바",2,1,70,90,70));
        list.add(new Student("안자바",2,2,60,100,80));
        list.add(new Student("홍길동",1,3,100,100,100));
        list.add(new Student("남궁성",1,1,90,70,80));
        list.add(new Student("김자바",1,2,80,80,90));

        answer(list);

        Iterator it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

    }

    private static void answer(List list){
        Collections.sort(list);
        int prevRank = -1 ;
        int prevTotal = -1;
        int length = list.size();

        for(int i=0;i<length;i++){
            Student s = (Student) list.get(i);
            if(s.total==prevTotal){
                s.schoolRank= prevRank;
            }else{
                s.schoolRank=i+1;
            }
            prevRank=s.schoolRank;
            prevTotal=s.total;
        }
        Collections.sort(list,(o1, o2) -> {
            Student s1 = (Student) o1;
            Student s2 = (Student) o2;
            return ((Student) o1).schoolRank-((Student) o2).schoolRank;
        });

    }


    private static void calculateSchoolRank(List list) {
        Collections.sort(list);
        int prevRank = list.size() +1 ;
        int prevTotal = -1;
        int length = list.size();

        for(int i=0;i< length;i++){
            if(list.get(i) instanceof Student){
                Student s = (Student) list.get(i);
                if(s.total==prevTotal){
                    s.schoolRank=prevRank--;
                }else{
                    s.schoolRank=--prevRank;
                }
                prevTotal = s.total;
            }
        }
        Collections.sort(list,(o1, o2) -> {
            Student s1 = (Student) o1;
            Student s2 = (Student) o2;
            return ((Student) o1).schoolRank-((Student) o2).schoolRank;
         });
    }
}
