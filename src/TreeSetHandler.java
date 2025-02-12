import java.util.Arrays;
import java.util.Collection;
import java.util.TreeSet;

public class TreeSetHandler implements Commands {
    private Collection coll;
    public TreeSetHandler() {
        coll = new TreeSet();
    }

    public String add(Route route){
        if(coll.add(route)) return "element was added";
        return "element is already in collection";
    }
    public String info(){
        return "in development";
    }
    public String show(){
        String s ="";
        if(coll.size()==0) return "collection is empty";

        for (Object o : coll) {
            s=s+o.toString()+"\n";
        }
        return s;
    }
    public String update(int id, Route route){
        for (Object o : coll) {
            if(((Route)o).getId()==id) {
                coll.remove(o);
                coll.add(new Route((long)id, route.getName(),route.getCreationDate(), route.getFrom(),route.getTo(), route.getDistance()));
                return "element updated by id";
            }
        }
        return "element with this id doesn`t exist";
    }
    public String removeById(int id){
        for (Object o : coll) {
            if(((Route)o).getId()==id) {
                coll.remove(o);
                return "element deleted";
            }
        }
        return "element with this id doesn`t exist";
    }
    public String clear(){
        coll.clear();
        return "collection cleared";
    }
    public String save(){
        return "in development";
    }
    public String executeScript(String fileName){
        return "in development";
    }
    public String exit(){
        System.exit(0);
        return "";
    }
    public String addIfMax(Route route){
        float maxd=0;
        for (Object o : coll) {
            if(((Route)o).getDistance()>maxd) maxd=((Route)o).getDistance();
        }
        if(route.getDistance()>maxd) {
            coll.add(route);
            return "element was added";
        }
        return "element is not max";
    }
    public String addIfMin(Route route){
        float mind=Float.POSITIVE_INFINITY;
        for (Object o : coll) {
            if(((Route)o).getDistance()<mind) mind=((Route)o).getDistance();
        }
        if(route.getDistance()<mind) {
            coll.add(route);
            return "element was added";
        }
        return "element is not min";
    }
    public String history(){
        return "in development";
    }
    public String avgdistance(){
        double s=0;
        for (Object o : coll) {
            s=s+((Route)o).getDistance();
        }
        return Double.toString(s/coll.size());
    }
    public String printAsc(){
        return "in development\n"+this.show();
    }
    public String printAscDist(){
        float[] dist=new float[coll.size()];
        int i =0;
        for (Object o : coll) {
            dist[i++]=((Route)o).getDistance();
        }
        Arrays.sort(dist);
        String s="";
        for (float v : dist) {
            s=s+v+", ";
        }
        return s;
    }
}
