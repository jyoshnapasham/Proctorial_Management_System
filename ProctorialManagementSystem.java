import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ProctorialManagementSystem extends JFrame {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/proctorial";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "laxmansai";

    private JMenuBar menuBar;
    private JMenu studentMenu, proctorMenu, examMenu, rulesMenu, assignmentMenu, resultsMenu, registerMenu;
    private JMenuItem addStudentItem, deleteStudentItem, updateStudentItem, displayStudentItem ,  displayExamRegistrationItem;
    private JMenuItem addProctorItem, deleteProctorItem, updateProctorItem, displayProctorItem;
    private JMenuItem addExamItem, deleteExamItem, updateExamItem, displayExamItem;
    private JMenuItem addRulesItem, deleteRulesItem, updateRulesItem, displayRulesItem;
    private JMenuItem addAssignmentItem, deleteAssignmentItem, updateAssignmentItem, displayAssignmentItem;
    private JMenuItem addResultsItem, deleteResultsItem, updateResultsItem, displayResultsItem;

    public ProctorialManagementSystem() {
        setTitle("Proctorial Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the menu bar
        menuBar = new JMenuBar();

        // Create the menus
        studentMenu = new JMenu("Student");
        proctorMenu = new JMenu("Proctor");
        examMenu = new JMenu("Exam");
        rulesMenu = new JMenu("Exam Rules");
        assignmentMenu = new JMenu("Proctor Assignment");
        resultsMenu = new JMenu("Exam Results");
        registerMenu = new JMenu("Exam Registration");

        // Create the menu items
        addStudentItem = new JMenuItem("Add Student");
        deleteStudentItem = new JMenuItem("Delete Student");
        updateStudentItem = new JMenuItem("Update Student");
        displayStudentItem = new JMenuItem("Display Students");

        addProctorItem = new JMenuItem("Add Proctor");
        deleteProctorItem = new JMenuItem("Delete Proctor");
        updateProctorItem = new JMenuItem("Update Proctor");
        displayProctorItem = new JMenuItem("Display Proctors");

        addExamItem = new JMenuItem("Add Exam");
        deleteExamItem = new JMenuItem("Delete Exam");
        updateExamItem = new JMenuItem("Update Exam");
        displayExamItem = new JMenuItem("Display Exams");

        addRulesItem = new JMenuItem("Add Exam Rules");
        deleteRulesItem = new JMenuItem("Delete Exam Rules");
        updateRulesItem = new JMenuItem("Update Exam Rules");
        displayRulesItem = new JMenuItem("Display Exam Rules");

        addAssignmentItem = new JMenuItem("Add Proctor Assignment");
        deleteAssignmentItem = new JMenuItem("Delete Proctor Assignment");
        updateAssignmentItem = new JMenuItem("Update Proctor Assignment");
        displayAssignmentItem = new JMenuItem("Display Proctor Assignments");

        addResultsItem = new JMenuItem("Add Exam Results");
        deleteResultsItem = new JMenuItem("Delete Exam Results");
        updateResultsItem = new JMenuItem("Update Exam Results");
        displayResultsItem = new JMenuItem("Display Exam Results");
        
        displayExamRegistrationItem = new JMenuItem("Display Exam Registration");
        
        // Add action listeners to menu items
        displayExamRegistrationItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayExamRegistration();
            }
        });
        addStudentItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });

        deleteStudentItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteStudent();
            }
        });

        updateStudentItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateStudent();
            }
        });

        displayStudentItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayStudents();
            }
        });
        addProctorItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addProctor();
            }
        });

        deleteProctorItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteProctor();
            }
        });

        updateProctorItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateProctor();
            }
        });

        displayProctorItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayProctors();
            }
        });

        addExamItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addExam();
            }
        });

        deleteExamItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteExam();
            }
        });

        updateExamItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateExam();
            }
        });

        displayExamItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayExams();
            }
        });

        addRulesItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addExamRules();
            }
        });

        deleteRulesItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteExamRules();
            }
        });

        updateRulesItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateExamRules();
            }
        });

        displayRulesItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayExamRules();
            }
        });

        addAssignmentItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addProctorAssignment();
            }
        });

        deleteAssignmentItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteProctorAssignment();
            }
        });

        updateAssignmentItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateProctorAssignment();
            }
        });

        displayAssignmentItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayProctorAssignments();
            }
        });

        addResultsItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addExamResults();
            }
        });

        deleteResultsItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteExamResults();
            }
        });

        updateResultsItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateExamResults();
            }
        });

        displayResultsItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayExamResults();
            }
        });
        // Add menu items to menus
        registerMenu.add(displayExamRegistrationItem);
        studentMenu.add(addStudentItem);
        studentMenu.add(deleteStudentItem);
        studentMenu.add(updateStudentItem);
        studentMenu.add(displayStudentItem);
        
        proctorMenu.add(addProctorItem);
        proctorMenu.add(deleteProctorItem);
        proctorMenu.add(updateProctorItem);
        proctorMenu.add(displayProctorItem);

        examMenu.add(addExamItem);
        examMenu.add(deleteExamItem);
        examMenu.add(updateExamItem);
        examMenu.add(displayExamItem);

        rulesMenu.add(addRulesItem);
        rulesMenu.add(deleteRulesItem);
        rulesMenu.add(updateRulesItem);
        rulesMenu.add(displayRulesItem);

        assignmentMenu.add(addAssignmentItem);
        assignmentMenu.add(deleteAssignmentItem);
        assignmentMenu.add(updateAssignmentItem);
        assignmentMenu.add(displayAssignmentItem);

        resultsMenu.add(addResultsItem);
        resultsMenu.add(deleteResultsItem);
        resultsMenu.add(updateResultsItem);
        resultsMenu.add(displayResultsItem);

        // Add menus to menu bar
        
        menuBar.add(studentMenu);
        menuBar.add(proctorMenu);
        menuBar.add(examMenu);
        menuBar.add(rulesMenu);
        menuBar.add(assignmentMenu);
        menuBar.add(resultsMenu);
        menuBar.add(registerMenu);
        

        // Set the menu bar
        setJMenuBar(menuBar);
    }

    private void addStudent() {
        JTextField idField = new JTextField(10);
        JTextField nameField = new JTextField(10);
        JTextField emailField = new JTextField(10);
        JTextField courseField = new JTextField(10);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(new JLabel("Student ID:"), constraints);
        constraints.gridx = 1;
        panel.add(idField, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(new JLabel("Name:"), constraints);
        constraints.gridx = 1;
        panel.add(nameField, constraints);
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(new JLabel("Email:"), constraints);
        constraints.gridx = 1;
        panel.add(emailField, constraints);
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(new JLabel("Course Details:"), constraints);
        constraints.gridx = 1;
        panel.add(courseField, constraints);

        int result = JOptionPane.showConfirmDialog(null, panel, "Add Student", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            int studentId = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            String email = emailField.getText();
            String courseDetails = courseField.getText();

            // Insert the student record into the database using JDBC
            try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                    PreparedStatement statement = connection.prepareStatement(
                            "INSERT INTO student (student_id, name, email, course_details) VALUES (?, ?, ?, ?)")) {
                statement.setInt(1, studentId);
                statement.setString(2, name);
                statement.setString(3, email);
                statement.setString(4, courseDetails);
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Student added successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to add student.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error adding student: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    private void deleteStudent() {
        JTextField idField = new JTextField(10);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Student ID:"));
        panel.add(idField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Delete Student", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            int studentId = Integer.parseInt(idField.getText());

            // Delete the student record from the database using JDBC
            try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                    PreparedStatement statement = connection.prepareStatement("DELETE FROM student WHERE student_id = ?")) {
                statement.setInt(1, studentId);
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Student deleted successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "No student found with the given ID.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error deleting student: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void updateStudent() {
        JTextField idField = new JTextField(10);
        JTextField nameField = new JTextField(50);
        JTextField emailField = new JTextField(100);
        JTextField courseField = new JTextField(100);

        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(new JLabel("Student ID:"));
        panel.add(idField);
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(new JLabel("Course Details:"));
        panel.add(courseField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Update Student", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            int studentId = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            String email = emailField.getText();
            String courseDetails = courseField.getText();

            // Update the student record in the database using JDBC
            try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                    PreparedStatement statement = connection.prepareStatement(
                            "UPDATE student SET name = ?, email = ?, course_details = ? WHERE student_id = ?")) {
                statement.setString(1, name);
                statement.setString(2, email);
                statement.setString(3, courseDetails);
                statement.setInt(4, studentId);
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Student updated successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "No student found with the given ID.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error updating student: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void displayStudents() {
        // Retrieve and display the list of students from the database using JDBC
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM student")) {
            StringBuilder sb = new StringBuilder();
            sb.append("Student ID\tName\tEmail\t\tCourse Details\n");
            while (resultSet.next()) {
                int studentId = resultSet.getInt("student_id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String courseDetails = resultSet.getString("course_details");
                sb.append(studentId).append("\t").append(name).append("\t").append(email).append("\t").append(courseDetails).append("\n");
            }
            JTextArea textArea = new JTextArea(sb.toString());
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(400, 300));
            JOptionPane.showMessageDialog(null, scrollPane, "Student List", JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error retrieving student list: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //Proctor
    private void addProctor() {
        JTextField idField = new JTextField(10);
        JTextField nameField = new JTextField(50);
        JTextField contactField = new JTextField(50);
        JTextField availabilityField = new JTextField(50);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(new JLabel("Proctor ID:"), constraints);
        constraints.gridx = 1;
        panel.add(idField, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(new JLabel("Name:"), constraints);
        constraints.gridx = 1;
        panel.add(nameField, constraints);
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(new JLabel("Contact Details:"), constraints);
        constraints.gridx = 1;
        panel.add(contactField, constraints);
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(new JLabel("Availability:"), constraints);
        constraints.gridx = 1;
        panel.add(availabilityField, constraints);


        int result = JOptionPane.showConfirmDialog(null, panel, "Add Proctor", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            int proctorId = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            String contactDetails = contactField.getText();
            String availability = availabilityField.getText();

            // Insert the proctor record into the database using JDBC
            try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                    PreparedStatement statement = connection.prepareStatement(
                            "INSERT INTO proctor (proctor_id, name, contact_details, availability) VALUES (?, ?, ?, ?)")) {
                statement.setInt(1, proctorId);
                statement.setString(2, name);
                statement.setString(3, contactDetails);
                statement.setString(4, availability);
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Proctor added successfully!");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error adding proctor: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void deleteProctor() {
        JTextField idField = new JTextField(10);

        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(new JLabel("Proctor ID:"));
        panel.add(idField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Delete Proctor", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            int proctorId = Integer.parseInt(idField.getText());

            // Delete the proctor record from the database using JDBC
            try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                    PreparedStatement statement = connection.prepareStatement(
                            "DELETE FROM proctor WHERE proctor_id = ?")) {
                statement.setInt(1, proctorId);
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Proctor deleted successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "No proctor found with the given ID.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error deleting proctor: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void updateProctor() {
        JTextField idField = new JTextField(10);
        JTextField nameField = new JTextField(50);
        JTextField contactField = new JTextField(50);
        JTextField availabilityField = new JTextField(50);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        // Proctor ID label
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(new JLabel("Proctor ID:"), constraints);

        // Proctor ID field
        constraints.gridx = 1;
        panel.add(idField, constraints);

        // Name label
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(new JLabel("Name:"), constraints);

        // Name field
        constraints.gridx = 1;
        panel.add(nameField, constraints);

        // Contact Details label
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(new JLabel("Contact Details:"), constraints);

        // Contact Details field
        constraints.gridx = 1;
        panel.add(contactField, constraints);

        // Availability label
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(new JLabel("Availability:"), constraints);

        // Availability field
        constraints.gridx = 1;
        panel.add(availabilityField, constraints);


        int result = JOptionPane.showConfirmDialog(null, panel, "Update Proctor", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            int proctorId = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            String contactDetails = contactField.getText();
            String availability = availabilityField.getText();

            // Update the proctor record in the database using JDBC
            try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                    PreparedStatement statement = connection.prepareStatement(
                            "UPDATE proctor SET name = ?, contact_details = ?, availability = ? WHERE proctor_id = ?")) {
                statement.setString(1, name);
                statement.setString(2, contactDetails);
                statement.setString(3, availability);
                statement.setInt(4, proctorId);
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Proctor updated successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "No proctor found with the given ID.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error updating proctor: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void displayProctors() {
        // Retrieve and display the list of proctors from the database using JDBC
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM proctor")) {
            StringBuilder sb = new StringBuilder();
            sb.append("Proctor ID\tName\tcontact_details\tavailability\n");
            while (resultSet.next()) {
                int proctorId = resultSet.getInt("proctor_id");
                String name = resultSet.getString("name");
                String course_details = resultSet.getString("contact_details");
                String availability = resultSet.getString("availability");

                sb.append(proctorId).append("\t").append(name).append("\t").append(course_details).append("\t").append(availability).append("\n");
            }
            JTextArea textArea = new JTextArea(sb.toString());
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(400, 300));
            JOptionPane.showMessageDialog(null, scrollPane, "Proctor List", JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error retrieving proctor list: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //Exam
    private void addExam() {
        JTextField idField = new JTextField(10);
        JTextField dateField = new JTextField(10);
        JTextField timeField = new JTextField(10);
        JTextField durationField = new JTextField(10);
        JTextField courseField = new JTextField(50);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        // Exam ID label
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(new JLabel("Exam ID:"), constraints);

        // Exam ID field
        constraints.gridx = 1;
        panel.add(idField, constraints);

        // Date label
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(new JLabel("Date (YYYY-MM-DD):"), constraints);

        // Date field
        constraints.gridx = 1;
        panel.add(dateField, constraints);

        // Time label
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(new JLabel("Time (HH:MM:SS):"), constraints);

        // Time field
        constraints.gridx = 1;
        panel.add(timeField, constraints);

        // Duration label
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(new JLabel("Duration (in minutes):"), constraints);

        // Duration field
        constraints.gridx = 1;
        panel.add(durationField, constraints);

        // Course Details label
        constraints.gridx = 0;
        constraints.gridy = 4;
        panel.add(new JLabel("Course Details:"), constraints);

        // Course Details field
        constraints.gridx = 1;
        panel.add(courseField, constraints);


        int result = JOptionPane.showConfirmDialog(null, panel, "Add Exam", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            int examId = Integer.parseInt(idField.getText());
            String date = dateField.getText();
            String time = timeField.getText();
            int duration = Integer.parseInt(durationField.getText());
            String courseDetails = courseField.getText();

            // Insert the exam record into the database using JDBC
            try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                    PreparedStatement statement = connection.prepareStatement(
                            "INSERT INTO exam (exam_id, date, time, duration, course_details) VALUES (?, ?, ?, ?, ?)")) {
                statement.setInt(1, examId);
                statement.setString(2, date);
                statement.setString(3, time);
                statement.setInt(4, duration);
                statement.setString(5, courseDetails);
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Exam added successfully!");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error adding exam: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void deleteExam() {
        JTextField idField = new JTextField(10);

        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(new JLabel("Exam ID:"));
        panel.add(idField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Delete Exam", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            int examId = Integer.parseInt(idField.getText());

            // Delete the exam record from the database using JDBC
            try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                    PreparedStatement statement = connection.prepareStatement(
                            "DELETE FROM exam WHERE exam_id = ?")) {
                statement.setInt(1, examId);
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Exam deleted successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "No exam found with the given ID.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error deleting exam: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void updateExam() {
        JTextField idField = new JTextField(10);
        JTextField dateField = new JTextField(10);
        JTextField timeField = new JTextField(10);
        JTextField durationField = new JTextField(10);
        JTextField courseField = new JTextField(50);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        // Exam ID label
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(new JLabel("Exam ID:"), constraints);

        // Exam ID field
        constraints.gridx = 1;
        panel.add(idField, constraints);

        // Date label
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(new JLabel("Date (YYYY-MM-DD):"), constraints);

        // Date field
        constraints.gridx = 1;
        panel.add(dateField, constraints);

        // Time label
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(new JLabel("Time (HH:MM:SS):"), constraints);

        // Time field
        constraints.gridx = 1;
        panel.add(timeField, constraints);

        // Duration label
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(new JLabel("Duration (in minutes):"), constraints);

        // Duration field
        constraints.gridx = 1;
        panel.add(durationField, constraints);

        // Course Details label
        constraints.gridx = 0;
        constraints.gridy = 4;
        panel.add(new JLabel("Course Details:"), constraints);

        // Course Details field
        constraints.gridx = 1;
        panel.add(courseField, constraints);


        int result = JOptionPane.showConfirmDialog(null, panel, "Update Exam", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            int examId = Integer.parseInt(idField.getText());
            String date = dateField.getText();
            String time = timeField.getText();
            int duration = Integer.parseInt(durationField.getText());
            String courseDetails = courseField.getText();

            // Update the exam record in the database using JDBC
            try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                    PreparedStatement statement = connection.prepareStatement(
                            "UPDATE exam SET date = ?, time = ?, duration = ?, course_details = ? WHERE exam_id = ?")) {
                statement.setString(1, date);
                statement.setString(2, time);
                statement.setInt(3, duration);
                statement.setString(4, courseDetails);
                statement.setInt(5, examId);
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Exam updated successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "No exam found with the given ID.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error updating exam: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void displayExams() {
        // Fetch and display the exam records from the database using JDBC
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM exam")) {
            StringBuilder sb = new StringBuilder();
            while (resultSet.next()) {
                int examId = resultSet.getInt("exam_id");
                String date = resultSet.getString("date");
                String time = resultSet.getString("time");
                int duration = resultSet.getInt("duration");
                String courseDetails = resultSet.getString("course_details");

                sb.append("Exam ID: ").append(examId).append("\n");
                sb.append("Date: ").append(date).append("\n");
                sb.append("Time: ").append(time).append("\n");
                sb.append("Duration: ").append(duration).append(" minutes\n");
                sb.append("Course Details: ").append(courseDetails).append("\n");
                sb.append("-------------------------\n");
            }

            JTextArea textArea = new JTextArea(sb.toString());
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(400, 300));
            JOptionPane.showMessageDialog(null, scrollPane, "Exam List", JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error fetching exams: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void addExamRules() {
        JTextField idField = new JTextField(10);
        JTextField allowedResourcesField = new JTextField(100);
        JTextField examFormatField = new JTextField(50);
        JTextField examRulesField = new JTextField(100);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        // Rule ID label
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(new JLabel("Rule ID:"), constraints);

        // Rule ID field
        constraints.gridx = 1;
        panel.add(idField, constraints);

        // Allowed Resources label
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(new JLabel("Allowed Resources:"), constraints);

        // Allowed Resources field
        constraints.gridx = 1;
        panel.add(allowedResourcesField, constraints);

        // Exam Format label
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(new JLabel("Exam Format:"), constraints);

        // Exam Format field
        constraints.gridx = 1;
        panel.add(examFormatField, constraints);

        // Exam Rules label
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(new JLabel("Exam Rules:"), constraints);

        // Exam Rules field
        constraints.gridx = 1;
        panel.add(examRulesField, constraints);


        int result = JOptionPane.showConfirmDialog(null, panel, "Add Exam Rules", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            int ruleId = Integer.parseInt(idField.getText());
            String allowedResources = allowedResourcesField.getText();
            String examFormat = examFormatField.getText();
            String examRules = examRulesField.getText();

            // Insert the exam rules record into the database using JDBC
            try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                    PreparedStatement statement = connection.prepareStatement(
                            "INSERT INTO exam_rules (rule_id, allowed_resources, exam_format, exam_rules) VALUES (?, ?, ?, ?)")) {
                statement.setInt(1, ruleId);
                statement.setString(2, allowedResources);
                statement.setString(3, examFormat);
                statement.setString(4, examRules);
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Exam rules added successfully!");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error adding exam rules: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void deleteExamRules() {
        JTextField idField = new JTextField(10);

        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(new JLabel("Rule ID:"));
        panel.add(idField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Delete Exam Rules", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            int ruleId = Integer.parseInt(idField.getText());

            // Delete the exam rules record from the database using JDBC
            try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                    PreparedStatement statement = connection.prepareStatement(
                            "DELETE FROM exam_rules WHERE rule_id = ?")) {
                statement.setInt(1, ruleId);
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Exam rules deleted successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "No exam rules found with the given ID.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error deleting exam rules: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void updateExamRules() {
        JTextField idField = new JTextField(10);
        JTextField allowedResourcesField = new JTextField(100);
        JTextField examFormatField = new JTextField(50);
        JTextField examRulesField = new JTextField(100);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        // Rule ID label
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(new JLabel("Rule ID:"), constraints);

        // Rule ID field
        constraints.gridx = 1;
        panel.add(idField, constraints);

        // Allowed Resources label
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(new JLabel("Allowed Resources:"), constraints);

        // Allowed Resources field
        constraints.gridx = 1;
        panel.add(allowedResourcesField, constraints);

        // Exam Format label
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(new JLabel("Exam Format:"), constraints);

        // Exam Format field
        constraints.gridx = 1;
        panel.add(examFormatField, constraints);

        // Exam Rules label
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(new JLabel("Exam Rules:"), constraints);

        // Exam Rules field
        constraints.gridx = 1;
        panel.add(examRulesField, constraints);


        int result = JOptionPane.showConfirmDialog(null, panel, "Update Exam Rules", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            int ruleId = Integer.parseInt(idField.getText());
            String allowedResources = allowedResourcesField.getText();
            String examFormat = examFormatField.getText();
            String examRules = examRulesField.getText();

            // Update the exam rules record in the database using JDBC
            try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                    PreparedStatement statement = connection.prepareStatement(
                            "UPDATE exam_rules SET allowed_resources = ?, exam_format = ?, exam_rules = ? WHERE rule_id = ?")) {
                statement.setString(1, allowedResources);
                statement.setString(2, examFormat);
                statement.setString(3, examRules);
                statement.setInt(4, ruleId);
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Exam rules updated successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "No exam rules found with the given ID.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error updating exam rules: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void displayExamRules() {
        // Fetch and display the exam rules records from the database using JDBC
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM exam_rules")) {
            StringBuilder sb = new StringBuilder();
            while (resultSet.next()) {
                int ruleId = resultSet.getInt("rule_id");
                String allowedResources = resultSet.getString("allowed_resources");
                String examFormat = resultSet.getString("exam_format");
                String examRules = resultSet.getString("exam_rules");

                sb.append("Rule ID: ").append(ruleId).append("\n");
                sb.append("Allowed Resources: ").append(allowedResources).append("\n");
                sb.append("Exam Format: ").append(examFormat).append("\n");
                sb.append("Exam Rules: ").append(examRules).append("\n");
                sb.append("-------------------------\n");
            }

            JTextArea textArea = new JTextArea(sb.toString());
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(400, 300));
            JOptionPane.showMessageDialog(null, scrollPane, "Exam Rules List", JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error fetching exam rules: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addProctorAssignment() {
        JTextField idField = new JTextField(10);
        JTextField examIdField = new JTextField(10);
        JTextField proctorIdField = new JTextField(10);
        JTextField assignmentDetailsField = new JTextField(100);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        // Assignment ID label
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(new JLabel("Assignment ID:"), constraints);

        // Assignment ID field
        constraints.gridx = 1;
        panel.add(idField, constraints);

        // Exam ID label
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(new JLabel("Exam ID:"), constraints);

        // Exam ID field
        constraints.gridx = 1;
        panel.add(examIdField, constraints);

        // Proctor ID label
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(new JLabel("Proctor ID:"), constraints);

        // Proctor ID field
        constraints.gridx = 1;
        panel.add(proctorIdField, constraints);

        // Assignment Details label
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(new JLabel("Assignment Details:"), constraints);

        // Assignment Details field
        constraints.gridx = 1;
        panel.add(assignmentDetailsField, constraints);


        int result = JOptionPane.showConfirmDialog(null, panel, "Add Proctor Assignment", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            int assignmentId = Integer.parseInt(idField.getText());
            int examId = Integer.parseInt(examIdField.getText());
            int proctorId = Integer.parseInt(proctorIdField.getText());
            String assignmentDetails = assignmentDetailsField.getText();

            // Insert the proctor assignment record into the database using JDBC
            try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                    PreparedStatement statement = connection.prepareStatement(
                            "INSERT INTO proctor_assignment (assignment_id, exam_id, proctor_id, assignment_details) VALUES (?, ?, ?, ?)")) {
                statement.setInt(1, assignmentId);
                statement.setInt(2, examId);
                statement.setInt(3, proctorId);
                statement.setString(4, assignmentDetails);
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Proctor assignment added successfully!");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error adding proctor assignment: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void deleteProctorAssignment() {
        JTextField idField = new JTextField(10);

        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(new JLabel("Assignment ID:"));
        panel.add(idField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Delete Proctor Assignment", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            int assignmentId = Integer.parseInt(idField.getText());

            // Delete the proctor assignment record from the database using JDBC
            try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                    PreparedStatement statement = connection.prepareStatement(
                            "DELETE FROM proctor_assignment WHERE assignment_id = ?")) {
                statement.setInt(1, assignmentId);
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Proctor assignment deleted successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "No proctor assignment found with the given ID.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error deleting proctor assignment: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void updateProctorAssignment() {
        JTextField idField = new JTextField(10);
        JTextField examIdField = new JTextField(10);
        JTextField proctorIdField = new JTextField(10);
        JTextField assignmentDetailsField = new JTextField(100);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        // Assignment ID label
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(new JLabel("Assignment ID:"), constraints);

        // Assignment ID field
        constraints.gridx = 1;
        panel.add(idField, constraints);

        // Exam ID label
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(new JLabel("Exam ID:"), constraints);

        // Exam ID field
        constraints.gridx = 1;
        panel.add(examIdField, constraints);

        // Proctor ID label
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(new JLabel("Proctor ID:"), constraints);

        // Proctor ID field
        constraints.gridx = 1;
        panel.add(proctorIdField, constraints);

        // Assignment Details label
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(new JLabel("Assignment Details:"), constraints);

        // Assignment Details field
        constraints.gridx = 1;
        panel.add(assignmentDetailsField, constraints);


        int result = JOptionPane.showConfirmDialog(null, panel, "Update Proctor Assignment", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            int assignmentId = Integer.parseInt(idField.getText());
            int examId = Integer.parseInt(examIdField.getText());
            int proctorId = Integer.parseInt(proctorIdField.getText());
            String assignmentDetails = assignmentDetailsField.getText();

            // Update the proctor assignment record in the database using JDBC
            try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                    PreparedStatement statement = connection.prepareStatement(
                            "UPDATE proctor_assignment SET exam_id = ?, proctor_id = ?, assignment_details = ? WHERE assignment_id = ?")) {
                statement.setInt(1, examId);
                statement.setInt(2, proctorId);
                statement.setString(3, assignmentDetails);
                statement.setInt(4, assignmentId);
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Proctor assignment updated successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "No proctor assignment found with the given ID.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error updating proctor assignment: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void displayProctorAssignments() {
        // Fetch and display the proctor assignment records from the database using JDBC
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM proctor_assignment")) {
            StringBuilder sb = new StringBuilder();
            while (resultSet.next()) {
                int assignmentId = resultSet.getInt("assignment_id");
                int examId = resultSet.getInt("exam_id");
                int proctorId = resultSet.getInt("proctor_id");
                String assignmentDetails = resultSet.getString("assignment_details");

                sb.append("Assignment ID: ").append(assignmentId).append("\n");
                sb.append("Exam ID: ").append(examId).append("\n");
                sb.append("Proctor ID: ").append(proctorId).append("\n");
                sb.append("Assignment Details: ").append(assignmentDetails).append("\n");
                sb.append("-------------------------\n");
            }

            JTextArea textArea = new JTextArea(sb.toString());
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(400, 300));
            JOptionPane.showMessageDialog(null, scrollPane, "Proctor Assignments List", JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error fetching proctor assignments: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addExamResults() {
        JTextField idField = new JTextField(10);
        JTextField examIdField = new JTextField(10);
        JTextField studentIdField = new JTextField(10);
        JTextField marksField = new JTextField(10);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        // Result ID label
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(new JLabel("Result ID:"), constraints);

        // Result ID field
        constraints.gridx = 1;
        panel.add(idField, constraints);

        // Exam ID label
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(new JLabel("Exam ID:"), constraints);

        // Exam ID field
        constraints.gridx = 1;
        panel.add(examIdField, constraints);

        // Student ID label
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(new JLabel("Student ID:"), constraints);

        // Student ID field
        constraints.gridx = 1;
        panel.add(studentIdField, constraints);

        // Marks label
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(new JLabel("Marks:"), constraints);

        // Marks field
        constraints.gridx = 1;
        panel.add(marksField, constraints);


        int result = JOptionPane.showConfirmDialog(null, panel, "Add Exam Results", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            int resultId = Integer.parseInt(idField.getText());
            int examId = Integer.parseInt(examIdField.getText());
            int studentId = Integer.parseInt(studentIdField.getText());
            int marks = Integer.parseInt(marksField.getText());

            // Insert the exam results record into the database using JDBC
            try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                    PreparedStatement statement = connection.prepareStatement(
                            "INSERT INTO exam_results (result_id, exam_id, student_id, marks) VALUES (?, ?, ?, ?)")) {
                statement.setInt(1, resultId);
                statement.setInt(2, examId);
                statement.setInt(3, studentId);
                statement.setInt(4, marks);
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Exam results added successfully!");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error adding exam results: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void deleteExamResults() {
        JTextField idField = new JTextField(10);

        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(new JLabel("Result ID:"));
        panel.add(idField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Delete Exam Results", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            int resultId = Integer.parseInt(idField.getText());

            // Delete the exam results record from the database using JDBC
            try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                    PreparedStatement statement = connection.prepareStatement(
                            "DELETE FROM exam_results WHERE result_id = ?")) {
                statement.setInt(1, resultId);
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Exam results deleted successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "No exam results found with the given ID.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error deleting exam results: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void updateExamResults() {
        JTextField idField = new JTextField(10);
        JTextField examIdField = new JTextField(10);
        JTextField studentIdField = new JTextField(10);
        JTextField marksField = new JTextField(10);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        // Result ID label
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(new JLabel("Result ID:"), constraints);

        // Result ID field
        constraints.gridx = 1;
        panel.add(idField, constraints);

        // Exam ID label
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(new JLabel("Exam ID:"), constraints);

        // Exam ID field
        constraints.gridx = 1;
        panel.add(examIdField, constraints);

        // Student ID label
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(new JLabel("Student ID:"), constraints);

        // Student ID field
        constraints.gridx = 1;
        panel.add(studentIdField, constraints);

        // Marks label
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(new JLabel("Marks:"), constraints);

        // Marks field
        constraints.gridx = 1;
        panel.add(marksField, constraints);

        int result = JOptionPane.showConfirmDialog(null, panel, "Update Exam Results", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            int resultId = Integer.parseInt(idField.getText());
            int examId = Integer.parseInt(examIdField.getText());
            int studentId = Integer.parseInt(studentIdField.getText());
            int marks = Integer.parseInt(marksField.getText());

            // Update the exam results record in the database using JDBC
            try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                    PreparedStatement statement = connection.prepareStatement(
                            "UPDATE exam_results SET exam_id = ?, student_id = ?, marks = ? WHERE result_id = ?")) {
                statement.setInt(1, examId);
                statement.setInt(2, studentId);
                statement.setInt(3, marks);
                statement.setInt(4, resultId);
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Exam results updated successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "No exam results found with the given ID.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error updating exam results: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void displayExamResults() {
        // Fetch and display the exam results records from the database using JDBC
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM exam_results")) {
            StringBuilder sb = new StringBuilder();
            while (resultSet.next()) {
                int resultId = resultSet.getInt("result_id");
                int examId = resultSet.getInt("exam_id");
                int studentId = resultSet.getInt("student_id");
                int marks = resultSet.getInt("marks_obtained");
                String Performance = resultSet.getString("other_details");

                sb.append("Result ID: ").append(resultId).append("\n");
                sb.append("Exam ID: ").append(examId).append("\n");
                sb.append("Student ID: ").append(studentId).append("\n");
                sb.append("Marks: ").append(marks).append("\n");
                sb.append("Performance: ").append(Performance).append("\n");
                sb.append("-------------------------\n");
            }

            JTextArea textArea = new JTextArea(sb.toString());
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(400, 300));
            JOptionPane.showMessageDialog(null, scrollPane, "Exam Results List", JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error fetching exam results: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void displayExamRegistration() {
        // Fetch and display the exam results records from the database using JDBC
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM exam_registration")) {
            StringBuilder sb = new StringBuilder();
            while (resultSet.next()) {
                
                int examId = resultSet.getInt("exam_id");
                int studentId = resultSet.getInt("student_id");

                sb.append("Exam ID: ").append(examId).append("\n");
                sb.append("Student ID: ").append(studentId).append("\n");
                sb.append("-------------------------\n");
            }

            JTextArea textArea = new JTextArea(sb.toString());
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(400, 300));
            JOptionPane.showMessageDialog(null, scrollPane, "Exam Registraion List", JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error fetching exam registrations: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }





    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ProctorialManagementSystem().setVisible(true);
            }
        });
    }
}
