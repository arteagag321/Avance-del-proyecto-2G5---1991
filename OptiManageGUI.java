import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptiManageGUI {
    private JPanel mainPanel;
    private JLabel titleLabel;
    private JTextField projectNameField;
    private JButton agregarTareasButton;
    private JButton eliminarTareasButton;
    private JButton asignarEmpleadosButton;
    private JButton generarReportesButton;
    private JTable tasksTable;
    private JComboBox<String> employeeSelector;
    private JTextArea descriptionArea;
    private JScrollPane tasksScrollPane;
    private JComboBox<String> taskStatusSelector;
    private JComboBox<String> projectSelector;
    private JComboBox<String> reportTypeSelector;

    public OptiManageGUI() {

        DefaultTableModel tableModel = new DefaultTableModel(
                new String[]{"ID", "Descripción", "Estado", "Empleado"}, 0);
        tasksTable.setModel(tableModel);


        agregarTareasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String taskDescription = JOptionPane.showInputDialog("Ingrese la descripción de la tarea:");
                if (taskDescription != null && !taskDescription.isEmpty()) {
                    String taskStatus = (String) taskStatusSelector.getSelectedItem();
                    int nextId = tableModel.getRowCount() + 1;
                    tableModel.addRow(new Object[]{nextId, taskDescription, taskStatus, "No asignado"});
                    JOptionPane.showMessageDialog(mainPanel, "Tarea agregada correctamente.");
                } else {
                    JOptionPane.showMessageDialog(mainPanel, "Debe ingresar una descripción válida.");
                }
            }
        });


        eliminarTareasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tasksTable.getSelectedRow();
                if (selectedRow >= 0) {
                    tableModel.removeRow(selectedRow);
                    JOptionPane.showMessageDialog(mainPanel, "Tarea eliminada correctamente.");
                } else {
                    JOptionPane.showMessageDialog(mainPanel, "Seleccione una tarea para eliminar.");
                }
            }
        });


        asignarEmpleadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tasksTable.getSelectedRow();
                String empleadoIngresado = projectNameField.getText().trim(); 
                if (selectedRow >= 0) {
                    if (!empleadoIngresado.isEmpty()) {
                        tableModel.setValueAt(empleadoIngresado, selectedRow, 3);
                        JOptionPane.showMessageDialog(mainPanel,
                                "Empleado '" + empleadoIngresado + "' asignado a la tarea seleccionada.");
                    } else {
                        JOptionPane.showMessageDialog(mainPanel, "Debe ingresar el nombre del empleado.");
                    }
                } else {
                    JOptionPane.showMessageDialog(mainPanel, "Seleccione una tarea para asignar un empleado.");
                }
            }
        });


        generarReportesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder reporte = new StringBuilder();
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    reporte.append("Tarea ID: ").append(tableModel.getValueAt(i, 0))
                            .append(", Descripción: ").append(tableModel.getValueAt(i, 1))
                            .append(", Estado: ").append(tableModel.getValueAt(i, 2))
                            .append(", Empleado: ").append(tableModel.getValueAt(i, 3)).append("\n");
                }
                if (reporte.length() > 0) {
                    descriptionArea.setText(reporte.toString());
                    JOptionPane.showMessageDialog(mainPanel, "Reporte generado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(mainPanel, "No hay tareas para generar un reporte.");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("OptiManageGUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new OptiManageGUI().mainPanel);
        frame.pack();
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}