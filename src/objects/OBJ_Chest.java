package objects;

import Main.GamePanel;
import Entity.Entity;

public class OBJ_Chest extends Entity {


    public OBJ_Chest(GamePanel gp) {
        super(gp);

        name = "Chest";
        Down1 = setup("objects/ChestC");
        collision = true;
    }
}
