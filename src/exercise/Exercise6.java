package exercise;

import com.sun.source.tree.Tree;

import java.util.*;

public class Exercise6 {
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
                    + getTotal() +" , "+ getAverage();
        }


        @Override
        public int compareTo(Object o) {
            if(o instanceof Student){
                Student tmp  = (Student) o;
                return this.name.compareTo(tmp.name);
            }
            else return -1;
        }
    }

    static int getGroupCount(TreeSet tset, int from, int to){
       /* SortedSet subset = tset.subSet(from,to);
        return subset.size();*/

        Student s1 = new Student("",0,0,from,from,from);
        Student s2 = new Student("",0,0,to,to,to);
        SortedSet subset = tset.subSet(s1,s2);
        return subset.size();
    }

    static int compare(Object o1, Object o2){
        if(o1 instanceof Student && o2 instanceof Student){
            Student s1 = (Student) o1;
            Student s2 = (Student) o2;
            return s1.getAverage() > s2.getAverage()?1 : -1;
        }
            else return -1;
    }

    public static void main(String[] args) {

        TreeSet set = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Student && o2 instanceof Student){
                    Student s1 = (Student) o1;
                    Student s2 = (Student) o2;
                    return s1.getAverage() > s2.getAverage()?1 : -1;
                }
                else return -1;
            }
        });

        set.add(new Student("홍길동",1,1,100,100,100));
        set.add(new Student("남궁성",1,2,90,70,80));
        set.add(new Student("김자바",1,3,80,80,90));
        set.add(new Student("이자바",1,4,70,90,70));
        set.add(new Student("안자바",1,5,60,100,80));

        Iterator it = set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        System.out.println(getGroupCount(set,60,70));
        System.out.println(getGroupCount(set,70,80));
        System.out.println(getGroupCount(set,80,90));
        System.out.println(getGroupCount(set,90,101));
    }
}

