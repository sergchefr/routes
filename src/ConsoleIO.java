import java.util.Scanner;

public class ConsoleIO {
    Scanner console = new Scanner(System.in);
    CommExec commExec;

    public ConsoleIO(CommExec commExec) {
        this.commExec = commExec;
    }

    public void start(){
        System.out.println("program started. Type commands or \"help\" for help");
        while(true){
            System.out.print(">>> ");
            String command = console.nextLine();
            command = deleteExtraSpace(command);
            String[] splitted = command.strip().split(" ");
            switch (splitted[0]){
                case("help"):
                    if(splitted.length==1) System.out.println(commExec.execute("help"));
                    else if(splitted[1]!=" ") System.out.println(commExec.execute("help " +splitted[1].strip()));
                    break;
                case("info"):
                    System.out.println(commExec.execute("info"));
                    break;
                case("show"):
                    System.out.println(commExec.execute("show"));
                    break;
                case("add"):
                    String c = "add ";
                    c=c+rangeConstructor();
                    System.out.println(commExec.execute(c));
                    break;
                case("exit"):
                    System.out.println(commExec.execute("exit"));
                    break;
                case("update"):
                    String a = "update ";
                    System.out.print("type id: ");
                    a=a+console.nextLine().strip();
                    a=a+rangeConstructor();
                    System.out.println(commExec.execute(a));
                    break;
                case("remove_by_id"):
                    if(splitted.length==2){
                        System.out.println(commExec.execute("remove_by_id "+splitted[1].strip()));
                    }else if(splitted.length==1){
                        System.out.print("type id: ");
                        System.out.println(commExec.execute("remove_by_id "+console.nextLine().strip()));
                    }
                    break;
                case("clear"):
                    System.out.println(commExec.execute("clear"));
                    break;
                case("save"):
                    System.out.println(commExec.execute("save"));
                    break;
                case("execute_script"):
                    if(splitted.length==2){
                        System.out.println(commExec.execute("execute_script "+splitted[1].strip()));
                    }else if(splitted.length==1){
                        System.out.print("type filename: ");
                        System.out.println(commExec.execute("execute_script "+console.nextLine().strip()));
                    }
                    break;
                case("add_if_max"):
                    String b = "add_if_max ";
                    b=b+rangeConstructor();
                    System.out.println(commExec.execute(b));
                    break;
                case("add_if_min"):
                    String d = "add_if_min ";
                    d=d+rangeConstructor();
                    System.out.println(commExec.execute(d));
                    break;
                case("history"):
                    System.out.println(commExec.execute("history"));
                    break;
                case("average_of_distance"):
                    System.out.println(commExec.execute("average_of_distance"));
                    break;
                case("print_ascending"):
                    System.out.println(commExec.execute("print_ascending"));
                    break;
                case("print_field_ascending_distance"):
                    System.out.println(commExec.execute("print_field_ascending_distance"));
                    break;
                default:
                    System.out.println("unidentified command");

            }
        }
    }

    private String rangeConstructor(){
        String c="";
        System.out.print("type the route name: ");
        String name = console.nextLine();

        System.out.println("type coordinates of from location. use \",\" as separator");
        System.out.print("x:int, y:int z:float: ");
        String[] fromCoordinates = console.nextLine().strip().split(",");
        for (int i = 0; i < 3; i++) {
            c=c+fromCoordinates[i].strip()+" ";
        }

        System.out.print("type the location name: ");
        c=c+ console.nextLine().strip()+" ";

        System.out.println("type coordinates of the destination location. use \",\" as separator");
        System.out.print("x:int, y:int z:float: ");
        String[] toCoordinates = console.nextLine().strip().split(",");
        for (int i = 0; i < 3; i++) {
            c=c+fromCoordinates[i].strip()+" ";
        }

        System.out.print("type the location name: ");
        c=c+ console.nextLine().strip()+" ";

        System.out.println("type the distance");
        System.out.print("dist:float: ");
        c=c+ console.nextLine().strip()+" ";

        c=c+name;

        //System.out.println("--c "+c);
        return c;
    }

    private String deleteExtraSpace(String a){
        char[] b = a.toCharArray();
        String s = "";
        boolean wasSpace = false;
        for (int i = 0; i < a.length(); i++) {
            if(!wasSpace){
                if(b[i]==' ') wasSpace = true;
                else wasSpace = false;

                s=s+b[i];
            }else{
                if(b[i]!=' ') s=s+b[i];
            }
        }
        return s;
    }

}
