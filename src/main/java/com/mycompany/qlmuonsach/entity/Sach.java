/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.qlmuonsach.entity;

import static com.mycompany.qlmuonsach.entity.BanDoc.AUTO_ID;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Sach {

    private int maSach;
    private String tenSach;
    private String tacGia;
    private ChuyenNganh chuyenNganh;
    private String namXuatBan;

    public Sach() {
        if (AUTO_ID == -1) {
            AUTO_ID = 10000;
            this.maSach = AUTO_ID;
            return;
        }
        this.maSach = ++AUTO_ID;
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public ChuyenNganh getChuyenNganh() {
        return chuyenNganh;
    }

    public void setChuyenNganh(ChuyenNganh chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }

    public String getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(String namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    @Override
    public String toString() {
        return "Sach{" + "maSach=" + maSach + ", tenSach=" + tenSach + ", tacGia=" + tacGia + ", chuyenNganh=" + chuyenNganh + ", namXuatBan=" + namXuatBan + '}';
    }

    public void inputInfo() {
        System.out.println("Nhap ten sach: ");
        tenSach = new Scanner(System.in).nextLine();
        System.out.println("Nhap ten tac gia: ");
        tacGia = new Scanner(System.in).nextLine();
        System.out.println("Moi ban chon chuyen nghanh cua sach: ");
        System.out.println("1. Khoa Hoc Tu Nhien.");
        System.out.println("2. Van Hoc - Nghe Thuat.");
        System.out.println("3. Dien Tu Vien Thong.");
        System.out.println("4. Cong Nghe Thong Tin.");
        System.out.print("Nhap lua chon cua ban: ");
        int choice = -1;
        do {
            choice = new Scanner(System.in).nextInt();
            if (choice >= 1 && choice <= 4) {
                break;
            }
            System.out.println("Lua chon cua ban khong hop le, vui long chon lai!");
        } while (choice > 4 || choice < 1);
        switch (choice) {
            case 1:
                this.chuyenNganh = chuyenNganh.KHTN;
                break;
            case 2:
                this.chuyenNganh = chuyenNganh.VH_NT;
                break;
            case 3:
                this.chuyenNganh = chuyenNganh.DTVT;
                break;
            case 4:
                this.chuyenNganh = chuyenNganh.CNTT;
                break;
        }
        System.out.println("Nhap nam xuat ban: ");
        namXuatBan = new Scanner(System.in).nextLine();
    }

}
