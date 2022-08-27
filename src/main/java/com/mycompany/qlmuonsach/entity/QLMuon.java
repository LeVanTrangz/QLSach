/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.qlmuonsach.entity;

import static com.mycompany.qlmuonsach.entity.BanDoc.AUTO_ID;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class QLMuon {

    private BanDoc banDoc;
    private PhieuMuonChiTiet[] phieuMuonChiTiet;

    public BanDoc getBanDoc() {
        return banDoc;
    }
    
    public void setBanDoc(BanDoc banDoc) {
        this.banDoc = banDoc;
    }

    public PhieuMuonChiTiet[] getPhieuMuonChiTiet() {
        return phieuMuonChiTiet;
    }

    public void setPhieuMuonChiTiet(PhieuMuonChiTiet[] phieuMuonChiTiet) {
        this.phieuMuonChiTiet = phieuMuonChiTiet;
    }

    public int tongSach() {
        int n = phieuMuonChiTiet.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (this.phieuMuonChiTiet[i] != null) {
                sum += this.phieuMuonChiTiet[i].getSoLuong();
            }
        }
        return sum;
    }

}
