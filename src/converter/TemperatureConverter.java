package converter;

import enums.TemperatureUnit;
import exception.ConversionException;

public class TemperatureConverter implements BaseConverter<TemperatureUnit> {
    @Override
    public double convert(double value, TemperatureUnit fromUnit, TemperatureUnit toUnit) throws ConversionException {
        if (fromUnit == null || toUnit == null) {
            throw new ConversionException("Invalid units provided for temperature conversion.");
        }

        return switch (fromUnit) {
            case CELSIUS -> switch (toUnit) {
                case FAHRENHEIT -> value * 9 / 5 + 32;
                case KELVIN -> value + 273.15;
                case CELSIUS -> value;
                default -> throw new ConversionException("Unsupported conversion from Celsius");
            };
            case FAHRENHEIT -> switch (toUnit) {
                case CELSIUS -> (value - 32) * 5 / 9;
                case KELVIN -> (value - 32) * 5 / 9 + 273.15;
                case FAHRENHEIT -> value;
                default -> throw new ConversionException("Unsupported conversion from Fahrenheit");
            };
            case KELVIN -> switch (toUnit) {
                case CELSIUS -> value - 273.15;
                case FAHRENHEIT -> (value - 273.15) * 9 / 5 + 32;
                case KELVIN -> value;
                default -> throw new ConversionException("Unsupported conversion from Kelvin");
            };
            default -> throw new ConversionException("Unsupported temperature unit");
        };
    }
}
