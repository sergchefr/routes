import java.util.Arrays;

public interface Commands {
    public String save(String filename);
    public String load(String filename);
    public String add(Route route);
    public String info();
    public String show();
    public String update(int id, Route route);
    public String removeById(int id);
    public String clear();
    public String executeScript(String fileName);
    public String exit();
    public String addIfMax(Route route);
    public String addIfMin(Route route);
    public String avgdistance();
    public String printAsc();
    public String printAscDist();
}
