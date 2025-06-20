public class Knight extends Character {
    public Knight() {
        super("KNIGHT", 100, 12);
    }

    @Override
    public void attack(Character target) {
        System.out.println("KNIGHT ATTACKS WITH HIS SWORD");
        super.attack(target);
    }
}
