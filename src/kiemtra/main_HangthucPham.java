package kiemtra;


// import java.io.FileInputStream;
// import java.io.FileNotFoundException;
// import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
public class main_HangthucPham{
    static Scanner sc = new Scanner(System.in);
    static  ArrayList<HangThucPham> arr_tp = new ArrayList<HangThucPham>();






    public static void main(String[] args) {
        HangThucPham tp = new HangThucPham("nông sản","1", "mot", 12.7, 1, 1, 345, 2, 2, 2354);
        HangThucPham tp8 = new HangThucPham("nông sản","46", "tam", 34.2, 1, 12, 3456, 2, 2, 2345);
        HangThucPham tp7 = new HangThucPham("nông sản","4561", "bay", 454.2, 1, 1, 346, 2, 2, 2345);
        HangThucPham tp6 = new HangThucPham("hải sản","45", "sau", 2345.2, 1, 1, 3456, 2, 2, 235);
        HangThucPham tp5 = new HangThucPham("hải sản","4561", "nam", 456.2, 12, 1, 3456, 2, 2, 534);
        HangThucPham tp4 = new HangThucPham("nông sản","461", "bon", 345.2, 1, 1, 346, 12, 2, 3452);
        HangThucPham tp3 = new HangThucPham("nông sản","51", "ba", 67.2, 1, 12, 3456, 2, 2, 456);
        HangThucPham tp1 = new HangThucPham("hải sản","61", "mot", 346.2, 12, 1, 346, 2, 2, 123);
        HangThucPham tp2 = new HangThucPham("hải sản","61", "hai", 3456.2, 1, 1, 3645, 2, 2, 345);
        arr_tp.add(tp);
        arr_tp.add(tp1);
        arr_tp.add(tp2);
        arr_tp.add(tp3);
        arr_tp.add(tp4);
        arr_tp.add(tp5);
        arr_tp.add(tp6);
        arr_tp.add(tp7);
        arr_tp.add(tp8);


        // System.out.println(String.valueOf(6));
        // System.out.println("0" + String.valueOf(6));


       menu();    


    }








