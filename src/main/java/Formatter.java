public class Formatter {

    public String formatRub(double price) {
        double roundedPrice = Math.floor(price) % 10;
        double roundedPrice2 = Math.floor(price) % 100;

        String wording;
        if (roundedPrice2 == 11 || roundedPrice2 == 12 || roundedPrice2 == 13 ||
                roundedPrice2 == 14) {
            wording = roundPrice(price) + " рублей.\n";
        } else if (roundedPrice == 1) {
            wording = roundPrice(price) + " рубль.\n";
        } else if (roundedPrice < 5 && roundedPrice > 1) {
            wording = roundPrice(price) + " рубля.\n";
        } else {
            wording = roundPrice(price) + " рублей.\n";
        }
        return wording;
    }

    private String roundPrice(double price) {
        return String.format("%.2f", price);
    }
}
