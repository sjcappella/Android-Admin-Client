package my.test;

import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

//Class to edit/create test questions
public class testUI5 extends javax.swing.JFrame {

    //Attributes
    private BufferedReader in;
    private PrintWriter out;
    private ArrayList<Question> test = new ArrayList<Question>();
    private JFrame frame = new JFrame();
    private String testName = "";
    private int numberOfQuestions = 0;
    private int currentQuestion;
    private boolean updateTest = false;

    //Constructor for creating new test
    public testUI5(BufferedReader inReader, PrintWriter outWrite, String testName, int numberOfQuestions){
        //Initialize components
        initComponents();
        in = inReader;
        out = outWrite;
        this.testName = testName;
        this.numberOfQuestions = numberOfQuestions;
        currentQuestion = 0;

        //Initialize test
        for(int x = 0; x < numberOfQuestions; x++){
            Question question = new Question();
            test.add(question);
        }

        //Set the label for the question number we are on
        questionNumberLabel.setText("Question # " + (currentQuestion+1));
        testNameLabel.setText(testName);
        //Change next button to submit if there is only 1 question
        if(numberOfQuestions == 1){
            nextButton.setText("SUMBIT");
        }
    }

    //Constructor for updating an existing test
    public testUI5(BufferedReader inReader, PrintWriter outWrite, String testName){
        //Initialize components
        initComponents();
        this.testName = testName;
        in = inReader;
        out = outWrite;
        currentQuestion = 0;
        updateTest = true;

        //Get test from the server
        out.println("LOAD_TEST");
        out.flush();
        out.println(testName);
        out.flush();
        try{
            //Get number of questions
            numberOfQuestions = Integer.parseInt(in.readLine());
            if(numberOfQuestions == 0){
                //Error loading the test
                JOptionPane.showMessageDialog(this, "There was an error loading the test!", "Error!", JOptionPane.ERROR_MESSAGE);
                testUI2 newScreen = new testUI2(in, out);
                newScreen.setLocation(this.getX(), this.getY());
                this.setVisible(true);
                newScreen.setVisible(true);
            }else{
                //Creating question variable fields
                String question;
                String answerA;
                String answerB;
                String answerC;
                String answerD;
                String correctAnswer;
                //Read in the information from server and set question fields
                for(int x = 0; x < numberOfQuestions; x++){
                    try{
                        question = in.readLine();
                        answerA = in.readLine();
                        answerB = in.readLine();
                        answerC = in.readLine();
                        answerD = in.readLine();
                        correctAnswer = in.readLine();
                        //Create new question object
                        Question questionObject = new Question(question, answerA, answerB, answerC, answerD, correctAnswer);
                        //Add question to the test
                        test.add(questionObject);
                    }catch(Exception e){
                        //Handle the error
                    }
                }

                //Set the initial values of the text boxes and labels
                testNameLabel.setText(testName);
                questionNumberLabel.setText("Question # " + (currentQuestion+1));
                questionField.setText(test.get(currentQuestion).getQuestion());
                answerAField.setText(test.get(currentQuestion).getAnswerA());
                answerBField.setText(test.get(currentQuestion).getAnswerB());
                answerCField.setText(test.get(currentQuestion).getAnswerC());
                answerDField.setText(test.get(currentQuestion).getAnswerD());
                answerDropDownBox.setSelectedItem(test.get(currentQuestion).getCorrectAnswer());

            }

        }catch(Exception e){
            //Handle the error
        }
        //If there is only 1 question, next button is changed to submit button
        if(test.size() == 1){
            nextButton.setText("SUMBIT");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        questionLabel = new javax.swing.JLabel();
        answerALabel = new javax.swing.JLabel();
        answerBLabel = new javax.swing.JLabel();
        answerCLabel = new javax.swing.JLabel();
        answerDLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nextButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        answerDropDownBox = new javax.swing.JComboBox();
        answerDField = new javax.swing.JTextField();
        answerCField = new javax.swing.JTextField();
        answerBField = new javax.swing.JTextField();
        answerAField = new javax.swing.JTextField();
        questionField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        questionNumberLabel = new javax.swing.JLabel();
        testNameLabel = new javax.swing.JLabel();

        jLabel3.setText("TEST MANAGEMENT CONSOLE");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        questionLabel.setText("QUESTION:");

        answerALabel.setText("ANSWER A:");

        answerBLabel.setText("ANSWER B:");

        answerCLabel.setText("ANSWER C:");

        answerDLabel.setText("ANSWER D:");

        jLabel7.setText("ANSWER:");

        nextButton.setText("NEXT");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        answerDropDownBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "B", "C", "D" }));
        answerDropDownBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answerDropDownBoxActionPerformed(evt);
            }
        });

        answerAField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answerAFieldActionPerformed(evt);
            }
        });

        questionField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionFieldActionPerformed(evt);
            }
        });

        jLabel8.setText("TEST MANAGEMENT CONSOLE");

        questionNumberLabel.setText("Question # ");

        testNameLabel.setText("Test Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(jLabel8)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(answerCLabel)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(answerDLabel))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(questionLabel)
                                        .addComponent(answerBLabel)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(answerDField)
                                    .addComponent(answerDropDownBox, 0, 181, Short.MAX_VALUE)
                                    .addComponent(answerCField, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(answerBField, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(answerALabel)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(answerAField)
                                    .addComponent(questionField, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(backButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 307, Short.MAX_VALUE)
                        .addComponent(nextButton)))
                .addGap(14, 14, 14))
            .addGroup(layout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(questionNumberLabel)
                    .addComponent(testNameLabel))
                .addContainerGap(202, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(testNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(questionNumberLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(questionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(questionLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(answerAField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(answerALabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(answerBField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(answerBLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(answerCField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(answerCLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(answerDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(answerDLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(answerDropDownBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(nextButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//Function to set the name and number of questions for a test
public void setTestDetails(String name, int number){
    testName = name;
    numberOfQuestions = number;
}

//Function to submit test to server
private boolean submitTest(){
    String serverResult;
    //If updating test, send update command
    if(updateTest){
        out.println("UPDATE_TEST");
        out.flush();
        out.println(numberOfQuestions);
        out.flush();
        out.println(testName);
        out.flush();
    }else{
        out.println("ADD_NEW_TEST");
        out.flush();
        out.println(numberOfQuestions);
        out.flush();
        out.println(testName);
        out.flush();
    }
    //For every question in the test, send each of its fields to the server
    for(int x = 0; x < test.size(); x++){
        out.println(test.get(x).getQuestion());
        out.flush();
        out.println(test.get(x).getAnswerA());
        out.flush();
        out.println(test.get(x).getAnswerB());
        out.flush();
        out.println(test.get(x).getAnswerC());
        out.flush();
        out.println(test.get(x).getAnswerD());
        out.flush();
        out.println(test.get(x).getCorrectAnswer());
        out.flush();
    }
    //Check for success of submissoin
    try{
        serverResult = in.readLine();
        if(serverResult.equals("TEST_ADD_SUCCESSFUL") || (serverResult.equals("TEST_UPDATE_SUCCESSFUL"))){
            //Success
            return true;
        }else{
            //Failure
            return false;
        }
    }catch(Exception e){
        //Handle the error
        return false;
    }
}

//Next button to go to next question
private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
    //Before moving to next question, store all the current questions information
    String question = questionField.getText();
    String answerA = answerAField.getText();
    String answerB = answerBField.getText();
    String answerC = answerCField.getText();
    String answerD = answerDField.getText();
    String correctAnswer = answerDropDownBox.getSelectedItem().toString();
    //Making sure nothing is empty
    if(question.isEmpty() || answerA.isEmpty() || answerB.isEmpty() || answerC.isEmpty() || answerD.isEmpty() || correctAnswer.isEmpty()){
        JOptionPane.showMessageDialog(frame, "You left a field empty!", "Error!", JOptionPane.ERROR_MESSAGE);
    }else{
        //Create a new question object with the gathered information
        Question questionObject = new Question(question, answerA, answerB, answerC, answerD, correctAnswer);
        //Replace the question in the test at the current index
        test.set(currentQuestion, questionObject);
        //At the end of the test so we will submit it
        if(currentQuestion == (numberOfQuestions-1)){
            //Submit
            int answer = JOptionPane.showConfirmDialog(this, "Would you like to submit this test to the server?", "Submit Test?", JOptionPane.YES_NO_OPTION);
            //Yes = 0, No = 1
            if(answer == 0){
                if(submitTest()){
                    //Success
                    JOptionPane.showMessageDialog(this, "Your test was successfully submitted to the server!", "Success!", JOptionPane.INFORMATION_MESSAGE);
                    testUI2 newScreen = new testUI2(in, out);
                    newScreen.setLocation(this.getX(), this.getY());
                    this.setVisible(false);
                    newScreen.setVisible(true);
                }else{
                    //Failure
                    JOptionPane.showMessageDialog(this, "There was an error submitting your test to the server!", "Error!", JOptionPane.ERROR_MESSAGE);
                    testUI2 newScreen = new testUI2(in, out);
                    newScreen.setLocation(this.getX(), this.getY());
                    this.setVisible(false);
                    newScreen.setVisible(true);
                }
            }
        //Move to the next question
        }else{
            //Increase the question index
            currentQuestion++;
            //Set all the fields for that question
            questionNumberLabel.setText("Question # " + (currentQuestion+1));
            questionField.setText(test.get(currentQuestion).getQuestion());
            answerAField.setText(test.get(currentQuestion).getAnswerA());
            answerBField.setText(test.get(currentQuestion).getAnswerB());
            answerCField.setText(test.get(currentQuestion).getAnswerC());
            answerDField.setText(test.get(currentQuestion).getAnswerD());
            //Default answer of A
            if(test.get(currentQuestion).getCorrectAnswer().isEmpty()){
                answerDropDownBox.setSelectedItem("A");
            }else{
                answerDropDownBox.setSelectedItem(test.get(currentQuestion).getCorrectAnswer());
            }
            //If we are at the last question now, next button turns into submit
            if(currentQuestion == (numberOfQuestions-1)){
                nextButton.setText("SUBMIT");
            }
        }
    }
}//GEN-LAST:event_nextButtonActionPerformed

private void answerDropDownBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answerDropDownBoxActionPerformed
// TODO add your handling code here:

}//GEN-LAST:event_answerDropDownBoxActionPerformed

//Button to go back to previous questions
private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
    //At the beginning of the test already
    if(currentQuestion == 0){
        JOptionPane.showMessageDialog(frame, "This is the first question of the test!", "Error!", JOptionPane.ERROR_MESSAGE);
    }else{
        //Save all the current information of the questions
        String question = questionField.getText();
        String answerA = answerAField.getText();
        String answerB = answerBField.getText();
        String answerC = answerCField.getText();
        String answerD = answerDField.getText();
        String correctAnswer = answerDropDownBox.getSelectedItem().toString();
        //Make sure nothing is blank
        if(question.isEmpty() || answerA.isEmpty() || answerB.isEmpty() || answerC.isEmpty() || answerD.isEmpty() || correctAnswer.isEmpty()){
            JOptionPane.showMessageDialog(this, "You left a field empty!", "Error!", JOptionPane.ERROR_MESSAGE);
        }else{
            //Create a new question object with the saved information
            Question questionObject = new Question(question, answerA, answerB, answerC, answerD, correctAnswer);
            test.set(currentQuestion, questionObject);
            //Decrease the question indext
            currentQuestion--;
            //Set the fields for the previous question and display
            questionNumberLabel.setText("Question # " + (currentQuestion+1));
            questionField.setText(test.get(currentQuestion).getQuestion());
            answerAField.setText(test.get(currentQuestion).getAnswerA());
            answerBField.setText(test.get(currentQuestion).getAnswerB());
            answerCField.setText(test.get(currentQuestion).getAnswerC());
            answerDField.setText(test.get(currentQuestion).getAnswerD());
            answerDropDownBox.setSelectedItem(test.get(currentQuestion).getCorrectAnswer());
            //If the next button was on submit, it will now be a next
            nextButton.setText("NEXT");
        }
    }
}//GEN-LAST:event_backButtonActionPerformed

private void answerAFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answerAFieldActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_answerAFieldActionPerformed

private void questionFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionFieldActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_questionFieldActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(testUI5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(testUI5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(testUI5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(testUI5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() 
            {
    
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField answerAField;
    private javax.swing.JLabel answerALabel;
    private javax.swing.JTextField answerBField;
    private javax.swing.JLabel answerBLabel;
    private javax.swing.JTextField answerCField;
    private javax.swing.JLabel answerCLabel;
    private javax.swing.JTextField answerDField;
    private javax.swing.JLabel answerDLabel;
    private javax.swing.JComboBox answerDropDownBox;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JButton nextButton;
    private javax.swing.JTextField questionField;
    private javax.swing.JLabel questionLabel;
    private javax.swing.JLabel questionNumberLabel;
    private javax.swing.JLabel testNameLabel;
    // End of variables declaration//GEN-END:variables
}