    public static void menu() {
        int chon;
        do {
            System.out.println("\n1. Nhập danh sách hàng hóa");
            System.out.println("2. Xuất danh sách hàng hóa");
           System.out.println("3. xóa hàng hóa");
           System.out.println("4. sửa");
           System.out.println("5. tìm kiếm");
           System.out.println("6. sắp xếp");
           System.out.println("7. đếm");
           System.out.println("8. xuất file");
            System.out.println("0.Thoát");
            System.out.print("hãy chọn:");
            chon = Integer.parseInt(sc.nextLine());
            switch (chon) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    nhapdanhsachHH();
                    break;
               case 2:
                    xuatdanhsach();
                   break;
               case 3:
                    xoa();
                   break;
               case 4:
                   sua();
                   break;
               case 5:
                    timkiem();
                   break;
                   
                case 6:
                   sapxep();
                   break;
                case 7:
                   demtheoloaihang();
                   break;
                case 8:
                   xuatFile_theoten();
                   break;
                default:
                    System.out.println("\nChọn sai, chọn lại");
            }
        } while (chon != 0);
        
    }
    static void nhapdanhsachHH()
    {
        int chon;
        HangThucPham tp;
        do
        {   
            System.out.print("1.Nông Sản \t");
            System.out.print("2.Hải Sản \t");


            System.out.println("0. thoat \t");
            System.out.print("Hãy chọn:");           
            

            chon = Integer.parseInt(sc.nextLine());
            switch (chon) {
                case 0:
                    // System.exit(0);
                    chon = 0;
                    break;
                case 1:
                    tp = new NongSan();
                    tp.nhaphnaghoa();
                    arr_tp.add(tp);
                    break;
                case 2:
                    tp= new HaiSan();
                    tp.nhaphnaghoa();
                    arr_tp.add(tp);
                    break;
            }
            if(chon != 0){
                System.out.print("Nữa ko? Nữa (1)/ Không(0), hãy chọn số:");
                chon = Integer.parseInt(sc.nextLine());
            }
        }while(chon == 1);
    }

    //-----------xuat
    static void xuatdanhsach() {
        int i = 1;
        System.out.printf("%-5s","STT");           
        System.out.format("%-12s%-12s%-12s%-12s%-12s%-12s%-17s  \n\n", "Loại","Mã hàng", "Tên hàng", "Đơn giá","ngày SX", "Ngày SD ", "tinh trang");
        for (HangThucPham d : arr_tp) {
            System.out.printf("%-5d",i);           
            System.out.println(d.toString());
            // d.toString();
            i++;
        }
    }


    //-----------xóa

    static void xoa()
    {
        int chon;
        // HangThucPham tp;
        do
        {   
            System.out.println("1.xóa theo tên");
            System.out.println("2.xóa theo vị trí");
            // System.out.println("2.Hải Sản");
            // System.out.println("2.Hải Sản");
            System.out.println("0. thoat");
            System.out.print("Hãy chọn:");
            chon = Integer.parseInt(sc.nextLine());
            switch (chon) {
                case 0:
                    chon = 0;
                    break;
                case 1:
                    xoatheoten();
                    break;
                case 2:
                    xoaTheoViTri();
                    break;
                case 3:
                   
                    break;
                case 4:

                    
                    break;
            }
            if(chon != 0){
                System.out.print("Nữa ko? Nữa (1)/ Không(0), hãy chọn số:");
                chon = Integer.parseInt(sc.nextLine());
            }
        }while(chon == 1);
    }




    static void xoaTheoViTri(){
        
        System.out.println("Nhap vi tri can xoa: ");
        int n = Integer.parseInt(sc.nextLine());
        if(n>=0&& n<arr_tp.size()){
            arr_tp.remove(n);
            System.out.println("Xoa thanh cong");
        }
        else{
            System.out.println("Xoa that bai");
        }
    }  

    static void xoatheoten()
    {
        System.out.println("nhập tên hàng hóa muốn xóa :");
        String ten=sc.nextLine();
        for (int i = 0; i < arr_tp.size(); i++) {
        
            if(arr_tp.get(i).getTenHang().equalsIgnoreCase(ten))
            {
                arr_tp.remove(i);
                System.out.println("da xoa xong");
                break;
            }
        }
    }


    // -------------sửa
    static void sua()
    {
        int chon;
        // HangThucPham tp;
        do
        {   
            xuatdanhsach();
            System.out.println("1.sửa theo tên");
            // System.out.println("2.xóa theo vị trí");
            // System.out.println("2.Hải Sản");
            // System.out.println("2.Hải Sản");

            System.out.println("0. thoat");
            System.out.print("Hãy chọn:");
            chon = Integer.parseInt(sc.nextLine());
            switch (chon) {
                case 0:
                    chon = 0;
                    break;
                case 1:
                    suatheoten();
                    break;
                case 2:
                    xoaTheoViTri();
                    break;
                case 3:

                   
                    break;
                case 4:

                    
                    break;
            }
            if(chon != 0){
                System.out.print("Nữa ko? Nữa (1)/ Không(0), hãy chọn số:");
                chon = Integer.parseInt(sc.nextLine());
            }
        }while(chon == 1);
    }


    static void suatheoten()
    {
        System.out.println("nhập tên hàng hóa muốn sửa :");
        String ten=sc.nextLine();
        for (int i = 0; i < arr_tp.size(); i++) {
        
            if(arr_tp.get(i).getTenHang().equalsIgnoreCase(ten))
            {
                System.out.println("sua lai thong tin hàng hóa");
                arr_tp.get(i).nhaphnaghoa();
                break;
            }
        }
    }


