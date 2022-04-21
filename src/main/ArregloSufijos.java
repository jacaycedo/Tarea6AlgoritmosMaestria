package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ArregloSufijos {

	private String realText;
	private int length;
	private ArrayList<Integer> suffix;

	public ArregloSufijos(String enterText)
	{
		this.realText = enterText;
		this.length = enterText.length();
		this.suffix = new ArrayList<Integer>();
		for (int i = 0; i < length; i++)
		{
			suffix.add(i);
		}
		orderArray(suffix);
	}

	public void orderArray(ArrayList<Integer> suffix)
	{
		Collections.sort(suffix, new Comparator<Integer>() 
		{
			@Override
			public int compare(Integer o1, Integer o2) {
				String suf1 = realText.substring(o1);
				String suf2 = realText.substring(o2);
				return suf1.compareToIgnoreCase(suf2)> 0 ? 1 : suf1.compareToIgnoreCase(suf2)< 0 ? -1 : 0;
			}
		});

	}

	public int busquedaBinaria(ArrayList<Integer> arr, String buscado)
	{

		int floor = 0;
		int roof = arr.size() - 1;
		int searchedIndex;
		while (floor <= roof) 
		{
			searchedIndex = (roof + floor) / 2;
			String subtext = realText.substring(suffix.get(searchedIndex));
			if ( subtext.compareTo(buscado) == 0 )
				return searchedIndex;
			else if ( subtext.compareTo(buscado) < 0 ) 
			{	
				floor = searchedIndex+1;
			} 
			else
			{
				roof = searchedIndex-1;
			}
		}
		return (floor*-1)-1;
	}

	public void lookForChains(ArrayList<String> arr)
	{
		System.out.println("INDICE DE CADENAS INDICADAS");
		for (int i = 0; i < arr.size(); i++)
		{
			String buscada = arr.get(i);
			ArrayList<Integer> apariciones = new ArrayList<Integer>();
			int indiceCadena = busquedaBinaria(suffix, buscada);
			int nuevoIndice;
			if(indiceCadena >= 0)
			{
				nuevoIndice = indiceCadena;
			}
			else
			{
				nuevoIndice = indiceCadena == -1? 1 : ((indiceCadena * -1) - 1);
			}
			int indiceArriba = nuevoIndice;
			int indiceAbajo = nuevoIndice + 1;
			boolean validoArriba = true;
			boolean validoAbajo = true;
			while(validoArriba && indiceArriba >= 0)
			{	
				String subtext = realText.substring(suffix.get(indiceArriba));
				if(subtext.compareTo(buscada) < 0)
				{
					validoArriba = false;
				}
				else if(subtext.startsWith(buscada)) 
				{
					apariciones.add(suffix.get(indiceArriba));
					indiceArriba--;
				}
				else 
				{
					validoArriba = false;
				}
			}
			while(validoAbajo && indiceAbajo < suffix.size())
			{	
				String subtext = realText.substring(suffix.get(indiceAbajo));
				if(subtext.compareToIgnoreCase(buscada) < 0)
				{
					validoAbajo = false;
				}
				else if(subtext.startsWith(buscada)) 
				{
					apariciones.add(suffix.get(indiceAbajo));
					indiceAbajo++;
				}
				else
				{
					validoAbajo = false;
				}
			}
			String impr = buscada + "\t";
			Collections.sort(apariciones);
			for(int j = 0; j < apariciones.size() ; j++)
			{
				if(j == apariciones.size()-1)
				{
					impr += apariciones.get(j);
				}
				else
				{
					impr += apariciones.get(j) + "\t";
				}
			}
			System.out.println(impr);
			
		}
	}

	/*
	 * public String[] getText() { return text; }
	 * 
	 * public int getLength() { return length; }
	 * 
	 * public int[] getIndex() { return index; }
	 * 
	 * public String[] getSuffix() { return suffix; }
	 */
}
