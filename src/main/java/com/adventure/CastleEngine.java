package com.adventure;

public class CastleEngine {

    private GameText gameText;


    public CastleEngine(GameText gameText) {
        this.gameText = gameText;
    }

    public void goToThroneRoom(Hero hero) throws InterruptedException{

        switch (hero.getGameProgress()){
            case 1:
                gameText.throneRoomNarrative1(hero);
        }
    }
}
