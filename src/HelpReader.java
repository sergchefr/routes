import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class HelpReader {
    ArrayList<String> commands = new ArrayList<>();

    public HelpReader() throws IOException {

        String filepath = System.getProperty("java.class.path")+"\\data\\"+"help.txt";
        try(BufferedReader bfr = new BufferedReader(new InputStreamReader(new FileInputStream(filepath)))){
            String nl;
            while(true){
                nl = bfr.readLine();
                if (nl!= null) commands.add(nl);
                else break;
            }
        }catch(IOException e){
            throw new IOException(e);
        }
    }

    public String read(){
        String s="";
        for (String command : commands) {
            s=s+command+"\n";
        }
        return s;
    }

    public String read(String ref){
        //System.out.println(ref);
        for (String command : commands) {
            //System.out.println();
            if(command.strip().split(":")[0].equals(ref)) return command+"\n";
        }
        return "command \""+ref+  "\" not found\n";
    }
}
