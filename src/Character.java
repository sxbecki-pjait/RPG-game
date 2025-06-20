public abstract class Character implements Attackable {
    private String name;
    private int level = 1;
    private int hp;
    private int hpMax;
    private String hometown = "N/A";
    private int attack;
    private boolean isDead = false;
    private String stats;


    public Character(String name, String hometown, int hp, int attack) {
        this.name = name;
        this.hometown = hometown;
        this.hp = hp;
        this.hpMax = hp;
        this.attack = attack;
        this.stats = name + " STATS       HP " + hp + "/"+ hpMax + "       LEVEL " + level;
    }

    public Character(String name, int hp, int attack) {
        this.name = name;
        this.hp = hp;
        this.hpMax = hp;
        this.attack = attack;
        this.stats = name + " STATS       HP " + hp + "/"+ hpMax + "       LEVEL " + level;
    }

    public void levelUp(){
        level++;
        attack = (int) Math.round(attack* LEVEL_MULTIPLIER);
        hpMax = (int) Math.round(hpMax* LEVEL_MULTIPLIER);

    }

    public String getName() {
        return name;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    public int getLevel() {
        return level;
    }

    public int getHp() {
        return hp;
    }

    public int getHpMax() {
        return hpMax;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void getInfo(){
        System.out.println("NAME: " + name);
        System.out.println("LEVEL: " + level);
        System.out.println("HP: " + hp);
        if(!hometown.equals("N/A")){
            System.out.println("HOMETOWN: " + hometown);
        }
        System.out.println("ATTACK: " + attack);
    }

    public boolean isDead() {
        return isDead;
    }

    public void refreshStats(){
        stats = name + " STATS       HP " + hp + "/"+ hpMax + "       LEVEL " + level;
    }

    public void receiveAttack(int hpAmount){
        if(hp-hpAmount <= 0){
            hp = 0;
        }
        else{
            hp -= hpAmount;
        }
        System.out.println(name + " HAS RECEIVED ATTACK! -" + hpAmount + "HP");
        refreshStats();
        if(hp<=0){
            isDead = true;
        }
    }

    public int getAttack(){
        return attack;
    }

    public String getStats() {
        refreshStats();
        return stats;
    }

    @Override
    public void attack(Character target) {
        boolean isCritical;
        if((int) (Math.random()*2)>0){
            isCritical = true;
        }
        else{
            isCritical = false;
        }
        if(isCritical){
            System.out.println("CRITICAL HIT!");
        }
        target.receiveAttack(isCritical? getAttack()*CRIT_MULTIPLIER : getAttack());
    }
}
