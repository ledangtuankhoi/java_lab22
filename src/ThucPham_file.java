import java.io.File;

public class ThucPham_file extends ThucPham   {

    public ThucPham_file() {
    }


    public void xuatInfoSanPham(){
        // private String tenHang;
        // try {
            
        //     File info = new File("info_%s.txt");
        //     do {
        //         if(info.createNewFile()){
        //             System.out.println("creat file sucse");
        //         }
        //         else{
        //             System.out.println("file exits");
        //             info.delete();
        //         }
                
        //     } while (info.createNewFile());
        // } catch (Exception e) {
        //     System.out.println("---------------loi");
        //     e.printStackTrace();
        // }
        try {
            
            String ext = "exe";
            File dir = new File("./");
            String name = String.format("%s.%s", getTenHang(), ext);
            File file = new File(dir, name);
            if(file.createNewFile()){
                System.out.println("111111111");
                System.out.println("111111111" + file.getName());
            }
            else{
                System.out.println("22222");
            }
    
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();

        }
    }

    
}
