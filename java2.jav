private void startQuiz() {
        timer.start();
        students.clear();
        outputTextArea.setText("");

        int numStudents;
        try {
            numStudents = Integer.parseInt(numStudentsField.getText());
        } catch (NumberFormatException e) {
            outputTextArea.append("Invalid number of students.\n");
            return;
        }

        for (int i = 0; i < numStudents; i++) {
            String name = JOptionPane.showInputDialog("Enter name for Student " + (i + 1) + ":");
            int rollNo;
            int phoneNo;
            try {
                rollNo = Integer.parseInt(JOptionPane.showInputDialog("Enter roll number for Student " + (i + 1) + ":"));
                phoneNo = Integer.parseInt(JOptionPane.showInputDialog("Enter phone number for Student " + (i + 1) + ":"));
            } catch (NumberFormatException ex) {
                outputTextArea.append("Invalid roll number or phone number for Student " + (i + 1) + ". Please enter a valid integer.\n");
                continue;
            }
            String email = JOptionPane.showInputDialog("Enter email for Student " + (i + 1) + ":");

            students.add(new Student(name, rollNo, email, phoneNo));

            int choice = subjectComboBox.getSelectedIndex();

            switch (choice) {
                case 0:
                    askQuestionsDSA(students.get(i));
                    break;
                case 1:
                    askQuestionsJava(students.get(i));
                    break;
                case 2:
                    askQuestionsPython(students.get(i));
                    break;
                default:
                    outputTextArea.append("Invalid choice.\n");
                    break;
            }
        }
        
        // Display scoreboard immediately after all questions are answered
        displayScoreboard();
    }
