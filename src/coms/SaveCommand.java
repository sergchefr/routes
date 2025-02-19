package coms;

import server.ServerManager;

public class SaveCommand extends AbstractCommand{

    private final String filename;
    public SaveCommand(ServerManager target, String[] param) {
        super(target, param);
        filename= param[0];
    }

    @Override
    public String execute() {
        return getTarget().save(filename);
    }

    @Override
    public String description() {
        return "saves the collection into the XML file";
    }
}
