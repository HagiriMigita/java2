package Thread;
class sample
{
    public static void main(String args[])
    {
        Wallet saihu = new Wallet();
        Robot r1 = new Robot( saihu );
        Robot r2 = new Robot( saihu );

        r1.start();
        r2.start();

        try
        {
            r1.join();
            r2.join();
        }
        catch( InterruptedException e ){}
        System.out.println("残高" + saihu.money);
    }
}