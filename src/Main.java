import coll.*;

public class Main {
    public static void main(String[] args) {
        TreeSetHandler tsh = new TreeSetHandler();
        ConsoleIO consoleIO = new ConsoleIO(new CommExec(tsh));
        consoleIO.start();
    }
}