package Lambda;

import Lambda.Lambda01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Lambda03 {
    public static void main(String[] args) {
        List<String> c = new ArrayList<>(Arrays.asList("mehmet",
                "emre", "nilgun", "cincix", "kader",
                "emine", "islam", "islam", "kokorec"));


        printAlfabetikTekrarsizBuyuk(c);
        System.out.println();
        System.out.println("   ***   ");

        karakSayisiTersten(c);
        System.out.println();
        System.out.println("   ***   ");

        karakSayisiKucuktenBuyuge1(c);
        System.out.println();
        System.out.println("   ***   ");

        karakSayisiKucuktenBuyuge2(c);
        System.out.println();
        System.out.println("   ***   ");

        sonHarfeGoreTersSirali(c);
        System.out.println();
        System.out.println("   ***   ");

        ciftSayiliKarelerTekrarsizBuyuktenKucuge(c);
        System.out.println();
        System.out.println("   ***   ");

        ciftSayiliKarelerTekrarsizBuyuktenKucuge(c);
        System.out.println();
        System.out.println("   ***   ");


        karakterSayisiYediKontrol(c);
        System.out.println();
        System.out.println("   ***   ");

        wIleBaslayanKontrol(c);
        System.out.println();
        System.out.println("   ***   ");

        karakterSayisiYediKontrol(c);
        System.out.println();
        System.out.println("   ***   ");

        xbitmeKotrol(c);
        System.out.println();
        System.out.println("   ***   ");

        printEnKarakterSayisiBuyukEleman(c);

        System.out.println();
        System.out.println("   ***   ");
        printEnKarakterSayisiBuyukEleman2(c);

        System.out.println();
        System.out.println("   ***   ");
        printSonHarfeGoreSiraliIlkElemanHaric(c);


    }

    // Soru 1
    // List elemanlarini alfabetik buyuk harf ve tekrarsiz yazdiriniz

    public static void printAlfabetikTekrarsizBuyuk(List<String> list) {

        list.
                stream().                   // akisa girdi
                //   map(t->t.toUpperCase()).  // elemanlar buyuk harf update edildi--> LambdaExpression ile
                        map(String::toUpperCase).   // elemanlar buyuk harf update edildi--> Method Referance ile
                sorted().                   // alfabetik sira, natural order
                distinct().                 // *** distinct () ile tekrarsiz yapildi.->>> COK ONEMLI
                forEach(t -> System.out.print(t + " ")); // yazdirildi
        // forEach(Lambda.Lambda01::printEl); ->> BURADA PRINTEL METHODUNU KULLANAMAYIZ
        // CUNKU PRINT EL METHODUNDAKI PARAMETRE Integer TÜRÜNDE. Burada ise String!

        // CINCIX EMINE EMRE ISLAM KADER KOKOREC MEHMET NILGUN


    }


    // Soru 2
    // List elemanlarinin "character sayisini" ters sirali olarak tekrarsiz yazdiriniz

    public static void karakSayisiTersten(List<String> list) {


        list.
                stream().
                map(t -> t.length()).                      // String elemanlerin uzunlugunu aldik
                sorted(Comparator.reverseOrder()).         // tersten
                distinct().                                // tekrarsiz
                forEach(t -> System.out.print(t + " "));   // yazdirdik
        // forEach(Lambda.Lambda01::printEl);


    }

    // Soru 3.1

    // List "elemanlarini" character sayisina gore kucukten buyuge gore yazdiriniz.

    public static void karakSayisiKucuktenBuyuge1(List<String> list) {


        list.
                stream().
                sorted(Comparator.comparing(t -> t.length())). // Comparator--> karsilastirma class i, comparing--> karsilastirma methodu
                forEach(t -> System.out.print(t + " "));


    }
    // Soru 3.2

    // List "elemanlarini" character sayisina gore buyukten kucuge gore yazdiriniz.


    public static void karakSayisiKucuktenBuyuge2(List<String> list) {


        list.
                stream().
                sorted(Comparator.comparing(t -> t.toString().length()).reversed()). // eleman karakter sayisina gore ozel siralama yapildi
                forEach(t -> System.out.print(t + " "));

    }

    // Soru 4
    // list elemanlarinin son harfine gore ters sirali yazdiriniz

    public static void sonHarfeGoreTersSirali(List<String> list) {


        list.
                stream().
                sorted(Comparator.
                        comparing(t -> t.toString().
                                charAt(t.toString().length() - 1)). // elemanin length()-1) --> son index inin karakterini alir
                                reversed()).                              // elemanin length()-1) --> son index inin karakterini ters siralar z->a
                forEach(t -> System.out.println(t + " "));


    }

    // Soru 5
    // listin elemanlarin karakterlerinin cift sayili  karelerini hesaplayan
    // ve karelerini tekrarsiz buyukten kucuge sirali  yaziniz.


    public static void ciftSayiliKarelerTekrarsizBuyuktenKucuge(List<String> list) {


        list.
                stream().
                //filter(t->t.length()%2==0).
                        map(t -> t.length() * t.length()).
                filter(Lambda01::ciftBul).
                sorted(Comparator.reverseOrder()).
                distinct().
                forEach(t -> System.out.println(t + ""));


    }

    // Soru 6
    // List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz

    public static void karakterSayisiYediKontrol(List<String> list) {


        //  boolean kontrol = list.stream().allMatch(t -> t.length() <= 7); // her bir elemani harf sayisi <=7 ye eslesmesine bakto

        //  if (kontrol) System.out.println("List elemanlari 7 harften buyuk degil");
        //  else System.out.println("List elemanlari 7 harften buyuk");

        //  System.out.println(kontrol);


        // =============NOT==============
       /*
          anyMatch() --> en az bir eleman sarti saglarsa true aksi durumda false return eder
          allMatch() --> tum  elemanlar sarti saglarsa true yani en az bir eleman sarti saglamazsa false return eder.
          noneMatch() --> hic bir sarti SAGLAMAZSA true yani en az bir eleman sarti SAGLARSA false return eder.

        */

        System.out.println(list.
                stream().
                allMatch(t -> t.length() <= 7) ? "List elemanlari 7 harften buyuk degil" : "List elemanlari 7 harften buyuk");

        // allMatch () : hepsi eslesiyor ise true doner
    }

    // Soru 7
    //List elemanlarinin "W" ile baslamasını kontrol ediniz

    public static void wIleBaslayanKontrol(List<String> list) {

        System.out.println(list.
                stream().
                noneMatch(t -> t.startsWith("w")) ? " w ile baslayan isim yok" : "w ile baslayan isim var");

        // noneMatch() : hicbiri eslesmez ise true doner
    }

    // Soru 8
    //List elemanlarinin "x" ile biten en az bir elemani kontrol ediniz

    public static void xbitmeKotrol(List<String> list) {

        System.out.println(list.
                stream().
                anyMatch(t -> t.endsWith("x")) ? " x ile biten isim var" : "x ile biten isim yok");

        // anyMatch() : en az bir tanesi eslesiyorsa true dondurur
    }

    // Soru 9
    // Karakter sayisi en buyuk elemani yazdiriniz.

    public static void printEnKarakterSayisiBuyukEleman(List<String> list) {

        System.out.println(list.
                stream().
                sorted(Comparator.comparing(t -> t.toString().length()). // lengt karakter uzunluguna gore siraladik -->kucukten buyuge
                        reversed()).                                     // ters siraladi --> buyukten kucuge
                        findFirst());


    }

    public static void printEnKarakterSayisiBuyukEleman2(List<String> list) {

        Stream<String> sonIsim = list.
                stream().
                sorted(Comparator.comparing(t -> t.toString().length()). // length karakter uzunluguna gore siraladik -->kucukten buyuge
                        reversed()).                                     // ters siraladi --> buyukten kucuge
                //   findFirst());
                        limit(1);                                        // limit(a) akistan cikan elemanlari a parametresine gore sinirlandirir, ilk a elemani alir
        System.out.println(Arrays.toString(sonIsim.toArray()));


    }

    // Soru 10
    // list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari yazdiriniz

    public static void printSonHarfeGoreSiraliIlkElemanHaric(List<String> list) {

        list.
                stream().
                sorted(Comparator.comparing(t -> t.charAt(t.length() - 1))).
                skip(1). // skip(): bu atlama methodu
                //forEach(t->System.out.println(t+ " "));
                        forEach(System.out::println);


    }


}
