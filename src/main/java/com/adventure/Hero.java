package com.adventure;

public class Hero {

    private String heroName;
    private int heroLevel;
    private int heroExperiencePoints;
    private int heroGold;
    private int heroHp;
    private int heroMp;
    private int heroRegularAttack;
    private int heroMagicAttack;
    private int heroDefense;
    private int potionSupply;
    private int etherSupply;


    public Hero(int heroLevel, int heroExperiencePoints, int heroGold, int heroHp, int heroMp,
                int heroRegularAttack, int heroMagicAttack, int heroDefense, int potion, int ether) {

        this.heroLevel = heroLevel;
        this.heroExperiencePoints = heroExperiencePoints;
        this.heroGold = heroGold;
        this.heroHp = heroHp;
        this.heroMp = heroMp;
        this.heroRegularAttack = heroRegularAttack;
        this.heroMagicAttack = heroMagicAttack;
        this.heroDefense = heroDefense;
        this.potionSupply = potion;
        this.etherSupply = ether;
    }

    public void getHeroStatus() {
        System.out.println(this.heroName + " -- Status");
        System.out.println("Level:  " + this.heroLevel);
        System.out.println("Experience:  " + this.heroExperiencePoints + "/100");
        System.out.println("Gold:  " + this.heroGold);
        System.out.println("Hp:  " + this.heroHp);
        System.out.println("Mp:  " + this.heroMp);
        System.out.println("Regular Attack:  " + this.heroRegularAttack);
        System.out.println("Magic Attack:  " + this.heroMagicAttack);
        System.out.println("Defense:  " + this.heroDefense);
        System.out.println("Potion:  " + this.potionSupply);
        System.out.println("Ether:  " + this.etherSupply + "\n");
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public int getHeroLevel() {
        return heroLevel;
    }

    public void setHeroLevel(int heroLevel) {
        this.heroLevel = heroLevel;
    }

    public int getHeroExperiencePoints() {
        return heroExperiencePoints;
    }

    public void setHeroExperiencePoints(int heroExperiencePoints) {
        this.heroExperiencePoints = heroExperiencePoints;
    }

    public int getHeroGold() {
        return heroGold;
    }

    public void setHeroGold(int heroGold) {
        this.heroGold = heroGold;
    }

    public int getHeroHp() {
        return heroHp;
    }

    public void setHeroHp(int heroHp) {
        this.heroHp = heroHp;
    }

    public int getHeroMp() {
        return heroMp;
    }

    public void setHeroMp(int heroMp) {
        this.heroMp = heroMp;
    }

    public int getHeroRegularAttack() {
        return heroRegularAttack;
    }

    public void setHeroRegularAttack(int heroRegularAttack) {
        this.heroRegularAttack = heroRegularAttack;
    }

    public int getHeroMagicAttack() {
        return heroMagicAttack;
    }

    public void setHeroMagicAttack(int heroMagicAttack) {
        this.heroMagicAttack = heroMagicAttack;
    }

    public int getHeroDefense() {
        return heroDefense;
    }

    public void setHeroDefense(int heroDefense) {
        this.heroDefense = heroDefense;
    }

    public int getPotionSupply() {
        return potionSupply;
    }

    public void setPotionSupply(int potionSupply) {
        this.potionSupply = potionSupply;
    }

    public int getEtherSupply() {
        return etherSupply;
    }

    public void setEtherSupply(int etherSupply) {
        this.etherSupply = etherSupply;
    }
}

