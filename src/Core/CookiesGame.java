package Core;

public class CookiesGame {

    private int cookies = 0;
    private int grannies = 0;
    private int farms = 0;

    static final int UNLOCK_GRANNY = 0;
    private long lastUpdateTime;


    public CookiesGame() {
        lastUpdateTime = System.currentTimeMillis();
    }

    public void click() {
        cookies += 1;
    }

    public void hireGranny() {
        grannies += 1;
    }

    public void buildFarm() {
        farms += 1;
    }

    public void updateCookies() {
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - lastUpdateTime;

        
        if (grannies >= 1) {
            cookies += (int) ((elapsedTime / 1000) * (grannies * 5));
        }

        if (farms >= 1) {
            cookies += (int) ((elapsedTime / 1000) * (farms * 20));

        }
        lastUpdateTime = currentTime;
    }

    public int getCookies() {
        updateCookies();
        return cookies;
    }

    public int getGrannies() {
        return grannies;
    }

    public int getFarms() {
        return farms;
    }
}
