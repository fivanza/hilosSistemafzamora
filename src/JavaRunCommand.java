import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
 
public class JavaRunCommand {
	
	private static boolean run;
 
    public static void main(String args[]) {
 
    	run= true;
		while(run)
		{
        //String s = null;
        
        String st="";
        
        LinkedList<String> lista= new LinkedList<>();
		LinkedList<Runnable> listaT= new LinkedList<>();
        
        Scanner in = new Scanner(System.in);
        System.out.println(">");
        st = in.nextLine();
        
        if(st.equals("exit"))
        {
        	run=false;
        	System.exit(0);
        }
        else
        {
        	
        	//separa los comandos
  	      
  	      //lista de separa comandos
  	      String[] parts=st.split("\\^");
  	      //System.out.println(parts.length);
  	  lista.addAll( Arrays.asList(parts));
  	  System.out.println(lista.toString());
  	  
  	  
  	for(int i=0; i<lista.size();i++)
	  {
  		ComandThread task= new ComandThread(lista.get(i));
  		listaT.add(task);
	  }
  	  
  	 //ComandThread task= new ComandThread(parts[0]);
	 // listaT.add(task);
	  
	  for(Runnable i : listaT)
		{
			
			Thread th= new Thread(i);
			th.start();
			try{
			th.join();
			}
			catch (InterruptedException iox) {
              throw new RuntimeException(iox);
          }
		}
        	/*try {
             
        			// run the Unix "ps -ef" command
        		// using the Runtime exec method:
        		Process p = Runtime.getRuntime().exec(st);
             
        		BufferedReader stdInput = new BufferedReader(new
        				InputStreamReader(p.getInputStream()));
 
        		BufferedReader stdError = new BufferedReader(new
        				InputStreamReader(p.getErrorStream()));
 
        		// read the output from the command
        		System.out.println("Here is the standard output of the command:\n");
        			while ((s = stdInput.readLine()) != null) {
        				System.out.println(s);
        			}
             
            // read any errors from the attempted command
        			System.out.println("Here is the standard error of the command (if any):\n");
        			while ((s = stdError.readLine()) != null) {
        				System.out.println(s);
        			}
             
        			//System.exit(0);
        	}
        	catch (IOException e) {
        		System.out.println("exception happened - here's what I know: ");
        		e.printStackTrace();
        		System.exit(-1);
        	}*/
        }
	  }
    }
}