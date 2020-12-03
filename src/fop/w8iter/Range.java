package fop.w8iter;

import java.util.ArrayList;
import java.util.Iterator;

public class Range implements Iterable<Integer>
{
	private final int begin;
	private final int end;
	private final int stride;
	
	private static int nextValue;
	
	public Range(int begin, int end, int stride)
	{
		this.begin = begin;
		this.end = end;
		this.stride = stride;
		nextValue = begin;
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
		if(end > begin)
		{
			for(int i = this.begin; (i+stride) <= this.end; i += stride)
				list.add(i);
			iter = list.iterator();
		}
		else if(begin > end)
		{
			for(int i = this.end; (i-stride) >= this.begin; i -= stride)
				list.add(i);
			iter = list.iterator();
		}
		else 
		{
			list.add(this.begin);
			iter = list.iterator();
		}
		
		return iter;
	}
	
	public Integer next() 
	{
	    if(hasNext() == false) 
	      Util.noSuchElement("There is no more elements.");
	    int ret = nextValue + this.stride;
	    nextValue += this.stride;
	    return Integer.valueOf(ret);
	}
	
	public boolean hasNext()
	{
		if(this.next() <= this.end) 
			return true;
		return false;
	}
	
	
}
