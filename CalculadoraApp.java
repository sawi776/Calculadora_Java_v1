import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Aplicación de Calculadora con interfaz gráfica en Java
 * Realiza operaciones matemáticas y conversiones de temperatura y moneda
 * 
 * @author Estudiante - Segundo Semestre
 */
public class CalculadoraApp extends JFrame implements ActionListener {

    // =============================================
    // COMPONENTES DE LA INTERFAZ (atributos)
    // =============================================

    // --- Sección de Operaciones Matemáticas ---
    JLabel lblTituloMatematicas;
    JLabel lblNumero1;
    JTextField txtNumero1;
    JLabel lblNumero2;
    JTextField txtNumero2;
    JLabel lblResultadoMatLabel;
    JLabel lblResultadoMat;

    JButton btnSumar;
    JButton btnRestar;
    JButton btnMultiplicar;
    JButton btnDividir;

    // --- Sección de Conversión de Temperatura ---
    JLabel lblTituloTemperatura;
    JLabel lblTempIngresa;
    JTextField txtTemperatura;
    JLabel lblResultadoTempLabel;
    JLabel lblResultadoTemp;

    JButton btnCelsiusAFahrenheit;
    JButton btnFahrenheitACelsius;

    // --- Sección de Conversión de Moneda ---
    JLabel lblTituloMoneda;
    JLabel lblMonedaIngresa;
    JTextField txtMoneda;
    JLabel lblResultadoMonedaLabel;
    JLabel lblResultadoMoneda;

    JButton btnUSDaCOP;
    JButton btnCOPaUSD;

    // Tasa de cambio fija
    final double TASA_CAMBIO = 3800.0;

    // =============================================
    // CONSTRUCTOR - Aquí se construye la ventana
    // =============================================
    public CalculadoraApp() {
        // Configuración básica de la ventana
        setTitle("Calculadora y Conversor");
        setSize(520, 620);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar en pantalla
        setResizable(false);

        // Usamos un layout nulo para posicionar los componentes manualmente
        setLayout(null);
        getContentPane().setBackground(new Color(240, 240, 240));

        // Llamamos al método que crea todos los componentes
        crearComponentes();
    }

