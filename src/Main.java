import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.nio.file.Files;

public class Main {
    public static void main(String[] args) {
        TreeSetHandler tsh = new TreeSetHandler();
        ConsoleIO consoleIO = new ConsoleIO(new CommExec(tsh));
        consoleIO.start();
    }
}