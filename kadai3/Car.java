class Car
{
	int number;
	int fuel;
	static int sum = 0;

	Car( )
	{
		number = 0;
		fuel = 100;
		++sum;
	}

	Car( int n, int f )
	{
		number = n;
		fuel = f;
		++sum;
	}

	void show( )
	{
		System.out.println( "Number=" + number + ", Fuel=" + fuel );
	}

	static void showSum( )
	{
		System.out.println( "Total " + sum + " cars" );
	}
}