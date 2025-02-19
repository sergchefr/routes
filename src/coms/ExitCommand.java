package coms;

import server.ServerManager;

public class ExitCommand extends AbstractCommand

{
    public ExitCommand(ServerManager target, String[] param) {
        super(target, param);
    }

    @Override
    public String execute() {
        return getTarget().exit();
    }

    @Override
    public String description() {
        return "use it to exit the program";
    }
}
