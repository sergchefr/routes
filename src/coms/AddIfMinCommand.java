package coms;

import coll.Location;
import coll.Route;
import server.ServerManager;

import java.io.IOException;

public class AddIfMinCommand extends AbstractCommand{
    private final Route route;

    public AddIfMinCommand(ServerManager target, String[] param) throws IOException {
        super(target, param);
        try {
            this.route = routeParse(param);
        } catch (IOException e) {
            throw new IOException(e);
        }
    }

    public String execute(){
        return getTarget().addIfMin(route);
    }

    public String description(){
        return "adds a route to the collection if it`s distance is the smallest in the collection";
    }

    private Route routeParse(String[] parm)throws IOException{
        //String[] parm = param.split(" ");

        //public Route(String name,Location from, Location to, Float distance)
        // public Location(Integer x, Integer y, Float z, String name)
        int fromx = Integer.parseInt(parm[0]);
        int fromy = Integer.parseInt(parm[1]);
        float fromz = Float.parseFloat(parm[2]);
        Location from = new Location(fromx, fromy, fromz, parm[3]);

        int tox = Integer.parseInt(parm[4]);
        int toy = Integer.parseInt(parm[5]);
        float toz = Float.parseFloat(parm[6]);
        Location to = new Location(tox, toy, toz, parm[7]);

        float dist = Float.parseFloat(parm[8]);

        String name = parm[9];
        try {
            return new Route(name, from, to, dist);
        }catch (IOException e){
            throw new IOException(e);
        }
    }
}
