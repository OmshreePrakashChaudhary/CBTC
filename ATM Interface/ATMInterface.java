import java.util.*;
import java.io.*;
import java.time.LocalDateTime;

public class ATMInterface {

	static float balance,wamount,damount,tamount;
	static int pin,cid;

    public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		try{
			System.out.println("Enter Customer Id:- ");	
			cid=sc.nextInt();
			System.out.println("Enter 4 digit PIN:- ");	
			pin=sc.nextInt();
		}
		catch(Exception e){
			System.out.println("Enter numbers only!!");
		}

		ATMInterface obj=new ATMInterface();

		if(Integer.toString(pin).length()<5)
		{
			menu(obj);
		}
		else{
			System.out.println("Please Enter valid PIN!!!");
		
		}
	}
	
		public static void menu(ATMInterface obj){
			System.out.println("\n*************ATM OPTIONS***************\n");
			System.out.println("1. Transaction History");
			System.out.println("2. Withdraw");
			System.out.println("3. Deposite");
			System.out.println("4. Transfer");
			System.out.println("5. Exit");
			System.out.println("Please Enter your choice:-");
			Scanner sc=new Scanner(System.in);
			int choice=sc.nextInt();

			switch(choice)
			{
				case 1:
				transactionHistory th=new transactionHistory();
				th.displayTransaction(obj);
				break;
		
				case 2:
				Withdraw w=new Withdraw();
				w.withdrawOperation(obj);
				break;
				
				case 3:
				Deposite d=new Deposite();
				d.depositeOperation(obj);
				break;

				case 4:
				Transfer t=new Transfer();
				t.transferOperation(obj);
				break;

				case 5:
				System.exit(0);
				break;
			
				default:
				System.out.println("Please Enter valid Choice!!!");
				menu(obj);
				break;
				
			
			}
		}	  
}
class transactionHistory extends ATMInterface{
    public void displayTransaction(ATMInterface obj){
		LocalDateTime date = LocalDateTime.now();
    	System.out.println("\n"+date);
		System.out.println("-------------Transaction History---------------\n");
		System.out.println("Withdraw: " + obj.wamount);
		System.out.println("Deposite: " + obj.damount);
		System.out.println("Transfer: " + obj.tamount);
		System.out.println("Balance: " + obj.balance);
		menu(obj);
    }
}

class Withdraw extends ATMInterface{
    public static void withdrawOperation(ATMInterface obj){
	Scanner sc=new Scanner(System.in);
    System.out.println("Enter amount to withdraw:");
    obj.wamount=sc.nextFloat();

    if(obj.wamount>obj.balance){
        System.out.println("You have not sufficient fund to withdraw.");
		wamount=0;
		menu(obj);
    }
	else{
		System.out.println("Please Collect Your Money...");
		obj.balance=obj.balance-obj.wamount;
		menu(obj);
	}
	
	}
}

class Deposite extends ATMInterface{
	public static void depositeOperation(ATMInterface obj){
		Scanner sc=new Scanner(System.in);
    	System.out.println("Enter amount to deposite:");
    	obj.damount=sc.nextFloat();
		System.out.println("Money has been deposited successfully...");
		obj.balance=obj.balance+obj.damount;
		menu(obj);
	}
}

class Transfer extends ATMInterface{
	public static void transferOperation(ATMInterface obj){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter recipients Account Id");
		int cId=sc.nextInt();
		System.out.println("Enter amount to Transfer:");
		obj.tamount=sc.nextFloat();
		if(obj.tamount>obj.balance)
		{
			System.out.println("You have not sufficient fund to transfer.");
			menu(obj);
		}
		else{
			
			System.out.println("Successfully Transfer "+ obj.tamount +" to "+ cId);
			obj.balance=obj.balance-obj.tamount;
			menu(obj);
		}
	}
}


