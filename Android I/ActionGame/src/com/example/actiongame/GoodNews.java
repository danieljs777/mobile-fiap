package com.example.actiongame;

import java.util.Random;

public class GoodNews implements Runnable
{

	@Override
	public void run()
	{
		try
		{
			Random randomGenerator = new Random( ) ;
			int rnd = 0 ;
			int threadNo = 0 ;

			while (i <= myMaxTics)
			{

				Thread.sleep( 1000 ) ;
				rnd = randomGenerator.nextInt( 4 ) ;
			}
		}
		
		
		
		
	}

}
