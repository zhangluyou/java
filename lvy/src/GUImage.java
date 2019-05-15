import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class GUImage {

    private GUImage() {
    }

    public static BufferedImage  getImage(String path) {
        URL u = GUImage.class.getClassLoader().getResource(path);
        BufferedImage image = null;
        try {
            image = ImageIO.read(u);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

}