package es2d2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {

    public static List<Integer> generateRandomNumbers(int n) {
        List<Integer> numbers = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            numbers.add(rand.nextInt(100));
        }

        Collections.sort(numbers);
        return numbers;
    }

    public static List<Integer> reverseList(List<Integer> list) {
        List<Integer> reversedList = new ArrayList<>(list);
        Collections.reverse(reversedList);
        reversedList.addAll(list);
        return reversedList;
    }

    public static void printListByCondition(List<Integer> list, boolean isEven) {
        for (int i = 0; i < list.size(); i++) {
            if (isEven && i % 2 == 0) {
                System.out.print(list.get(i) + " ");
            } else if (!isEven && i % 2 != 0) {
                System.out.print(list.get(i) + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> numbers = generateRandomNumbers(10);
        System.out.println("Lista di numeri casuali ordinati: " + numbers);

        List<Integer> reversedNumbers = reverseList(numbers);
        System.out.println("Lista di numeri casuali ordinati in ordine inverso: " + reversedNumbers);

        System.out.print("Valori in posizioni pari: ");
        printListByCondition(reversedNumbers, true);

        System.out.print("Valori in posizioni dispari: ");
        printListByCondition(reversedNumbers, false);
    }
}
