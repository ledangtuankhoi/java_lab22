import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class ThucPham {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<ThucPham> arr_tp = new ArrayList<ThucPham>();

    // Khai báo các thuộc tính cần thiết cho bài toán
    private int maHang;
    private String tenHang;
    private double donGia;
    private Date nSX, hSD;

    // Khởi tạo constructor có tham số


    public ThucPham(int maHang, String tenHang, double donGia, Date nSX, Date hSD) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.donGia = donGia;
        this.nSX = nSX;
        this.hSD = hSD;
    }

    
    public ThucPham(int maHang, String tenHang, double donGia, int ngay_nsx, int thang_nsx, int nam_nsx, int ngay_hsd, int thang_hsd, int nam_hsd) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.donGia = donGia;
        setNSX(nam_nsx, thang_nsx, ngay_nsx);
        this.nSX = getnSX();
        setHSD(nam_hsd, thang_hsd, ngay_hsd);
        this.hSD =gethSD();
        // this.hSD = hSD;
    }

    

    //

    // Khởi tạo constructor mặc định
    public ThucPham() {
    }

    // -------------------begin getter and setter-----------------------
    public int getMaHang() {
        return maHang;
    }

    public void setMaHang(int maHang) {
        this.maHang = maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public Date getnSX() {
        return nSX;
    }

    public void setnSX(Date nSX) {
        this.nSX = nSX;
    }

    public Date gethSD() {
        return hSD;
    }

    public void sethSD(Date hSD) {
        this.hSD = hSD;
    }// -------------------end getter and setter-----------------------

    @Override
    // khởi tạo phương thức toString
    public String toString() {
        // sử dung phương thức Locale để biến đổi theo tiền tệ việt nam
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(localeVN);
        String str = numberFormat.format(donGia);
        // sử dụng phương thức SimpleDateFormat để biến đổi ngày tháng năm theo dạng
        // "dd/MM/yyyy"
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd - MM - yyyy");
        String str1 = simpleDateFormat.format(nSX);
        String str2 = simpleDateFormat.format(hSD);
        return "Thông tin về thực phẩm: \n" + "Mã hàng : " + maHang + "\nTên hàng : '" + tenHang + "\nĐơn giá : " + str
                + "\nNgày sản xuất : " + str1 + "\nHạn sử dụng : " + str2;

        // return "&-12s";
    }

    // Khởi tạo phương thức để nhập năm tháng ngày sản xuất
    public void xylydate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        this.nSX = calendar.getTime();
    }

    // Khởi tạo phương thức để nhập năm tháng ngày sản xuất
    public void setNSX(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        this.nSX = calendar.getTime();

    }

    // Khởi tạo phương thức để nhập hạn sử dụng
    public void setHSD(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        this.hSD = calendar.getTime();
    }

    // khởi tạo phương thức kiểm tra tên hàng không được để trống
    public boolean kiemTraTenHang(boolean k) {

        if (this.tenHang == "" || this.tenHang.isEmpty()) {
            System.out.println("Tên hàng không được để trống : ");
        } else {
            k = false;
        }
        return k;
    }

    // khởi tạo hàm kiểm tra ngày hết hạn không được nhỏ hơn ngày sản xuất
    public boolean kiemTraNgay(boolean t) {
        if (this.getnSX().compareTo(this.gethSD()) < 0) {
            t = false;
        } else {
            System.out.println("Ngày hết hạn không được nhỏ hơn ngày sản xuất : ");
        }

        return t;
    }

    // khởi tạo phương thức kiểm tra hạn sử dụng của sản phẩm đã hết hạn hay còn hạn
    // public void kiemTraHSD() {
    //     Date today = new Date();
    //     today.getTime();
    //     SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd - MM - yyyy");
    //     String st = simpleDateFormat.format(today);
    //     if (this.gethSD().compareTo(today) < 0) {
    //         System.out.println("Hôm nay là ngày " + st + ", hàng hóa đã hết hạn ");
    //     } else {
    //         System.out.println("Hôm nay là ngày " + st + ", hàng hóa vẫn còn hạn ");
    //     }
    // }

    public String kiemTraHSD() {
        Date today = new Date();
        today.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd - MM - yyyy");
        String st = simpleDateFormat.format(today);
        if (this.gethSD().compareTo(today) < 0) {
            return "hết hạn ";
        } else {
            // System.out.println("Hôm nay là ngày " + st + ", hàng hóa vẫn còn hạn ");
            return "  còn hạn ";

        }
    }

    public long thoiGianSuDung() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd");
        // simpleDateFormat.format(dd);     
        if ((hSD.getTime() - nSX.getTime()) / (24 * 3600 * 1000) < 0)
            return 0;
        else{
        return (hSD.getTime() - nSX.getTime()) / (24 * 3600 * 1000);
        }

        
    }

    // thong tin san pham
    public void xuat() {
        // sử dung phương thức Locale để biến đổi theo tiền tệ việt nam
        Locale localeVN = new Locale("vi", "VN");
        // NumberFormat numberFormat = NumberFormat.getCurrencyInstance(localeVN);
        // String str_dongia = numberFormat.format(donGia);


        // String str_dongia = donGia.tostr
        BigDecimal str_dongia = BigDecimal.valueOf(donGia);
        str_dongia = str_dongia.setScale(3, RoundingMode.DOWN);
        // sử dụng phương thức SimpleDateFormx  at để biến đổi ngày tháng năm theo dạng
        // "dd/MM/yyyy"
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String str1_nsx = simpleDateFormat.format(nSX);
        String str2_hsd = simpleDateFormat.format(hSD);
        // return "Thông tin về thực phẩm: \n" + "Mã hàng : " + maHang + "\nTên hàng :
        // '" + tenHang + "\nĐơn giá : " + str
        // + "\nNgày sản xuất : " + str1 + "\nHạn sử dụng : " + str2;

        // System.out.printf("\t thong tin san pham \n");
        // System.out.printf("%-12s%-12s%-12s%-12s%-12s%-12s  \n", "maHang", "tenHang", "str_dongia", "str1_nsx", "str2_hsd ", "tinh trang");

        System.out.printf("%-12s%-12s%-12s%-12s%-12s%-12s%-20d  \n", maHang, tenHang, str_dongia, str1_nsx, str2_hsd, kiemTraHSD(), thoiGianSuDung());
        // return "&-12s";
    }

    // nhap thon tin san pham
    public void nhap() {

        // ThucPham tp = new ThucPham();
        boolean kt = true;
        boolean th = true;
        System.out.println("Nhập mã hàng : ");
        this.setMaHang(scanner.nextInt());
        scanner.nextLine();
        do {
            System.out.println("Nhập tên hàng : ");
            this.setTenHang(scanner.nextLine());
        } while (this.kiemTraTenHang(kt));
        System.out.println("Nhập đơn giá : ");
        this.setDonGia(scanner.nextDouble());
        do {
            System.out.println("Nhập năm,tháng,ngày sản xuất : ");
            this.setNSX(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
            System.out.println("nhập năm,tháng,ngày hết hạn : ");
            this.setHSD(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        } while (this.kiemTraNgay(th));

        // arr_this.add(tp);

        // System.out.println(this.toString());
        // xuat();
        // kiemTraHSD();
    }

}