    // =============================================
    // MÉTODO: Crear y posicionar todos los componentes
    // =============================================
    private void crearComponentes() {

        // ==== SECCIÓN 1: OPERACIONES MATEMÁTICAS ====

        // Título de la sección
        lblTituloMatematicas = new JLabel("── OPERACIONES MATEMÁTICAS ──");
        lblTituloMatematicas.setBounds(60, 10, 400, 25);
        lblTituloMatematicas.setFont(new Font("Arial", Font.BOLD, 14));
        lblTituloMatematicas.setForeground(new Color(30, 90, 160));
        add(lblTituloMatematicas);

        // Número 1
        lblNumero1 = new JLabel("Primer número:");
        lblNumero1.setBounds(20, 45, 130, 25);
        lblNumero1.setFont(new Font("Arial", Font.PLAIN, 13));
        add(lblNumero1);

        txtNumero1 = new JTextField();
        txtNumero1.setBounds(155, 45, 150, 25);
        txtNumero1.setFont(new Font("Arial", Font.PLAIN, 13));
        add(txtNumero1);

        // Número 2
        lblNumero2 = new JLabel("Segundo número:");
        lblNumero2.setBounds(20, 80, 130, 25);
        lblNumero2.setFont(new Font("Arial", Font.PLAIN, 13));
        add(lblNumero2);

        txtNumero2 = new JTextField();
        txtNumero2.setBounds(155, 80, 150, 25);
        txtNumero2.setFont(new Font("Arial", Font.PLAIN, 13));
        add(txtNumero2);

        // Botones de operaciones matemáticas
        btnSumar = new JButton("Sumar");
        btnSumar.setBounds(20, 120, 105, 35);
        btnSumar.setBackground(new Color(52, 152, 219));
        btnSumar.setForeground(Color.WHITE);
        btnSumar.setFont(new Font("Arial", Font.BOLD, 12));
        btnSumar.addActionListener(this);
        add(btnSumar);

        btnRestar = new JButton("Restar");
        btnRestar.setBounds(135, 120, 105, 35);
        btnRestar.setBackground(new Color(52, 152, 219));
        btnRestar.setForeground(Color.WHITE);
        btnRestar.setFont(new Font("Arial", Font.BOLD, 12));
        btnRestar.addActionListener(this);
        add(btnRestar);

        btnMultiplicar = new JButton("Multiplicar");
        btnMultiplicar.setBounds(250, 120, 105, 35);
        btnMultiplicar.setBackground(new Color(52, 152, 219));
        btnMultiplicar.setForeground(Color.WHITE);
        btnMultiplicar.setFont(new Font("Arial", Font.BOLD, 12));
        btnMultiplicar.addActionListener(this);
        add(btnMultiplicar);

        btnDividir = new JButton("Dividir");
        btnDividir.setBounds(365, 120, 105, 35);
        btnDividir.setBackground(new Color(52, 152, 219));
        btnDividir.setForeground(Color.WHITE);
        btnDividir.setFont(new Font("Arial", Font.BOLD, 12));
        btnDividir.addActionListener(this);
        add(btnDividir);

        // Resultado matemático
        lblResultadoMatLabel = new JLabel("Resultado:");
        lblResultadoMatLabel.setBounds(20, 168, 100, 25);
        lblResultadoMatLabel.setFont(new Font("Arial", Font.BOLD, 13));
        add(lblResultadoMatLabel);

        lblResultadoMat = new JLabel("---");
        lblResultadoMat.setBounds(120, 168, 360, 25);
        lblResultadoMat.setFont(new Font("Arial", Font.BOLD, 14));
        lblResultadoMat.setForeground(new Color(30, 90, 160));
        add(lblResultadoMat);

        // Línea separadora (usando un panel)
        JSeparator sep1 = new JSeparator();
        sep1.setBounds(10, 205, 480, 5);
        add(sep1);

        // ==== SECCIÓN 2: CONVERSIÓN DE TEMPERATURA ====

        lblTituloTemperatura = new JLabel("── CONVERSIÓN DE TEMPERATURA ──");
        lblTituloTemperatura.setBounds(50, 215, 420, 25);
        lblTituloTemperatura.setFont(new Font("Arial", Font.BOLD, 14));
        lblTituloTemperatura.setForeground(new Color(180, 60, 30));
        add(lblTituloTemperatura);

        // Campo de temperatura
        lblTempIngresa = new JLabel("Ingresa la temperatura:");
        lblTempIngresa.setBounds(20, 250, 165, 25);
        lblTempIngresa.setFont(new Font("Arial", Font.PLAIN, 13));
        add(lblTempIngresa);

        txtTemperatura = new JTextField();
        txtTemperatura.setBounds(190, 250, 150, 25);
        txtTemperatura.setFont(new Font("Arial", Font.PLAIN, 13));
        add(txtTemperatura);

        // Botones de temperatura
        btnCelsiusAFahrenheit = new JButton("°C  →  °F");
        btnCelsiusAFahrenheit.setBounds(20, 290, 200, 35);
        btnCelsiusAFahrenheit.setBackground(new Color(231, 76, 60));
        btnCelsiusAFahrenheit.setForeground(Color.WHITE);
        btnCelsiusAFahrenheit.setFont(new Font("Arial", Font.BOLD, 12));
        btnCelsiusAFahrenheit.addActionListener(this);
        add(btnCelsiusAFahrenheit);

        btnFahrenheitACelsius = new JButton("°F  →  °C");
        btnFahrenheitACelsius.setBounds(270, 290, 200, 35);
        btnFahrenheitACelsius.setBackground(new Color(231, 76, 60));
        btnFahrenheitACelsius.setForeground(Color.WHITE);
        btnFahrenheitACelsius.setFont(new Font("Arial", Font.BOLD, 12));
        btnFahrenheitACelsius.addActionListener(this);
        add(btnFahrenheitACelsius);

        // Resultado temperatura
        lblResultadoTempLabel = new JLabel("Resultado:");
        lblResultadoTempLabel.setBounds(20, 338, 100, 25);
        lblResultadoTempLabel.setFont(new Font("Arial", Font.BOLD, 13));
        add(lblResultadoTempLabel);

        lblResultadoTemp = new JLabel("---");
        lblResultadoTemp.setBounds(120, 338, 360, 25);
        lblResultadoTemp.setFont(new Font("Arial", Font.BOLD, 14));
        lblResultadoTemp.setForeground(new Color(180, 60, 30));
        add(lblResultadoTemp);

        // Línea separadora
        JSeparator sep2 = new JSeparator();
        sep2.setBounds(10, 375, 480, 5);
        add(sep2);

        // ==== SECCIÓN 3: CONVERSIÓN DE MONEDA ====

        lblTituloMoneda = new JLabel("── CONVERSIÓN DE MONEDA (Tasa: $3800) ──");
        lblTituloMoneda.setBounds(30, 385, 460, 25);
        lblTituloMoneda.setFont(new Font("Arial", Font.BOLD, 14));
        lblTituloMoneda.setForeground(new Color(30, 130, 80));
        add(lblTituloMoneda);

        // Campo de moneda
        lblMonedaIngresa = new JLabel("Ingresa el valor:");
        lblMonedaIngresa.setBounds(20, 420, 130, 25);
        lblMonedaIngresa.setFont(new Font("Arial", Font.PLAIN, 13));
        add(lblMonedaIngresa);

        txtMoneda = new JTextField();
        txtMoneda.setBounds(155, 420, 150, 25);
        txtMoneda.setFont(new Font("Arial", Font.PLAIN, 13));
        add(txtMoneda);

        // Botones de moneda
        btnUSDaCOP = new JButton("USD  →  COP");
        btnUSDaCOP.setBounds(20, 460, 200, 35);
        btnUSDaCOP.setBackground(new Color(39, 174, 96));
        btnUSDaCOP.setForeground(Color.WHITE);
        btnUSDaCOP.setFont(new Font("Arial", Font.BOLD, 12));
        btnUSDaCOP.addActionListener(this);
        add(btnUSDaCOP);

        btnCOPaUSD = new JButton("COP  →  USD");
        btnCOPaUSD.setBounds(270, 460, 200, 35);
        btnCOPaUSD.setBackground(new Color(39, 174, 96));
        btnCOPaUSD.setForeground(Color.WHITE);
        btnCOPaUSD.setFont(new Font("Arial", Font.BOLD, 12));
        btnCOPaUSD.addActionListener(this);
        add(btnCOPaUSD);

        // Resultado moneda
        lblResultadoMonedaLabel = new JLabel("Resultado:");
        lblResultadoMonedaLabel.setBounds(20, 508, 100, 25);
        lblResultadoMonedaLabel.setFont(new Font("Arial", Font.BOLD, 13));
        add(lblResultadoMonedaLabel);

        lblResultadoMoneda = new JLabel("---");
        lblResultadoMoneda.setBounds(120, 508, 360, 25);
        lblResultadoMoneda.setFont(new Font("Arial", Font.BOLD, 14));
        lblResultadoMoneda.setForeground(new Color(30, 130, 80));
        add(lblResultadoMoneda);

        // Créditos al pie
        JLabel lblCredito = new JLabel("Tasa fija USD/COP: $3,800");
        lblCredito.setBounds(160, 545, 300, 20);
        lblCredito.setFont(new Font("Arial", Font.ITALIC, 11));
        lblCredito.setForeground(Color.GRAY);
        add(lblCredito);
    }

