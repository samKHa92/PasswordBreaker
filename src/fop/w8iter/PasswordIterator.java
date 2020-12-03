package fop.w8iter;

import java.util.Iterator;

public class PasswordIterator implements Iterator<String> 
{

    public PasswordIterator(int passwordLength) 
    {
    	if(passwordLength < 1 || passwordLength > 9)
    		Util.badArgument("Password length is not appropriate");
    }

    public boolean hasNext() 
    {
        return (this.next() != null);
    }

    public String next() 
    {
    	if(this.hasNext())
    		return this.next();
    	return null;
    }

}
