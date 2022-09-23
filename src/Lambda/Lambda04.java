package Lambda;

import java.util.*;
import java.util.stream.Collectors;


public class Lambda04 {
    public static void main(String[] args) {
        Mustingo trGunduz = new Mustingo("yaz", "TR gunduz", 97, 124);
        Mustingo engGunduz = new Mustingo("kis", "ENG gunduz", 95, 131);
        Mustingo trGece = new Mustingo("bahar", "TR gece", 98, 143);
        Mustingo engGece = new Mustingo("sonbahar", "ENG gece", 93, 151);

        List<Mustingo> d = new ArrayList<>(Arrays.asList(trGunduz, engGunduz, trGece, engGece));

//bu class'da agirlikli return type calisacagiz


        System.out.println(batchOrtalama92(d));
        System.out.println();
        System.out.println("   ***   ");

        System.out.println(ogrenciSayisi110danAzMi(d));
        System.out.println();
        System.out.println("   ***   ");

        System.out.println(baharVarMI(d));
        System.out.println();
        System.out.println("   ***   ");

        System.out.println(batchSiralamaOgrenciSayisinaGore(d));
        System.out.println();
        System.out.println("   ***   ");


        System.out.println(ortalamayaGoreBuyuktenKucukgeIlk3(d));
        System.out.println();
        System.out.println("   ***   ");

        System.out.println(ogrenciSayisiEnAzIkinciBatch(d));
        System.out.println();
        System.out.println("   ***   ");

        System.out.println(ortalama95BuyukBatchlerinOgrenciSayilariToplami(d));
        System.out.println();
        System.out.println("   ***   ");

        System.out.println(batchOrt95BykOgrcSayisi1(d));
        System.out.println();
        System.out.println("   ***   ");

        System.out.println(ogrenciSayisi130danBuyukBatchOrtalamasi(d));
        System.out.println();
        System.out.println("   ***   ");

        System.out.println(gunduzBatchSayisi(d));
        System.out.println();
        System.out.println("   ***   ");

        System.out.println(ogrenciSayisi130danBuyukBatchlerdenEnBuyukOlaninOrtalamasi(d));
        System.out.println();
        System.out.println("   ***   ");

        System.out.println(ogrenciSayisi150denAzEnKucukBatchOrtalamasi(d));
        System.out.println();
        System.out.println("   ***   ");


    }


    //Soru 01 :  batch ort'larinin 92 den buyuk oldugunu kontrol eden bir program create ediniz.

    public static boolean batchOrtalama92(List<Mustingo> list) {

        return list.
                stream().
                allMatch(t -> t.getBatchOrt() > 92); //akısdaki her eleman batchort field'a gore eslesmesi kontrol edildi


    }

    //Soru 02-->ogrcenci sayilarinin   110 den az olmadigini  kontrol eden program create ediniz.

    public static boolean ogrenciSayisi110danAzMi(List<Mustingo> list) {


        return list.
                stream().
                allMatch(t -> t.getOgrcSayisi() >= 100);
        // noneMatch(t -> t.getOgrcSayisi() < 110);


    }

    // Soru 03-->batch'lerde herhangi birinde "bahar" olup olmadigini  kontrol eden program create ediniz.

    public static boolean baharVarMI(List<Mustingo> list) {

        return list.
                stream().
                anyMatch(t -> t.getBatch().equals("bahar"));


    }

    //Soru 04-->batch'leri ogrenci sayilarina gore buyukten kucuge  siralayiniz.

    public static List<Mustingo> batchSiralamaOgrenciSayisinaGore(List<Mustingo> list) {

        return list.
                stream().
                sorted(Comparator.comparing(Mustingo::getOgrcSayisi).
                        reversed()). // ogrcSayisi parametresine gore ters siraladik
                        collect(Collectors.toList());
        //  collect ()           :  methodu akistaki elemanlari istenen sarta gore toplar
        //  Collectors.toList() :  collect'e toplanan elemanlarilist'e cevirir


    }

    //Soru 05-->batch'leri batch ort gore  b->k siralayip ilk3 'unu yazdiriniz.


    public static List<Mustingo> ortalamayaGoreBuyuktenKucukgeIlk3(List<Mustingo> list) {

        return list.
                stream().
                sorted(Comparator.comparing(Mustingo::getBatchOrt)
                        .reversed()).
                limit(3).
                collect(Collectors.toList());


    }

    //Soru 06--> ogrc sayisi en az olan 2. batch'i  yazdiriniz.


    public static List<Mustingo> ogrenciSayisiEnAzIkinciBatch(List<Mustingo> list) {

        return list.
                stream().
                sorted(Comparator.comparing(Mustingo::getOgrcSayisi)).
                skip(1).
                limit(1).
                collect(Collectors.toList());


    }

    //Soru 07--> batch ort 95 'den buyuk olan batch'lerin ogrc sayilarini toplamini yazdiriniz

    public static int ortalama95BuyukBatchlerinOgrenciSayilariToplami(List<Mustingo> list) {

        return list.
                stream().
                filter(t -> t.getBatchOrt() > 95).           // 95 den byk sarti saglandi
                        map(t -> t.getOgrcSayisi()).         // batch ortalamasi olan data, ogrenci sayisi olarak update edildi
                //reduce(0,Integer::sum);            // ogrc sayisi toplandi
                        reduce(0, (t, u) -> t + u);   // ogrc sayisi toplandi


    }

    public static int batchOrt95BykOgrcSayisi1(List<Mustingo> list) {

        return list.
                stream().
                filter(t -> t.getBatchOrt() > 95).        // 95 den byk sarti saglandi
                        mapToInt(t -> t.getOgrcSayisi()). // mapToInt()-->type gore int return ederki sum() calisir
                // reduce gerek kalmaz daha kisa ve hizli code imkani saglar
                        sum();

    }

    // Soru 08--> Ogrenci sayisi 130'dan buyuk olan Batch'lerin batchOrt'larinin ortalamasini bulunuz.

    public static OptionalDouble ogrenciSayisi130danBuyukBatchOrtalamasi(List<Mustingo> list) {

        return list.
                stream().
                filter(t -> t.getOgrcSayisi() > 130).
                mapToDouble(t -> t.getBatchOrt()).
                average();


    }

    // Soru 09-->gunduz batch'lerinin sayisini  yazdiriniz.

    public static int gunduzBatchSayisi(List<Mustingo> list) {

        return (int) list.
                stream().
                filter(t -> t.getBatchName().
                        contains("gunduz")).
                count();


    }
    // Soru 10-->Ogrenci sayilari 130'dan fazla olan batch'lerin en buyuk batch ortalamasini bulunuz

    public static OptionalInt ogrenciSayisi130danBuyukBatchlerdenEnBuyukOlaninOrtalamasi(List<Mustingo> list) {

        return list.
                stream().
                filter(t -> t.getOgrcSayisi() > 130).
                mapToInt(Mustingo::getBatchOrt).
                max();


    }

    // Soru 11-->Ogrenci sayilari 150'dan az olan batch'lerin en kucuk batch ortalamasini bulunuz.


    public static int ogrenciSayisi150denAzEnKucukBatchOrtalamasi(List<Mustingo> list) {

        return list.
                stream()
                .filter(t -> t.getOgrcSayisi() < 150).
                mapToInt(Mustingo::getBatchOrt).
                min().
                getAsInt();//getAsInt()-->cıktıyı int type olarak return eder


    }

}
