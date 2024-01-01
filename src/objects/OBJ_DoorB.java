package objects;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_DoorB extends SuperObject {

    GamePanel gp;

    public OBJ_DoorB(GamePanel gp) {

        this.gp = gp;

        name = "DoorB";
        try {
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("objects/DoorB.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);

        } catch (IOException e) {
            e.printStackTrace();
        }

        collision = true;
    }
}
