import java.lang.Math;
import java.util.ArrayList;


class revision {
    
    public static void main(String[] args) {
        //declare arraylist with variable subject as string
        ArrayList<String> subject = new ArrayList<String>();   
        //add in the string into the arraylist
        subject.add("ryzen9 7950");
        subject.add("ryzen9 7900");
        subject.add("i5k");   
        subject.add("i5kf");
        subject.add("i7k"); 
        subject.add("i7kf");
        //convert the string arraylist into integer 
        int rand =(int) (Math.random()*subject.size());
        //display randomize element within the arraylist 
        System.out.println(subject.get(rand));
    }
}