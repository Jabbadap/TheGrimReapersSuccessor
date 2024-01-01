package objects;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_DoorR extends SuperObject {

    GamePanel gp;

    public OBJ_DoorR(GamePanel gp) {

        this.gp = gp;

        name = "DoorR";
        try {
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("objects/DoorR.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);

        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}
