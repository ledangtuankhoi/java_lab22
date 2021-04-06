
// import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class mainHangThucPham {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<ThucPham>  arr_tp = new ArrayList<ThucPham>();

    public static void main(String[] args) throws Exception {

        ThucPham tp = new ThucPham(1,"mot",12.7, 1,1,345,2,2,2354);
        ThucPham tp8 = new ThucPham(46,"tam",34.2, 1,1,3456,2,2,2345);
        ThucPham tp7 = new ThucPham(4561,"bay",454.2, 1,1,346,2,2,2345);
        ThucPham tp6 = new ThucPham(45,"sau",2345.2, 1,1,3456,2,2,235);
        ThucPham tp5 = new ThucPham(4561,"nam",456.2, 1,1,3456,2,2,534);
        ThucPham tp4 = new ThucPham(461,"bon",345.2, 1,1,346,2,2,3452);
        ThucPham tp3 = new ThucPham(51,"ba",67.2, 1,1,3456,2,2,456);
        ThucPham tp1 = new ThucPham(61,"mot",346.2, 1,1,346,2,2,123);
        ThucPham tp2 = new ThucPham(61,"hai",3456.2, 1,1,3645,2,2,345);

        arr_tp.add(tp);
        arr_tp.add(tp1);
        arr_tp.add(tp2);
        arr_tp.add(tp3);
        arr_tp.add(tp4);
        arr_tp.add(tp5);
        arr_tp.add(tp6);
        arr_tp.add(tp7);
        arr_tp.add(tp8);

        // tp.nhap();


        menu();

    }

    public static void menu() {
        int chon;

        do {
            System.out.println("\n1.Nhập danh sách thuc pham");
            System.out.println("2.Xuất danh sách thuc pham");
            System.out.println("3.Xuất danh sách thuc pham học lực giỏi");
            System.out.println("4.Đếm xem có ? thuc pham dưới điểm trung bình");
            System.out.println("5.Sắp xếp theo diem");
            System.out.println("6.nhap t dong");
            System.out.println("0.Thoát");
            System.out.print("hãy chọn:");
            chon = scanner.nextInt();
            switch (chon) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    // nhapdanhsach();
                    // tp.nhap();
                    nhapdanhsach();
                    break;
                case 2:
                    xuatdanhsach();
                    break;
                case 3:
                    // xuatgioi();
                    break;
                case 4:
                    // System.out.println("Có " + demTB() + " SV <5.0");
                    break;
                case 5:
                    // sapxeptheoDiem();
                    break;
                case 6:
                    // nhapTuDong();
                    break;
                default:
                    System.out.println("\nChọn sai, chọn lại");
            }
        } while (chon != 0);
    }

    public static void nhapdanhsach(){
        int i;
        ThucPham tp = new ThucPham();
        do {
            System.out.println("\nsanpham " + arr_tp.size());
            tp.nhap();
            arr_tp.add(tp);
            System.out.print("Nữa ko? Nữa (1)/ Không(0), hãy chọn số:");
            i = scanner.nextInt();
        } while (i == 1);
    }

    static void xuatdanhsach() {
        int i = 1;
        System.out.println("thong tin san pham");
        System.out.printf("%-5s%-12s%-12s%-12s%-12s%-12s%-12s%-17s  \n"," ", "maHang", "tenHang", "str_dongia", "str1_nsx", "str2_hsd ", "tinh trang", "thoi gian su dung(ngay)");

        for (ThucPham tp : arr_tp) {
            System.out.printf("%-5d",i);           
            tp.xuat();
            i++;
        }
    }

    // static public void nhap(){

        
    //     ThucPham tp = new ThucPham();
    //     boolean kt = true;
    //     boolean th = true;
    //     System.out.println("Nhập mã hàng : ");
    //     tp.setMaHang(scanner.nextInt());
    //     scanner.nextLine();
    //     do {
    //         System.out.println("Nhập tên hàng : ");
    //         tp.setTenHang(scanner.nextLine());
    //     } while (tp.kiemTraTenHang(kt));
    //     System.out.println("Nhập đơn giá : ");
    //     tp.setDonGia(scanner.nextDouble());
    //     do {
    //         System.out.println("Nhập năm,tháng,ngày sản xuất : ");
    //         tp.setNSX(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
    //         System.out.println("nhập năm,tháng,ngày hết hạn : ");
    //         tp.setHSD(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
    //     } while (tp.kiemTraNgay(th));

    //     arr_tp.add(tp);

    //     System.out.println(tp);
    //     tp.xuat();
    //     tp.kiemTraHSD();
    // }

}
