import java.util.Scanner;

public class QuestionService {
    
    Question[] questions = new Question[5];
    String[] playerChoices = new String[5];

    public QuestionService()
    {
        questions[0] = new Question(
            1,"Founded in 1995", "A: Java", "B: Cpp","C: python", "D: JS",
            "A"
        );
        questions[1] = new Question(
            2,"size of int", "A: 2", "B: 6","C: 4", "D: 8",
            "C"
        );
        questions[2] = new Question(
            3,"size of double", "A: 2", "B: 6","C: 4", "D: 8",
            "D"
        );
        questions[3] = new Question(
            4,"size of char", "A: 2", "B: 8","C: 6", "D: 4",
            "A"
        );
        questions[4] = new Question(
            5,"size of boolean", "A: 2", "B: 4","C: 1", "D: 8",
            "C"
        );
    }

    public void playQuiz()
    {   
        int i = 0;
        for(Question question : questions)
        {   
            System.out.println("Question: " + question.getId());
            System.out.println(question.getQuestion());
            System.out.println(
                question.getOpt1() + "\n" +
                question.getOpt2() + "\n" +
                question.getOpt3() + "\n" +
                question.getOpt4() + "\n"
            );

            System.out.println("What is your answer? ");
            Scanner sc = new Scanner(System.in);
            playerChoices[i] = sc.nextLine();
            i++;
           

            System.out.println("\n");

            
    
        }

        i = 1;
        System.out.println("Your answers were: ");
        for(String choice : playerChoices){
            System.out.println(i + " " + choice);
            i++;
        }
    }

    public void displayScore()
    {   
        int score = 0;
        for(int i=0;i<questions.length;i++)
        {
            if(playerChoices[i].equals(questions[i].getAns()))
            {
                score++;
            }
        }

        System.out.println("Your Score: " + score);
    }
}
