package coms;

import server.ServerManager;

public class ClearCommand extends AbstractCommand {
    public ClearCommand(ServerManager target, String[] param) {
        super(target,param);
    }

    @Override
    public String execute() {
        return getTarget().clear();
    }

    @Override
    public String description() {
        return "deletes all elements from the collection";
    }
}
