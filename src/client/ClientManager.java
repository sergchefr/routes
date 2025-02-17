package client;

import coll.Location;
import coll.Route;
import coll.TreeSetHandler;
import coms.AddCommand;
import coms.Icommand;
import server.ServerManager;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ClientManager {
    ServerManager serverManager;
    HashMap<String, Icommand> coms = new HashMap<>();

    public ClientManager(ServerManager serverManager) {
        this.serverManager = serverManager;

        coms.put("add",new AddCommand(new TreeSetHandler(), new String()));
    }

    public void action(){
        //try {
            Constructor<?> constructor = coms.get("add").getClass().getConstructors()[1];
        try {
            ///Icommand s = (Icommand)
            Icommand s =(Icommand) constructor.newInstance("sdg");
            System.out.println(s.description());
            //constructor.newInstance(new TreeSetHandler(), new Route("asrgf", new Location(1, 3, 5f, "awerf"), new Location(1, 5, 8f, "mugfh"), 456f));
        } catch (/*IOException |*/ InstantiationException | IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }


            //}catch(NoSuchMethodException e){
            //System.out.println("bullshit");
        //}



    }



}
