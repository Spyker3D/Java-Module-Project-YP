import java.util.Scanner;

public class Calculator {

    public String getAllItemsList(String allItemsList, String name, double price) {
        Item item = new Item(name, price);
        allItemsList += item.toString();

        return allItemsList;

    }

    public String addName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите наименование товара: ");
        return scanner.nextLine();
    }

    public double addPrice() {
        Scanner scanner = new Scanner(System.in);
        Double price;

        System.out.print("Введите стоимость товара в формате рубли.копейки: ");
        if (scanner.hasNextDouble()) {
            price = scanner.nextDouble();
            scanner.nextLine();

            if (price < 0) {
                System.out.println("Ошибка! Стоимость товара не может быть отрицательной.");
                price = addPrice();
            }
        } else {
            System.out.println("Ошибка! Некорректно введена цена товара (введите цену в " +
                    "формате \"рубли.копейки\"");
            scanner.nextLine();
            price = addPrice();
        }
        return price;
    }
}
