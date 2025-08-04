package main;

import converter.BaseConverter;
import converter.LengthConverter;
import converter.TemperatureConverter;
import converter.WeightConverter;
import enums.LengthUnit;
import enums.TemperatureUnit;
import enums.WeightUnit;

import java.util.Scanner;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            if (parts.length != 4) {
                System.err.println("Ошибка: неверный формат ввода.");
                continue;
            }
            try {
                double value = Double.parseDouble(parts[1]);
                String category = parts[0];
                String fromUnitStr = parts[2].toUpperCase();
                String toUnitStr = parts[3].toUpperCase();

                switch (category) {
                    case "length":
                        convertLength(value, fromUnitStr, toUnitStr);
                        break;
                    case "temperature":
                        convertTemperature(value, fromUnitStr, toUnitStr);
                        break;
                    case "weight":
                        convertWeight(value, fromUnitStr, toUnitStr);
                        break;
                    default:
                        System.err.println("Ошибка: неизвестная категория '" + category + "'");
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.err.println("Ошибка: " + e.getMessage());
            }
        }
    }

    private static void convertLength(double value, String fromUnitStr, String toUnitStr) {
        LengthConverter converter = new LengthConverter();
        LengthUnit fromUnit = LengthUnit.valueOf(fromUnitStr);
        LengthUnit toUnit = LengthUnit.valueOf(toUnitStr);
        System.out.printf("%.2f %s = %.2f %s%n", value, fromUnit, converter.convert(value, fromUnit, toUnit), toUnit);
    }

    private static void convertTemperature(double value, String fromUnitStr, String toUnitStr) {
        TemperatureConverter converter = new TemperatureConverter();
        TemperatureUnit fromTempUnit = TemperatureUnit.valueOf(fromUnitStr);
        TemperatureUnit toTempUnit = TemperatureUnit.valueOf(toUnitStr);
        System.out.printf("%.2f %s = %.2f %s%n", value, fromTempUnit, converter.convert(value, fromTempUnit, toTempUnit), toTempUnit);
    }

    private static void convertWeight(double value, String fromUnitStr, String toUnitStr) {
        WeightConverter converter = new WeightConverter();
        WeightUnit fromWeightUnit = WeightUnit.valueOf(fromUnitStr);
        WeightUnit toWeightUnit = WeightUnit.valueOf(toUnitStr);
        System.out.printf("%.2f %s = %.2f %s%n", value, fromWeightUnit, converter.convert(value, fromWeightUnit, toWeightUnit), toWeightUnit);
    }
}