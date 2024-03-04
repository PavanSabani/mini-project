import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuizApp extends JFrame {
    private JTextField numStudentsField;
    private JComboBox<String> subjectComboBox;
    private JTextArea outputTextArea;
    private JLabel timerLabel;

    private List<Student> students;
    private Timer timer;
    private int timeRemaining = 600; // 10 minutes in seconds

    public QuizApp() {
        setTitle("Quiz Program");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(6, 2, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel numStudentsLabel = new JLabel("Number of students:");
        numStudentsField = new JTextField();
        mainPanel.add(numStudentsLabel);
        mainPanel.add(numStudentsField);

        JLabel subjectLabel = new JLabel("Select subject:");
        String[] subjects = {"DSA", "Java", "Python"};
        subjectComboBox = new JComboBox<>(subjects);
        mainPanel.add(subjectLabel);
        mainPanel.add(subjectComboBox);

        JButton startButton = new JButton("Start Quiz");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startQuiz();
            }
        });
        mainPanel.add(startButton);

        timerLabel = new JLabel("Time Remaining: 10:00");
        mainPanel.add(timerLabel);

        outputTextArea = new JTextArea();
        outputTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputTextArea);
        mainPanel.add(scrollPane);

        add(mainPanel);

        students = new ArrayList<>();

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (timeRemaining > 0) {
                    timeRemaining--;
                    int minutes = timeRemaining / 60;
                    int seconds = timeRemaining % 60;
                    timerLabel.setText("Time Remaining: " + String.format("%02d:%02d", minutes, seconds));
                } else {
                    timer.stop();
                    startButton.setEnabled(false);
                    outputTextArea.append("\nTime's up! Quiz ended.\n");
                    displayScoreboard();
                }
            }
        });
    }
