package client;

import coll.Location;
import coll.Route;
import coll.TreeSetHandler;
import coms.AbstractCommand;
import coms.AddCommand;
import coms.Icommand;
import coms.Response;
import server.ServerManager;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ClientManager {
    ServerManager serverManager;
    HashMap<String, Class> coms = new HashMap<>();

    public ClientManager(ServerManager serverManager) {
        this.serverManager = serverManager;
    }

    public AbstractCommand getCommand(String comName, String[] param){
            Constructor<?> constructor = coms.get("add").getConstructors()[0];
        try {
            return (AbstractCommand) constructor.newInstance(serverManager, param);
            //constructor.newInstance(new TreeSetHandler(), new Route("asrgf", new Location(1, 3, 5f, "awerf"), new Location(1, 5, 8f, "mugfh"), 456f));
        } catch (/*IOException |*/ InstantiationException | IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
    }

    public void setServerManager(ServerManager serverManager) {
        this.serverManager = serverManager;
    }

    public void giveResponse(Response resp){
        System.out.println(resp.getResponse());
    }

    public void addCommand(String name, Class cl){
        coms.put(name, cl);
    }

}
