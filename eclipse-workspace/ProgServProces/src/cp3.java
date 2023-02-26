import java.io.IOException;

public class cp3 {
    public static void main(String[] args) {

        ProcessBuilder pb=new ProcessBuilder();

        for (String arg : args) {
            try{
                pb.command(arg);
                Process p=pb.start();
                System.out.println("Lanzado el comando "+arg+" con PID "+p.pid()+" en "+p.info().startInstant().toString());
            } catch (IOException e){
                System.out.println("Error de E/S: "+e.getMessage());
            }
        }
    }
}
