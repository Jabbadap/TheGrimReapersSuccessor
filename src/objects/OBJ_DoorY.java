package objects;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_DoorY extends SuperObject {

    GamePanel gp;

    public OBJ_DoorY(GamePanel gp) {

        this.gp = gp;

        name = "DoorY";
        try {
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("objects/DoorY.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);

        } catch (IOException e) {
            e.printStackTrace();
        }

        collision = true;
    }
}
