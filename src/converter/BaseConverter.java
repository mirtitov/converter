
package converter;

import exception.ConversionException;

public interface BaseConverter<T> {
    double convert(double value, T fromUnit, T toUnit) throws ConversionException;
}
