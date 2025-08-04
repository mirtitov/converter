package enums;

public enum WeightUnit {
    KILOGRAM(1), POUND(0.453592), OUNCE(0.0283495);
    private final double factor;

    WeightUnit(double factor) {
        this.factor = factor;
    }

    public double getFactor() {
        return factor;
    }
}
