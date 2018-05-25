package com.adventure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class GameText {

    @Value("#{'${beginningNarrative}'.split('\\|')}")
    private List<String> beginningNarrative;

    @Value("${beginningNarrativeLine1}")
    public String beginningNarrativeLine1;

    @Value("${isAttacking}")
    public String isAttacking;


    private Sleep sleep = new Sleep();
    public Narrator narrator = new Narrator();

    public void beginningNarrative(Hero hero) throws InterruptedException, IOException{
        narrator.storyNarrator(beginningNarrative);
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
        System.out.println(String.format(isAttacking, monster.getMonsterName()));
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
        System.out.println(String.format(isAttacking, hero.getHeroName()));
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
