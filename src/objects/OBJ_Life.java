package objects;

import Main.GamePanel;
import Entity.Entity;

public class OBJ_Life extends Entity {

    public OBJ_Life(GamePanel gp) {
        super(gp);

        name = "Life";
        image = setup("objects/LifeFull", gp.tileSize, gp.tileSize);
        image2 = setup("objects/LifeHalf", gp.tileSize, gp.tileSize);
        image3 = setup("objects/LifeBlank", gp.tileSize, gp.tileSize);
    }
}
