public class Lumberjack extends Character {
    public Lumberjack() {
        super("LUMBERJACK", "SHED IN THE FOREST", 200, 20);
    }

    @Override
    public void attack(Character target) {
        System.out.println("MONK ATTACKS USING UNKNOWN MARTIAL ART ATTACK");
        super.attack(target);
    }
}
