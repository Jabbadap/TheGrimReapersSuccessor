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
        Up1 = setup("NPC/Grimm Up");
        Up2 = setup("NPC/Grimm Up");
        Down1 = setup("NPC/Grimm Down");
        Down2 = setup("NPC/Grimm Down");
        Left1 = setup("NPC/Grimm Left");
        Left2 = setup("NPC/Grimm Left");
        Right1 = setup("NPC/Grimm Right");
        Right2 = setup("NPC/Grimm Right");
    }

    public void setDialogue() {
        dialogues[0] = "Hello my dear ^^\n\nOh my, I am still in my... Euh... Friday robes!\nOh well...You don't mind " +
                "do you?";
        dialogues[1] = "Ah, that's right, you probably have some questions\non were you are and how you got here" +
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
        dialogues[11] = "Wait no, that's not what I meant...\nWhat I am trying to say is that it's not as bad as it " +
                "sounds like.\nYou also have some lovely people waiting for you! <3";
        dialogues[12] = "But that's not the reason we came to this island specifically...";
        dialogues[13] = "The thing is, I have been doing this for a very, very, very long time and have gotten really " +
                "tired. I haven't even been able to attend my knitting club in decennia!\nReading books, something I " +
                "used to love, has become a chore...\nAnd let's nog even start about my my poor, poor Ceberus... " +
                "Sitting at home... Alone... All day!:(\nEven getting dressed out of my pyjama's in the morning is " +
                "difficult!";
        dialogues[14] = "...";
        dialogues[15] = "...Euh... Yeah...";
        dialogues[16] = "These are actually my pyjama robes...";
        dialogues[17] = "Anyway, the thing I am asking trying to say, is that I am looking for a new successor.";
        dialogues[18] = "But I want it to be someone who is loving and caring,\nsome characteristics I think you might " +
                "posses:)";
        dialogues[19] = "To test my new successor I made this island, containing 3 dungeons\nto challenge if " +
                "you are the right person!\n\nSo if you are intrested, I'd say give it a go!:)";
    }

    public void speak() {
        super.speak();
    }
}
