import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginApp {
    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel messageLabel;

    public LoginApp() {
        // Configuración del marco
        frame = new JFrame("prestamo de laboratorio");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(720, 350);
        frame.setLayout(new GridBagLayout());
        frame.setLocationRelativeTo(null); // Centrar la ventana

        // Crear componentes
        JLabel usernameLabel = new JLabel("Nombre de usuario:");
        usernameField = new JTextField(20);
        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordField = new JPasswordField(20);
        JButton loginButton = new JButton("Iniciar sesión");
        messageLabel = new JLabel("", SwingConstants.CENTER);

        // Estilo de los componentes
        usernameLabel.setForeground(Color.BLUE);
        passwordLabel.setForeground(Color.BLUE);
        messageLabel.setForeground(Color.RED);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 14));

        // Estilo del botón
        loginButton.setBackground(Color.GREEN);
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));

        // acción al botón
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // credenciales
                if (validateCredentials(username, password)) {
                    messageLabel.setText("¡Bienvenido!");
                    messageLabel.setForeground(Color.GREEN);
                } else {
                    messageLabel.setText("Usuario o contraseña equivocado");
                    messageLabel.setForeground(Color.RED);
                }
            }
        });

        // GridBagLayout para un mejor diseño
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espaciado

        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(usernameLabel, gbc);

        gbc.gridx = 1;
        frame.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(passwordLabel, gbc);

        gbc.gridx = 1;
        frame.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2; // Ocupa dos columnas
        frame.add(loginButton, gbc);

        gbc.gridy = 3;
        frame.add(messageLabel, gbc);

        // Hacer visible el marco
        frame.getContentPane().setBackground(Color.LIGHT_GRAY); // Color de fondo
        frame.setVisible(true);
    }

    private boolean validateCredentials(String username, String password) {
        //  validar las credenciales
        // usuario y contraseña fijos
        return "usuario".equals(username) && "contraseña".equals(password);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginApp());
    }
}