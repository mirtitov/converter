package enums;

public enum TemperatureUnit {
    CELSIUS(0), FAHRENHEIT(32), KELVIN(273.15);
    private final double offset;

    TemperatureUnit(double offset) {
        this.offset = offset;
    }

    public double getOffset() {
        return offset;
    }


    }