// ------------------tìm kiếm
static void timkiem()
    {
        int chon;
        // HangThucPham tp;
        do
        {   
            System.out.println("1.tiem kiem theo tên");
            // System.out.println("2.xóa theo vị trí");
            // System.out.println("2.Hải Sản");
            // System.out.println("2.Hải Sản");

            System.out.println("0. thoat");
            System.out.print("Hãy chọn:");
            chon = Integer.parseInt(sc.nextLine());
            switch (chon) {
                case 0:
                    chon = 0;
                    break;
                case 1:
                    timKiemTheoTen();
                    break;
                case 2:

                    break;
                case 3:

                   
                    break;
                case 4:

                    
                    break;
            }
            if(chon != 0){
                System.out.print("Nữa ko? Nữa (1)/ Không(0), hãy chọn số:");
                chon = Integer.parseInt(sc.nextLine());
            }
        }while(chon == 1);
    }

    static void timKiemTheoTen(){
        System.out.println("Nhap ten hang can tim: ");
        String search = sc.nextLine();
        for(HangThucPham d : arr_tp){
            if(d.getTenHang() != null && d.getTenHang().contains(search)){

                // System.out.println("Ma hang: "+d.getMaHang());
                // System.out.println("Ten hang: "+d.getTenHang());
                // System.out.println("Don gia: "+d.getDonGia());
                // System.out.println("Ngay san xuat: "+d.getNSX());
                // System.out.println("Ngay het han: "+d.getHSD()); 
                System.out.println(d.toString());
            }
                            
        }
    }


// ----------sắp xếp

static void sapxep()
    {
        int chon;
        // HangThucPham tp;
        do
        {   
            System.out.println("1.sắp xếp theo tên");
            System.out.println("2.sắp xếp theo giá");
            // System.out.println("2.Hải Sản");
            // System.out.println("2.Hải Sản");

            System.out.println("0. thoat");
            System.out.print("Hãy chọn:");
            chon = Integer.parseInt(sc.nextLine());
            switch (chon) {
                case 0:
                    chon = 0;
                    break;
                case 1:
                    sapxeptheoten();
                    break;
                case 2:
                    SapxeptheoGia();
                    break;
                case 3:

                   
                    break;
                case 4:

                    
                    break;
            }
            if(chon != 0){
                System.out.print("Nữa ko? Nữa (1)/ Không(0), hãy chọn số:");
                chon = Integer.parseInt(sc.nextLine());
            }
        }while(chon == 1);
    }
    static void sapxeptheoten()
        {
            Comparator<HangThucPham> comp = new Comparator<HangThucPham>(){
                @Override
                public int compare(HangThucPham n1, HangThucPham n2 ){
                    //  return n1.getDiem().compareTo(n2.getDiem());
                    return n1.getTenHang().compareTo(n2.getTenHang());
                }
            };
            Collections.sort(arr_tp,comp);
            xuatdanhsach();
        }

        static void SapxeptheoGia(){
            Comparator<HangThucPham> comp = new Comparator<HangThucPham>(){
                @Override
                public int compare(HangThucPham tp1,HangThucPham tp2){
                    
                    return Double.compare(tp1.getDonGia(),tp2.getDonGia());
                }
            };
            Collections.sort(arr_tp,comp);
            xuatdanhsach();
            
        }
// ------------xuất file
    static void xuatFile_theoten(){
        System.out.println("Nhap ten hang can tim: ");
        String search = sc.nextLine();
        for(HangThucPham d : arr_tp){
            if(d.getTenHang() != null && d.getTenHang().contains(search)){
                d.xuatFile_txt(search);
            }
                            
        }
    }

    // ------------ đếm
    static void demtheoloaihang()
     {
         int c,d=0;
         System.out.println("1.đếm số lượng nông sản");
            System.out.println("2.đếm số lượng hải sản");
            System.out.print("Hãy chọn:");
            c = Integer.parseInt(sc.nextLine());
            switch (c) {
                case 0:
                    c = 0;
                    break;
                case 1:
                    for(HangThucPham s : arr_tp)
                    {
                        if(s.getLoaiHang().equalsIgnoreCase("nông sản"))
                        {
                            d++;
                            System.out.println(s.toString());
                        }
                    }
                    
                    System.out.println("\nsố lượng nông sản: "+d);
                    break;
                case 2:
                    
                    for(HangThucPham s : arr_tp)
                    {
                        if(s.getLoaiHang().equalsIgnoreCase("hải sản"))
                        {
                            d++;
                            System.out.println(s.toString());
                        }
                    }
                    System.out.println("số lượng hải sản: "+d);
                    break;
            }
            if(c != 0){
                System.out.print("Nữa ko? Nữa (1)/ Không(0), hãy chọn số:");
                c = Integer.parseInt(sc.nextLine());
            }
            
     }

}
