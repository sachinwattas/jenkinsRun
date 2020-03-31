public class Chromedriver implements WebDriverInterafce {
    public void get(String url) {
        System.out.println("Launch the URL " + url);
    }

    public void sendKey(String key) {

        System.out.println("enter the key "+ key);
    }
}
