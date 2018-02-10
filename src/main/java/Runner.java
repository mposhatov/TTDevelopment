public class Runner  {

    private final static StringHolder stringHolder = new StringHolder();

    public static void main(String[] args) {
        new StringHolderProcessor(stringHolder, 1).start();
        new StringHolderProcessor(stringHolder, 2).start();
    }
}
