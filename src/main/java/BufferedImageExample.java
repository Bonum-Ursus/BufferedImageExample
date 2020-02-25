import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class BufferedImageExample {
    public static void main(String[] args) throws IOException {
        String folder = "C:\\Users\\User\\Desktop\\Class_7\\Geometry\\Atanasyan";
        for (int i = 1; i < 4; i++) {
            String folder1 = folder + "\\Task_" + i;
            ArrayList<BufferedImage> list = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                BufferedImage img0 = ImageIO.read(new File(folder1 + "\\" + (j) +".png"));
                list.add(img0);
            }
            System.out.println(list);
            int maxWidth = 0;
            int totalHeight = 0;
            for (BufferedImage bi : list) {
                totalHeight += bi.getHeight();
                maxWidth = maxWidth > bi.getWidth() ? maxWidth : bi.getWidth();
            }
            BufferedImage im = new BufferedImage(maxWidth,totalHeight,BufferedImage.TYPE_INT_ARGB);
            int x = 0;
            int y = 0;
            for (int j = 0; j < 5; j++) {

                im.getGraphics().drawImage(list.get(j), x, y, null);
                y += list.get(j).getHeight();
            }
            ImageIO.write(im,"png",new File("C:\\Users\\User\\Desktop\\Class_7\\Geometry\\Atanasyan\\Task_"+ i + "\\5.png"));
        }
    }
}
