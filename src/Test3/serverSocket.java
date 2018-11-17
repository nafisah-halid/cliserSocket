package Test3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;


public class serverSocket {

   private static final long MEGABYTE = 1048576; //1024 x 1024 = 1048576
private static ServerSocket ser;

    public static long bytesToMegabytes(long memory) {
        return memory / MEGABYTE;
    }
    
    public static void main(String[] args) {
        
        try
        {
            ser = new ServerSocket(8080);
            Socket sock = ser.accept();
            
           BufferedReader ed = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            String tmp = ed.readLine();
            System.out.print("I Received :"+tmp);
            
      
       
              Runtime runtime = Runtime.getRuntime();
        // Run the garbage collector
        runtime.gc();
        // Calculate the used memory
        long memory = runtime.totalMemory() - runtime.freeMemory();
            PrintStream pr = new PrintStream(sock.getOutputStream());
            String str = "Memory used:"+memory+" bytes";
            pr.println(str);
           
            
    
       
        }catch(Exception ex){}
               
        
    
                    
            
    }
    
}