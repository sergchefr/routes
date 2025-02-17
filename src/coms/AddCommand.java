package coms;
import coll.Commands;

import coll.Route;

import java.io.IOException;
import java.util.Arrays;

public class AddCommand implements Icommand {
Commands target;
Object obj;

    public AddCommand(Commands target, String param) {
        this.target = target;
        this.obj = obj;
    }

    public AddCommand(String a) {
    }

    public void execute(){
        target.add(obj);
    }

    public String description(){
        return "adds a new route to the collection";
    }


}
