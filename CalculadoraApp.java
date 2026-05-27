import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculadoraApp extends JFrame implements ActionListener {

    JTextField txt1 = new JTextField(), txt2 = new JTextField(), txtTemp = new JTextField(), txtMoneda = new JTextField();
    JLabel resMat = new JLabel("---"), resTemp = new JLabel("---"), resMoneda = new JLabel("---");
    final double TASA = 3800.0;

    public CalculadoraApp() {
        setTitle("Calculadora");
        setSize(500, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(0, 1, 5, 5));

        // --- MATEMÁTICAS ---
        add(titulo("OPERACIONES MATEMÁTICAS", new Color(30, 90, 160)));
        add(fila("Primer número:", txt1));
        add(fila("Segundo número:", txt2));
        JPanel pMat = new JPanel(new GridLayout(1, 4, 5, 0));
        for (String op : new String[]{"Sumar", "Restar", "Multiplicar", "Dividir"}) {
            JButton b = new JButton(op);
            b.setBackground(new Color(52, 152, 219)); b.setForeground(Color.WHITE);
            b.addActionListener(this); pMat.add(b);
        }
        add(pMat);
        add(fila("Resultado:", resMat));

        // --- TEMPERATURA ---
        add(titulo("CONVERSIÓN DE TEMPERATURA", new Color(180, 60, 30)));
        add(fila("Temperatura:", txtTemp));
        JPanel pTemp = new JPanel(new GridLayout(1, 2, 5, 0));
        for (String op : new String[]{"°C a °F", "°F a °C"}) {
            JButton b = new JButton(op);
            b.setBackground(new Color(231, 76, 60)); b.setForeground(Color.WHITE);
            b.addActionListener(this); pTemp.add(b);
        }
        add(pTemp);
        add(fila("Resultado:", resTemp));

        // --- MONEDA ---
        add(titulo("MONEDA (Tasa: $3800)", new Color(30, 130, 80)));
        add(fila("Valor:", txtMoneda));
        JPanel pMon = new JPanel(new GridLayout(1, 2, 5, 0));
        for (String op : new String[]{"USD a COP", "COP a USD"}) {
            JButton b = new JButton(op);
            b.setBackground(new Color(39, 174, 96)); b.setForeground(Color.WHITE);
            b.addActionListener(this); pMon.add(b);
        }
        add(pMon);
        add(fila("Resultado:", resMoneda));
    }

    JPanel fila(String texto, JComponent campo) {
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p.add(new JLabel(texto)); p.add(campo);
        campo.setPreferredSize(new Dimension(160, 25));
        return p;
    }

    JLabel titulo(String texto, Color color) {
        JLabel l = new JLabel(texto, SwingConstants.CENTER);
        l.setFont(new Font("Arial", Font.BOLD, 13));
        l.setForeground(color); return l;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        // Operaciones matemáticas
        if (cmd.equals("Sumar") || cmd.equals("Restar") || cmd.equals("Multiplicar") || cmd.equals("Dividir")) {
            if (txt1.getText().trim().isEmpty() || txt2.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingresa ambos números.", "Error", JOptionPane.WARNING_MESSAGE); return;
            }
            try {
                double a = Double.parseDouble(txt1.getText().trim());
                double b = Double.parseDouble(txt2.getText().trim());
                double r = switch (cmd) {
                    case "Sumar" -> a + b;
                    case "Restar" -> a - b;
                    case "Multiplicar" -> a * b;
                    default -> {
                        if (b == 0) { JOptionPane.showMessageDialog(this, "No se puede dividir entre cero.", "Error", JOptionPane.ERROR_MESSAGE); yield Double.NaN; }
                        yield a / b;
                    }
                };
                if (!Double.isNaN(r)) resMat.setText(a + " " + cmd + " " + b + " = " + r);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Solo se permiten números.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Temperatura
        else if (cmd.equals("°C a °F") || cmd.equals("°F a °C")) {
            if (txtTemp.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingresa la temperatura.", "Error", JOptionPane.WARNING_MESSAGE); return;
            }
            try {
                double t = Double.parseDouble(txtTemp.getText().trim());
                if (cmd.equals("°C a °F")) resTemp.setText(t + " °C = " + Math.round((t * 9.0/5 + 32) * 100.0)/100.0 + " °F");
                else resTemp.setText(t + " °F = " + Math.round((t - 32) * 5.0/9 * 100.0)/100.0 + " °C");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Solo se permiten números.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Moneda
        else if (cmd.equals("USD a COP") || cmd.equals("COP a USD")) {
            if (txtMoneda.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingresa el valor.", "Error", JOptionPane.WARNING_MESSAGE); return;
            }
            try {
                double v = Double.parseDouble(txtMoneda.getText().trim());
                if (cmd.equals("USD a COP")) resMoneda.setText(v + " USD = $" + String.format("%,.2f", v * TASA) + " COP");
                else resMoneda.setText("$" + String.format("%,.2f", v) + " COP = " + Math.round(v / TASA * 100.0)/100.0 + " USD");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Solo se permiten números.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculadoraApp().setVisible(true));
    }
}