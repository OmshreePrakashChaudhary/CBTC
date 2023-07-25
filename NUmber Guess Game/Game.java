import java.util.*;
import javax.swing.*;
import java.awt.*;
class Game1{
    public static int number,i,input;
    public static int attempts=0,limit=7,score=0,points=0;

    Game1(){
        Random r=new Random();
        number=r.nextInt(100);
        
        
    }
    static void getAttempts(){
        
        System.out.println("Total Attempts: "+attempts);
    }
    static void getScore(){
        System.out.println("Total Score: "+score);
    }
    static void getPoints(){
        System.out.println("Total Points: "+points);
    }
        
    public static void userInput(){ 
      
        input=Integer.parseInt(JOptionPane.showInputDialog("Guess the correct number between 1 to 100\nConstraints are:\n no of trials: 7 \n correct guess=100score \n wrong guess=-10score")); 
    }
    static void checkInput(){
        
        for(i=0;i<limit;i++){
            if(i!=limit){
                userInput();
                attempts++;
                if(input==number){
                    System.out.println("Congratulations!!! You have guessed correct number\nThe number was  " + number);     
                    getAttempts();
                    score+=100;
                    getScore();
                    points+=attempts;
                    getPoints();
                }
                else if(input>number && i!=limit){
                    System.out.println("your integer "+ input + " is Higher!! Try Again...");
                    score-=10;
                    points-=attempts;
                    
                }
                else if(input<number && i!=limit){
                    System.out.println("your integer "+ input + " is Lower!! Try Again...");
                    score-=10;
                    points-=attempts;
                    
                }
                
            }
        }
        if(i>=limit){
            System.out.println("Oooppss!!!You're up as you've used all "+limit+" trials.");
            System.out.println("The number was " + number);

        }

       
    } 
}
public class Game{
    public static void main(String[] args){
        Game1 g=new Game1();
        boolean b=false;
        while(!b){
            g.checkInput();
            
        }
        
    }
    
}
