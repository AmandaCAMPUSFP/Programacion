package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import dao.ProductoDAO;
import modelo.ProductoOtaku;

public class MainGUI {
    public static void main(String[] args) {
        // Configuración básica de la ventana
        JFrame frame = new JFrame("Akihabara Market");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // Componentes
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        JButton btnActualizar = new JButton("Actualizar lista");
        JButton btnAgregar = new JButton("Agregar producto");

        // Panel para botones
        JPanel panelBotones = new JPanel();
        panelBotones.add(btnActualizar);
        panelBotones.add(btnAgregar);

        // Agregar componentes a la ventana
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(panelBotones, BorderLayout.SOUTH);

        // Acción para actualizar la lista
        btnActualizar.addActionListener((ActionEvent e) -> {
            ProductoDAO dao = new ProductoDAO();
            StringBuilder sb = new StringBuilder();
            for (ProductoOtaku p : dao.obtenerTodosLosProductos()) {
                sb.append(p.toString()).append("\n");
            }
            textArea.setText(sb.toString());
        });

        // Acción para agregar producto 
        btnAgregar.addActionListener((ActionEvent e) -> {
            JTextField nombreField = new JTextField();
            JTextField precioField = new JTextField();

            JPanel panel = new JPanel(new GridLayout(0, 1));
            panel.add(new JLabel("Nombre:"));
            panel.add(nombreField);
            panel.add(new JLabel("Precio:"));
            panel.add(precioField);

            int result = JOptionPane.showConfirmDialog(
                frame, 
                panel, 
                "Agregar Producto", 
                JOptionPane.OK_CANCEL_OPTION
            );

            if (result == JOptionPane.OK_OPTION) {
                ProductoDAO dao = new ProductoDAO();
                ProductoOtaku nuevo = new ProductoOtaku(
                    nombreField.getText(),
                    "General",
                    Double.parseDouble(precioField.getText()),
                    10  // Stock por defecto
                );
                dao.agregarProducto(nuevo);
                JOptionPane.showMessageDialog(frame, "Producto agregado!");
            }
        });

        // Mostrar ventana
        frame.setVisible(true);
    }
}