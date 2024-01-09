package Entity;

import Main.GamePanel;

import java.util.Random;

public class NPC_GrimmReaper extends Entity {

    public NPC_GrimmReaper(GamePanel gp) {
        super(gp);

        direction = "Down";

        getImage();
        setDialogue();
    }

    public void getImage() {
        // Getting the right image for the right movement
        Up1 = setup("NPC/GrimmU");
        Up2 = setup("NPC/GrimmU");
        Down1 = setup("NPC/GrimmD");
        Down2 = setup("NPC/GrimmD");
        Left1 = setup("NPC/GrimmL");
        Left2 = setup("NPC/GrimmL");
        Right1 = setup("NPC/GrimmR");
        Right2 = setup("NPC/GrimmR");
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
        dialogues[12] = "But that's not the reason we came to this island specifically...";
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
                To test my new successor I made this island, containing 3 dungeons to see if you are the 
                right person!
                So if you are intrested, I'd say give it a go!:)""";
        dialogues[20] = "Here is the key for the first dungeon!";
    }

    public void speak() {
        super.speak();
    }
}
