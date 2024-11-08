package SQL;

public class KhachHang {
    private static int maKH;
    private static String ten;

    public int getMaKH(){
        return maKH;
    }

    public String getTen(){
        return ten;
    }

    public KhachHang(int maKH, String ten){
        this.maKH = maKH;
        this.ten = ten;
    }
}
