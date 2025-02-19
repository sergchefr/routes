package coms;

import server.ServerManager;

public class ExecuteScriptCommand extends AbstractCommand{

    private String filename;
    public ExecuteScriptCommand(ServerManager target, String[] param) {
        super(target, param);
        filename = param[0];
    }

    @Override
    public String execute() {
        return getTarget().executeScript(filename);
    }

    @Override
    public String description() {
        return "execute_script filename executes script with filename";
    }
}
