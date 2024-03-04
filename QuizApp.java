 private void createScoreboardFile(List<Student> students) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("scoreboard.txt"))) {
            bufferedWriter.write("Scoreboard:\n");
            int rank = 1;
            for (Student student : students) {
                bufferedWriter.write("Rank " + rank++ + ":\n");
                bufferedWriter.write("Name: " + student.name + "\n");
                bufferedWriter.write("Roll No: " + student.rollNo + "\n");
                bufferedWriter.write("Email: " + student.email + "\n");
                bufferedWriter.write("Phone No: " + student.phoneNo + "\n");
                bufferedWriter.write("Score: " + student.score + "/" + getTotalQuestions(subjectComboBox.getSelectedIndex()) + "\n\n");
            }

            outputTextArea.append("\nScoreboard file created successfully!\n");
        } catch (IOException e) {
            outputTextArea.append("An error occurred while creating the scoreboard file: " + e.getMessage() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new QuizApp().setVisible(true));
    }

    static class Student {
        String name;
        int rollNo;
        String email;
        int phoneNo;
        int score;

        public Student(String name, int rollNo, String email, int phoneNo) {
            this.name = name;
            this.rollNo = rollNo;
            this.email = email;
            this.phoneNo = phoneNo;
            this.score = 0;
        }
    }
}
