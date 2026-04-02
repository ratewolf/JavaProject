package ai0402;

public class DailySales {
    public static void main(String[] args) {
        int totalPurchase = 0;
        int totalSell = 0;
        int totalSale;

        totalPurchase += 900 * 10;
        totalSell += 1800 * 2;
        totalPurchase += 3500 * 5;
        totalSell += 4000 * 4;
        totalSell += 1500 * 1;
        totalSell += 2000 * 4;
        totalSell += 1800 * 5;

        totalSale = totalSell - totalPurchase;

        System.out.printf("오늘 총매출액은 %d원입니다.", totalSale);
    }
}
