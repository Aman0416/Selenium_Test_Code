package org.example;

import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class javastreams {
    //count the number of names starting with alphabet 'A' in the list
    //@Test
    public void streamTest(){
        ArrayList<String> names = new ArrayList<>();
        names.add("Abhijeet");
        names.add("Don");
        names.add("Aman");
        names.add("Test");
        names.add("Ram");

        System.out.println(names.stream().filter(s -> s.startsWith("A")).count());
        System.out.println("--------------------------");
        //To Print all names with more Letters than 4
        names.stream().filter(s->s.length()>3).forEach(System.out::println);
        System.out.println("--------------------------");
        //To Print all names with more than 4 Letters but only first result
        names.stream().filter(s->s.length()>3).limit(1).forEach(System.out::println);
    }

    //@Test
    public void streamMap(){
        //Print Names which have last letter as "a" with Uppercase
        Stream.of("Abhijeet", "Don", "Alekya", "Adam", "Rama").filter(s->s.endsWith("a"))
                .map(String::toUpperCase).forEach(System.out::println);

        System.out.println("--------------------------");

        //Print names which have first letter as "a" with Uppercase and sorted
        List<String> names = Arrays.asList("Abhijeet", "Don", "Alekya", "Adam", "Rama");
        names.stream().filter(s->s.startsWith("A")).sorted()
                .map(String::toUpperCase).forEach(System.out::println);

        System.out.println("--------------------------");

        //To merge to Arrays and then sort them
        ArrayList<String> names2 = new ArrayList<>();
        names2.add("Abhi");
        names2.add("Raju");
        names2.add("Rohan");
        names2.add("Test");
        names2.add("Ram");

        Stream.concat(names.stream(), names2.stream()).sorted().forEach(System.out::println);

        //To check that a certain value in a Array
        Boolean flag = names2.stream().anyMatch(s -> s.equalsIgnoreCase("Raju"));
        System.out.println(flag);
    }

    @Test
    public void streamCollect(){
        //To collect all data in a List
        List<String> names = Arrays.asList("Abhijeet", "Don", "Alekya", "Adam", "Rama");
        List<String> result = names.stream().filter(s->s.startsWith("A")).sorted()
                .map(String::toUpperCase).collect(Collectors.toList());

        System.out.println(result.get(0));

        System.out.println("-------------------------------");

        List<Integer> numbers = Arrays.asList(3,2,2,7,5,1,9,7);
        //Print Unique numbers in the List
        numbers.stream().distinct().forEach(System.out::println);

        System.out.println("-------------------------------");

        //Sort the Array
        numbers.stream().distinct().sorted().forEach(System.out::println);
    }
}
