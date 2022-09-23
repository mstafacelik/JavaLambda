package Lambda;

import java.util.stream.IntStream;

public class Lambda05 {
    public static void main(String[] args) {


        System.out.println(topla1(10));
        System.out.println("***");
        System.out.println(topla2(10));
        System.out.println("***");
        System.out.println(toplaCift(10));
        System.out.println("***");
        System.out.println(toplamIlkXCiftSayi(10));
        System.out.println("***");
        ilkXPozitifTekSayiToplami(10);
        System.out.println("***");
        ikininXKuvveti(10);
        System.out.println("***");
        istenenSayiKuvvet(2, 3); // 2 nin ilk 3 kuvveti : 2 4 8
        istenenSayiKuvvet(3, 4); // 3 un ilk 4 kuvveti  : 3 9 27 81
        System.out.println("***");
        System.out.println(istenenSayininXinciKuvveti(2, 4));
        System.out.println("***");
        System.out.println(faktoriyelHesaplama(5));


    }
    //SORU 01 --> 1'den x'e kadar tamsayilari toplayan bir program yaziniz.

    //Structured Programming ( Core Java ile)

    public static int topla1(int x) {

        int summe = 0;

        for (int i = 0; i <= x; i++) {

            summe += i;


        }
        return summe;


    }


    //Functional Programming

    public static int topla2(int x) {


        return IntStream.range(1, x + 1). //1 2 3 ... x elemanarinin akısı --> 1 dahil x+1 haric tipki subString() teki gibi
                sum();

        //return IntStream.rangeClosed(1,x).sum(); --> 1 2 3 ...x --> 1 ve x dahil


    }


    //SORU 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program yaziniz

    public static int toplaCift(int x) {


        return IntStream.range(1, x + 1). //1 2 3 ... x elemanarinin akısı
                filter(t -> t % 2 == 0). //2 4 6 ... elaman akısı
                //  filter(Lambda01::ciftBul). //2 4 6 ... elaman akısı
                        sum();

    }

    //SORU 03 --> Ilk x pozitif cift sayiyi toplayan program yaziniz

    public static int toplamIlkXCiftSayi(int x) {


        return IntStream.iterate(2, t -> t + 2). //2 4 6 ... x elemanlarinin akisi
                limit(x). // akistaki ilk x elamanni verir
                sum();


    }


    //SORU 04 --> Ilk X pozitif tek tamsayiyi toplayan programi yaziniz


    public static void ilkXPozitifTekSayiToplami(int x) {


        int sonuc = IntStream.iterate(1, t -> t + 2).
                limit(x).
                sum();
        System.out.println(sonuc);


    }


//SORU 05.1 --> 2'nin ilk x kuvvetini ekrana yazdiran programi yaziniz--> 2 4 8 16


    public static void ikininXKuvveti(int x) {


        IntStream.
                iterate(2, t -> t * 2).
                limit(x).
                forEach(t -> System.out.print(t + " "));
        //  forEach(Lambda01::printEl);


    }


//SORU 06 --> Istenilen bir sayinin ilk x  kuvvetini ekrana yazdiran programi yaziniz


    public static void istenenSayiKuvvet(int a, int x) {


        IntStream.iterate(a, t -> t * a).limit(x).forEach(t -> System.out.println(t + " "));


    }

    //SORU 07 --> Istenilen bir sayinin  x.  kuvvetini ekrana yazdiran programi yaziniz


    public static int istenenSayininXinciKuvveti(int a, int x) {


        return
                IntStream.
                        iterate(a, t -> t * a).
                        limit(x).
                        // reduce(Math::max);
                                reduce(0, (t, u) -> u);
        //skip(x-1);    // skip ten sonra cikan elemanlari toList ile yazdirmaliyiz


    }

    //SORU 07 --> Istenilen bir sayinin faktoriyelini hesaplayan program yaziniz


    public static int faktoriyelHesaplama(int x) {

        return IntStream.range(1, x + 1).
                // reduce(Math::multiplyExact);

                        reduce(1, (t, u) -> t * u);

    }


//Buyuk sayilarla faktoriyel...


}