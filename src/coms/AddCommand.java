package coms;
import coll.Commands;

import coll.Route;

import java.io.IOException;
import java.util.Arrays;

public class AddCommand implements Icommand {
Commands target;
Object obj;

    public AddCommand(Commands target, Object obj) {
        this.target = target;
        this.obj = obj;
    }

    public void execute(){
        target.add(obj);
    }

    public String description(){
        return "adds a new route to the collection";
    }
}
