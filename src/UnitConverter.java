import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnitConverter extends JApplet implements ActionListener {
    private JButton convertBtn;
    private JComboBox<String> unitTypeOption, inputOption, outputOption;
    private JTextField inputValueTextField, outputValueTextField;

    private final String[] lengthUnits = {"Millimetre", "Centimetre", "Metre", "Kilometre", "Mile", "Inch"};
    private final String[] massUnits = {"Milligram", "Gram", "Kilogram", "Pound"};
    private final String[] temperatureUnits = {"Fahrenheit", "Celsius", "Kelvin"};

    public void init() {
        final String[] unitTypes = {"Length", "Mass", "Temperature"};
        unitTypeOption = new JComboBox<String>(unitTypes);
        inputOption = new JComboBox<String>(lengthUnits);
        outputOption = new JComboBox<String>(lengthUnits);


        unitTypeOption.addActionListener(this);
        inputOption.addActionListener(this);
        outputOption.addActionListener(this);

        setSize(400,400); //size of the applet set to 400,400
        setVisible(true);
        setLayout(null);

        JPanel p1 = new JPanel(); //create a pannel
        p1.setBounds(30,20,330,330);//set pannel size and xy
        p1.setBackground(Color.gray); //paint the pannel to grey

        unitTypeOption.setBounds(100,80,200,20);
        inputOption.setBounds(60,150,100,20);
        outputOption.setBounds(240,150,100,20);

        inputValueTextField = new JTextField(""); //the value of the original value to be key in
        inputValueTextField.setBounds(50,200,120,20);
        outputValueTextField = new JTextField(""); //the value that the value already being converted
        outputValueTextField.setBounds(230,200,120,20);

        convertBtn = new JButton("CONVERT ! "); //button clicked to start the convert
        convertBtn.setBounds(130,280,120,50);
        convertBtn.addActionListener(this);

        add(unitTypeOption);  //add the Combo Box(Units of Measurement)
        add(inputOption); //add the Combo Box(Unit of the original)
        add(outputOption); //add the Combo Box(Unit done convert)

        add(inputValueTextField); //add the Text Box(Unit of the original)
        add(outputValueTextField); //add the Text Bos(Unit done convert)

        add(convertBtn); //add thw Button

        add(p1,BorderLayout.SOUTH);//add pannel
    }

    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == convertBtn) {
            double standardUnitValue = getStandardUnit(), convertedValue = getConvertedUnit(standardUnitValue);

            outputValueTextField.setText(String.format("%f", convertedValue));
        }
        else if (actionEvent.getSource() == unitTypeOption) {
            switch (unitTypeOption.getSelectedItem().toString()) {
                case "Length":
                    inputOption.setModel(new DefaultComboBoxModel<>(lengthUnits));
                    outputOption.setModel(new DefaultComboBoxModel<>(lengthUnits));
                    break;

                case "Mass":
                    inputOption.setModel(new DefaultComboBoxModel<>(massUnits));
                    outputOption.setModel(new DefaultComboBoxModel<>(massUnits));
                    break;

                case "Temperature":
                    inputOption.setModel(new DefaultComboBoxModel<>(temperatureUnits));
                    outputOption.setModel(new DefaultComboBoxModel<>(temperatureUnits));
                    break;
            }
        }
    }

    private double getStandardUnit() {
        String unit = (String) inputOption.getSelectedItem();
        double value = Double.parseDouble(inputValueTextField.getText().toString());
        switch (unit) {
            case "Millimetre":
                return ConvertUnit.convertMmToMeter(value);

            case "Centimetre":
                return ConvertUnit.convertCmToMeter(value);

            case "Kilometre":
                return ConvertUnit.convertKmToMeter(value);

            case "Mile":
                return ConvertUnit.convertMiToMeter(value);

            case "Inch":
                return ConvertUnit.convertInchToMeter(value);

            case "Milligram":
                return ConvertUnit.convertMilligramToGram(value);

            case "Kilogram":
                return ConvertUnit.convertKilogramToGram(value);

            case "Pound":
                return ConvertUnit.convertPoundToGram(value);

            case "Fahrenheit":
                return ConvertUnit.convertFahrenheitToCelsius(value);

            case "Kelvin":
                return ConvertUnit.convertKelvinToCelsius(value);

            case "Metre":

            case "Celsius":

            case "Gram":
                return value;
        }

        return 0;
    }

    private double getConvertedUnit(double value) {
        String unit = (String) outputOption.getSelectedItem();
        switch (unit) {
            case "Millimetre":
                return ConvertUnit.convertMeterToMm(value);

            case "Centimetre":
                return ConvertUnit.convertMeterToCm(value);

            case "Kilometre":
                return ConvertUnit.convertMeterToKm(value);

            case "Mile":
                return ConvertUnit.convertMeterToMi(value);

            case "Inch":
                return ConvertUnit.convertMeterToInch(value);

            case "Milligram":
                return ConvertUnit.convertGramToMilligram(value);

            case "Kilogram":
                return ConvertUnit.convertGramToKilogram(value);

            case "Pound":
                return ConvertUnit.convertGramToPound(value);

            case "Fahrenheit":
                return ConvertUnit.convertCelsiusToFahrenheit(value);

            case "Kelvin":
                return ConvertUnit.convertCelsiusToKelvin(value);

            case "Metre":

            case "Gram":

            case "Celsius":
                return value;
        }

        return 0;
    }
}
