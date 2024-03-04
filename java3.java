 private void askQuestionsDSA(Student student) {
        String[][] questions = {
                {"What is the result of the following operation TOP(push(S,X)) ?", "A) X", "B) X+S", "C) S ", "D) XS", "A"},
                {"Which data structure is needed to convert infix to postfix notation", "A) Branch", "B) Tree", "C) Queue", "D) Stack", "D"},
                {"What is the time complexity of searching in a binary search tree?", "A) O(n)", "B) O(log n)", "C) O(1)", "D) O(n log n)", "B"},
                {"postfix form of A*B+C/D is ?", "A) *AB/CD+", "B) AB*CD/+", "C) A*BC+/D ", "D) ABCD+/*", "B"},
                {"If the sequence of operation - push(1), push(2), pop(), push(1), pop(), pop(), pop(), push(2), pop() are performed, the sequence of popped out values?", "A) 2,2,1,1,2", "B) 2,2,1,2,2", "C) 2,1,2,2,1 ", "D) 2,1,2,2,2", "A"},
                {"Which of the following is a linear data structure?", "A) Array", "B)AVL TREE ", "C) graph ", "D) binary tree", "A"},
                {"When a pop() operation is called on an empty queue, what is the condition called?", "A) overflow", "B)underflow ", "C) syntax error ", "D) garbabge value", "B"},
                {"Which of the following data structures can be used to implement queues?", "A) array", "B)linked list ", "C) Stack ", "D) all of the above", "D"},
                {"Which of the following data structures finds its use in recursion?", "A) Queue", "B)Stack ", "C) linked list ", "D) array", "B"},
                {"What is the maximum number of swaps that can be performed in the Selection Sort algorithm?", "A) n-1", "B)n ", "C) n-2 ", "D) 1", "A"}
        };
        askQuestions("DSA", questions, student);
    }

    private void askQuestionsJava(Student student) {
        String[][] questions = {
                {"What is a constructor in Java?", "A) A method used to destroy objects", "B) A special method invoked when an object is instantiated", "C) A method used to initialize objects", "D) A method used to compare objects", "B"},
                {"What is method overloading?", "A) Having multiple methods in the same class with different names", "B) Having multiple methods in the same class with the same name but different parameters", "C) Having multiple methods in different classes with the same name and parameters", "D) Having multiple classes with the same method", "B"},
                {"What is the difference between == and equals() method in Java?", "A) == compares references, equals() compares contents", "B) Both compare references", "C) Both compare contents", "D) == compares contents, equals() compares references", "A"},
                {"What is the output of the following code?\n\npublic class Main {\n    public static void main(String[] args) {\n        int x = 5;\n        System.out.println(x++);\n        System.out.println(++x);\n    }\n}", "A) 5 6", "B) 6 7", "C) 5 5", "D) 6 6", "B"},
                {"Which keyword is used to prevent method overriding in Java?", "A) final", "B) static", "C) abstract", "D) const", "A"},
                {"NUMBER of primitive data types in java", "A) 6", "B) 7", "C)8", "D) 9", "C"},
                {"What is the size of float and double in JAVA ?", "A) 32&64", "B) 32&32", "C) 64&64", "D) 64&32", "A"},
                {"automatic type conoversion is possible in which of the following case", "A) byte to int ", "B) int to long", "C) long to int ", "D) short to int ", "B"},
                {"select the valid statement", "A) char[] ch=new char(5)", "B) char[] ch=new char[5]", "C) char[] ch=new char()", "D)  char[] ch=new char[]", "B"}
        };
        askQuestions("Java", questions, student);
    }

    private void askQuestionsPython(Student student) {
        String[][] questions = {
                {"What is PEP 8 in Python?", "A) Python Enhancement Proposal", "B) Python Extension Pack", "C) Python Editor Plugin", "D) Style guide for Python code", "D"},
                {"What are dictionaries in Python?", "A) A collection of elements stored in a sequence", "B) A collection of key-value pairs", "C) A collection of unique elements", "D) A collection of elements with random access", "B"},
                {"What is a list comprehension in Python?", "A) A way to filter elements from a list", "B) A concise way to create lists", "C) A way to perform arithmetic operations on lists", "D) A way to sort lists", "B"},
                {"What is the output of the following code?\n\na = [1, 2, 3]\nprint(a[3])", "A) 1", "B) 2", "C) 3", "D) IndexError", "D"},
                {"What is the output of the following code?\n\nd = {0: 'a', 1: 'b', 2: 'c'}\nprint(d.get(3, 'default'))", "A) 'a'", "B) 'b'", "C) 'c'", "D) 'default'", "D"},
                {"What is the output of the following code?\n\nx = 10\nif x > 5:\n    print('Hello')\nelse:\n    print('Hi')\nprint('End')", "A) Hello\nEnd", "B) Hi\nEnd", "C) Hello", "D) Hi", "A"},
                {"What is the purpose of the '__init__' method in Python?", "A) To initialize the class variables", "B) To initialize an object of the class", "C) To define class methods", "D) To destroy an object of the class", "B"},
                {"Which of the following is an immutable data type in Python?", "A) List", "B) Dictionary", "C) Tuple", "D) Set", "C"},
                {"What is the output of the following code?\n\ns = 'hello'\nprint(s[1:3])", "A) 'he'", "B) 'el'", "C) 'lo'", "D) 'ell'", "B"},
                {"What is the output of the following code?\n\nprint(type(10/2))", "A) int", "B) float", "C) str", "D) Error", "B"}
        };
        askQuestions("Python", questions, student);
    }

    private void askQuestions(String subject, String[][] questions, Student student) {
        outputTextArea.append("\nAnswer the following questions, " + student.name + ":\n");

        int score = 0;
        for (String[] q : questions) {
            outputTextArea.append("\nQuestion: " + q[0] + "\n");
            for (int i = 1; i < q.length - 1; i++) {
                outputTextArea.append(q[i] + "\n");
            }
            String answer = JOptionPane.showInputDialog("Your answer (A, B, C, or D):").toUpperCase();

            if (answer.equals(q[q.length - 1])) {
                outputTextArea.append("Correct!\n");
                score++;
            } else {
                outputTextArea.append("Incorrect. The correct answer is: " + q[q.length - 1] + "\n");
            }
        }

        student.score = score;
        outputTextArea.append("\nQuiz for " + subject + " completed for " + student.name + "\n");
    }

    private void displayScoreboard() {
        outputTextArea.append("\nScoreboard:\n");
        students.sort((s1, s2) -> s2.score - s1.score);

        int rank = 1;
        for (Student student : students) {
            outputTextArea.append("Rank " + rank++ + ":\n");
            outputTextArea.append("Name: " + student.name + "\n");
            outputTextArea.append("Roll No: " + student.rollNo + "\n");
            outputTextArea.append("Email: " + student.email + "\n");
            outputTextArea.append("Phone No: " + student.phoneNo + "\n");
            outputTextArea.append("Score: " + student.score + "/" + getTotalQuestions(subjectComboBox.getSelectedIndex()) + "\n\n");
        }

        createScoreboardFile(students);
    }

    private int getTotalQuestions(int subjectIndex) {
        switch (subjectIndex) {
            case 0: return 10; // DSA
            case 1: return 9; // Java
            case 2: return 10; // Python
            default: return 0;
        }
    }
