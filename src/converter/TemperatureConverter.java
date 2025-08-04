package converter;

import enums.TemperatureUnit;
import exception.ConversionException;

public class TemperatureConverter implements BaseConverter<TemperatureUnit> {
    @Override
    public double convert(double value, TemperatureUnit fromUnit, TemperatureUnit toUnit) throws ConversionException {
        if (fromUnit == null || toUnit == null) {
            throw new ConversionException("Invalid units provided for temperature conversion.");
        }
        if (fromUnit == TemperatureUnit.CELSIUS && toUnit == TemperatureUnit.FAHRENHEIT) {
            return value * 9 / 5 + 32;
        } else if (fromUnit == TemperatureUnit.CELSIUS && toUnit == TemperatureUnit.KELVIN) {
            return value + 273.15;
        } else if (fromUnit == TemperatureUnit.FAHRENHEIT && toUnit == TemperatureUnit.CELSIUS) {
            return (value - 32) * 5 / 9;
        } else if (fromUnit == TemperatureUnit.FAHRENHEIT && toUnit == TemperatureUnit.KELVIN) {
            return (value - 32) * 5 / 9 + 273.15;
        } else if (fromUnit == TemperatureUnit.KELVIN && toUnit == TemperatureUnit.CELSIUS) {
            return value - 273.15;
        } else if (fromUnit == TemperatureUnit.KELVIN && toUnit == TemperatureUnit.FAHRENHEIT) {
            return (value - 273.15) * 9 / 5 + 32;
        } else {
            throw new ConversionException("Unsupported temperature conversion.");
        }
    }
}
