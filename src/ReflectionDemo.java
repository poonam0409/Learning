import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.poonam.XYZ;

class A{
	public void check()
	{System.out.println("inside check");}
}

public class ReflectionDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Class c = Class.forName("com.poonam.XYZ");
		
		XYZ x= (XYZ) c.newInstance();
		
		Method m= c.getDeclaredMethod("show", null);
		m.setAccessible(true);
		m.invoke(x, null);
		
		

	}

}
