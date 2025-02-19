package coms;

import server.ServerManager;

public class Infocommand extends AbstractCommand{

    public Infocommand(ServerManager target,String[] param) {
        super(target,param);
    }

    @Override
    public String execute() {
        return getTarget().info();
    }

    @Override
    public String description() {
        return "shows the info about the collection";
    }
}
