package objects;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class OBJ_DoorG extends SuperObject {

    GamePanel gp;

    public OBJ_DoorG(GamePanel gp) {

        this.gp = gp;

        name = "DoorG";
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("objects/DoorR.png")));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);

        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}