public class KingBruceLee extends Character{
    public KingBruceLee(){
        super("KING BRUCE LEE", 120, 15);
    }

    @Override
    public void attack(Character target) {
        System.out.println("KING BRUCE LEE ATTACKS WITH HIS KARATE HIT! HI-YAH");
        super.attack(target);
    }
}
