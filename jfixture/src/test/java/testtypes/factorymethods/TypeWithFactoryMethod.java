package testtypes.factorymethods;

public class TypeWithFactoryMethod {

    private final String symbol;
    private final int size;

    private TypeWithFactoryMethod(String symbol, int size) {
        this.symbol = symbol;
        this.size = size;
    }

    public static TypeWithFactoryMethod create(String symbol) {
        return new TypeWithFactoryMethod(symbol, 0);
    }

    public static TypeWithFactoryMethod create(String symbol, int size) {
        return new TypeWithFactoryMethod(symbol, size);
    }

    public static TypeWithFactoryMethod create(int size, String symbol) {
        // different logic (+1) for overload, so it's detectable which one was called
        return new TypeWithFactoryMethod(symbol, size + 1);
    }

    // Not factory method because it's not static
    public TypeWithFactoryMethod create(String symbol, double size) {
        return new TypeWithFactoryMethod(symbol, (int)size);
    }

    public String getSymbol() {
        return symbol;
    }

    public int getSize() {
        return size;
    }
}
