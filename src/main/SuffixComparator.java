package main;

import java.util.Comparator;

public class SuffixComparator implements Comparator<Integer>{

	private String text;
	public SuffixComparator( String text)
	{
		this.text = text;
	}
	
	@Override
	public int compare(Integer o1, Integer o2) {
		String suf1 = text.substring(o1);
		String suf2 = text.substring(o2);
		return suf1.compareToIgnoreCase(suf2)> 0 ? 1 : suf1.compareToIgnoreCase(suf2)< 0 ? -1 : 0;
	}
}
