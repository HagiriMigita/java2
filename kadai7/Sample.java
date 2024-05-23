package kadai7;
import java.io.*;

class Sample
{
    public static void main(String[] args)
    {
        String line;
        String result;
        double squared;
        double number;
        try
        {
            BufferedReader br = new BufferedReader( new FileReader("C:\\workspace\\java2\\kadai7\\input.txt"));
            BufferedWriter bw = new BufferedWriter( new FileWriter("C:\\workspace\\java2\\kadai7\\output.txt"));
            while((line = br.readLine()) != null)
            {
                number = Double.parseDouble(line);
                squared = Math.pow(number,2);
                result = String.valueOf(squared);
                bw.write(result);
                bw.newLine();
            }
            br.close();
            bw.close();
        }
        catch( IOException e)
        {
            System.out.println(e);
        }
    }

}