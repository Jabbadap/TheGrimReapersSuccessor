package Entity;

import Main.GamePanel;

public class NPC_GrimmReaper extends Entity {

    public NPC_GrimmReaper(GamePanel gp) {
        super(gp);

        direction = "Down";

        getImage();
        setDialogue();
    }

    public void getImage() {
        // Getting the right image for the right movement
        Up1 = setup("NPC/GrimmU", gp.tileSize, gp.tileSize);
        Up2 = setup("NPC/GrimmU", gp.tileSize, gp.tileSize);
        Down1 = setup("NPC/GrimmD", gp.tileSize, gp.tileSize);
        Down2 = setup("NPC/GrimmD", gp.tileSize, gp.tileSize);
        Left1 = setup("NPC/GrimmL", gp.tileSize, gp.tileSize);
        Left2 = setup("NPC/GrimmL", gp.tileSize, gp.tileSize);
        Right1 = setup("NPC/GrimmR", gp.tileSize, gp.tileSize);
        Right2 = setup("NPC/GrimmR", gp.tileSize, gp.tileSize);
    }

    public void setDialogue() {
        dialogues[0] = """
                Hello my dear ^^
                Oh my, I am still in my... Euh... Friday robes!
                Oh well...You don't mind do you?""";
        dialogues[1] = "Ah, that's right, you probably have some questions on were you are and how you got here" +
                "\nI'll explain them for you!";
        dialogues[2] = "So... Were do I start?";
        dialogues[3] = "...Euhm...Well...";
        dialogues[4] = "How do I say this...?";
        dialogues[5] = "You euh...?";
        dialogues[6] = "...";
        dialogues[7] = "...";
        dialogues[8] = "...Died...";
        dialogues[9] = "...Yeah...\nThat happend";
        dialogues[10] = "But there's nothing to worry about!\n(You go to heaven after all...)\nDeath is a lively place!";
        dialogues[11] = """
                Wait no, that's not what I meant...
                What I am trying to say is that it's not as bad as it sounds like.
                You also have some lovely people waiting for you! <3""";
        dialogues[12] = "But that's not the reason we came to this place specifically..." +
                "\nSo, as you might have figured by now (or not), I am the Grimm Reaper, " +
                "but please just call me Grimm!";
        dialogues[13] = """
                The thing is, I have been doing this for a very, very, very long time and have gotten really tired.
                I haven't even been able to attend my knitting club in centuries!
                Reading books, something I used to love, has become a chore...""";
        dialogues[14] = """
                        And let's nog even start about my poor, poor Ceberus... Sitting at home... Alone... All day!:(
                        Even getting dressed out of my pyjama's in the morning is difficult!""";
        dialogues[15] = "...";
        dialogues[16] = "...Yeah\nThese are actually my pyjama robes...";
        dialogues[17] = "Anyway, the thing I am trying to say, is that I am looking for a new successor.";
        dialogues[18] = "But I want it to be someone who is loving and caring, some characteristics I think you might\n" +
                "posses:)";
        dialogues[19] = """
                To test my new successor I made this place, containing 3 dungeons to see if you are the 
                right person!
                So if you are interested, I'd say give it a go!:)""";
        dialogues[20] = "I will give you the key for the first dungeon!";
        dialogues[21] = "Je moeder";
    }

    public void dialogueAction() {
        if (dialogueIndex == 21 && !dialogueFinished) {
            gp.player.hasKeyB++;
            gp.ui.showMessage("You got a key!");
            dialogueFinished = true;
        }
        if (dialogueFinished) {
            dialogueIndex = 0;
            if(gp.player.hasTeddybear == 0) {
                dialogues[0] = "Go to the first dungeon, I am sure you can do it!";
            }
            if(gp.player.hasTeddybear == 1) {
                if(gp.player.karma < 0) {
                    dialogues[0] = "...I clearly misjudged you...";
                }
                if(gp.player.karma > 0) {
                    if(gp.monster[0] != null) {
                        dialogues[0] = "I knew you could do it!";
                    }
                    if(gp.monster[0] == null) {
                        dialogues[0] = "So you gave his Teddybear and then went back to kill his friend..." +
                                "\nYou are terrible!";
                    }
                }
                if(gp.player.karma == 0) {
                    if(gp.monster[0] != null) {
                        dialogues[0] = "So you kept his friend alive but stole his Teddybear???";
                    }
                    if(gp.monster[0] == null) {
                        dialogues[0] = "So you killed his friend AND stole his Teddybear???";
                    }
                }
            }
        }
    }

    public void speak() {
        super.speak();
    }
}
