package objects;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_KeyY extends SuperObject {

    GamePanel gp;

    public OBJ_KeyY(GamePanel gp) {

        this.gp = gp;

        this.gp = gp;
        name = "KeyY";
        try {
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("objects/KeyY.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
