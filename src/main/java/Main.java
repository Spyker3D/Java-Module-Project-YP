import android.security.keystore.StrongBoxUnavailableException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num;

        while (true) {
            System.out.print("Укажите на скольких человек необходимо разделить счёт: ");
            if (scanner.hasNextInt()) {
                num = scanner.nextInt();
                if (num == 1) {
                    System.out.println("Ошибка! Количество человек = 1. Расчёт не имеет смысла. " +
                            "Введите количество человек заново.");
                } else if (num < 1) {
                    System.out.println("Ошибка! Количество челвовек должно быть больше 1." +
                            "Введите количество человек заново.");
                } else {
                    scanner.nextLine();
                    break;
                }
            } else {
                System.out.println("Ошибка! Количество человек должно быть натуральным числом.");
                scanner.nextLine();
            }
        }

        String allItemsList = "";
        double totalPrice = 0;


        while (true) {
            Calculator calculator = new Calculator();
            String name = calculator.addName();
            double price = calculator.addPrice();

            totalPrice += price;
            allItemsList = calculator.getAllItemsList(allItemsList, name, price);

            System.out.println("Товар успешно добавлен в калькулятор!" +
                    " Хотите добавить еще один товар? Если да, то введите любой символ, " +
                    "если нет - введите команду \"Завершить\".");

            if (scanner.nextLine().equalsIgnoreCase("Завершить")) {
                break;
            }
        }
        scanner.close();

        System.out.println("Добавленные товары:\n" + allItemsList);

        Formatter formatting = new Formatter();
        System.out.println("Cумма к оплате: " + formatting.formatRub(totalPrice / num));
    }
}