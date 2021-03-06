package ic.doc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GuiApp implements View {

    Model calc = new Model();
    JTextField textField = new JTextField(10);

    String[] operators = {"+", "-", "*", "/"};

    public static void main(String[] args) {
        new GuiApp().display();
    }

    private void display() {
        JFrame frame = new JFrame("RPN App");
        frame.setSize(600, 400);
        calc.setView(this);
        JPanel panel = new JPanel();

        panel.add(textField);

        for (int i = 0; i < 10; i++) {
            JButton number = new JButton(String.valueOf(i));
            int finalI = i;
            number.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    calc.addNumberToStack(finalI);
                }
            });

            panel.add(number);
        }

        for (int i = 0; i < operators.length; i++) {
            JButton operator = new JButton(operators[i]);
            int finalI = i;
            operator.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {

                    calc.findResult(operators[finalI]);

                }
            });
            panel.add(operator);
        }

        frame.getContentPane().add(panel);
        frame.setVisible(true);

    }

    @Override
    public void change(int i) {
        textField.setText(String.valueOf(i));
    }
}
