import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameManager {
    private List<Character> allCharacters = new ArrayList<Character>();
    private Character playerCharacter;
    private String playerLocation;
    private boolean entityInTheCave = true;
    private boolean entityInTheTemple = true;
    private boolean entityInTheForest = true;

    public GameManager() {
        this.playerLocation = "HOME";
    }

    public Character chooseCharacter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("WELCOME TO THE GAME: CHOOSE YOUR CHARACTER");
        System.out.println("brave, strong KNIGHT (0)");
        System.out.println("unbeatable, karate master, KING BRUCE LEE (1)");
        int input = scanner.nextInt();
        if(input == 0) {
            playerCharacter = new Knight();
        }
        else if(input == 1) {
            playerCharacter = new KingBruceLee();
        }
        else {
            System.out.println("\n\n\nINVALID INPUT. TRY AGAIN");
            chooseCharacter();
        }
        System.out.println("YOU CHOSE " + playerCharacter.getName() + ". HERE ARE SOME STATS");
        playerCharacter.getInfo();
        moveToNextAction();
        return playerCharacter;
    }

    public void startGame(){
        playerAtHome();
    }

    public void playerChoiceScreen() {
        clearScreen();
        System.out.println("---------" + playerLocation + "---------");
        System.out.println(playerCharacter.getStats());
        System.out.println("\nACTIONS:");
    }

    public void playerAtHome(){
        playerChoiceScreen();
        System.out.println("GO TO MOUNTAINS (0)");
        System.out.println("GO TO TEMPLE (1)");
        System.out.println("GO TO FOREST (2)");
        if(playerCharacter.getHp() < playerCharacter.getHpMax()){
            System.out.println("REST ((IF HP NOT MAX) HP + 40) (3)");
        }
        System.out.print("\nYOUR CHOICE: ");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if(input == 0) {
            playerLocation = "MOUNTAINS";
            playerInTheMountains();
        }
        else if(input == 1) {
            playerLocation = "OUTSIDE THE TEMPLE";
            playerInTheTemple();
        }
        else if (input == 2) {
            playerLocation = "FOREST";
            playerInTheForest();
        }
        else if(input == 3 && playerCharacter.getHp() < playerCharacter.getHpMax()) {
            if(playerCharacter.getHp() + 40 > playerCharacter.getHpMax()){
                playerCharacter.setHp(playerCharacter.getHpMax());
            }
            else{
                playerCharacter.setHp(playerCharacter.getHp() + 40);
            }
            System.out.print("*TAKING A NAP*");
            playerCharacter.refreshStats();
            moveToNextAction();
            playerAtHome();
        }
        else{
            System.out.println("\n\n\nINVALID INPUT. TRY AGAIN");
            moveToNextAction();
            playerAtHome();
        }

    }
    public void playerInTheMountains(){
        playerLocation = "MOUNTAINS";
        playerChoiceScreen();
        System.out.println("ENTER THE CAVE (0)");
        System.out.println("GRAB AND THROW SOME STONES INTO THE CAVE (1)");
        System.out.println("GO BACK HOME (2)");
        System.out.print("\nYOUR CHOICE: ");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if(input == 0) {
            if(!entityInTheCave){
                System.out.println("SEEMS LIKE THERE IS NOTHING INTERESTING ANYMORE");
                moveToNextAction();
            }
            else{
                battle(playerCharacter, new Caveman(), "CAVE");
            }
            if(!playerCharacter.isDead()){
                playerInTheMountains();
            }
        }
        else if(input == 1) {
            clearScreen();
            if(entityInTheCave){
                System.out.println("*SOMETHING (?) IS MUMBLING QUIETLY*");
            }
            else{
                System.out.println("*SOUND OF STONES HITTING THE GROUND*");
            }
            moveToNextAction();
            playerInTheMountains();
        }
        else if (input == 2) {
            System.out.println("*GOING BACK HOME*");
            moveToNextAction();
            playerAtHome();
        }
        else{
            System.out.println("\n\n\nINVALID INPUT. TRY AGAIN");
            moveToNextAction();
            playerInTheMountains();
        }

    }
    public void playerInTheTemple(){
        playerLocation = "OUTSIDE THE TEMPLE";
        playerChoiceScreen();
        System.out.println("ENTER THE TEMPLE (0)");
        System.out.println("READ THE TEXT ON THE OLD WALL (1)");
        System.out.println("GO BACK HOME (2)");
        System.out.print("\nYOUR CHOICE: ");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if(input == 0) {
            if(!entityInTheTemple){
                System.out.println("SEEMS LIKE THERE IS NOTHING INTERESTING ANYMORE");
                moveToNextAction();
            }
            else{
                battle(playerCharacter, new Monk(), "TEMPLE");
            }
            if(!playerCharacter.isDead()){
                playerInTheTemple();
            }
        }
        else if(input == 1) {
            clearScreen();
            if(entityInTheTemple){
                System.out.println("IT'S WRITTEN *UNBEATABLE MONK DYNASTY*");
            }
            else{
                System.out.println("THE TEXT IS BLURRED AND CHANGED IT'S COLOR TO GREY, YOU CAN'T READ IT ANYMORE");
            }
            moveToNextAction();
            playerInTheTemple();
        }
        else if (input == 2) {
            System.out.println("*GOING BACK HOME*");
            moveToNextAction();
            playerAtHome();
        }
        else {
            System.out.println("\n\n\nINVALID INPUT. TRY AGAIN");
            moveToNextAction();
            playerInTheTemple();
        }

    }
    public void playerInTheForest(){
        playerLocation = "FOREST";
        playerChoiceScreen();
        System.out.println("ENTER THE DARK WOODEN SHED (0)");
        System.out.println("READ THE TEXT ON THE OLD WALL (1)");
        System.out.println("GO BACK HOME (2)");
        System.out.print("\nYOUR CHOICE: ");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if(input == 0) {
            if(!entityInTheTemple){
                System.out.println("SEEMS LIKE THERE IS NOTHING INTERESTING ANYMORE");
                moveToNextAction();
            }
            else{
                battle(playerCharacter, new Monk(), "TEMPLE");
            }
            if(!playerCharacter.isDead()){
                playerInTheTemple();
            }
        }
        else if(input == 1) {
            clearScreen();
            if(entityInTheTemple){
                System.out.println("IT'S WRITTEN *UNBEATABLE MONK DYNASTY*");
            }
            else{
                System.out.println("THE TEXT IS BLURRED AND CHANGED IT'S COLOR TO GREY, YOU CAN'T READ IT ANYMORE");
            }
            moveToNextAction();
            playerInTheTemple();
        }
        else if (input == 2) {
            System.out.println("*GOING BACK HOME*");
            moveToNextAction();
            playerAtHome();
        }
        else {
            System.out.println("\n\n\nINVALID INPUT. TRY AGAIN");
            moveToNextAction();
            playerInTheTemple();
        }

    }

    public void clearScreen(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
    }

    public void battle(Character character, Character enemy, String location){
        clearScreen();
        playerLocation = location;
        System.out.println("---------" + playerLocation + "---------");
        System.out.println("THE " + enemy.getName() + " WAS HIDDEN IN THE " + location + "\n");
        while(!character.isDead() && !enemy.isDead()){
            enemy.attack(character);
            System.out.println("\n\n" + enemy.getStats());
            System.out.println(playerCharacter.getStats());
            moveToNextAction();
            if(character.isDead()){
                System.out.println("\nYOU ARE DEAD");
                break;
            }
            character.attack(enemy);
            System.out.println("\n\n" + enemy.getStats());
            System.out.println(playerCharacter.getStats());
            moveToNextAction();


        }
        if(enemy.isDead()){
            switch (enemy.getName()) {
                case "CAVEMAN" -> {
                    System.out.println("There is no caveman anymore!");
                    entityInTheCave = false;
                }
                case "MONK" -> entityInTheTemple = false;
                case "LUMBERJACK" -> entityInTheForest = false;
            }
        }
        if(!playerCharacter.isDead()){
            System.out.println("YOU WON THE BATTLE! ++ LEVEL ++");
            playerCharacter.levelUp();
        }
        System.out.println(playerCharacter.getStats());
        moveToNextAction();

    }

    public void moveToNextAction(){
        System.out.println("\nPRESS 'ENTER' TO CONTINUE");
        Scanner scanner = new Scanner(System.in);
        String sc = scanner.nextLine();
        clearScreen();
    }
}
