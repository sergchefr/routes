import java.io.IOException;
import java.util.Arrays;

public class CommExec {
private Commands collhandler;
boolean helpFileExists = true;
HelpReader hrd;
History hst = new History();

public CommExec(Commands collhandler){
    this.collhandler = collhandler;
    try {
        hrd = new HelpReader();
    }catch (IOException e){
        helpFileExists = false;
    }

}
    public String execute(String par){
        String[] parm = par.strip().split(" ");
        hst.add(parm[0]);
        switch (parm[0]){

            case ("help"):{
                if(!helpFileExists) return "error while opening the help file";
                //System.out.println(parm[1]);
                if(parm.length==1){
                    return hrd.read();
                }else{

                    return hrd.read(parm[1]);
                }
            }

            case ("info"):{
                return collhandler.info();
            }

            case ("show"):{
                return collhandler.show();
            }

            case ("add"):{
                try{
                    Route route = RouteParse(Arrays.copyOfRange(parm, 1,11));
                    return collhandler.add(route);
                }catch (IOException e){
                    return e.getMessage();
                }
            }

            case ("update"):{
                int id = Integer.parseInt(parm[1]);
                try {
                    Route route = RouteParse(Arrays.copyOfRange(parm, 2, 12));
                    return collhandler.update(id, route);
                }catch (IOException e){
                    return e.getMessage();
                }
            }

            case ("remove_by_id"):{
                int id = Integer.parseInt(parm[1]);
                return collhandler.removeById(id);
            }

            case ("clear"):{
                return collhandler.clear();
            }

            case ("history"):{
                return hst.showHistory();
            }

            case ("execute_script"):{
                String filename = parm[1];
                return collhandler.executeScript(filename);
            }

            case ("exit"):{
                return collhandler.exit();
            }

            case ("add_if_max"):{
                try {
                    Route route = RouteParse(Arrays.copyOfRange(parm, 1,11));
                    return collhandler.addIfMax(route);
                }catch (IOException e){
                    return e.getMessage();
                }


            }

            case ("add_if_min"):{
                try{
                    Route route = RouteParse(Arrays.copyOfRange(parm, 1,11));
                    return collhandler.addIfMin(route);
                }catch (IOException e){
                    return e.getMessage();
                }
            }

            case ("average_of_distance"):{
                return collhandler.avgdistance();
            }

            case ("print_ascending"):{
                return collhandler.printAsc();
            }

            case ("print_field_ascending_distance"):{
                return collhandler.printAscDist();
            }

            case ("save"):{
                return collhandler.save(parm[1]);
            }

            case ("load"):{
                return collhandler.load(parm[1]);
            }


            default:
                //throw new ParseException("unidentified command", 0);
                return "unknown error";
        }
    }

    private Route RouteParse(String[] parm)throws IOException{    //public Route(String name,Location from, Location to, Float distance)
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
