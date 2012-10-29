import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class myBoundedQueueTest {

	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void simpleEnqueueDequeueTest() {
		myBoundedQueue test=new myBoundedQueue(2);
		test.enqueue(1);
		test.enqueue(2);
		assertTrue(test.dequeue()==1);
		assertTrue(test.dequeue()==2);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void dequeueEmptyQueueTest() {
		myBoundedQueue test=new myBoundedQueue(2);
		test.enqueue(1);
		test.enqueue(2);
		test.dequeue();
		test.dequeue();
		test.dequeue();
	}

	@Test
	public void tryToEnqueueFullQueueTest() {
		myBoundedQueue test=new myBoundedQueue(2);
		test.enqueue(1);
		test.enqueue(2);
		assertFalse(test.enqueue(3));
	}
	
	@Test
	public void wrapAroundTest() {
		myBoundedQueue test= new myBoundedQueue(5);
		test.enqueue(1);
		test.enqueue(2);
		test.dequeue();
		test.dequeue();
		test.enqueue(3);
		test.enqueue(4);
		test.enqueue(5);
		test.enqueue(6);
		test.enqueue(7);
		assertTrue(test.dequeue()==3);
		assertTrue(test.dequeue()==4);
		assertTrue(test.dequeue()==5);
		assertTrue(test.dequeue()==6);
		assertTrue(test.dequeue()==7);
	}
	
	
}
