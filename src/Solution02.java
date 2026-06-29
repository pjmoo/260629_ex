public class Solution02 {
    public static void main(String[] args) {

    }
}

class SyncCounter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }
}