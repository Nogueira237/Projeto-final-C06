package academia.app;

public class Main {

    public static void main(String[] args) {

        Menu menu = new Menu();
        Thread threadMenu = new Thread(menu);
        threadMenu.start();

    }

}

