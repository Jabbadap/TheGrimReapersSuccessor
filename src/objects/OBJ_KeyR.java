package objects;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_KeyR extends SuperObject {

    GamePanel gp;

    public OBJ_KeyR(GamePanel gp) {

        this.gp = gp;

        name = "KeyR";
        try {
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("objects/KeyR.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
