import Core.CookiesGame;
import Ui.CookiesUi;
import Ui.GUICookiesUi;

public class Main {
    public static void main(String[] args) {

        CookiesGame game = new CookiesGame();
        CookiesUi ui = new GUICookiesUi(game);
    }


}