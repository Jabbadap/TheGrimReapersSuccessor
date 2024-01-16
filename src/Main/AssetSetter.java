package Main;

import Entity.NPC_1;
import Entity.NPC_2;
import Entity.NPC_3;
import Entity.NPC_GrimmReaper;
import Monster.MON_Spider;
import objects.*;

public class AssetSetter {

    GamePanel gp;
    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {
        // Objecten
        // gp.obj[0] = new OBJ_Door(gp);
        // gp.obj[0].worldX = 16 * gp.tileSize;
        // gp.obj[0].worldY = 46 * gp.tileSize;

        // gp.obj[1] = new OBJ_KeyR(gp);
        // gp.obj[1].worldX = 58 * gp.tileSize;
        // gp.obj[1].worldY = 41 * gp.tileSize;

        gp.obj[2] = new OBJ_KeyR(gp);
        gp.obj[2].worldX = 19 * gp.tileSize;
        gp.obj[2].worldY = 43 * gp.tileSize;

        gp.obj[3] = new OBJ_DoorG(gp);
        gp.obj[3].worldX = 18 * gp.tileSize;
        gp.obj[3].worldY = 44 * gp.tileSize;

        gp.obj[4] = new OBJ_DoorB(gp);
        gp.obj[4].worldX = 30 * gp.tileSize;
        gp.obj[4].worldY = 41 * gp.tileSize;

        // gp.obj[5] = new OBJ_DoorY(gp);
        // gp.obj[5].worldX = 16 * gp.tileSize;
        // gp.obj[5].worldY = 46 * gp.tileSize;

        gp.obj[6] = new OBJ_DoorR(gp);
        gp.obj[6].worldX = 16 * gp.tileSize;
        gp.obj[6].worldY = 46 * gp.tileSize;

        gp.obj[7] = new OBJ_TeddyBear(gp);
        gp.obj[7].worldX = 22 * gp.tileSize;
        gp.obj[7].worldY = 53 * gp.tileSize;
    }

    public void setNPC() {
        gp.npc[0] = new NPC_GrimmReaper(gp);
        gp.npc[0].worldX = gp.tileSize * 38;
        gp.npc[0].worldY = gp.tileSize * 36;

        gp.npc[2] = new NPC_1(gp);
        gp.npc[2].worldX = gp.tileSize * 12;
        gp.npc[2].worldY = gp.tileSize * 49;

        // gp.npc[1] = new NPC_2(gp);
        // gp.npc[1].worldX = gp.tileSize * 38;
        // gp.npc[1].worldY = gp.tileSize * 21;

        // gp.npc[3] = new NPC_3(gp);
        // gp.npc[3].worldX = gp.tileSize * 54;
        // gp.npc[3].worldY = gp.tileSize * 41;
    }

    public void setMonster() {
        gp.monster[0] = new MON_Spider(gp);
        gp.monster[0].worldX = gp.tileSize * 20;
        gp.monster[0].worldY = gp.tileSize * 50;

        gp.monster[1] = new MON_Spider(gp);
        gp.monster[1].worldX = gp.tileSize * 33;
        gp.monster[1].worldY = gp.tileSize * 35;

        gp.monster[2] = new MON_Spider(gp);
        gp.monster[2].worldX = gp.tileSize * 35;
        gp.monster[2].worldY = gp.tileSize * 40;

        gp.monster[3] = new MON_Spider(gp);
        gp.monster[3].worldX = gp.tileSize * 40;
        gp.monster[3].worldY = gp.tileSize * 45;

        gp.monster[4] = new MON_Spider(gp);
        gp.monster[4].worldX = gp.tileSize * 45;
        gp.monster[4].worldY = gp.tileSize * 50;
    }
}

