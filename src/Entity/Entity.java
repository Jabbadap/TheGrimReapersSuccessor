package Entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
    /*
    Deze class is een superclasse om verschillende entities aan te maken, zoals de player, NPC's en enemies etc.

    Variabelen die meegegeven kunnen/moeten worden bij het aanmaken van een entity:
        - worldx, worldY = Laat begin positie op de map zien
        - speed = Snelheid van je entity
        - Up1, Up2 etc. = De afbeeldingen die gebruikt worden om de entity te visualiseren
        - direction = De start direction van de entity

    Standaard variabelen:
        - spriteCounter, default 0 = Wordt gebruikt om het aantal frames wanneer de afbeelding moet switchen tijdens
            het bewegen weer te geven voor de loop animatie, hoe minder frames, hoe sneller de loopanimatie
        - spriteNumber, default 1 = De frames waar de loop animatie tussen switcht (bijvoorbeeld Up1 en Up2)
        - solidArea = Het gedeelte van je entity dat collision kan vormen
        - solidAreaDefaultX, solidAreaDefaultY = De default X en Y waarden van de solidArea
        - collisionOn, default false = Of de entity collision kan vormen met andere objecten of niet
     */

    // Set default variables
    public int worldX, worldY;
    public int speed;
    public BufferedImage Up1, Up2, Down1, Down2, Left1, Left2, Right1, Right2;
    public String direction;

    // Standard variables
    public int spriteCounter = 0;
    public int spriteNumber = 1;
    public Rectangle solidArea;
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;

}
