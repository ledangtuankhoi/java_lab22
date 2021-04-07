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
public class HaiSan extends NongSan{
    private String loaiHS;

    public HaiSan() {
    }

    public String getLoaiHS() {
        return loaiHS;
    }

    public void setLoaiHS(String loaiHS) {
        this.loaiHS = loaiHS;
    }
    
     public void nhaphnaghoa()
     {
        super.setLoaiHang("hải sản");
         super.nhaphnaghoa();
         System.out.println("nhập loại hải sản: ");
         setLoaiHS(sc.nextLine());
     }
    
    
}
