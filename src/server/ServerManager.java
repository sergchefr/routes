package server;
import client.ClientManager;
import coll.Commands;
import coms.*;

import java.util.ArrayDeque;
import java.util.Collection;

public class ServerManager{
    ClientManager clientManager;
    ArrayDeque<Icommand> coms= new ArrayDeque<>();

    public ServerManager(ClientManager clientManager) {
        this.clientManager = clientManager;
    }

    public ServerManager() {
    }

    public void execute(){
        if(!coms.isEmpty()) coms.pollFirst().execute();
    }

    public void addCommand(Icommand com){
        coms.addLast(com);
        execute();
    }

}
