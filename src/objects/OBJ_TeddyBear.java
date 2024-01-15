package objects;

import Entity.Entity;
import Main.GamePanel;

public class OBJ_TeddyBear extends Entity {

    public OBJ_TeddyBear(GamePanel gp) {
        super(gp);

        name = "Teddybear";
        Down1 = setup("objects/Teddybear", gp.tileSize, gp.tileSize);
    }
}
