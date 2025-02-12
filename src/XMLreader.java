import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;

public class XMLreader {





    public String[] read()throws IOException{
        ArrayList<String> commands = new ArrayList<>();
        String filepath  ="src/save.txt";
        try(BufferedReader bfr = new BufferedReader(new InputStreamReader(new FileInputStream(filepath)))){
            String nl;
            while(true){
                nl = bfr.readLine();
                if (nl!= null) commands.add(nl.strip());
                else break;
            }
        }catch(IOException e){
            throw new IOException(e);
        }
        return commands.toArray(new String[0]);
    }
    public void getRoutes(){
        Long id;
        String name;
        Date creationTime;
        Location from;
        Location to;
        float distance;

    }
}
