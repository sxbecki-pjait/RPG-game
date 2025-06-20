public class Caveman extends Character {
    public Caveman() {
        super("CAVEMAN", "CAVE", 150, 10);
    }

    @Override
    public void attack(Character target) {
        System.out.println("CAVEMAN THROWS MULTIPLE STONES!");
        super.attack(target);
    }
}
