package Lambda;

public class Mustingo {

    private String batch;
    private String batchName;
    private  int batchOrt;
    private int ogrcSayisi;

    public Mustingo(String batch, String batchName, int batchOrt, int ogrcSayisi) {
        this.batch = batch;
        this.batchName = batchName;
        this.batchOrt = batchOrt;
        this.ogrcSayisi = ogrcSayisi;
    }

    public Mustingo() {
    }

    public  String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public int getBatchOrt() {
        return batchOrt;
    }

    public void setBatchOrt(int batchOrt) {
        this.batchOrt = batchOrt;
    }

    public int getOgrcSayisi() {
        return ogrcSayisi;
    }

    public void setOgrcSayisi(int ogrcSayisi) {
        this.ogrcSayisi = ogrcSayisi;
    }

    @Override
    public String toString() {
        return "TechPro{" +
                "batch='" + batch + '\'' +
                ", batchName='" + batchName + '\'' +
                ", batchOrt=" + batchOrt +
                ", ogrcSayisi=" + ogrcSayisi +
                '}';
    }
}
