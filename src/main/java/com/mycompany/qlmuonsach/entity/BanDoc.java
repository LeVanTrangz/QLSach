/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.qlmuonsach.entity;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class BanDoc {

    public static int AUTO_ID = -1;

    private int maBanDoc;
    private String hoTen;
    private String diaChi;
    private String soDT;
    private LoaiBanDoc loaiBanDoc;

    public BanDoc() {
        if (AUTO_ID == -1) {
            AUTO_ID = 10000;
            this.maBanDoc = AUTO_ID;
            return;
        }
        this.maBanDoc = ++AUTO_ID;
    }

    public int getMaBanDoc() {
        return maBanDoc;
    }

    public void setMaBanDoc(int maBanDoc) {
        this.maBanDoc = maBanDoc;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public LoaiBanDoc getLoaiBanDoc() {
        return loaiBanDoc;
    }

    public void setLoaiBanDoc(LoaiBanDoc loaiBanDoc) {
        this.loaiBanDoc = loaiBanDoc;
    }

    @Override
    public String toString() {
        return "BanDoc{" + "maBanDoc=" + maBanDoc + ", hoTen=" + hoTen + ", diaChi=" + diaChi + ", soDT=" + soDT + ", loaiBanDoc=" + loaiBanDoc + '}';
    }

    public void inputInfo() {
        System.out.println("Nhap ten ban doc: ");
        hoTen = new Scanner(System.in).nextLine();
        System.out.println("Nhap dia chi ban doc: ");
        diaChi = new Scanner(System.in).nextLine();
        System.out.println("Nhap SDT ban doc: ");
        soDT = new Scanner(System.in).nextLine();
        System.out.println("Chon loai ban doc:");
        System.out.println("1. Sinh Vien");
        System.out.println("2. Sinh Vien Cao Hoc");
        System.out.println("3. Giao Vien");
        System.out.print("Lua chon cua ban la: ");
        int choice = -1;
        do {
            choice = new Scanner(System.in).nextInt();
            if (choice >= 1 && choice <= 3) {
                break;
            }
            System.out.println("Lua chon cua ban khong hop le, vui long chon lai!");
        } while (choice > 3 || choice < 1);
        switch (choice) {
            case 1:
                this.loaiBanDoc = loaiBanDoc.SV;
                break;
            case 2:
                this.loaiBanDoc = loaiBanDoc.SVCH;
                break;
            case 3:
                this.loaiBanDoc = loaiBanDoc.GV;
                break;

        }
    }

}
