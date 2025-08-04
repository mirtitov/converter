package converter;

import enums.WeightUnit;
import exception.ConversionException;

public class WeightConverter implements BaseConverter<WeightUnit> {
    @Override
    public double convert(double value, WeightUnit fromUnit, WeightUnit toUnit) throws ConversionException {
        if (fromUnit == null || toUnit == null) {
            throw new ConversionException("Invalid units provided for weight conversion.");
        }
        return value * fromUnit.getFactor() / toUnit.getFactor();
    }
}