import java.io.IOException;

public class ConsoleUtilities
{
    //From https://www.delftstack.com/howto/java/java-clear-console/ with some fixes
    public static void clearConsole(){
        try{
            String operatingSystem = System.getProperty("os.name"); //Check the current operating system

            if(operatingSystem.contains("Windows")){
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();

                startProcess.waitFor();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void setConsoleWindow(String columns, String lines, String color, String title) throws IOException, InterruptedException
    {
        String operatingSystem = System.getProperty("os.name"); //Check the current operating system
        String commands[] = {"mode con: cols="+ columns+ " lines=" + lines, "color " + color, "title " + title};


        for(String command : commands)
        {
            if (operatingSystem.contains("Windows"))
            {
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", command);
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            }
        }
    }
}
