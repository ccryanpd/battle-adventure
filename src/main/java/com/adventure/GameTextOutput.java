package com.adventure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class GameTextOutput {

    @Autowired
    private ResourceLoader resourceLoader;

    private Sleep sleep = new Sleep();

    public void beginningNarrative(Hero hero) throws InterruptedException, IOException{

        final Resource fileResource = resourceLoader.getResource("classpath:src/main/java/resource/GameText");
        fileResource

        System.out.println("------------------------------THE LOST KEYS------------------------------");
        TimeUnit.SECONDS.sleep(3);
        System.out.println("\n" + "ZZZZZ.....ZZZZZ.....ZZZZZ.....ZZZZ....Zzz...Zz..z........" + "\n");
        TimeUnit.SECONDS.sleep(3);
        System.out.println("The sun shines bright overhead as you awake confused in the middle of a field.");
        TimeUnit.SECONDS.sleep(3);
        System.out.println("The field shows no signs of crops.  The ground is extremely dry.");
        TimeUnit.SECONDS.sleep(3);
        System.out.println("You have no memory of where or who you are.  There is an empty backpack beside you.");
        TimeUnit.SECONDS.sleep(3);
        System.out.println("You look around at your surroundings.  There is a castle to the north.");
        TimeUnit.SECONDS.sleep(3);
        System.out.println("As you gaze toward the castle, a magical fairy appears in front of you.");
        TimeUnit.SECONDS.sleep(3);
        System.out.println("The fairy said --> " + hero.getHeroName() + ", go and speak with the King so your destiny may become clear.");
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Before the fairy disappears she hands you a GOLDEN KEY.  You put it in your pack. " + "\n");
        TimeUnit.SECONDS.sleep(3);
        hero.addItemToHeroInventory(hero, "GOLDEN KEY");
    }

    public void throneRoomNarrative1(Hero hero) throws InterruptedException {
        System.out.println("------------------------------THE THRONE ROOM------------------------------");
        TimeUnit.SECONDS.sleep(4);
        System.out.println("  ");

    }

    public void thankYou() throws InterruptedException {
        sleep.mediumSleep();
        System.out.println("Thank you for playing.");
    }

    public void monsterIsAttacking(Monster monster) throws InterruptedException {
        System.out.println("\n" + monster.getMonsterName() + " is Attacking...");
        sleep.attackActionSleep();
    }

    public void monsterAttack(Monster monster, String attackType, int result) throws InterruptedException {
        System.out.println("\n" + monster.getMonsterName() + " used a " + attackType + " Attack. Your Hp was reduced by " + result + "\n");
        sleep.mediumSleep();
    }

    public void monsterAttackMissed(Monster monster, String attackType) throws InterruptedException {
        System.out.println(monster.getMonsterName() + " " + attackType + " Attack Missed!" + "\n");
        sleep.mediumSleep();
    }

    public void heroIsAttacking(Hero hero) throws InterruptedException {
        System.out.println(hero.getHeroName() + " is Attacking...");
        sleep.attackActionSleep();
    }

    public void heroAttack(Hero hero, Monster monster, String typeOfAttack, int result) throws InterruptedException {
        System.out.println("\n" + hero.getHeroName() + " used a " + typeOfAttack + " Attack. " + monster.getMonsterName() + " Hp was reduced by " + result + "\n");
        sleep.mediumSleep();
    }

    public void heroAttackMissed(Monster monster, String typeOfAttack) throws InterruptedException {
        System.out.println(typeOfAttack + " Attack Missed!" + "\n");
        sleep.mediumSleep();
    }

    public void monsterPreemptive() throws InterruptedException {
        System.out.println("------------------------------MONSTER PREEMPTIVE ATTACK!!------------------------------" + "\n");
        sleep.mediumSleep();
    }





}
