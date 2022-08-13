package com.example.everyday.Mode;

public class NguoiDung {
    private  int MaND;
    private String HinhAnhNG,TenND,NoiDung,ThoiGian,NgayThang;

    public NguoiDung() {
    }

    public int getMaND() {
        return MaND;
    }

    public void setMaND(int maND) {
        MaND = maND;
    }

    public String getHinhAnhNG() {
        return HinhAnhNG;
    }

    public void setHinhAnhNG(String hinhAnhNG) {
        HinhAnhNG = hinhAnhNG;
    }

    public String getTenND() {
        return TenND;
    }

    public void setTenND(String tenND) {
        TenND = tenND;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String noiDung) {
        NoiDung = noiDung;
    }

    public String getThoiGian() {
        return ThoiGian;
    }

    public void setThoiGian(String thoiGian) {
        ThoiGian = thoiGian;
    }

    public String getNgayThang() {
        return NgayThang;
    }

    public void setNgayThang(String ngayThang) {
        NgayThang = ngayThang;
    }

    public NguoiDung(int maND, String hinhAnhNG, String tenND, String noiDung, String thoiGian, String ngayThang) {
        MaND = maND;
        HinhAnhNG = hinhAnhNG;
        TenND = tenND;
        NoiDung = noiDung;
        ThoiGian = thoiGian;
        NgayThang = ngayThang;
    }
}
