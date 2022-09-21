import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda02 {
    public static void main(String[] args) {

        List<Integer> b = new ArrayList<>(Arrays.asList(12, -3, 3, 65, 7, 34, 22, -60, 42, 15));

        printCiftKareMax(b);
        System.out.println();
        System.out.println("   ***   ");

        printListToplam1(b);
        System.out.println();
        System.out.println("   ***   ");

        printListToplam2(b);
        System.out.println();
        System.out.println("   ***   ");

        printCiftCarpim1(b);
        System.out.println();
        System.out.println("   ***   ");

        printCiftCarpim2(b);
        System.out.println();
        System.out.println("   ***   ");

        min1(b);
        min2(b);
        min3(b);
        min4(b);
        System.out.println();
        System.out.println("   ***   ");


    }

    // Soru 1

    //List'in cift olan elemanlarin karelerini aliniz ve en buyugunu yazdiriniz

    public static void printCiftKareMax(List<Integer> list) {


        Optional max = list.stream().filter(Lambda01::ciftBul).map(t -> t * t).reduce(Integer::max);

        // Optional max = list.stream().filter(Lambda01::ciftBul).map(t -> t * t).reduce(Math::max);
        // reduce(Math::max) da kullanilabilir ancak  reduce(Integer::max) daha spesifik oldugu icin daha hizli calisir


        // int max = list.stream().filter(Lambda01::ciftBul).map(t -> t * t).reduce(Integer::max);
        // reduce () return edilen eleman null ya da int ten buyuk olma ihtimali icin Java guvenlik olarak handle ederek
        // Optional Class i sart kosuyor

        System.out.println(max);


    }

    // Soru 2
    // 1. yol
    //List'teki tum elemanlarin toplamini yazdiriniz. Lambda Expression ile... Method referance degil!

    public static void printListToplam1(List<Integer> list) {


        int toplam = list.stream().reduce(0, (x, y) -> x + y);

        System.out.println(toplam);

        // x her zaman ilk degerini atanan degerden (0) alir.
        // y her zaman degerini list.stream()'den yani akistan alir.
        // x ilk degerden sonraki degerlerini islemden alir.


    }
    // 2. yol
    //List'teki tum elemanlarin toplamini yazdiriniz. Method Reference ile.


    public static void printListToplam2(List<Integer> list) {

        Optional<Integer> toplam1 = list.stream().reduce(Integer::sum);
        Optional<Integer> toplam2 = list.stream().reduce(Math::addExact);

        System.out.println(toplam1);
        System.out.println();
        System.out.println(toplam2);

    }


    // Soru 3
    //1. Yol
    //List'teki cift elemanlarin carpimini  yazdiriniz. Method Reference ile.

    public static void printCiftCarpim1(List<Integer> list) {

        Optional<Integer> carpimSonuc = list.stream().filter(Lambda01::ciftBul).reduce(Math::multiplyExact);

        System.out.println(carpimSonuc);


    }

    // 2. Yol
    // List'teki cift elemanlarin carpimini yazdiriniz.
    // Lambda expression...

    public static void printCiftCarpim2(List<Integer> list) {

        Integer carp = list.stream().filter(Lambda01::ciftBul).reduce(1, (x, y) -> x * y);

        // pozitif deger uretin
        Integer carpPoz = list.stream().filter(Lambda01::ciftBul).reduce(-1, (x, y) -> x * y);

        System.out.println(carp);
        System.out.println(carpPoz);


    }

    //List'teki elemanlardan en kucugunu 4 farklı yontem ile yazdiriniz
    //1. yontem Method Reference --> Integer class
    public static void min1(List<Integer> list) {
        Optional<Integer> min = list.stream().reduce(Integer::min);
        System.out.println(min);
    }

    //2. yontem Method Reference --> Math class
    public static void min2(List<Integer> list) {
        Optional<Integer> min = list.stream().reduce(Math::min);
        System.out.println(min);
    }

    //3. yontem Method Reference --> Mustingo Class (Kendi creat ettigimiz analog method)

    public static int minBul(int x, int y) {

        return x < y ? x : y;
    }

    public static void min3(List<Integer> list) {
        Optional<Integer> min = list.stream().reduce(Lambda02::minBul);
        System.out.println(min);
    }

    //4. yontem Lambda Expression

    public static void min4(List<Integer> list) {
        Integer min = list.stream().reduce(Integer.MAX_VALUE, (x, y) -> x < y ? x : y);
        System.out.println(min);
    }


}
