package exercise;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class SutdaCard{
    int num;
    boolean isKwang;

    SutdaCard(){
        this(1,true);
    }

    SutdaCard(int num, boolean isKwang){
        this.isKwang=isKwang;
        this.num=num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SutdaCard sutdaCard = (SutdaCard) o;
        return num == sutdaCard.num && isKwang == sutdaCard.isKwang;
    }

    @Override
    public String toString() {
        return num + (isKwang? "K" :"");
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }
}
public class Exercise11 {

    public static void main(String[] args) {
        SutdaCard s1 = new SutdaCard(3,true);
        SutdaCard s2 = new SutdaCard(3,true);
        SutdaCard s3 = new SutdaCard(1,true);
        Set<SutdaCard> sutdaCards = new HashSet<>();
        sutdaCards.add(s1);
        sutdaCards.add(s2);
        sutdaCards.add(s3);

        sutdaCards.stream().forEach(System.out::println);
    }
}
