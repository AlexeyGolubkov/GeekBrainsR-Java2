import java.util.*;

public class Main {
    public static void main(String[] args) {
        //1)
        ArrayList<String> listOfWords = new ArrayList<>();
        listOfWords.add("Test1");
        listOfWords.add("Test1");
        listOfWords.add("Test1");
        listOfWords.add("Test1");
        listOfWords.add("Test2");
        listOfWords.add("Test3");
        listOfWords.add("Test4");
        listOfWords.add("Test1");
        listOfWords.add("Test1");
        listOfWords.add("Test1");
        listOfWords.add("Test1");
        listOfWords.add("Test2");
        listOfWords.add("Test3");
        listOfWords.add("Test4");
        listOfWords.add("Test5");
        listOfWords.add("Test5");
        listOfWords.add("Test5");
        listOfWords.add("Test5");
        listOfWords.add("Test5");
        listOfWords.add("Test5");
        System.out.println("Исходный список:");
        System.out.println(listOfWords + "\n");
        Set<String> uniqueWords = new HashSet<>();
        Set<String> uniqueWordsOfRange = new TreeSet<>();
        Iterator<String> iterator = listOfWords.iterator();
        while (iterator.hasNext()) {    //for (String str : listOfWords) but erudition don't hide
            String str = iterator.next();
            uniqueWords.add(str);
            uniqueWordsOfRange.add(str);
        }
        System.out.println("Уникальные значения списка:\n"+uniqueWords + "\n");
        System.out.println("Уникальные значения списка, в режиме сортировки:\n"+uniqueWordsOfRange + "\n");
        //2)

        HashMap<String, String> telephoneBook = new HashMap<>();
        telephoneBook.put("+1-555-777-777-770", "Petrov");
        telephoneBook.put("+1-555-777-777-771", "Ivanov");
        telephoneBook.put("+1-555-777-777771", "Sidorov is stepfather of Ivanov");
        telephoneBook.put("+1-555-777-777-772", "Oslov");
        telephoneBook.put("+1-555-777-777-773", "Petrov");
        telephoneBook.put("+1-555-777-777-774", "Ivanov");
        telephoneBook.put("+1-555-777-777-775", "Sidorov");
        telephoneBook.put("+1-555-777-777-776", "Olennikov");
        telephoneBook.put("+1-555-777-777-777", "Petrov");
        telephoneBook.put("+1-555-777-777-778", "Ivanov");
        telephoneBook.put("+1-555-777-777-779", "Sidorov");
        telephoneBook.put("+1-555-777-777-780", "Oblomov");
        telephoneBook.put("+1-555-777-777780", "Oblomov");


         findSurnameInPhoneBook("Olennikov",telephoneBook);

        findSurnameInPhoneBook("Ivanov",telephoneBook);

         findSurnameInPhoneBook("Oblomov",telephoneBook);

        findSurnameInPhoneBook("Sidorov",telephoneBook);

        findSurnameInPhoneBook("Kozlov",telephoneBook);


    }




    private static void findSurnameInPhoneBook(String surname,HashMap <String, String> telephoneBook) {
        boolean flagFindNoSuccess=true;
        System.out.println("\nFind: \""+surname+"\"");
        ArrayList<String> surnameListAndPhone = new ArrayList<>();

        //if (telephoneBook.containsValue(surname)) { //indexOf(String str) - i now about but indexOf is better


            for (Map.Entry <String, String> str : telephoneBook.entrySet()) {

                if (str.getValue().indexOf(surname)>=0) {
                    System.out.println(str.getValue() + ": " + str.getKey());
                    flagFindNoSuccess=false;
                }
            }
       // }
        if(!surnameListAndPhone.isEmpty()){System.out.println("Results: "+surnameListAndPhone);}
        else if (flagFindNoSuccess){
            System.out.println("\""+surname+"\" not found");
        }
    }

}

