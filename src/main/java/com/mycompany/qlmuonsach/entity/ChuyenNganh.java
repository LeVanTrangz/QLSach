/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.qlmuonsach.entity;

/**
 *
 * @author Admin
 */
public enum ChuyenNganh {
    KHTN("Khoa Hoc Tu Nhien"),
    VH_NT("Van Hoc - Nghe Thuat"),
    DTVT("Dien Tu Vien Thong"),
    CNTT("Cong Nghe Thong Tin");

    public final String value;

    private ChuyenNganh(String value) {
        this.value = value;
    }
}
