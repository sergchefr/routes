package coll;

import java.util.Arrays;
/** Интерфейс с командами управления коллекцией*/
public interface Commands {
    public String save(String filename);
    public String load(String filename);
    public String add(Object obj);
    public String info();
    public String show();
    public String update(int id, Object obj);
    public String removeById(int id);
    public String clear();
    public String executeScript(String fileName);
    public String exit();
    public String addIfMax(Object obj);
    public String addIfMin(Object obj);
    public String avgdistance();
    public String printAsc();
    public String printAscDist();
}
