import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda01 {


/*
	 	1) Lambda "Functional Programming"
	 		"Functional Programming" de "Nasil yaparim?" degil "Ne yaparim?" dusunulur.
	 	2) "Structured Programming" de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur
	 	3) "Functional Programming" hiz, code kisaligi, code okunabilirligi
	 	ve hatasiz code yazma acilarindan cok faydalidir.
	 	4) Lambda sadece collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir ancak MAP'LERDE KULLANILMAZ.
        Lambda kullanmak hatasız code kullanmaktır.
	 */

    public static void main(String[] args) {


        List<Integer> a = new ArrayList<>(Arrays.asList(12, 13, 65, 3, 7, 34, 22, 60, 42, 55));

        printListStructured(a);   // core java, uzun yol
        System.out.println();
        System.out.println("   ***   ");

        printListMitFunctional(a); // lambda expression
        System.out.println();
        System.out.println("   ***   ");

        printElFunctional1(a);  // method referance
        System.out.println();
        System.out.println("=============");

        printCiftStructered(a);
        System.out.println();
        System.out.println("   ***   ");

        printCiftElFunctional1(a);
        System.out.println();
        System.out.println("   ***   ");

        printCiftElFunctional2(a);
        System.out.println();
        System.out.println("==================");

        printELCiftAltmistanKucuk(a);
        System.out.println();
        System.out.println("==================");

        printListTekveyaKucukYirmi(a);
        System.out.println();
        System.out.println("==================");

        printELCiftKare(a);
        System.out.println();
        System.out.println("==================");

        printTekKupBirFazla(a);
        System.out.println();
        System.out.println("==================");

        printCiftKarekok(a);
        System.out.println();
        System.out.println("==================");

        maxElFunctional(a);


    }

    // SORU 1

    //structured Programming ile list elemanlerinin  tamamini aralarina bosluk birakarak yazdiriniz
    // 1. yol -> bildigimiz core java, uzun yol

    public static void printListStructured(List<Integer> a) {  // 12 13 65 3 7 34 22 60 42 55

        for (Integer w : a) {

            System.out.print(w + " ");

        }


    }

    //Functional Programming ile list elemanlerinin  tamamini aralarina bosluk birakarak yazdiriniz
    // 2. yol-> Lambda Expression ile

    public static void printListMitFunctional(List<Integer> list) {

        // Lambda Expression ile
        list.stream().forEach(t -> System.out.print(t + " "));

        // stream () : bir lambda methodur ve datalari yukaridan asagiya akis sekline getirir.
        // Yataya göre (structured Programming) daha fazla methodu vardir
        // forEach () : datanin parametresine gore her bir eleamni isler
        // t->     : Lambda operatoru
        // Lambda Expression yapisi cok tavsiye edilmez daha cok METHOD REFERENCE kullanilir


    }

    // 3. yol -> Method Reference ile
    //Method Reference --> kendi create ettigimiz veya java'dan aldigimiz method ile
    // ClassName::MethodName--> EZBERLE !!!

    public static void printEl(double t) {  // refere edilecek method creat edildi
        System.out.print(t + " ");          // data type int olunca karekok almali sorularin
        // sonucu virgüllu olacagi icin RTE hatasi verir. BKZ satir 233

    }

    public static void printElFunctional1(List<Integer> list) {

        // Method Reference ile

        list.
                stream().
                forEach(Lambda01::printEl); // das ist lambda!


    }

    // ==================================================

    // SORU 2

    //structured Programming ile list elemanlarinin  cift olanalrini ayni satirda aralarina bosluk birakarak yazdiriniz.
    // 1. yol -> bildigimiz core java, uzun yol
    public static void printCiftStructered(List<Integer> c) {

        for (Integer w : c) {

            if (w % 2 == 0) System.out.print(w + " ");

        }


    }


    //Functional Programming ile list elemanlarinin  cift olanalrini ayni satirda aralarina bosluk birakarak yazdirin
    // 2. yol-> Lambda Expression ile

    public static void printCiftElFunctional1(List<Integer> list) {


        list.
                stream().
                filter(t -> t % 2 == 0).
                forEach(Lambda01::printEl);

        // filter () burada if görevi görüyor, istenen sarta göre filtreleme yapiyor.

    }


    // 3. yol -> Method Reference ile
    public static boolean ciftBul(int i) { // refere edilecek tohum method creat edildi.


        return i % 2 == 0;


    }

    public static void printCiftElFunctional2(List<Integer> list) {

        list.
                stream().
                filter(Lambda01::ciftBul).
                forEach(Lambda01::printEl);  // iki tane method refere edildi


    }

    // SORU 3
    //  Functional Programming ile list elemanlarinin  cift olanalrinin 60 dan kucuk olanlarını
    //  ayni satirda aralarina bosluk birakarak yazdiriniz


    public static void printELCiftAltmistanKucuk(List<Integer> list) {


        list.
                stream().
                filter(t -> t % 2 == 00 & t < 60).
                forEach(Lambda01::printEl);
        // list.stream().filter(t->t%2==00 & t<60).forEach(t-> System.out.println(t + " "));


    }

    // SORU 4

    //Functional Programming ile list elemanlarinin  tek olanalrini veya 20 dan buyuk
    // olanlarını ayni satirda aralarina bosluk birakarak yazdiriniz


    public static void printListTekveyaKucukYirmi(List<Integer> list) {


        list.
                stream().
                filter(t -> t % 2 != 0 || t > 20).
                forEach(Lambda01::printEl);


    }

    // SORU 5
    //Functional Programming ile list elemanlarinin  cift olanlarinin
    // karelerini ayni satirda aralarina bosluk birakarak yazdiriniz


    public static void printELCiftKare(List<Integer> list) {

        list.
                stream().
                filter(Lambda01::ciftBul).
                map(t -> t * t).
                forEach(Lambda01::printEl);

        // map() : bir ara islemde kullanilir. Elemanlari istenen isleme gore degistirmek, update etmek icin kullanilir
        //  list.stream().filter(t-> t%2==0).forEach(t-> System.out.println(t*t + " "));


    }


    // SORU 6

    // Functional Programming ile list elemanlarinin  tek olanlarinin
    // kuplerinin bir fazlasini ayni satirda aralarina bosluk birakarak yazdiriniz


    public static void printTekKupBirFazla(List<Integer> list) {


        list.
                stream().
                filter(t -> t % 2 != 0).
                map(t -> (t * t * t) + 1).
                forEach(Lambda01::printEl);


    }

    // SORU 7

    // Functional Programming ile list elemanlarinin  cift olanlarinin
    // karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz


    public static void printCiftKarekok(List<Integer> list) {

        // list.stream().filter(Lambda01::ciftBul).map(Math::sqrt).forEach(t -> System.out.println(t + " "));
        list.
                stream().
                filter(Lambda01::ciftBul).
                map(Math::sqrt).
                forEach(Lambda01::printEl);


    }

    // SORU 8

    //list'in en buyuk elemanini yazdiriniz

    public static void maxElFunctional(List<Integer> list) {

        Optional<Integer> maxEl = list.stream().reduce(Math::max);

        System.out.println(maxEl);

        // reduce () : azaltmak anlaminda gelir. Bir cok datayi tek bir dataya(max, min, topla vs) cevirmek icin kullanilir

        // Eger list in tüm elemanlarini toplamak isteseydik -->>> reduce(Math::addExact)


    }


}
