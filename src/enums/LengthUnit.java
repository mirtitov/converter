package enums;

public enum LengthUnit {
    METER(1), KILOMETER(1000), MILE(1609.34);
    private final double factor;

    LengthUnit(double factor) {
        this.factor = factor;
    }

    public double getFactor() {
        return factor;
    }
}
