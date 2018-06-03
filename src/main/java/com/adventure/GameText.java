package com.adventure;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameText {

    @Value("#{'${beginningNarrative}'.split('\\|')}")
    public List<String> beginningNarrative;

    @Value("${isAttacking}")
    public String isAttacking;

    @Value("#{'${throneRoomNarrative}'.split('\\|')}")
    public List<String> throneRoomNarrative;

    @Value("${monsterPreemptiveAttack}")
    public String monsterPreemptiveAttack;

    @Value("${monsterAttack}")
    public String monsterAttack;

    @Value("${monsterAttackMissed}")
    public String monsterAttackMissed;

    @Value("${heroAttack}")
    public String heroAttack;

    @Value("${heroAttackMissed}")
    public String heroAttackMissed;

    @Value("${thankYou}")
    public String thankYou;

    @Value("#{'${mainGameMenu}'.split('\\|')}")
    public List<String> mainGameMenu;

    @Value("${heroChoice}")
    public String heroChoice;

    @Value("#{'${questMenu}'.split('\\|')}")
    public List<String> questMenu;

    @Value("#{'${castleMenu}'.split('\\|')}")
    public List<String> castleMenu;

    @Value("#{'${battleMenu}'.split('\\|')}")
    public List<String> battleMenu;

    @Value("#{'${yesOrNo}'.split('\\|')}")
    public List<String> yesOrNo;

    @Value("${dropItemMenu}")
    public String dropItemMenu;

    @Value("${notAnInteger}")
    public String notAnInteger;

    @Value("${tryAgain}")
    public String tryAgain;

    @Value("${heroName}")
    public String heroName;

    @Value("${heroStatus}")
    public String heroStatus;

    @Value("${heroExperience}")
    public String heroExperience;

    @Value("${heroLevel}")
    public String heroLevel;

    @Value("${heroGold}")
    public String heroGold;

    @Value("${heroHp}")
    public String heroHp;

    @Value("${heroMp}")
    public String heroMp;

    @Value("${heroRegularAttack}")
    public String heroRegularAttack;

    @Value("${heroMagicAttack}")
    public String heroMagicAttack;

    @Value("${heroDefense}")
    public String heroDefense;

    @Value("${addedtoInventory}")
    public String addedtoInventory;

    @Value("${youDied}")
    public String youDied;

    @Value("${noMp}")
    public String noMp;

    @Value("${inventory}")
    public String inventory;

    @Value("${heroPotion}")
    public String heroPotion;

    @Value("${heroEther}")
    public String heroEther;

    @Value("${inventoryItems}")
    public String inventoryItems;

    @Value("${monsterStatus}")
    public String monsterStatus;

    @Value("${monsterName}")
    public String monsterName;

    @Value("${monsterHp}")
    public String monsterHp;

    @Value("${monsterMp}")
    public String monsterMp;

    @Value("${monsterIsDead}")
    public String monsterIsDead;

    @Value("${battle}")
    public String battle;

    @Value("${vs}")
    public String vs;

    @Value("${questCompleted}")
    public String questCompleted;

    @Value("${seperator}")
    public String seperator;

    @Value("${dropItemChoice}")
    public String dropItemChoice;

    @Value("${notInInventory}")
    public String notInInventory;


}
