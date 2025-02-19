package coms;

import server.ServerManager;

public class ShowCommand extends AbstractCommand{

    public ShowCommand(ServerManager target, String[] param) {
        super(target, param);
    }

    @Override
    public String execute() {
        return getTarget().show();
    }

    @Override
    public String description() {
        return "shows the collection`s elements";
    }
}