    // =============================================
    // MÉTODO actionPerformed - SE EJECUTA AL HACER CLIC EN UN BOTÓN
    // =============================================
    @Override
    public void actionPerformed(ActionEvent e) {

        // Obtenemos la fuente (qué botón se presionó)
        Object fuente = e.getSource();

        // ---- BOTONES DE MATEMÁTICAS ----
        if (fuente == btnSumar || fuente == btnRestar ||
            fuente == btnMultiplicar || fuente == btnDividir) {

            // Validar que los campos no estén vacíos
            if (txtNumero1.getText().trim().isEmpty() || txtNumero2.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                    "Por favor ingresa ambos números antes de operar.",
                    "Campos vacíos", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Intentar convertir los textos a números
            double num1, num2;
            try {
                num1 = Double.parseDouble(txtNumero1.getText().trim());
                num2 = Double.parseDouble(txtNumero2.getText().trim());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                    "Solo se permiten números.\nNo uses letras ni caracteres especiales.",
                    "Dato inválido", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Realizar la operación según el botón
            double resultado = 0;
            String operacion = "";

            if (fuente == btnSumar) {
                resultado = num1 + num2;
                operacion = num1 + " + " + num2 + " = " + resultado;

            } else if (fuente == btnRestar) {
                resultado = num1 - num2;
                operacion = num1 + " - " + num2 + " = " + resultado;

            } else if (fuente == btnMultiplicar) {
                resultado = num1 * num2;
                operacion = num1 + " × " + num2 + " = " + resultado;

            } else if (fuente == btnDividir) {
                // Validar división por cero
                if (num2 == 0) {
                    JOptionPane.showMessageDialog(this,
                        "No se puede dividir entre cero.",
                        "División por cero", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                resultado = num1 / num2;
                operacion = num1 + " ÷ " + num2 + " = " + resultado;
            }

            lblResultadoMat.setText(operacion);
        }

        // ---- BOTONES DE TEMPERATURA ----
        else if (fuente == btnCelsiusAFahrenheit || fuente == btnFahrenheitACelsius) {

            // Validar campo vacío
            if (txtTemperatura.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                    "Por favor ingresa la temperatura a convertir.",
                    "Campo vacío", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Validar que sea número
            double temp;
            try {
                temp = Double.parseDouble(txtTemperatura.getText().trim());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                    "Solo se permiten números.\nNo uses letras ni caracteres especiales.",
                    "Dato inválido", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Realizar la conversión
            if (fuente == btnCelsiusAFahrenheit) {
                double fahrenheit = (temp * 9.0 / 5.0) + 32;
                // Redondeamos a 2 decimales para que se vea limpio
                fahrenheit = Math.round(fahrenheit * 100.0) / 100.0;
                lblResultadoTemp.setText(temp + " °C  =  " + fahrenheit + " °F");

            } else if (fuente == btnFahrenheitACelsius) {
                double celsius = (temp - 32) * 5.0 / 9.0;
                celsius = Math.round(celsius * 100.0) / 100.0;
                lblResultadoTemp.setText(temp + " °F  =  " + celsius + " °C");
            }
        }

        // ---- BOTONES DE MONEDA ----
        else if (fuente == btnUSDaCOP || fuente == btnCOPaUSD) {

            // Validar campo vacío
            if (txtMoneda.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                    "Por favor ingresa el valor a convertir.",
                    "Campo vacío", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Validar que sea número
            double valorMoneda;
            try {
                valorMoneda = Double.parseDouble(txtMoneda.getText().trim());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                    "Solo se permiten números.\nNo uses letras ni caracteres especiales.",
                    "Dato inválido", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Realizar la conversión
            if (fuente == btnUSDaCOP) {
                double cop = valorMoneda * TASA_CAMBIO;
                // Formateamos con separadores de miles para que sea legible
                lblResultadoMoneda.setText(valorMoneda + " USD  =  $" + String.format("%,.2f", cop) + " COP");

            } else if (fuente == btnCOPaUSD) {
                double usd = valorMoneda / TASA_CAMBIO;
                usd = Math.round(usd * 100.0) / 100.0;
                lblResultadoMoneda.setText("$" + String.format("%,.2f", valorMoneda) + " COP  =  " + usd + " USD");
            }
        }
    }

    // =============================================
    // MÉTODO MAIN - Punto de entrada del programa
    // =============================================
    public static void main(String[] args) {
        // SwingUtilities.invokeLater garantiza que la interfaz
        // se cree en el hilo correcto de Java Swing
        SwingUtilities.invokeLater(() -> {
            CalculadoraApp app = new CalculadoraApp();
            app.setVisible(true); // Mostrar la ventana
        });
    }
}
