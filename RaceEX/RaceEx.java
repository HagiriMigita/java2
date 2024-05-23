import java.io.*;
import java.util.Random;

class RaceEx {
    public static void main(String args[]) throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long startTime = System.currentTimeMillis();
        String input ="";
        CarEx carEx = new CarEx();
        
        while (carEx.getMileage() < 20) 
        {
            char[] randomWay = "wrl".toCharArray();
            Random random = new Random();
            char randomAlphabet = randomWay[random.nextInt(randomWay.length)];

            switch (randomAlphabet) 
            {
                case 'w':
                    System.out.println("前進してください");
                    break;
                case 'r':
                    System.out.println("右旋回してください");
                    break;
                case 'l':
                    System.out.println("左旋回してください");
                    break;
            }


            while (true)
            {
                System.out.print("Input: ");
                input = br.readLine(); //キー入力

                if (!String.valueOf(randomAlphabet).equals(input)) 
                {
                    System.out.println("再入力して下さい");
                } 
                else
                {
                    break;
                }
            }

            if (carEx.getFuel() <= 2) 
            {
                System.out.println("緊急給油します。");
                input = "f";
            }

            switch (input)
            {
                case "w":
                    carEx.goForward();
                    System.out.println("前進");
                    break;
                case "r":
                    carEx.turn();
                    System.out.println("右旋回");
                    break;
                case "l":
                    carEx.turn();
                    System.out.println("左旋回");
                    break;
                case "f":
                    carEx.refuel();
                    System.out.println("給油");
                    break;
                default:
                    System.out.println("?");
                    break;
            }
        }
        long endTime = System.currentTimeMillis();
        long pastTime = endTime - startTime;
        System.out.println("経過時間" + pastTime / 1000.0 + "秒");
    }
}
