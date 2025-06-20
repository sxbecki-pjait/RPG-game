public class Lumberjack extends Character {
    private boolean angry;
    public Lumberjack(boolean angry) {
        super("LUMBERJACK", "SHED IN THE FOREST", 180, 18);
        if(angry){
            for(int i = 0; i <=5; i++){
                this.levelUp();
            }
            setHp(getHpMax());
        }
    }

    @Override
    public void attack(Character target) {
        System.out.println("LUMBERJACK USES HIS SHARP AXE");
        super.attack(target);
    }
}
