package my.test;

//Creating the quesiton object class
public class Question {
    //All the question attributes
    private String question = "";
    private String answerA = "";
    private String answerB = "";
    private String answerC = "";
    private String answerD = "";
    private String correctAnswer = "";

    //Constructor
    Question(String q, String a, String b, String c, String d, String ca){
        //Setting the attributes
        question = q;
        answerA = a;
        answerB = b;
        answerC = c;
        answerD = d;
        correctAnswer = ca;
    }

    //Overloaded constructor
    Question(){}

    //Function to get the questions
    public String getQuestion(){
        return question;
    }

    //Function to get AnswerA
    public String getAnswerA(){
        return answerA;
    }

    //Function to get AnswerB
    public String getAnswerB(){
        return answerB;
    }

    //Function to get AnswerC
    public String getAnswerC(){
        return answerC;
    }

    //Function to get AnswerD
    public String getAnswerD(){
        return answerD;
    }

    //Functoin to get the CorrectAnswer
    public String getCorrectAnswer(){
        return correctAnswer;
    }

    //Function to set the questions
    public void setQuestion(String q){
        question = q;
    }

    //Function to set AnswerA
    public void setAnswerA(String a){
        answerA = a;
    }

    //Function to set AnswerB
    public void setAnswerB(String b){
        answerB = b;
    }

    //Function to set AnswerC
    public void setAnswerC(String c){
        answerC = c;
    }

    //Function to set AnswerD
    public void setAnswerD(String d){
        answerD = d;
    }

    //Function to set CorrectAnswer
    public void setCorrectAnswer(String ca){
        correctAnswer = ca;
    }

}