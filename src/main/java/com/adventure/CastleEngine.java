package com.adventure;

public class CastleEngine {

    public void goToThroneRoom(Hero hero) throws InterruptedException{
        Story story = new Story();
        switch (hero.getGameProgress()){
            case 1:
                story.throneRoomNarrative1(hero);
        }

    }
}
