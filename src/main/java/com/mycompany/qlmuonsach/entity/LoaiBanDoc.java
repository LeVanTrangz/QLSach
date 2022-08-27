/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.qlmuonsach.entity;

/**
 *
 * @author Admin
 */
public enum LoaiBanDoc {
    SV("Sinh Vien"),
    SVCH("Sinh Vien Cao Hoc"),
    GV("Giao Vien");

    public final String value;

    private LoaiBanDoc(String value) {
        this.value = value;
    }
}
