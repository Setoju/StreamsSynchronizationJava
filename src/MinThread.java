public class MinThread extends Thread {
    private final int start;
    private final int end;
    private final ArrayClass arrayClass;

    public MinThread(int start, int end, ArrayClass arrayClass) {
        this.start = start;
        this.end = end;
        this.arrayClass = arrayClass;
    }

    @Override
    public void run() {
        int localMin = Integer.MAX_VALUE;

        for(int i = start; i < end; i++) {
            if(arrayClass.array[i] < localMin){
                localMin = arrayClass.array[i];
            }
        }

        arrayClass.collectMin(localMin);
        arrayClass.increaseThreadCount();
    }
}
