package objects;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_KeyB extends SuperObject {

    GamePanel gp;

    public OBJ_KeyB(GamePanel gp) {

        this.gp = gp;

        name = "KeyB";
        try {
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("objects/KeyB.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
