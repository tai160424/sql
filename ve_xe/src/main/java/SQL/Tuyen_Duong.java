package SQL;

public class Tuyen_Duong {
    private static int maTuyen;
    private static String diemDi;
    private static String diemDen;
    private static int giaVe;

    public int getMaTuyen() {
        return maTuyen;
    }

    public String getDiemDi(){
        return diemDi;
    }

    public String getDiemDen(){
        return diemDen;
    }

    public int getGiaVe() {
        return giaVe;
    }

    public Tuyen_Duong(int maTuyen, String diemDi, String diemDen, int giaVe){
        this.maTuyen = maTuyen;
        this.diemDi = diemDi;
        this.diemDen = diemDen;
        this.giaVe = giaVe;
    }

}
