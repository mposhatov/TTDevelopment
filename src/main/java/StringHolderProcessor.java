public class StringHolderProcessor extends Thread {

    private StringHolder stringHolder;
    private Integer number;

    public StringHolderProcessor(StringHolder stringHolder, Integer number) {
        this.stringHolder = stringHolder;
        this.number = number;
    }

    @Override
    public void run() {
        while (true) {
            try {
                stringHolder.addSymbolsPackage(number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
