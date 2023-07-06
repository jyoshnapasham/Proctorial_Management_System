import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ProctorialManagementSystem23 extends JFrame {
    private Connection connection;

    public ProctorialManagementSystem23() {
        super("Proctorial Management System");

        // Connect to the database
        try {
            String JDBC_URL = "jdbc:mysql://localhost:3306/Proctorial";
            String USERNAME = "root";
            String PASSWORD = "laxmansai";
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Failed to connect to the database: " + e.getMessage(),
                    "Database Connection Error", JOptionPane.ERROR_MESSAGE);
        }

        // Create components
        JButton registerButton = new JButton("Register for Exam");
        JButton assignProctorButton = new JButton("Assign Proctor");
        JButton viewProctorAssignmentsButton = new JButton("View Proctor Assignments");

        // Create panel and set layout
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(registerButton);
        panel.add(assignProctorButton);
        panel.add(viewProctorAssignmentsButton);

        // Add panel to the frame
        add(panel);

        // Set frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null); // Center the frame on the screen

        // Add action listener for register button
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle student registration logic
                registerForExam();
            }
        });

        // Add action listener for assign proctor button
        assignProctorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle proctor assignment logic
                assignProctor();
            }
        });

        // Add action listener for view proctor assignments button
        viewProctorAssignmentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle viewing proctor assignments logic
                viewProctorAssignments();
            }
        });
    }

    private void registerForExam() {
        // Retrieve and display the list of exams from the database
        try (Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM exam")) {
            StringBuilder sb = new StringBuilder();
            sb.append("Exam ID\tDate\tTime\tDuration\tCourse Details\n");
            while (resultSet.next()) {
                int examId = resultSet.getInt("exam_id");
                Date date = resultSet.getDate("date");
                Time time = resultSet.getTime("time");
                int duration = resultSet.getInt("duration");
                String courseDetails = resultSet.getString("course_details");
                sb.append(examId).append("\t").append(date).append("\t").append(time).append("\t")
                        .append(duration).append("\t").append(courseDetails).append("\n");
            }

            JTextArea textArea = new JTextArea(sb.toString());
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(400, 300));
            JOptionPane.showMessageDialog(null, scrollPane, "Available Exams", JOptionPane.PLAIN_MESSAGE);

            // Prompt the user for necessary information
            JTextField studentIdField = new JTextField(10);
            JTextField examIdField = new JTextField(10);

            JPanel panel = new JPanel(new GridBagLayout());
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.gridx = 0;
            constraints.gridy = 0;
            panel.add(new JLabel("Student ID:"), constraints);
            constraints.gridx = 1;
            panel.add(studentIdField, constraints);
            constraints.gridx = 0;
            constraints.gridy = 1;
            panel.add(new JLabel("Exam ID:"), constraints);
            constraints.gridx = 1;
            panel.add(examIdField, constraints);

            int result = JOptionPane.showConfirmDialog(null, panel, "Register for Exam", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                // Get the input values
                int studentId = Integer.parseInt(studentIdField.getText());
                int examId = Integer.parseInt(examIdField.getText());

                // Check if the student is already registered for the exam
                try (PreparedStatement regStatement = connection.prepareStatement(
                        "SELECT * FROM exam_registration WHERE student_id = ? AND exam_id = ?")) {
                    regStatement.setInt(1, studentId);
                    regStatement.setInt(2, examId);
                    ResultSet registrationResultSet = regStatement.executeQuery();
                    if (registrationResultSet.next()) {
                        JOptionPane.showMessageDialog(null, "You are already registered for this exam.",
                                "Registration Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        // Insert the registration into the database
                        try (PreparedStatement insertStatement = connection.prepareStatement(
                                "INSERT INTO exam_registration (student_id, exam_id) VALUES (?, ?)")) {
                            insertStatement.setInt(1, studentId);
                            insertStatement.setInt(2, examId);
                            int rowsAffected = insertStatement.executeUpdate();
                            if (rowsAffected > 0) {
                                JOptionPane.showMessageDialog(null, "Registration successful!");
                            } else {
                                JOptionPane.showMessageDialog(null, "Failed to register for the exam.",
                                        "Registration Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error during registration: " + e.getMessage(),
                            "Registration Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error retrieving exam details: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
       
        }
    }

    

    private void assignProctor() {
        // Prompt the user for necessary information
        JTextField examIdField = new JTextField(10);
        JTextField proctorIdField = new JTextField(10);
    
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(new JLabel("Exam ID:"), constraints);
        constraints.gridx = 1;
        panel.add(examIdField, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(new JLabel("Proctor ID:"), constraints);
        constraints.gridx = 1;
        panel.add(proctorIdField, constraints);
    
        int result = JOptionPane.showConfirmDialog(null, panel, "Assign Proctor", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            // Get the input values
            int examId = Integer.parseInt(examIdField.getText());
            int proctorId = Integer.parseInt(proctorIdField.getText());
            int assignmentId = Integer.parseInt(proctorIdField.getText());
    
            // Check if the proctor is already assigned to the exam
            try (PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM proctor_assignment WHERE exam_id = ? AND proctor_id = ?")) {
                statement.setInt(1, examId);
                statement.setInt(2, proctorId);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(null, "This proctor is already assigned to this exam.",
                            "Assignment Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Insert the assignment into the database
                    try (PreparedStatement insertStatement = connection.prepareStatement(
                            "INSERT INTO proctor_assignment (exam_id, proctor_id) VALUES (?, ?)")) {
                        insertStatement.setInt(1, examId);
                        insertStatement.setInt(2, proctorId);
                        int rowsAffected = insertStatement.executeUpdate();
                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(null, "Proctor assignment successful!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Failed to assign the proctor to the exam.",
                                    "Assignment Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error during proctor assignment: " + e.getMessage(),
                        "Assignment Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    

    private void viewProctorAssignments() {
        // Retrieve the proctor assignments from the database
        try (Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM proctor_assignment")) {
            // Create a StringBuilder to store the assignment details
            StringBuilder sb = new StringBuilder();
            sb.append("Assignment ID\tExam ID\tProctor ID\n");
    
            // Iterate over the result set and append the assignment details to the StringBuilder
            while (resultSet.next()) {
                int assignmentId = resultSet.getInt("assignment_id");
                int examId = resultSet.getInt("exam_id");
                int proctorId = resultSet.getInt("proctor_id");
                sb.append(assignmentId).append("\t").append(examId).append("\t").append(proctorId).append("\n");
            }
    
            // Display the assignment details to the user
            JTextArea textArea = new JTextArea(sb.toString());
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(400, 300));
            JOptionPane.showMessageDialog(null, scrollPane, "Proctor Assignments", JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error retrieving proctor assignments: " + e.getMessage(),
                    "Assignment Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ProctorialManagementSystem23().setVisible(true);
            }
        });
    }
}
