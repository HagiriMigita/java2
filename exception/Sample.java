package exception;
class Sample
{
	public static void main( String[ ] args )
	{
		try
		{
			int[ ] x = new int[ 5 ];
			x[ 10 ] = 100;	// 例外発生
			System.out.println( "xの10番目の要素 = " + x[ 10 ] );
		}
		catch( ArrayIndexOutOfBoundsException e )
		{
			System.out.println( e + "が発生" );
		}
		System.out.println( "Hello World" );
	}
}
