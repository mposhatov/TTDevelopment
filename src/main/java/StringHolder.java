public class StringHolder {

    private final int SYMBOLS_PACKAGE_SIZE = 10;

    private StringBuffer stringBuffer = new StringBuffer();

    public synchronized void addSymbolsPackage(int number) throws InterruptedException {
        for (int i = 0; i < SYMBOLS_PACKAGE_SIZE; ++i) {
            stringBuffer.append(number);
            Thread.sleep(100);
        }
        notifyAll();
        wait();
    }

    public void clear() {
        stringBuffer.setLength(0);
    }

    public String getString() {
        return stringBuffer.toString();
    }
}
