package fop.w8iter;

import java.util.Iterator;

public class PasswordIterator implements Iterator<String> 
{
	private final int passwordLength;
	private static int operationNumber = 0;
	private static int indexer0 = 0;
	private static int indexer1 = 0;
	private static int indexer2 = 0;
	private static int indexer3 = 0;
	private static int index = 0;
    public PasswordIterator(int passwordLength) 
    {
    	this.passwordLength = passwordLength;
    	if(passwordLength < 1 || passwordLength > 9)
    		Util.badArgument("Password length is not appropriate");
    }

    public boolean hasNext() 
    {
        if(operationNumber >= Math.pow(10, this.passwordLength))
        	return false;
        return true;
    }

    public String next() 
    {
    	boolean firstPriorityPassed = false;
    	boolean secondPriorityPassed = false;
    	boolean thirdPriorityPassed = false;
    	if(this.hasNext() == false)
    		Util.noSuchElement("No more options.");
    	String ret = null;
    	String [] alreadyTyped = new String [(int) Math.pow(10, this.passwordLength)];
    	if(firstPriorityPassed == false)
    	{
    		if(indexer0 < 10)
    			ret += (char)operationNumber;
    		indexer0++;
    		alreadyTyped[index] = ret;
    		index++;
    		if(indexer0 == 9)
    			firstPriorityPassed = true;
    		operationNumber++;
    		return ret;
    	}
    	
    	else if (secondPriorityPassed == false)
    	{
    		if(indexer1 < (11 - this.passwordLength))
    		{
    			for(int j = 0, startSymbol = indexer1; j < this.passwordLength; j++, startSymbol++)
    				ret += (char)startSymbol;
    			alreadyTyped[index] = ret;
        		index++;
    			indexer1++;
    		}
    		if(indexer1 == 10 - this.passwordLength)
    			secondPriorityPassed = true;
    		operationNumber++;
    		return ret;
    	}
    	
    	else if (thirdPriorityPassed == false)
    	{
    		if(indexer2 < (11 - this.passwordLength))
    		{
    			for(int j = 0, startSymbol = this.passwordLength + indexer2 - 1; j < this.passwordLength; j++, startSymbol--)
    				ret += (char)startSymbol;
    			alreadyTyped[index] = ret;
        		index++;
    			indexer2++;
    		}
    		if(indexer2 == 10 - this.passwordLength)
    			thirdPriorityPassed = true;
    		operationNumber++;
    		return ret;
    	}
    	
    	else
    	{
 
   			boolean alreadyTypedChecker = false;
   			for(int j = 0; j < alreadyTyped.length; j++)
   				if(alreadyTyped[j].equals(Util.longToStringWithLength(indexer3, this.passwordLength)))
    			{
    				alreadyTypedChecker = true;
    				break;
    			}    			
   			if(alreadyTypedChecker == false)
   				ret = Util.longToStringWithLength(indexer3, this.passwordLength);
   			indexer3++;
   			if(alreadyTypedChecker == true)
   			{
   				operationNumber++;
    			return this.next();
   			}
   			operationNumber++;
    		return ret;
    		
    	}
    }

}
