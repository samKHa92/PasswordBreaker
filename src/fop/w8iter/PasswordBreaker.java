package fop.w8iter;

import java.util.function.Function;

public class PasswordBreaker {

    public static String findPassword(Function<String, Integer> hashFunction, int passwordLength,
            String salt, int saltedPasswordHashValue) 
    {
        if(salt == null || hashFunction == null)
        	Util.badArgument("Salt and hash value, both should have non-empty values.");
        PasswordIterator iter = new PasswordIterator(passwordLength);
		while(iter.hasNext())
		{
			String pass = iter.next();
			String arg = pass + salt;
			if(hashFunction.apply(arg) == saltedPasswordHashValue)
				return pass;
		}
        return null;
    }

}
