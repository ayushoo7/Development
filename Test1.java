package barclays;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Test1 {

	public static void main(String[] args) {
		Test1 t1 = new Test1();

		Queue<String> que = new LinkedList<String>();

		Stack<String> stk = new Stack<>();

		Method[] privateStringMethod = Test1.class.getDeclaredMethods();

		Arrays.sort(privateStringMethod, new Comparator<Method>() {
			@Override
			public int compare(Method o1, Method o2) {
				Order or1 = o1.getAnnotation(Order.class);
				Order or2 = o2.getAnnotation(Order.class);
				// nulls last
				if (or1 != null && or2 != null) {
					return or1.value() - or2.value();
				} else if (or1 != null && or2 == null) {
					return -1;
				} else if (or1 == null && or2 != null) {
					return 1;
				}
				return o1.getName().compareTo(o2.getName());
			}
		});

		for (Method method : privateStringMethod) {
			method.setAccessible(true);
			try {
				if (method.getName().contains("test")) {

					que.add(method.getName());

				}
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (String method : que) {

			try {
				@SuppressWarnings("rawtypes")
				Class[] cArg = new Class[1];
		         cArg[0] = Boolean.class;
				Method method1 = Test1.class.getDeclaredMethod(method, cArg);
				method1.setAccessible(true);
				Boolean b1 = (Boolean) method1.invoke(t1, true);
				if(b1) {
					stk.push(method);
					System.out.println(b1);
				}else {
					
					break;
				}
			} catch (NoSuchMethodException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SecurityException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if(!stk.isEmpty()) {
			while(!stk.isEmpty()) {
				String method = stk.pop();
				try {
					@SuppressWarnings("rawtypes")
					Class[] cArg = new Class[1];
			         cArg[0] = Boolean.class;
					Method method1 = Test1.class.getDeclaredMethod(method, cArg);
					method1.setAccessible(true);
					Boolean b1 = (Boolean) method1.invoke(t1, false);
				} catch (NoSuchMethodException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SecurityException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}

	}

	@Order(value = 1)
	private Boolean test1(Boolean arg) {
		System.out.println(arg +"test1");
		return arg;
	}

	@Order(value = 2)
	private Boolean test2(Boolean arg) {
		System.out.println(arg +"test2");
		return arg;
	}

	@Order(value = 3)
	private Boolean test3(Boolean arg) {
		System.out.println(arg +"test3");
		return arg;
	}
	
	@Order(value = 4)
	private Boolean test4(Boolean arg) {
		System.out.println(arg +"test4");
		return arg;
	}

	
	@Order(value = 5)
	private Boolean test5(Boolean arg) {
		System.out.println(arg +"test5");
		return false;
	}


	@Retention(RetentionPolicy.RUNTIME)
	public @interface Order {
		int value();
	}

}
