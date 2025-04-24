public class Main {
    private final static int threadCount = Runtime.getRuntime().availableProcessors();
    private final static int length = 1000000000;
    public static void main(String[] args) {
        ArrayClass arrayClass = new ArrayClass(length, threadCount);
        int minElement = arrayClass.threadMin();

        System.out.println("minElement = " + minElement);
    }
}