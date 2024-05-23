package Thread;
class Wallet
{
    public int money = 0;
    public void add( int m)
    {
        int temp = money;
        System.out.println(temp);
        money = temp + m;
        System.out.println(money);
    }
}