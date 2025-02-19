package coms;

import server.ServerManager;

public class PrintAscCommand extends AbstractCommand{
    public PrintAscCommand(ServerManager target, String[] param) {
        super(target, param);
    }

    @Override
    public String execute() {
        return getTarget().printAsc();
    }

    @Override
    public String description() {
        return "shows elements of the collection, sorted by their distance";
    }
}
