
public class myBoundedQueue {
	
	private int size; //current size of the queue
	private int bound; //max size of the queue... its bounded size
	private int[] myQueue;
	private int head; //points to the index that is the current head
	
	public myBoundedQueue(int bound){
		this.bound=bound;
		myQueue=new int[this.bound];
		this.size=0;
		this.head=0;
	}
	/*
	 * If the queue id full, return false and don't enqueue e. Otherwise add the element
	 * e to the index that is one behind the head. This is equated by (size+head) % bound.
	 * Then increase the current size by 1.
	 */
	public boolean enqueue(int e){
		if(size==bound){
			return false;
		}
		else{
			myQueue[(size+head) % bound]=e;
			size++;
			return true;
		}
	}
	/*
	 * If the current size of the queue is 0, throw an out of bounds exception.
	 * Otherwise return the value at the head, increase the head by 1 (moded by the bound
	 * to wrap the head around if necessary), and decrease the current size of the queue by 1.
	 */
	public int dequeue(){
		if(size==0){
			throw new IndexOutOfBoundsException("Cannot dequeue an empty queue");
		}
		else{
			int toReturn=myQueue[head];
			head=(head+1)%bound;
			size--;
			return toReturn;
		}
	}

}
