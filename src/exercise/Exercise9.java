package exercise;

import java.util.*;

public class Exercise9 {
    static class Student implements Comparable{
        String name;
        int ban;
        int no;
        int kor,eng,math;

        int total;
        int schoolRank;
        int classRank;

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
                    + getTotal() +" , "+ getAverage() +" , " + schoolRank +" , " + classRank;
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

    static class ClassTotalComparator implements Comparator<Student>{

        @Override
        public int compare(Student o1, Student o2) {
            if(o1.ban==o2.ban){
                return o2.total-o1.total;
            }else if(o1.ban>o2.ban){
                return 1;
            }else{
                return -1;
            }
        }
    }


    public static void main(String[] args) {
        ArrayList list = new ArrayList();


        list.add(new Student("이자바",2,1,70,90,70));
        list.add(new Student("안자바",2,2,60,100,80));
        list.add(new Student("홍길동",1,3,100,100,100));
        list.add(new Student("남궁성",1,1,90,70,80));
        list.add(new Student("김자바",1,2,80,80,90));

        calculateClassRank(list);

        Iterator it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

    }

    private static void calculateClassRank(List<Student> list){
        Collections.sort(list, new ClassTotalComparator());
        int prevBan = -1 ;
        int prevRank = 0 ;
        int prevTotal = -1;
        int length = list.size();

        for(int i=0;i<length;i++){
            Student s = list.get(i);
            if(s.total==prevTotal){
                s.schoolRank=prevRank;
            }else{

                s.schoolRank=++prevRank;
            }prevRank=s.schoolRank;
            prevTotal=s.total;
        }


        calculateClassRank2(list);


    }
    private static void calculateClassRank2(List<Student> list){
        int prevBan = -1 ;
        int prevRank = 0 ;
        int prevTotal = -1;
        int length = list.size();
        for(int i=0;i<length;i++){
            Student s = list.get(i);
            if(s.ban==prevBan){
                if(s.total==prevTotal){
                    s.classRank=prevRank;
                }else{
                    s.classRank=++prevRank;
                }
            }else{
                prevBan=s.ban;
                prevRank = 0 ;
                prevTotal = -1;
                if(s.total==prevTotal){
                    s.classRank=prevRank;
                }else{
                    s.classRank=++prevRank;
                }
            }
            prevRank=s.classRank;
            prevTotal=s.total;
        }
    };



}
