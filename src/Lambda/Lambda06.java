package Lambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

import static com.sun.org.apache.xalan.internal.lib.ExsltStrings.split;

public class Lambda06 {
    public static void main(String[] args) throws IOException {

        // Soru 01
        System.out.println("Soru 01 --> yenidenBaslamali.txt dosyasini okuyunuz.(Console'a yazdiriniz)");

        Files.
                lines(Paths.get("src/Lambda/yenidenBaslamali.txt")). // file'a erisip file satirlari akisa alindi
                forEach(System.out::println);


        // Soru 02
        System.out.println("Soru 02 --> yenidenBaslamali.txt dosyasini buyuk harflerle okuyunuz.(Console'a buyuk harflerle yazdiriniz)");

        Files.
                lines(Paths.get("src/Lambda/yenidenBaslamali.txt")).
                map(String::toUpperCase).
                //map(t->t.toUpperCase()).
                        forEach(System.out::println);

        // Soru 03
        System.out.println("Soru 03 --> yenidenBaslamali.txt dosyasindaki ilk satiri kucuk harflerle yazdiriniz.");

        Files.
                lines(Paths.get("src/Lambda/yenidenBaslamali.txt")).
                //findFirst().
                        limit(1).
                map(String::toLowerCase).
                forEach(System.out::println);

        // Soru 04
        System.out.println("Soru 04 --> yenidenBaslamali.txt dosyasinda \"yeniden\" kelimesinin kac satirda gectiginiz yazdiriniz");

        System.out.println(Files.
                lines(Paths.get("src/Lambda/yenidenBaslamali.txt")).
                filter(t -> t.
                        contains("basari")).  // basari icerme sarti
                        count());                          // sarti saglayan elemanlar yani satirlar sayildi

        // Soru 05
        System.out.println("Soru 05 --> yenidenBaslamali.txt dosyasindaki farkli kelimeleri  yazdiriniz.");


        System.out.println(Files.
                lines(Paths.get("src/Lambda/yenidenBaslamali.txt")).
                map(t -> t.
                        split(" ")).
                flatMap(Arrays::stream).
                distinct().
                toList());
        //collect(Collectors.toList()));

        // Soru 06
        System.out.println("Soru 06 --> yenidenBaslamali.txt dosyasindaki tum kelimeleri natural order  yazdiriniz.");


        System.out.println(Files.
                lines(Paths.get("src/Lambda/yenidenBaslamali.txt")).
                map(t -> t.
                        toLowerCase().
                        split(" ")).
                flatMap(Arrays::stream).
                sorted().
                toList());

        // Soru 07
        System.out.println("Soru 07 --> yenidenBaslamali.txt dosyasinda \"gül\" kelimesinin kac kere gectigini buyuk harf kucuk harf bagımsız yaziniz.");


        System.out.println(Files.
                lines(Paths.get("src/Lambda/yenidenBaslamali.txt")).
                map(t -> t.
                        toLowerCase().
                        split(" ")).
                flatMap(Arrays::stream).
                filter(t -> t.
                        toLowerCase().
                        contains("gül")).
                count());

        // Soru 08
        System.out.println("Soru 08 --> yenidenBaslamali.txt dosyasinda \"a\" harfi gecen kelimelerin sayisini ekrana yazdiran programi yaziniz");

        System.out.println(Files.
                lines(Paths.get("src/Lambda/yenidenBaslamali.txt")).
                map(t -> t.
                        split(" ")).
                flatMap(Arrays::stream).
                filter(t -> t.
                        contains("a")).
                count());

        // Soru 09
        System.out.println("Soru 09 --> yenidenBaslamali.txt dosyasinda icinde \"a\" harfi gecen kelimeleri yazdiriniz");


        Files.
                lines(Paths.get("src/Lambda/yenidenBaslamali.txt")).
                map(t -> t.
                        split(" ")).
                flatMap(Arrays::stream).
                filter(t -> t.
                        contains("a")).
                forEach(System.out::println);

        // Soru 10
        System.out.println("Soru 10 --> yenidenBaslamali.txt dosyasinda kac farklı harf kullanildigini yazdiriniz");

        System.out.println(Files.
                lines(Paths.get("src/Lambda/yenidenBaslamali.txt")).
                map(t -> t.
                        replaceAll("\\W", "").   // array verir
                                replaceAll("\\d", "").   // array verir
                                split("")).
                flatMap(Arrays::stream).
                distinct().
                count());

        // Soru 11
        System.out.println("Soru 11 --> yenidenBaslamali.txt dosyasinda kac farkli kelime kullanildigini yazdiriniz");


        System.out.println(Files.
                lines(Paths.
                        get("src/Lambda/yenidenBaslamali.txt")).
                map(t -> t.
                        replaceAll("[.!?,\\-]", "").
                        split(" ")).
                flatMap(Arrays::stream).
                distinct().
                count());


    }
}
