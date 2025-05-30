import org.testng.annotations.Test;
import java.util.ArrayList;

public class JavaStream {
    //count the number of names starting with alphabet 'A' in the list
    @Test
    public void streamTest(){
        ArrayList<String> names = new ArrayList<>();
        names.add("Abhijeet");
        names.add("Don");
        names.add("Aman");
        names.add("Test");
        names.add("Ram");

        System.out.println(names.stream().filter(s -> s.startsWith("A")).count());
    }
}
