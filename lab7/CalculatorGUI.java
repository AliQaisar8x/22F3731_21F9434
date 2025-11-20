package lab7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame implements ActionListener {

    JTextField num1Field, num2Field, resultField;
    JButton addBtn, subBtn, mulBtn, divBtn;

    Calculator calculator = new Calculator();

    public CalculatorGUI() {

        setTitle("Calculator - Lab 7");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(6, 2, 10, 10));

        // Labels and text fields
        add(new JLabel("Number 1:"));
        num1Field = new JTextField();
        add(num1Field);

        add(new JLabel("Number 2:"));
        num2Field = new JTextField();
        add(num2Field);

        add(new JLabel("Result:"));
        resultField = new JTextField();
        resultField.setEditable(false);
        add(resultField);

        // Buttons
        addBtn = new JButton("Add");
        subBtn = new JButton("Subtract");
        mulBtn = new JButton("Multiply");
        divBtn = new JButton("Divide");

        add(addBtn);
        add(subBtn);
        add(mulBtn);
        add(divBtn);

        // Action listeners
        addBtn.addActionListener(this);
        subBtn.addActionListener(this);
        mulBtn.addActionListener(this);
        divBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            int num1 = Integer.parseInt(num1Field.getText());
            int num2 = Integer.parseInt(num2Field.getText());

            if (e.getSource() == addBtn) {
                resultField.setText(String.valueOf(calculator.add(num1, num2)));
            }

            if (e.getSource() == subBtn) {
                resultField.setText(String.valueOf(calculator.subtract(num1, num2)));
            }

            if (e.getSource() == mulBtn) {
                resultField.setText(String.valueOf(calculator.multiply(num1, num2)));
            }

            if (e.getSource() == divBtn) {
                resultField.setText(String.valueOf(calculator.divide(num1, num2)));
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers!");
        }
    }

    public static void main(String[] args) {
        new CalculatorGUI().setVisible(true);
    }
}
