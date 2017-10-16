package com.joham.base;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个线程打印ABCABCABC
 */
public class TestPrint {
    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();
    private String threadPrintName = "A";

    class A implements Runnable {
        @Override
        public void run() {
            try {
                lock.lock();
                for (int i = 0; i < 3; i++) {
                    while (!Thread.currentThread().getName()
                            .equals(threadPrintName)) {
                        conditionA.await();
                    }
                    System.out.print(Thread.currentThread().getName());
                    threadPrintName = "B";
                    conditionB.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }

    class B implements Runnable {
        @Override
        public void run() {
            try {
                lock.lock();
                for (int i = 0; i < 3; i++) {
                    while (!Thread.currentThread().getName()
                            .equals(threadPrintName)) {
                        conditionB.await();
                    }
                    System.out.print(Thread.currentThread().getName());
                    threadPrintName = "C";
                    conditionC.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    class C implements Runnable {
        @Override
        public void run() {
            try {
                lock.lock();
                for (int i = 0; i < 3; i++) {
                    while (!Thread.currentThread().getName()
                            .equals(threadPrintName)) {
                        conditionC.await();
                    }
                    System.out.print(Thread.currentThread().getName());
                    threadPrintName = "A";
                    conditionA.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        TestPrint tt = new TestPrint();
        Thread t1 = new Thread(tt.new A());
        Thread t2 = new Thread(tt.new B());
        Thread t3 = new Thread(tt.new C());
        t1.setName("A");
        t2.setName("B");
        t3.setName("C");
        t1.start();
        t2.start();
        t3.start();
    }
}
