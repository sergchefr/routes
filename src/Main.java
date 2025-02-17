import client.ClientManager;
import coll.*;
import server.ServerManager;

public class Main {
    public static void main(String[] args) {
        TreeSetHandler tsh = new TreeSetHandler();
        ConsoleIO consoleIO = new ConsoleIO(new CommExec(tsh));
        //consoleIO.start();
        ClientManager cl = new ClientManager(new ServerManager());
        cl.action();
    }
}