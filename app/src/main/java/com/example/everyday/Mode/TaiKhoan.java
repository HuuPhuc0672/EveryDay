package com.example.everyday.Mode;

public class TaiKhoan {
    public String TenTk,EmailTk,PassTK;

    public TaiKhoan() {
    }

    public TaiKhoan(String tenTk, String emailTk, String passTK) {
        TenTk = tenTk;
        EmailTk = emailTk;
        PassTK = passTK;
    }

    public String getTenTk() {
        return TenTk;
    }

    public void setTenTk(String tenTk) {
        TenTk = tenTk;
    }

    public String getEmailTk() {
        return EmailTk;
    }

    public void setEmailTk(String emailTk) {
        EmailTk = emailTk;
    }

    public String getPassTK() {
        return PassTK;
    }

    public void setPassTK(String passTK) {
        PassTK = passTK;
    }
}
