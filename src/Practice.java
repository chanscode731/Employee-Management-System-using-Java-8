import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Practice {
    public static void main(String[] args) {

        List<Integer> myList = Arrays.asList(11, 34, 12, 67, 23, 89, 67, 12, 11);
        List<Integer> myNewlist = myList.stream().distinct().collect(Collectors.toList());
        System.out.println("Original list : " + myList);
        System.out.println("New list : " + myNewlist);

        List<Integer> listOfIntegers = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 14, 56, 87);
        Map<Boolean, List<Integer>> oddEvenMap = listOfIntegers.stream()
                .collect(Collectors.partitioningBy(i -> i % 2 == 0));
        Set<Map.Entry<Boolean, List<Integer>>> myEntry = oddEvenMap.entrySet();
        for(Map.Entry<Boolean, List<Integer>> me : myEntry){
            System.out.println("---------------------------------");
            if(me.getKey()){
                System.out.println("Even numbers");
            }
            else{
                System.out.println("Odd numbers");
            }
            System.out.println("---------------------------------");
            List<Integer> list = me.getValue();
            for(int i : list){
                System.out.println(i);
            }
        }

        // remove duplicate elements from a list
        List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python");
        List<String> uniqueStr = listOfStrings.stream().distinct().collect(Collectors.toList());
        System.out.println("Without duplicates = " + uniqueStr);


        List<String> stationeryList = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Stapler", "Note Book", "Pencil");
        Map<String, Long> stringCount = stationeryList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("String count : " + stringCount);


        List<Double> decimalList = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);
        System.out.println("Decimals in descending order : ");
        decimalList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        System.out.println("Decimals in natural order : ");
        decimalList.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);



        List<Integer> list1 = Arrays.asList(3, 15, 71, 86, 45, 20, 62, 90);
        List<Integer> multiplesOf5 = list1.stream().filter(i -> i % 5 == 0).collect(Collectors.toList());
        System.out.println(multiplesOf5);



        List<Integer> list2 = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        int max = list2.stream().max(Comparator.naturalOrder()).get();
        int min = list2.stream().min(Comparator.naturalOrder()).get();
        System.out.println("Max = " + max);
        System.out.println("Min = " + min);
        int newMax = list2.stream().sorted(Comparator.reverseOrder()).findFirst().get();
        int newMin = list2.stream().sorted().findFirst().get();
        System.out.println("New max = " + newMax);
        System.out.println("New min = " + newMin);



        int[] a = new int[]{4, 2, 7, 1};
        int[] b = new int[]{8, 3, 9, 1};
        int[] c = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().distinct().toArray();
        System.out.println(Arrays.toString(c));



        List<Integer> list3 = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        System.out.println("-----------------------------------------");
        System.out.println("Three minimum numbers : ");
        System.out.println("-----------------------------------------");
        List<Integer> min3 = list3.stream().sorted().limit(3).collect(Collectors.toList());
        System.out.println(min3);
        System.out.println();
        System.out.println("-----------------------------------------");
        System.out.println("Three maximum numbers : ");
        System.out.println("-----------------------------------------");
        List<Integer> max3 = list3.stream().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList());
        System.out.println(max3);



        List<Integer> list4 = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        int secondLargest = list4.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println("Original list : " + list4);
        System.out.println("Second largest number : " + secondLargest);



        int[] a1 = new int[] {45, 12, 56, 15, 24, 75, 31, 89};
        int sum = Arrays.stream(a1).sum();
        double avg = Arrays.stream(a1).average().getAsDouble();
        System.out.println("Sum = " + sum + " and average = " + avg);



        List<Integer> list5 = Arrays.asList(71, 21, 34, 89, 56, 28);
        List<Integer> list6 = Arrays.asList(12, 56, 17, 21, 94, 34);
        System.out.println("Common elements : ");
        list5.stream().filter(list6::contains).forEach(System.out::println);



        String str = "Java Concept Of The Day";
        String reversedStr = Arrays.stream(str.split(" "))
                .map(word -> new StringBuffer(word).reverse())
                .collect(Collectors.joining(" "));
        System.out.println("Original string : " + str);
        System.out.println("Reversed string : " + reversedStr);



        // sum of first 10 natural numbers
        int sum1 = IntStream.rangeClosed(1, 10).sum();
        System.out.println(sum1);



        // print first 10 even numbers
        System.out.println("First 10 even numbers : ");
        IntStream.rangeClosed(1, 10).map(i -> i * 2).forEach(System.out::println);



        // most repeated element in an array
        List<String> listOfStr1 = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Pen", "Note Book", "Pencil");
        Map<String, Long> elementCountMap = listOfStr1.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map.Entry<String, Long> mostFrequentElement = elementCountMap.entrySet().stream().max(Map.Entry.comparingByValue()).get();
        System.out.println("Most frequent element : " + mostFrequentElement);



        // strings starting with a digit
        List<String> listOfStrings1 = Arrays.asList("One", "2wo", "3hree", "Four", "5ive", "Six");
        System.out.println("Strings starting with a digit : ");
        listOfStrings1.stream().filter(str1 -> Character.isDigit(str1.charAt(0))).forEach(System.out::println);



        // print duplicate characters in a string
        String str1 = "Java concept of the day".replaceAll("\\s+", "").toLowerCase();
        Set<String> uniqueChars = new HashSet<>();
        Set<String> duplicates = Arrays.stream(str1.split(""))
                .filter(ch -> !uniqueChars.add(ch))
                .collect(Collectors.toSet());
        System.out.println(duplicates);



        // get last element of an array
        List<String> listOfStrings2 = Arrays.asList("One", "Two", "Three", "Four", "Five", "Six");
        System.out.println("size = " + listOfStrings2.size());
        String lastElement = listOfStrings2.stream().skip(listOfStrings2.size() - 1).findFirst().get();
        System.out.println(lastElement);



        // extract duplicate elements from an array
        List<Integer> listOfIntegers4 = Arrays.asList(111, 222, 333, 111, 555, 333, 777, 222);
        Set<Integer> uniqueElements = new HashSet<>();
        Set<Integer> duplicateElements = listOfIntegers4.stream()
                .filter(i -> !uniqueElements.add(i))
                .collect(Collectors.toSet());
        System.out.println("Duplicate elements : " + duplicateElements);



        // find first repeated character in a string
        String input1 = "Java concept of the day".replaceAll("\s+", "").toLowerCase();
        Map<String, Long> charcountMap = Arrays.stream(input1.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        String firstRepeatedChar = charcountMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(entry -> entry.getKey())
                .findFirst()
                .get();
        System.out.println("First repeated character = " + firstRepeatedChar);



        // find first non-repeated character in a string
        String input2 = "Java concept of the day".replaceAll("\s+", "").toLowerCase();
        Map<String, Long> charCountMap2 = Arrays.stream(input2.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        String firstNonRepeatedChar = charCountMap2.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(entry -> entry.getKey())
                .findFirst()
                .get();
        System.out.println("First non-repeated character = " + firstNonRepeatedChar);


    }
}