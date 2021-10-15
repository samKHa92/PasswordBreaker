package fop.w8iter;

import java.util.ArrayList;
import java.util.Iterator;

public class Range implements Iterable<Integer>
{
	private final int begin;
	private final int end;
	private final int stride;
	
	private static int currentValue;
	
	public Range(int begin, int end, int stride)
	{
		this.begin = begin;
		this.end = end;
		this.stride = stride;
		currentValue = begin;
		if(stride <= 0)
			Util.badArgument("Stride should be positive.");
	}
	
	public Range(int begin, int end)
	{
		this.begin = begin;
		this.end = end;
		this.stride = 1;
	}
	
	public Iterator<Integer> iterator()
	{
		ArrayList <Integer> list = new ArrayList<>();
		Iterator<Integer> iter = null;
		list.add(this.begin);
		while(this.hasNext())
			list.add(this.next());
		iter = list.iterator();
		return iter;
	}
	
	public Integer next() 
	{
		int ret = 0;
	    if(hasNext() == false) 
	      Util.noSuchElement("There is no more elements.");
	    if(begin < end)
	    {
	    	ret = currentValue + this.stride;
	    	currentValue += this.stride;
	    }
	    if(begin > end)
	    {
	    	ret = currentValue - this.stride;
	    	currentValue -= this.stride;
	    }
	    return Integer.valueOf(ret);
	}
	
	public boolean hasNext()
	{
		if(begin < end)
			if(currentValue + stride <= this.end) 
				return true;
		if (begin > end)
			if(currentValue - stride >= this.end) 
				return true;
		return false;
	}
}
