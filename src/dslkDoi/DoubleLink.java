package dslkDoi;

import java.io.Serializable;

public class DoubleLink implements Serializable {
    private String maSV;
    private String hoTen;
    private double diem;
    private String kq, xl;
    public DoubleLink next, prev;

    public DoubleLink(String maSV, String hoTen, double diem) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.diem = diem;
        this.next = null;
        this.prev = null;
    }

    public DoubleLink() {
        super();
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public double getDiem() {
        return diem;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }

    public String getXl() {
        return xl;
    }

    public void setXl(String xl) {
        this.xl = xl;
    }

    public String getKq() {
        return kq;
    }

    public void setKq(String kq) {
        this.kq = kq;
    }
}
