package school.lemon.changerequest.java.io.hw1;

public class App {

    public static void main(String[] args) {
        FileManager manager = new FileManager("test");
        System.out.println(manager.ls());
        System.out.println();
        System.out.println(manager.ls(Order.BY_LAST_UPDATE_DESCENDING));
        System.out.println();
        System.out.println(manager.ls(Order.BY_LEXICOGRAPHICAL_DESCENDING, false));
    }

}
