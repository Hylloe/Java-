import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {
    private JComboBox<String> shapeSelector;
    private JTextField input1, input2, input3;
    private JLabel label1, label2, label3, resultLabel;
    private JButton calculateButton;

    public Calculator() {
        setTitle("Geometry Calculator");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        shapeSelector = new JComboBox<>(new String[]{"三角形", "矩形", "正方形", "梯形", "圆", "球体", "圆柱体", "圆锥体"});
        input1 = new JTextField(10);
        input2 = new JTextField(10);
        input3 = new JTextField(10);
        label1 = new JLabel("输入1:");
        label2 = new JLabel("输入2:");
        label3 = new JLabel("输入3:");
        resultLabel = new JLabel("结果:");
        calculateButton = new JButton("计算");

        shapeSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedShape = (String) shapeSelector.getSelectedItem();
                updateLabels(selectedShape);
            }
        });

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate();
            }
        });

        panel.add(shapeSelector);
        panel.add(label1);
        panel.add(input1);
        panel.add(label2);
        panel.add(input2);
        panel.add(label3);
        panel.add(input3);
        panel.add(calculateButton);
        panel.add(resultLabel);

        add(panel);
        setVisible(true);
    }

    private void updateLabels(String shape) {
        switch (shape) {
            case "三角形":
                label1.setText("边长1:");
                label2.setText("边长2:");
                label3.setText("边长3:");
                input2.setVisible(true);
                label2.setVisible(true);
                input3.setVisible(true);
                label3.setVisible(true);
                break;
            case "矩形":
                label1.setText("长度:");
                label2.setText("宽度:");
                input2.setVisible(true);
                label2.setVisible(true);
                input3.setVisible(false);
                label3.setVisible(false);
                break;
            case "正方形":
                label1.setText("边长:");
                input2.setVisible(false);
                label2.setVisible(false);
                input3.setVisible(false);
                label3.setVisible(false);
                break;
            case "梯形":
                label1.setText("上底:");
                label2.setText("下底:");
                label3.setText("高:");
                input2.setVisible(true);
                label2.setVisible(true);
                input3.setVisible(true);
                label3.setVisible(true);
                break;
            case "圆":
                label1.setText("半径:");
                input2.setVisible(false);
                label2.setVisible(false);
                input3.setVisible(false);
                label3.setVisible(false);
                break;
            case "球体":
                label1.setText("半径:");
                input2.setVisible(false);
                label2.setVisible(false);
                input3.setVisible(false);
                label3.setVisible(false);
                break;
            case "圆柱体":
                label1.setText("半径:");
                label2.setText("高度:");
                input2.setVisible(true);
                label2.setVisible(true);
                input3.setVisible(false);
                label3.setVisible(false);
                break;
            case "圆锥体":
                label1.setText("半径:");
                label2.setText("高度:");
                input2.setVisible(true);
                label2.setVisible(true);
                input3.setVisible(false);
                label3.setVisible(false);
                break;
        }
    }

    private void calculate() {
        String selectedShape = (String) shapeSelector.getSelectedItem();
        double value1 = Double.parseDouble(input1.getText());
        double value2 = input2.isVisible() ? Double.parseDouble(input2.getText()) : 0;
        double value3 = input3.isVisible() ? Double.parseDouble(input3.getText()) : 0;
        Shape shape = null;

        switch (selectedShape) {
            case "三角形":
                shape = new Triangle(value1, value2, value3);
                break;
            case "矩形":
                shape = new Rectangle(value1, value2);
                break;
            case "正方形":
                shape = new Square(value1);
                break;
            case "梯形":
                shape = new Trapezoid(value1, value2, value3);
                break;
            case "圆":
                shape = new Circle(value1);
                break;
            case "球体":
                shape = new Sphere(value1);
                break;
            case "圆柱体":
                shape = new Cylinder(value1, value2);
                break;
            case "圆锥体":
                shape = new Cone(value1, value2);
                break;
        }

        if (shape != null) {
            double perimeter = shape.calculatePerimeter();
            double area = shape.calculateArea();
            double surfaceArea = shape.calculateSurfaceArea();
            double volume = shape.calculateVolume();
            resultLabel.setText(String.format("周长: %.2f, 面积: %.2f, 表面积: %.2f, 体积: %.2f",
                    perimeter, area, surfaceArea, volume));
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}