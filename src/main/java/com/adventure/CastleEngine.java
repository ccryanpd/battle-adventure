package com.adventure;

public class CastleEngine {

    GameTextOutput gameTextOutput = new GameTextOutput();

    public void goToThroneRoom(Hero hero) throws InterruptedException{

        switch (hero.getGameProgress()){
            case 1:
                gameTextOutput.throneRoomNarrative1(hero);
        }
    }
}
