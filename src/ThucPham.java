import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
// import java.text.NumberFormat;
// import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
// import java.util.Locale;
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

    public boolean kiemTraHSD() {
        Date today = new Date();
        today.getTime();
        // SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd - MM - yyyy");
        // String st = simpleDateFormat.format(today);
        if (this.gethSD().compareTo(today) < 0) {
            return false;
        } else {
            // System.out.println("Hôm nay là ngày " + st + ", hàng hóa vẫn còn hạn ");
            return true;

        }
    }

    public long thoiGianSuDung() {
        
  
        if ((hSD.getTime() - nSX.getTime()) / (24 * 3600 * 1000) < 0)
            return 0 ;
        else{
        return (hSD.getTime() - nSX.getTime()) / (24 * 3600 * 1000);
        }

        
    }

    // thong tin san pham
    public void xuat() {


        // String str_dongia = donGia.tostr
        BigDecimal str_dongia = BigDecimal.valueOf(donGia);
        str_dongia = str_dongia.setScale(3, RoundingMode.DOWN);
        // sử dụng phương thức SimpleDateFormx  at để biến đổi ngày tháng năm theo dạng
        // "dd/MM/yyyy"
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String str1_nsx = simpleDateFormat.format(nSX);
        String str2_hsd = simpleDateFormat.format(hSD);

        System.out.printf("%-12s%-12s%-12s%-12s%-12s%-12s%-20d  \n", maHang, tenHang, str_dongia, str1_nsx, str2_hsd, kiemTraHSD(), thoiGianSuDung());

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


    }



    //========================================================================
    // quan lý file


    public void xuatInfo_File(){
        try {
            
            //kiểu của file
            String ext = "txt";
            //đường dẫn của file
            File dir = new File("./");
            //tao string name để nap vào  
            String name = String.format("%s%s.%s",dir, this.getTenHang(), ext);
            FileWriter file = new FileWriter(name);

            // định dạng kiểu hiện thi cho double
            BigDecimal str_dongia = BigDecimal.valueOf(donGia);
            str_dongia = str_dongia.setScale(3, RoundingMode.DOWN);
            // sử dụng phương thức SimpleDateFormx  at để biến đổi ngày tháng năm theo dạng
            // "dd/MM/yyyy"
            //định dạng kiểm hiện thi cho date
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String str1_nsx = simpleDateFormat.format(nSX);
            String str2_hsd = simpleDateFormat.format(hSD);

                System.out.println("thanh cong");
                System.out.println("ten file dc tao" + name);
                String return_col = String.format("%-12s%-12s%-12s%-12s%-12s%-12s%-17s  \n", "maHang", "tenHang", "str_dongia","str1_nsx", "str2_hsd ", "tinh trang", "thoi gian su dung(ngay)");
                String return_tp = String.format("%-12s%-12s%-12s%-12s%-12s%-12s%-20d  \n", maHang, tenHang, str_dongia, str1_nsx, str2_hsd, kiemTraHSD(), thoiGianSuDung());
                file.write(return_col);
                file.write(return_tp);
                file.close();
    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void xuatFile_txt(String nameFile){
        // try {
        //     //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
        //     FileOutputStream fos = new FileOutputStream("d:/Tuan_Khoi/SourceDemo/java/Lab22/HangThucPham/src/hello.txt");
        //     DataOutputStream dos = new DataOutputStream(fos);
        //     //Bước 2: Ghi dữ liệu
        //     dos.writeInt(100);
        //     dos.writeDouble(9.5);
        //     dos.writeUTF("sdfasdfasdfsa");
            
        //     //Bước 3: Đóng luồng
        //     fos.close();
        //     dos.close();
        //     System.out.println("Done!");
        //    } catch (IOException ex) {
        //      ex.printStackTrace();
           
        // }
        String ext = "txt";
        //đường dẫn của file
        File dir = new File("./");
        //tao string name để nap vào  
        String name = String.format("%s%s.%s",dir, this.getTenHang(), ext);
        // FileWriter file = new FileWriter(name);

        // định dạng kiểu hiện thi cho double
        BigDecimal str_dongia = BigDecimal.valueOf(donGia);
        str_dongia = str_dongia.setScale(3, RoundingMode.DOWN);
        // sử dụng phương thức SimpleDateFormx  at để biến đổi ngày tháng năm theo dạng
        // "dd/MM/yyyy"
        //định dạng kiểm hiện thi cho date
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String str1_nsx = simpleDateFormat.format(nSX);
        String str2_hsd = simpleDateFormat.format(hSD);


        BufferedWriter bw = null;
		FileWriter fw = null;
		try {
            // String return_col = String.format("%-12s%-12s%-12s%-12s%-12s%-12s%-17s  \n", "maHang", "tenHang", "str_dongia","str1_nsx", "str2_hsd ", "tinh trang", "thoi gian su dung(ngay)");
            String return_tp = String.format("%-12s%-12s%-12s%-12s%-12s%-12s%-20d  \n", maHang, tenHang, str_dongia, str1_nsx, str2_hsd, kiemTraHSD(), thoiGianSuDung());
          
            String FILENAME = String.format("%s.txt", nameFile);
			File file = new File(FILENAME);

			// kiểm tra nếu file chưa có thì tạo file mới
			if (!file.exists()) {
				file.createNewFile();
			}
			// true = append file
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);
			// bw.write(return_col);
			bw.write(return_tp);
			System.out.println("Xong");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
    }
    
    
    
    

}