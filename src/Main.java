import client.ClientManager;
import coll.*;
import coms.AbstractCommand;
import coms.*;
import coms.Icommand;
import server.ServerManager;

public class Main {
    public static void main(String[] args) {
        TreeSetHandler tsh = new TreeSetHandler();
        ConsoleIO consoleIO = new ConsoleIO(new CommExec(tsh));
        //consoleIO.start();
        ClientManager clientManager = new ClientManager(null);
        ServerManager servermanager =  new ServerManager(null,tsh);
        clientManager.setServerManager(servermanager);
        servermanager.setClientManager(clientManager);

        clientManager.addCommand("add", AddCommand.class);
        clientManager.addCommand("add_if_max", AddIfMaxCommand.class);
        clientManager.addCommand("add_if_min", AddIfMinCommand.class);
        clientManager.addCommand("info", Infocommand.class);
        clientManager.addCommand("show", ShowCommand.class);
        clientManager.addCommand("update", UpdateCommand.class);
        clientManager.addCommand("remove_by_id", RemoveByIdCommand.class);
        clientManager.addCommand("clear", ClearCommand.class);
        clientManager.addCommand("history", HistoryCommand.class);
        clientManager.addCommand("execute_script", ExecuteScriptCommand.class);
        clientManager.addCommand("exit", ExitCommand.class);
        clientManager.addCommand("average_of_distance", AVGdistanceCommand.class);
        clientManager.addCommand("print_ascending", PrintAscCommand.class);
        clientManager.addCommand("print_field_ascending_distance", PrintFieldAscDistCommand.class);
        clientManager.addCommand("save", SaveCommand.class);
        clientManager.addCommand("load", LoadCommand.class);

        AbstractCommand s = clientManager.getCommand("add","1 2 3 svo 1 2 3 skibidi 228 goida".split(" ") );
        //System.out.println(s.description());

        servermanager.addCommand(s);

consoleIO.start();
    }
}