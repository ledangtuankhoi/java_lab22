
package kiemtra;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;
import java.util.Scanner;
// import sun.util.calendar.CalendarDate;

public class HangThucPham {
    // khai báo các thuộc tính cần thiết cho bài toán
    private String loaiHang;
    private String maHang;
    private String tenHang;
    private double donGia;
    private double soLuong;
    private Date nSX,hSD;
    
    Scanner sc = new Scanner(System.in);
    // khoi tạo các contruction

    public HangThucPham(String LoaiHang, String maHang, String tenHang, double donGia, double soLuong, Date nSX, Date hSD) {
        this.loaiHang = loaiHang;
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.nSX = nSX;
        this.hSD = hSD;
    }

    public HangThucPham(String loaihang, String i, String tenHang, double donGia, int ngay_nsx, int thang_nsx, int nam_nsx, int ngay_hsd, int thang_hsd, int nam_hsd) {
        this.loaiHang = loaihang;
        this.maHang = i;
        this.tenHang = tenHang;
        this.donGia = donGia;
        setNSX(nam_nsx, thang_nsx, ngay_nsx);
        this.nSX = getnSX();
        setHSD(nam_hsd, thang_hsd, ngay_hsd);
        this.hSD =gethSD();
        // this.hSD = hSD;
    }

    public double getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(double soLuong) {
        this.soLuong = soLuong;
    }

   

    public HangThucPham() {
    }

    public String getLoaiHang() {
        return loaiHang;
    }

    public void setLoaiHang(String loaiHang) {
        this.loaiHang = loaiHang;
    }

    public String getMaHang() {
        return maHang;
    }

    public void setMaHang(String maHang) {
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
    }

    
    // khởi tạo phương thức toString

    /**
     *
     * @return
     */
    @Override
    public String toString(){
        // sử dụng phương thức local để biến đổi về tiền tệ việt nam
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(localeVN);
        String strDonGia = numberFormat.format(donGia);
        // sử dụng phương thức SimpleDateFormat để biến đổi ngày tháng năm theo dạng "dd/MM/yyyy"
        SimpleDateFormat a = new SimpleDateFormat("dd/MM/yyyy");
        String strNgaySX = a.format(nSX);
        String strHanSD = a.format(hSD);

        String checkHSD;
        if (kiemTraHSD() == true) {
            checkHSD = "còn hạn";
        } else {
            checkHSD = "    hêt hạn";
        }
         return new Formatter().format("%-12s%-12s%-12s%-12s%-12s%-12s%-12s  \n",this.loaiHang, this.maHang, this.tenHang, strDonGia, strNgaySX, strHanSD, checkHSD).toString();
                
    }
    // phương thức nhập năm tháng ngày sản xUẤT
    public void setNSX(int nam, int thang, int ngay){
        Calendar lichNgaySX = Calendar.getInstance();
        lichNgaySX.set(nam, thang+1 , ngay);
        this.nSX=lichNgaySX.getTime();
    }
    // phương thức nhập hạn sử dụng
    public void setHSD(int nam, int thang, int ngay){
        Calendar lichHanSD = Calendar.getInstance();
        lichHanSD.set(nam, thang+1, ngay);
        this.hSD = lichHanSD.getTime();
    }
    // phương thức kiểm tra tên hàng trống không
    public boolean KiemTraTenHang(boolean k)
    {
        if(this.getTenHang()=="" ||this.getTenHang().isEmpty())
            System.out.println("tên không không được đêt trống");
        else
            k=false;
        return k;
    }
    //khởi tạo hàm kiểm tra ngày hết hạn không được nhỏ hơn ngày sản xuất
    public boolean KiemTraNgay(boolean t){
        if(this.getnSX().compareTo(this.gethSD())<0)
            t=false;
        else
            System.out.println("ngày hết hạn lớn hơn ngày sản xuất");
        return t;
    }
    //khởi tạo phương thức kiểm tra hạn sử dụng của sản phẩm đã hết hạn hay còn hạn
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

// nhap vao danh sach
    public void nhaphnaghoa()
    {
        
        int m=0;
        boolean kt = true;
        boolean th = true;
        
        // System.out.println("nhập loai hàng: ");
        // setLoaiHang(sc.nextLine());
        do
        {
            String parater = "[H|N]S[0-9]{2}";
            System.out.println("nhập mã hàng : ");
            System.out.println("(vd:HS01 -hải sản 01, NS02 -hải sản 02: ");
            setMaHang(sc.nextLine());
            if(!(this.getMaHang().matches(parater)))
            {
                System.out.println("bạn đã nhập sai mã hàng, nhập lại");
                // System.out.println("(vd:HS0 -hải sản 0, NS0 -hải sản 0: ");
                 m=1;
            }else m = 0;

        }while(m==1);
        
        do
        {
            System.out.println("nhập tên hàng: ");
            setTenHang(sc.nextLine());
        }while(KiemTraTenHang(kt));
        System.out.println("Nhập đơn giá : ");
        setDonGia(Double.parseDouble(sc.nextLine()));
        System.out.println("Nhập số lượng : ");
        setSoLuong(Double.parseDouble(sc.nextLine()));
        do
        {
            System.out.println("Nhập năm,tháng,ngày sản xuất : ");
            setNSX(Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine()));
            System.out.println("nhập năm,tháng,ngày hết hạn : ");
            setHSD(Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine()));
        } while (KiemTraNgay(th));
        
    }
    // ------------file
        public void xuatFile_txt(String nameFile){



            // // định dạng kiểu hiện thi cho double
            BigDecimal str_dongia = BigDecimal.valueOf(donGia);
            str_dongia = str_dongia.setScale(3, RoundingMode.DOWN);

            // //định dạng kiểm hiện thi cho date
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String str1_nsx = simpleDateFormat.format(nSX);
            String str2_hsd = simpleDateFormat.format(hSD);


            BufferedWriter bw = null;
            FileWriter fw = null;
            try {
                // String return_col = String.format("%-12s%-12s%-12s%-12s%-12s%-12s%-17s  \n", "maHang", "tenHang", "str_dongia","str1_nsx", "str2_hsd ", "tinh trang", "thoi gian su dung(ngay)");
                String return_tp = String.format("%-12s%-12s%-12s%-12s%-12s%-12s  \n", maHang, tenHang, str_dongia, str1_nsx, str2_hsd, kiemTraHSD());
            
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
