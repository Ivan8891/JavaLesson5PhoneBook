package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<String, ArrayList<Integer>>();
        LinkedHashMap<String, ArrayList<Integer>> phoneBookSort = new LinkedHashMap<String, ArrayList<Integer>>();
        while (true){
            String name = InputFIO("Для завершения ввода введите 'end'.\nВведите имя: ");
            if(name.equalsIgnoreCase("end")) {
                break;
            } else {
                if (phoneBook.containsKey(name)) {
                    phoneBook.get(name).add(InputNum("Имя существует\nДобавте номер: "));
                    System.out.println("Номер добавлен: " + phoneBook.get(name));
                    System.out.println("-".repeat(35));
                } else {
                    phoneBook.put(name, InputNums("Введите номер: "));
                    System.out.println("Номер добавлен: " + phoneBook.get(name));
                    System.out.println("-".repeat(35));
                }
            }
        }

        ArrayList<String> names = new ArrayList<String>();
        String name = null;
        int size = 0;
        for(int i = 0; i < phoneBook.size(); i++) {
            for (String line : phoneBook.keySet()) {
                if (names.contains(line)) {
                    continue;
                }
                else if (size < phoneBook.get(line).size()) {
                    size = phoneBook.get(line).size();
                    name = line;
                }
            }
            names.add(name);
            size = 0;
        }
        for(String line: names){
            phoneBookSort.put(line, phoneBook.get(line));
        }
        System.out.println(phoneBookSort.toString());
    }

    static String InputFIO (String message) {
        Scanner input = new Scanner(System.in);
        System.out.println(message);
        String name = input.nextLine();
        return name;
    }
    static ArrayList<Integer> InputNums (String message) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        Scanner input = new Scanner(System.in);
        System.out.println(message);
        int number = input.nextInt();
        numbers.add(number);
        return numbers;
    }
    static int InputNum (String message) {
        Scanner input = new Scanner(System.in);
        System.out.println(message);
        int number = input.nextInt();
        return number;
    }
}