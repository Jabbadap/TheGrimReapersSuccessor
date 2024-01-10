package Main;

import Entity.NPC_1;
import Entity.NPC_2;
import Entity.NPC_GrimmReaper;
import objects.*;

public class AssetSetter {

    GamePanel gp;
    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {
        // Objecten
        gp.obj[1] = new OBJ_KeyY(gp);
        gp.obj[1].worldX = 57 * gp.tileSize;
        gp.obj[1].worldY = 40 * gp.tileSize;

        gp.obj[2] = new OBJ_KeyB(gp);
        gp.obj[2].worldX = 37 * gp.tileSize;
        gp.obj[2].worldY = 10 * gp.tileSize;

        gp.obj[3] = new OBJ_DoorG(gp);
        gp.obj[3].worldX = 37 * gp.tileSize;
        gp.obj[3].worldY = 32 * gp.tileSize;

        gp.obj[4] = new OBJ_DoorY(gp);
        gp.obj[4].worldX = 29 * gp.tileSize;
        gp.obj[4].worldY = 40 * gp.tileSize;

        gp.obj[5] = new OBJ_DoorB(gp);
        gp.obj[5].worldX = 45 * gp.tileSize;
        gp.obj[5].worldY = 40 * gp.tileSize;

        gp.obj[6] = new OBJ_Chest(gp);
        gp.obj[6].worldX = 37 * gp.tileSize;
        gp.obj[6].worldY = 16 * gp.tileSize;

        gp.obj[7] = new OBJ_KeyR(gp);
        gp.obj[7].worldX = 14 * gp.tileSize;
        gp.obj[7].worldY = 40 * gp.tileSize;
    }

    public void setNPC() {
        gp.npc[0] = new NPC_GrimmReaper(gp);
        gp.npc[0].worldX = gp.tileSize * 37;
        gp.npc[0].worldY = gp.tileSize * 35;

        gp.npc[1] = new NPC_1(gp);
        gp.npc[1].worldX = gp.tileSize * 37;
        gp.npc[1].worldY = gp.tileSize * 20;

        gp.npc[2] = new NPC_2(gp);
        gp.npc[2].worldX = gp.tileSize * 16;
        gp.npc[2].worldY = gp.tileSize * 40;

        gp.npc[3] = new NPC_2(gp);
        gp.npc[3].worldX = gp.tileSize * 53;
        gp.npc[3].worldY = gp.tileSize * 40;
    }
}

