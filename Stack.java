public class Stack{
	public static final int SIZE = 1000;
	public Object[] array;
	public int ctr = 0;
	public Stack(){
		this.array = new Object[SIZE];
	}
	public void addToStack(Object o){
		array[ctr] = o;
		ctr++;
	}
	public Object popFromStack(){
		Object r = array[ctr-1];
		array[ctr-1] = null;
		ctr--;
		return r;
	}

}