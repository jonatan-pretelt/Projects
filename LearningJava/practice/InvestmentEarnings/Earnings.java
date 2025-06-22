import java.util.Scanner;
import java.text.DecimalFormat;

class Earnings {

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.00");
        double initialSharePrice = 0.0;
        double closingPrice = 0.0;
        double earnings = 0.0;
        int day = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the initial share price you bought at? ");
        initialSharePrice = sc.nextDouble();
        
        
        while (true) {
            System.out.println("What is day " + day + " closing price of the share? (Enter negative number to quit.) ");
            closingPrice = sc.nextDouble();

            if(closingPrice < 0) break;

            earnings = closingPrice - initialSharePrice;

            if(earnings > 0.0){
                System.out.println("After day " + day + " your earnings are " + df.format(earnings) + " per share");
            } else if(earnings < 0.0){
                System.out.println("After day " + day + " you lost " + df.format(-earnings) + " per share");
            }else{
                System.out.println("There are no earnings. ");
            }
            day++;
        }

        sc.close();
    }

}
