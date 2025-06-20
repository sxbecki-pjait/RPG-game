public class Main {

    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        Character player = gameManager.chooseCharacter();
        gameManager.startGame();
    }
}