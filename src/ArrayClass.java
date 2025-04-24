import java.util.Random;

public class ArrayClass {
    private final int length;
    private final int threadCount;
    public final int[] array;

    private int minValue = Integer.MAX_VALUE;
    private int threadCompleted = 0;

    public ArrayClass(int length, int threadCount) {
        this.length = length;
        this.threadCount = threadCount;

        Random random = new Random();
        array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt();
        }
    }

    synchronized public void collectMin(int value) {
        if (value < minValue) {
            minValue = value;
        }
    }

    synchronized void increaseThreadCount() {
        threadCompleted++;
        notify();
    }

    synchronized private int getCompletedThreadCount() {
        return threadCompleted;
    }

    synchronized private int waitForThreads() {
        while (getCompletedThreadCount() < threadCount) {
            try{
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return minValue;
    }

    public int threadMin(){
        MinThread[] threads = new MinThread[threadCount];
        int chunk = (int)Math.ceil(length / (double)threadCount);

        for (int i = 0; i < threadCount; i++) {
            int start = i * chunk;
            int end = Math.min(start + chunk, length);

            threads[i] = new MinThread(start, end, this);
            threads[i].start();
        }

        return waitForThreads();
    }
}
