package Main;

import objects.*;

public class AssetSetter {

    GamePanel gp;
    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {
        gp.obj[0] = new OBJ_KeyR(gp);
        gp.obj[0].worldX = 33 * gp.tileSize;
        gp.obj[0].worldY = 35 * gp.tileSize;

        gp.obj[1] = new OBJ_KeyY(gp);
        gp.obj[1].worldX = 52 * gp.tileSize;
        gp.obj[1].worldY = 35 * gp.tileSize;

        gp.obj[2] = new OBJ_KeyB(gp);
        gp.obj[2].worldX = 33 * gp.tileSize;
        gp.obj[2].worldY = 10 * gp.tileSize;

        gp.obj[3] = new OBJ_DoorR(gp);
        gp.obj[3].worldX = 33 * gp.tileSize;
        gp.obj[3].worldY = 24 * gp.tileSize;

        gp.obj[4] = new OBJ_DoorY(gp);
        gp.obj[4].worldX = 21 * gp.tileSize;
        gp.obj[4].worldY = 35 * gp.tileSize;

        gp.obj[5] = new OBJ_DoorB(gp);
        gp.obj[5].worldX = 45 * gp.tileSize;
        gp.obj[5].worldY = 35 * gp.tileSize;

        gp.obj[6] = new OBJ_Chest(gp);
        gp.obj[6].worldX = 33 * gp.tileSize;
        gp.obj[6].worldY = 16 * gp.tileSize;

        gp.obj[7] = new OBJ_Key(gp);
        gp.obj[7].worldX = 14 * gp.tileSize;
        gp.obj[7].worldY = 35 * gp.tileSize;
    }
}

