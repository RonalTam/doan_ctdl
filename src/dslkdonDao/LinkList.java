package dslkdonDao;

import java.util.Scanner;


public class LinkList {
    public Link first;
    LinkDao obj = new LinkDao();

    //LinkList constructor
    public LinkList() {
        first = null;

    }

    public void insert(String maSV, String hoten, double diem) {
        //TẠO NÚT VÀ ĐIỀN GIÁ TRỊ CHO NÚT ĐÓ
        Link nut = new Link(maSV, hoten, diem);
        // ĐƯA NÚT ĐÓ VÀO DANH SÁCH
        nut.nextLink = first;
        first = nut;
    }

    public void ghifile() {
        insert("001", "Anh A", 9);
        insert("002", "Anh B", 4);
        obj.ghiFile(first);
    }

    public void docfile() {
        first = obj.docFile("D://thi2.bin");
    }

    public void printList() {
        Link p = first;
        //   System.out.print("List: ");
        while (p != null) {
            System.out.println(p.getMaSV() + "  " + p.getHoten() + "   " + p.getDiem());
            p = p.nextLink;
        }
        System.out.println("");
    }
}
