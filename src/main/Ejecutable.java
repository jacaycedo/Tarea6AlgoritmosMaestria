package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Ejecutable {

	public static void main( String args[])
	{
		String contenido = "";		
		try (BufferedReader br = new BufferedReader( new FileReader( new File(args[0]))))
		{
			String temp = "";
			while((temp = br.readLine()) != null )
			{
				contenido += temp;
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		ArrayList<String> cadenasABuscar = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader( new FileReader( new File(args[1]))))
		{
			String temp = "";
			while((temp = br.readLine()) != null )
			{
				cadenasABuscar.add(temp);
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		long ini = System.currentTimeMillis();
		ArregloSufijos suffixarray = new ArregloSufijos(contenido);
		suffixarray.lookForChains(cadenasABuscar);
		long fin = System.currentTimeMillis();
		System.out.println("Se tardo " + (fin-ini) + " ms en terminar el proceso.");
	}

}
