
public interface Stack<T> {
	
	public void push(T item);
	public T pop() throws Exception;
	public T peek() throws Exception;
	public boolean empty();

}
