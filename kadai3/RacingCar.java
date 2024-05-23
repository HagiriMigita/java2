class RacingCar
{
	protected int number;
	protected int fuel;
	protected int teamNumber;
	int tireNumber;

	RacingCar( )
	{
		this.teamNumber = 0;
	}

	RacingCar( int n, int f )
	{
		this.number = n;
		this.fuel = f;
	}

	void showTeam()
	{
		System.out.println("TeamNumber =" + teamNumber );
	}

	void show( )
	{
		System.out.println( "Number=" + number + ", Fuel=" + fuel + ", TeamNumber=" + teamNumber);
	}

	public void setnumber(int a)
	{
		this.number = a;
	}

	public void setfuel(int a)
	{
		this.fuel = a;
	}

	public void setteamNunber(int a)
	{
		this.teamNumber = a;
	}

	public int getnumber()
	{
		return this.number;
	}

	public int getfuel()
	{
		return this.fuel;
	}

	public int getteamNumber()
	{
		return this.teamNumber;
	}


}