package exception;
import java.io.*;
class posException
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        int pos = 0;
        try
        {
            System.out.printf("Input to str:");
            str = br.readLine();
            System.out.printf("Input to pos:");
            pos = Integer.parseInt(br.readLine());

            if( 0 <= pos && pos <= str.length())
            {
                System.out.println(str.charAt(pos));
            }
            
        }
        catch(StringIndexOutOfBoundsException e)
        {
            System.out.println( e + "が発生");
        }
        catch(NumberFormatException e)
        {
            System.out.println( e + "が発生");
        }

        System.out.println("Hello World");
        
       
    }
}