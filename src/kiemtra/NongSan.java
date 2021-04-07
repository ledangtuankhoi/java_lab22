/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiemtra;

/**
 *
 * @author ANH TUAN
 */
public class NongSan extends HangThucPham{
    
    
    private String nguonGoc;
    private double nangLuong;
    private double khoangChat;

    public NongSan() {
    }

    public String getNguonGoc() {
        return nguonGoc;
    }

    public void setNguonGoc(String nguonGoc) {
        this.nguonGoc = nguonGoc;
    }

    public double getNangLuong() {
        return nangLuong;
    }

    public void setNangLuong(double nangLuong) {
        this.nangLuong = nangLuong;
    }

    public double getKhoangChat() {
        return khoangChat;
    }

    public void setKhoangChat(double khoangChat) {
        this.khoangChat = khoangChat;
    }

   
    @Override
    public void nhaphnaghoa()
    {
        super.setLoaiHang("HS");
        super.nhaphnaghoa();
        System.out.println("nguồn gốc xuất xứ: ");
        setNguonGoc(sc.nextLine());
        do
        {
            System.out.println("năng lượng: ");
            setNangLuong(Double.parseDouble(sc.nextLine()));
        }while(getNangLuong()<0);
        do
        {
            System.out.println("thành phần khoáng chất: ");
            setKhoangChat(Double.parseDouble(sc.nextLine()));
        }while(getKhoangChat()<0);
        
    }
}
