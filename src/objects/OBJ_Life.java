package objects;

import Main.GamePanel;
import Entity.Entity;

public class OBJ_Life extends Entity {

    public OBJ_Life(GamePanel gp) {
        super(gp);

        name = "Life";
        image = setup("objects/LifeFull");
        image2 = setup("objects/LifeHalf");
        image3 = setup("objects/LifeBlank");
    }
}
