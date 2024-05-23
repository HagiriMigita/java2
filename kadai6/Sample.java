package kadai6;
import java.io.*;
class Counter
{
    private static int count = 0;
    public static synchronized void add()
    {
        try
        {
            int temp = count;
            Thread.sleep(1000);
            count = temp + 1;
        }
        catch( InterruptedException e){ } 
    }
    public static int getCount()
    {
        return count;
    }
}

class Worker extends Thread
{
    public void run()
    {
        System.out.println("adding…(1sec sleep)");
        Counter.add();
        System.out.println("Count =" + Counter.getCount());
    }
}

class Sample 
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";

        while(true)
        {
            System.out.print("Press Enter:");
            input = br.readLine();
            if(input.equals(""))
            {
                Worker worker = new Worker();
                worker.start();
                try
                {
                    Thread.sleep(1000);
                }
                catch( InterruptedException e)
                {

                }
            }
        } 
    }
}