import java.util.concurrent.locks.ReentrantLock;

class Syncvariable {
	ReentrantLock lock = new ReentrantLock();
	volatile int count=0;

	public void increment() throws IllegalArgumentException {

		// l.lock();
		// count++;
		if (lock.tryLock()) {
			count++;
			System.out.println("count value "+count);
			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}

		else {
			System.out.println("Does not get lock");
		}

	}

}

// class Thread2 implements Runnable {
// @Override
// public void run() {
//
// for (int i = 65; i < 75; i++) {
// System.out.println((char) i);
// try {
// Thread.sleep(2000);
// } catch (InterruptedException e) {
// // TODO Auto-generated catch block
// e.printStackTrace();
// }
// }
//
// }
// }

public class MyThread {
	public static void main(String... strings) throws InterruptedException {
		// Thread1 t1 = new Thread1();
		// Thread2 t2 = new Thread2();
		// Thread t3 = new Thread(t1);
		// Thread t4 = new Thread(t2);
		// // t1.start();
		// // t2.join();
		// t3.start();
		// System.out.println("end556");
		// t4.start();
		// System.out.println("end");
		// System.out.println("end2");
		// System.out.println("end3");
		// // t1.run();
		// // t2.run();

		System.out.println(Thread.currentThread().getThreadGroup().getName());
		Syncvariable sync = new Syncvariable();
		// ReentrantLock l = new ReentrantLock();
		// l.lock();
		// l.lock();
		// System.out.println(l.getHoldCount());
		// System.out.println(l.isLocked());
		// System.out.println(l.getQueueLength());
		// l.unlock();
		// System.out.println(l.getHoldCount());
		// System.out.println(l.isFair());
		// System.out.println(l.isHeldByCurrentThread());
		// l.unlock();
		// System.out.println(l.getHoldCount());
		Runnable r1 = () -> {
			for (int i = 0; i < 10; i++) {
				sync.increment();
				System.out.println("In r1 " + sync.count);
				// // System.out.println(i);
				// try {
				// Thread.sleep(4000);
				// } catch (InterruptedException e) {
				// e.printStackTrace();
				// }
			}
		};

		Runnable r2 = () -> {
			for (int i = 65; i < 75; i++) {
				// System.out.println((char)i);
				sync.increment();
				System.out.println("In r2 " + sync.count);
				// try {
				// Thread.sleep(4000);
				// } catch (InterruptedException e) {
				// // TODO Auto-generated catch block
				// e.printStackTrace();
				// }

			}

		};

		Runnable r3 = () -> {
			for (int i = 65; i < 75; i++) {
				// System.out.println((char)i);
				sync.increment();
				System.out.println("In r3 " + sync.count);
				// try {
				// Thread.sleep(4000);
				// } catch (InterruptedException e) {
				// // TODO Auto-generated catch block
				// e.printStackTrace();
				// }

			}

		};

		Thread t3 = new Thread(r1);
		Thread t4 = new Thread(r2);
		Thread t5 = new Thread(r3);
		// t1.start();
		// t2.join();
		t3.start();
		t4.start();
		t5.start();
		// t3.join();
		System.out.println(sync.count);
		System.out.println("end");
		System.out.println("end2");
		System.out.println("end3");
	}

}
