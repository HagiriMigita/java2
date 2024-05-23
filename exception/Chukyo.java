package exception;
import java.io.*;

class NotChukyoException extends Exception{}

class chukyo
{
    public static void main(String args[]) throws NotChukyoException, IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        System.out.printf("あなたの所属している大学は?:");
        input = br.readLine();

        if( !input.equals("Chukyo") )
        {
            throw (new NotChukyoException());
        }

        System.out.println(input);


    }
}