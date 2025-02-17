package server;
import coll.Commands;
import coms.*;

import java.util.ArrayDeque;
import java.util.Collection;

public class ServerManager{
    ArrayDeque<Icommand> coms= new ArrayDeque<>();
    public void execute(){
        if(coms.size()>0) coms.pollFirst().execute();
    }

    public void addCommand(Icommand com){
        coms.addLast(com);
        execute();
    }
}
