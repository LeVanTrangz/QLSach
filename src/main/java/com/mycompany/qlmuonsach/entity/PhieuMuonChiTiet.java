/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.qlmuonsach.entity;

/**
 *
 * @author Admin
 */
public class PhieuMuonChiTiet {

    private Sach sach;
    private int soLuong;
    private String tinhTrang;

    public Sach getSach() {
        return sach;
    }

    public void setSach(Sach sach) {
        this.sach = sach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    @Override
    public String toString() {
        return "PhieuMuonChiTiet{" + "sach=" + sach + ", soLuong=" + soLuong + ", tinhTrang=" + tinhTrang + '}';
    }

}
