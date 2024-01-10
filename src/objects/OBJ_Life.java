package objects;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class OBJ_Life extends SuperObject {
    GamePanel gp;

    public OBJ_Life(GamePanel gp) {

        this.gp = gp;

        name = "Life";
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("objects/LifeFull.png")));
            image2 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("objects/LifeHalf.png")));
            image3 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("objects/LifeBlank.png")));
            image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
            image2 = uTool.scaleImage(image2, gp.tileSize, gp.tileSize);
            image3 = uTool.scaleImage(image3, gp.tileSize, gp.tileSize);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
