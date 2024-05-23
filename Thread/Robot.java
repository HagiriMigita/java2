package Thread;
class Robot extends Thread
{
    public Wallet wallet;
    public Robot( Wallet w )
    {
        wallet = w;
    } 

    public void run()
    {
        for(int i = 0; i < 100; i++)
        {
            wallet.add( 50 );
        }
    }
}