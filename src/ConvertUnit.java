import java.text.DecimalFormat;

public class ConvertUnit {
	DecimalFormat df5 = new DecimalFormat("0.00000");
	DecimalFormat df2 = new DecimalFormat("0.00");

    public static double convertKmToMeter(double kilometer) {
        return kilometer * 1000;
    }

    public static double convertMiToMeter(double mile) {
        return mile * 1609.34;
    }

    public static double convertFeetToMeter(double feet) {
        return feet * 0.3048;
    }

    public static double convertMeterToKm(double meter) {
        return meter * 0.001;
    }

    public static double convertMeterToFeet(double meter) {
        return meter * 3.28084;
    }

    public static double convertMeterToMi(double meter) {
        return meter * 0.000621371;
    }

    public static double convertMeterToMm(double meter) {
        return meter * 1000;
    }
    public static double convertMeterToCm(double cm) {
        return cm * 100;
    }
    public static double convertMeterToInch(double inch) {
        return inch * 39.37;
    }
    public static double convertMmToMeter(double mm) {
        return mm / 1000;
    }
    public static double convertCmToMeter(double cm) {
        return cm / 100;
    }
    public static double convertInchToMeter(double inch) {
        return inch / 39.37;
    }

	public static double convertMilligramToGram(double milligram) {
        return milligram / 1000;
    }
    public static double convertGramToMilligram(double gram) {
        return gram * 1000;
    }

    public static double convertGramToKilogram(double gram) {
        return gram / 1000;
    }
    
    public static double convertGramToPound(double gram) {
        return gram / 454;
    }
    
    //Kilogram
    public static double convertKilogramToGram(double kilogram) {
        return kilogram * 1000;
    }
    
    //Pound
    public static double convertPoundToGram(double pound) {
        return pound * 453.592;
    }
    
    //Fahrenheit
    public static double convertFahrenheitToCelsius(double farenheit) {
        return (farenheit - 32) * 5 / 9;
    }
    
    public static double convertCelsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }
    
    public static double convertCelsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }
    
    public static double convertKelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }
}
