import java.util.Date;

public class Route implements Comparable{
    private Long id;//Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private static Long nextid=0L;
    private String name; //Поле не может быть null, Строка не может быть пустой
    //private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Location from; //Поле может быть null
    private Location to; //Поле не может быть null
    private Float distance; //Поле не может быть null, Значение поля должно быть больше 1


    public Route(Long id, String name, Date creationDate, Location from, Location to, Float distance) {
        this.id = id;
        this.name = name;
        //this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.from = from;
        this.to = to;
        this.distance = distance;
    }

    public Route(String name,Location from, Location to, Float distance) {
        nextid++;
        id=nextid;
        this.name = name;
        //this.coordinates = coordinates;
        this.from = from;
        this.to = to;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", name='" + name + '\'' +
                //", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", from=" + from +
                ", to=" + to +
                ", distance=" + distance +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return (int)(this.id-((Route)o).id);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

//    public Coordinates getCoordinates() {
//        return coordinates;
//    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Location getFrom() {
        return from;
    }

    public Location getTo() {
        return to;
    }

    public Float getDistance() {
        return distance;
    }
}
