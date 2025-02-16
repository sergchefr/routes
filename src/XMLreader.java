import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Stack;

public class XMLreader {


    public String[] read() throws IOException {
        ArrayList<String> commands = new ArrayList<>();
        String filepath = "src/save.xml";
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(new FileInputStream(filepath)))) {
            String nl;
            String version = bfr.readLine();
            while (true) {
                nl = bfr.readLine();
                if (nl != null) commands.add(nl.strip());
                else break;
            }
        } catch (IOException e) {
            throw new IOException(e);
        }
        return commands.toArray(new String[0]);
    }

    public ArrayList<Route> getRoutes1() throws IOException {
        Long id = -1L;
        String name = "";
        Date creationDate = new Date();
        String nameFrom = "";
        int fromx = 0;
        int fromy = 0;
        float fromz = 0;
        String nameTo = "";
        int tox = 0;
        int toy = 0;
        float toz = 0;
        float distance = 0;
        ArrayList<Route> routes = new ArrayList<>();
        Location from = new Location(0, 0, 0f, "mustBeChanged");
        Location to = new Location(0, 0, 0f, "mustBeChanged");

        String b = "";
        Stack<String> cond = new Stack<>();
        Stack<String> data = new Stack<>();
        try {
            for (String a : read()) {
                b = b + a;
            }
        } catch (IOException e) {
            throw new IOException(e);
        }




        return new ArrayList<Route>();
    }



























    public ArrayList<Route> getRoutes() throws IOException {
        Long id = -1L;
        String name = "";
        Date creationDate = new Date();
        String nameFrom = "";
        int fromx = 0;
        int fromy = 0;
        float fromz = 0;
        String nameTo = "";
        int tox = 0;
        int toy = 0;
        float toz = 0;
        float distance = 0;
        ArrayList<Route> routes = new ArrayList<>();
        Location from = new Location(0, 0, 0f, "mustBeChanged");
        Location to = new Location(0, 0, 0f, "mustBeChanged");

        String b = "";
        Stack<String> cond = new Stack<>();
        Stack<String> data = new Stack<>();
        try {
            for (String a : read()) {
                b = b + a;
            }
        } catch (IOException e) {
            throw new IOException(e);
        }


        data.add(b);

        System.out.println(data);
        System.out.println(cond);
        System.out.println();

        boolean wasString = false;
        while (data.size() != 0) {
            String first = data.pop();
            cond.add(first.substring(0, first.indexOf('>') + 1));
            //System.out.println(getmatch(cond.peek()));
            String p = first.substring(first.indexOf(cond.peek()) + cond.peek().length(), first.indexOf(getmatch(cond.peek())));
            String q = first.substring(first.indexOf(getmatch(cond.peek())) + cond.peek().length() + 1);


            if (true) {
                wasString = true;
                String a = cond.pop();
                System.out.println(a);
                switch (a) {
                    case ("<id>"):
                        id = Long.parseLong(p);
                        break;
                    case ("<name>"):
                        if (cond.peek().equals("<route>")) name = p;
                        else if (cond.peek().equals("<locationFrom>")) nameFrom = p;
                        else if (cond.peek().equals("<locationTo>")) nameTo = p;
                        break;

                    case ("<creationDate>"):
                        creationDate = null;
                        break;

                    case ("<x>"):
                        if (cond.peek().equals("<locationFrom>")) fromx = Integer.parseInt(p);
                        else if (cond.peek().equals("<locationTo>")) tox = Integer.parseInt(p);
                        break;
                    case ("<y>"):
                        if (cond.peek().equals("<locationFrom>")) fromy = Integer.parseInt(p);
                        else if (cond.peek().equals("<locationTo>")) toy = Integer.parseInt(p);
                        break;
                    case ("<z>"):
                        if (cond.peek().equals("<locationFrom>")) fromz = Float.parseFloat(p);
                        else if (cond.peek().equals("<locationTo>")) toz = Float.parseFloat(p);
                        break;
                    case ("<distance>"):
                        //System.out.println("goida");
                        distance = Float.parseFloat(p);
                        break;
                    case ("<route>"):
                        routes.add(new Route(id, name, creationDate, new Location(fromx, fromy, fromz, nameFrom), new Location(tox, toy, toz, nameTo), distance));
                        break;
                    case ("<locationFrom>"):
                        from = new Location(fromx, fromy, fromz, nameFrom);
                        break;
                    case ("<locationTo>"):
                        to = new Location(tox, toy, toz, nameTo);
                        break;
                }
            }
            else{
                wasString = true;
            }
            if (q != "") data.add(q);
            if (p != "" & p.contains("/")) data.add(p);
//            if (q=="" & wasString){
//
//            }
//
//                cond.pop();
            System.out.println(data);
            System.out.println(cond);
            System.out.println();
        }
        return routes;
    }

    private String getmatch (String a){
        return "</" + a.substring(1, a.length());
    }
}