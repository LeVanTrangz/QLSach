/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

import com.mycompany.qlmuonsach.entity.BanDoc;
import com.mycompany.qlmuonsach.entity.PhieuMuonChiTiet;
import com.mycompany.qlmuonsach.entity.QLMuon;
import com.mycompany.qlmuonsach.entity.Sach;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class QLMuonSach {

    private static Sach[] sach = new Sach[100];
    private static BanDoc[] bandoc = new BanDoc[100];
    private static QLMuon[] qlmuon = new QLMuon[100];
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        showMenu();
    }

    private static void showMenu() {
        while (true) {
            int functionChoice = functionChoice();
            switch (functionChoice) {
                case 1:
                    themDauSach();
                    break;
                case 2:
                    themBanDoc();
                    break;
                case 3:
                    lapBangQLM();
                    break;
                case 4:
                    sapXepTheoTen();
                    break;
                case 5:
                    sapXepTheoSoLuongMuon();
                    break;
                case 6:
                    timKiemTheoTen();
                    break;
                case 0:
                    System.out.println("Xin cam on ban da su dung phan mem cua chung toi!");
                    System.exit(0);
                    break;
            }
        }
    }

    private static int functionChoice() {
        System.out.println("\n\n===== PHAN MEM QUAN LY MUON SACH =====\n\n");
        System.out.println("1. Nhap danh sach dau sach moi.");
        System.out.println("2. Nhap danh sach ban doc moi.");
        System.out.println("3. Lap bang QL Muon Sach.");
        System.out.println("4. Sap xep danh sach quan ly muon sach theo ten ban doc.");
        System.out.println("5. Sap xep danh sach quan ly muon sach theo so luong cuon sach duoc muon.");
        System.out.println("6. Tim kiem va hien thi danh sach muon sach theo ten ban doc.");
        System.out.println("0. Thoat chuong trinh");
        System.out.println("--------------------------------------");
        System.out.print("Lua chon cua ban la: ");
        int functionChoice = -1;
        do {
            functionChoice = new Scanner(System.in).nextInt();
            if (functionChoice >= 0 && functionChoice <= 6) {
                break;
            }
            System.out.print("Chuc nang duoc chon khong hop le, vui long chon lai: ");
        } while (functionChoice > 6 || functionChoice < 0);
        return functionChoice;
    }

    public static void themDauSach() {
        System.out.println("Nhap so luong dau sach muon them: ");
        int newBook = new Scanner(System.in).nextInt();
        for (int i = 1; i <= newBook; i++) {
            System.out.println("Nhap thong tin dau sach thu " + i);
            Sach sach = new Sach();

            sach.inputInfo();

            saveBook(sach);
        }
    }

    public static void themBanDoc() {
        System.out.println("Nhap so luong ban doc muon them: ");
        int newReader = new Scanner(System.in).nextInt();
        for (int i = 1; i <= newReader; i++) {
            System.out.println("Nhap thong tin ban doc thu " + i);
            BanDoc bandoc = new BanDoc();

            bandoc.inputInfo();

            saveReader(bandoc);
        }
    }

    private static void lapBangQLM() {
        if (!checkData()) {
            System.out.println("Chua co du lieu ve sach hay ban doc, vui long them du lieu!");
            return;
        }

        System.out.println("Nhap so luong sach ban doc muon muon: ");
        int sl = sc.nextInt();

        for (int i = 0; i < sl; i++) {
            QLMuon phieumuon = new QLMuon();
            BanDoc ngMuon = nhapNguoiMuon(i);
            phieumuon.setBanDoc(ngMuon);
            PhieuMuonChiTiet[] chitietMuonSach = taoPhieuMuonCT();
            phieumuon.setPhieuMuonChiTiet(chitietMuonSach);

            luuPhieuMuon(phieumuon);
        }
    }

    private static void luuPhieuMuon(QLMuon phieumuon) {
        for (int i = 0; i < qlmuon.length; i++) {
            if (qlmuon[i] == null) {
                qlmuon[i] = phieumuon;
                return;
            }
        }
    }

    private static boolean checkData() {
        boolean duLieuBanDoc = false;
        for (int i = 0; i < bandoc.length; i++) {
            if (bandoc[i] != null) {
                duLieuBanDoc = true;
                break;
            }
        }
        boolean duLieuSach = false;
        for (int i = 0; i < sach.length; i++) {
            if (sach[i] != null) {
                duLieuSach = true;
                break;
            }
        }
        return duLieuBanDoc && duLieuSach;
    }

    private static BanDoc nhapNguoiMuon(int index) {
        System.out.print("Nhap ma ban doc thu " + (index + 1) + " muon muon sach: ");
        int idBanDoc;
        BanDoc banDoc;
        do {
            idBanDoc = sc.nextInt();
            banDoc = timIdBanDoc(idBanDoc);
            if (banDoc != null) {
                break;
            }
            System.out.print("Khong ton tai ban doc co ID la " + idBanDoc + ", vui long nhap lai: ");
        } while (true);
        return banDoc;
    }

    private static BanDoc timIdBanDoc(int idBanDoc) {
        for (int i = 0; i < bandoc.length; i++) {
            BanDoc ngMuon = bandoc[i];
            if (ngMuon != null && ngMuon.getMaBanDoc() == idBanDoc) {
                return ngMuon;
            }
        }
        return null;
    }

    private static void showAllPhieuMuon() {
        for (int i = 0; i < qlmuon.length; i++) {
            QLMuon qlMuonSach = qlmuon[i];
            if (qlMuonSach != null) {
                System.out.println("Ban doc co ten " + qlMuonSach.getBanDoc().getHoTen() + " da muon nhung quyen sach:");
                for (int j = 0; j < qlMuonSach.getPhieuMuonChiTiet().length; j++) {
                    System.out.println(qlMuonSach.getPhieuMuonChiTiet()[j]);
                }
                System.out.println();
            }
        }
    }

    private static void timKiemTheoTen() {
        System.out.print("Nhap ten ban doc muon xem lich su muon sach: ");
        String name = new Scanner(System.in).nextLine();
        System.out.println("Lich su muon sach cua ban doc co ten " + name + " la:");

        for (int i = 0; i < qlmuon.length; i++) {
            QLMuon qlms = qlmuon[i];

            if (qlms != null) {
                if (qlmuon[i].getBanDoc().getHoTen().equals(name)) {
                    System.out.println("Ban doc" + qlms.getBanDoc().getHoTen() + " da muon nhung quyen sach sau:");
                    for (int j = 0; j < qlms.getPhieuMuonChiTiet().length; j++) {
                        System.out.println(qlms.getPhieuMuonChiTiet()[j]);
                    }
                }
            }
        }
    }

    // tạo phiếu mượn chi tiết
    private static PhieuMuonChiTiet[] taoPhieuMuonCT() {
        System.out.println("Nhap so luong dau sach ma ban doc muon muon: ");
        int slDauSach;
        do {
            slDauSach = sc.nextInt();
            if (slDauSach <= 5 && slDauSach > 0) {
                break;
            }
            System.out.print("Ban khong the muon qua 5 dau sach, hay nhap lai!");
        } while (true);

        PhieuMuonChiTiet[] phieuCT = new PhieuMuonChiTiet[slDauSach];
        for (int i = 0; i < slDauSach; i++) {
            PhieuMuonChiTiet phieu = new PhieuMuonChiTiet();
            // xác nhận bạn đọc muốn mượn sách nào
            Sach sach = nhapSach(i);
            phieu.setSach(sach);

            System.out.print("Nhap so luong dau sach muon muon: ");
            int slMuon;

            do {
                slMuon = sc.nextInt();
                if (slMuon > 0 && slMuon <= 3) {
                    break;
                }
                System.out.println("Moi ban doc khong the muon qua 3 cuon sach / 1 dau sach hoac so luong phai > 0, hay nhap lai!");
            } while (true);
            phieu.setSoLuong(slMuon);

            System.out.print("Nhap tinh trang sach: ");
            String tinhTrang = new Scanner(System.in).nextLine();
            phieu.setTinhTrang(tinhTrang);

            for (int j = 0; j < phieuCT.length; j++) {
                if (phieuCT[i] == null) {
                    phieuCT[i] = phieu;
                    break;
                }
            }
        }
        return phieuCT;
    }

    private static Sach nhapSach(int index) {
        System.out.print("Nhap ID quyen sach thu " + (index + 1) + " ma ban doc muon muon:  ");
        int idSach;
        Sach sach;
        do {
            idSach = sc.nextInt();
            sach = timTheoMaSach(idSach);
            if (sach != null) {
                break;
            }
            System.out.println("Khong ton tai quyen sach co ID la " + idSach + ", vui long nhap lai");
        } while (true);
        return sach;
    }

    private static Sach timTheoMaSach(int idSach) {
        for (int i = 0; i < sach.length; i++) {
            Sach sach = QLMuonSach.sach[i];
            if (sach != null && sach.getMaSach() == idSach) {
                return sach;
            }
        }
        return null;
    }

    private static void saveBook(Sach sach) {
        for (int i = 0; i < QLMuonSach.sach.length; i++) {
            if (QLMuonSach.sach[i] == null) {
                System.out.println("Them sach thanh cong");
                QLMuonSach.sach[i] = sach;
                break;
            }
        }
        showAllBook();
    }

    private static void saveReader(BanDoc bandoc) {
        for (int i = 0; i < QLMuonSach.bandoc.length; i++) {
            if (QLMuonSach.bandoc[i] == null) {
                System.out.println("Them ban doc thanh cong");
                QLMuonSach.bandoc[i] = bandoc;
                break;
            }
        }
        showAllBandoc();
    }

    private static void savePhieuMuon(QLMuon qlm) {
        for (int j = 0; j < qlmuon.length; j++) {
            if (qlmuon[j] == null) {
                qlmuon[j] = qlm;
                System.out.println("Them phieu muon thanh cong");
                break;
            }
            System.out.println("Them phieu muon that bai");
        }
    }

    private static void showAllBook() {
        for (int i = 0; i < sach.length; i++) {
            if (sach[i] == null) {
                continue;
            }
            System.out.println(sach[i]);
        }
    }

    private static void showAllBandoc() {
        for (int i = 0; i < bandoc.length; i++) {
            if (bandoc[i] == null) {
                continue;
            }
            System.out.println(bandoc[i]);
        }
    }

    private static void sapXepTheoTen() {
        boolean coDuLieuHoaDon = false;
        for (int i = 0; i < qlmuon.length; i++) {
            if (qlmuon[i] != null) {
                coDuLieuHoaDon = true;
            }
        }
        if (!coDuLieuHoaDon) {
            System.out.println(
                    "Chua co hoa don nao trong he thong!.");
            return;
        }
        for (int i = 0; i < qlmuon.length - 1; i++) {
            QLMuon qlm = qlmuon[i];
            for (int j = i + 1; j < qlmuon.length; j++) {
                QLMuon qlm2 = qlmuon[j];
                if (qlm.getBanDoc().getHoTen().compareTo(qlm2.getBanDoc().getHoTen()) > 0) {
                    QLMuon temp = qlm;
                    qlm = qlm2;
                    qlm2 = temp;
                }
            }
        }
        showAllPhieuMuon();
    }

    private static void sapXepTheoSoLuongMuon() {
        boolean coDuLieuHoaDon = false;
        for (int i = 0; i < qlmuon.length; i++) {
            if (qlmuon[i] != null) {
                coDuLieuHoaDon = true;
            }
        }
        if (!coDuLieuHoaDon) {
            System.out.println(
                    "Chua co phieu muon nao trong he thong.");
            return;
        }
        for (int i = 0; i < qlmuon.length - 1; i++) {
            QLMuon qlm = qlmuon[i];
            for (int j = i + 1; j < qlmuon.length; j++) {
                QLMuon qlm2 = qlmuon[j];
                if (qlm.tongSach() > qlm2.tongSach()) {
                    QLMuon temp = qlm;
                    qlm = qlm2;
                    qlm2 = temp;
                }
            }
        }
        showAllPhieuMuon();
    }
}
