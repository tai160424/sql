package SQL;

public class DAT_VE{
    private static int ID;
    private static int maKH;
    private static int maTuyen;
    private static String ngayDatVe;

    public int getID(){
        return ID;
    }

    public int getmaKH(){
        return maKH;
    }

    public int getMaTuyen(){
        return maTuyen;
    }

    public String getNgayDatVe(){
        return ngayDatVe;
    }

    public DAT_VE(int ID, int maKH, int maTuyen, String ngayDatVe){
        this.ID = ID;
        this.maKH = maKH;
        this.maTuyen = maTuyen;
        this.ngayDatVe = ngayDatVe;
    }


}
