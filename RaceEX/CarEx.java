class CarEx
{
    private int mileage;
    private int fuel;

    CarEx()
    {
        mileage = 0;
        fuel = 10;
    }

    public int getFuel()
    {
        return fuel;
    }

    public int getMileage()
    {
        return mileage;
    }

    public void goForward()
    {
        if( mileage + 2 <= 20 && fuel -1 >= 0)
        {
            mileage += 2;
            fuel--;
            System.out.println("mileage :" + mileage + "," + "fuel" + fuel); 
        }
    }

    public void turn()
    {
        if( mileage + 1 <= 20 && fuel - 2 >= 0)
        {
            mileage++;
            fuel -= 2;
            System.out.println("mileage :" + mileage + "," + "fuel" + fuel); 
        }
    }

    public void refuel()
    {
        fuel = 10;
        System.out.println("mileage :" + mileage + "," + "fuel" + fuel); 
    }

}


