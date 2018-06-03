package com.adventure;

public class CastleEngine {
    private Narrator narrator;

    public CastleEngine(Narrator narrator) {
        this.narrator = narrator;
    }





    public void goToThroneRoom(Hero hero) throws InterruptedException{

        switch (hero.getGameProgress()){
            case 1:
                narrator.throneRoomNarrative(hero);
        }
    }
}
