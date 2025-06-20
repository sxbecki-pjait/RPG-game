public class Monk extends Character {
    public Monk() {
        super("MONK", "TEMPLE", 150, 10);
    }

    @Override
    public void attack(Character target) {
        System.out.println("MONK ATTACKS USING UNKNOWN MARTIAL ART ATTACK");
        super.attack(target);
    }
}
