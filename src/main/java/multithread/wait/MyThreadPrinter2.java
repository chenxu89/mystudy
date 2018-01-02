/** 
 * wait用法 
 * @author DreamSea  
 * @time 2015.3.9  
 */
package multithread.wait;

public class MyThreadPrinter2 implements Runnable {

	private String name;
	private Object prev;
	private Object self;

	private MyThreadPrinter2(String name, Object prev, Object self) {
		this.name = name;
		this.prev = prev;
		this.self = self;
	}

	@Override
	public void run() {
		int count = 10;
		while (count > 0) {
			synchronized (prev) {
				synchronized (self) {
					System.out.print(name);
					count--;
					
					self.notify();
				}
				try {
					prev.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
	}

	public static void main(String[] args) throws Exception {
		// 线程数可以任意增加，多少个线程就有多少把锁，每个线程需要传入两把锁才能执行，
		// 自己的锁和上一个线程的锁，自己的锁用来唤醒下一个等待的线程，而上个线程的锁，用来让本线程进入等待状态
		Object a = new Object();
		Object b = new Object();
		Object c = new Object();
		Object d = new Object();
		MyThreadPrinter2 pa = new MyThreadPrinter2("A", d, a);
		MyThreadPrinter2 pb = new MyThreadPrinter2("B", a, b);
		MyThreadPrinter2 pc = new MyThreadPrinter2("C", b, c);
		MyThreadPrinter2 pd = new MyThreadPrinter2("D", c, d);

		new Thread(pa).start();
		Thread.sleep(100); // 确保按顺序A、B、C执行
		new Thread(pb).start();
		Thread.sleep(100);
		new Thread(pc).start();
		Thread.sleep(100);
		new Thread(pd).start();
		Thread.sleep(100);
	}
}
