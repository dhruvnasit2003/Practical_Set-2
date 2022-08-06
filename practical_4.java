import java.util.Scanner;
public class practical_4 {

    private int id = 0;
    private double balance = 500;
    private double AIR = 7;
    private java.util.Date dateCreated;

    practical_4() {
        int id = 0;
        double balance = 500;
        double AIR = 7;

        dateCreated = new java.util.Date();
    }

    practical_4(int i) {
        dateCreated = new java.util.Date();
        id = i;

    }

    void setid(int si) {
        id = si;
    }

    int getid() {
        return id;
    }


    void setBalance(double sb) {
        balance = sb;
    }

    double getBalance() {
        return balance;
    }


    void setair(double sair) {
        AIR = sair;
    }

    double getAIR() {
        return AIR / 100;
    }


    java.util.Date getdate() {
        return dateCreated;
    }


    double getMonthlyInterestRate() {

        return AIR / 12;
    }

    double getMonthlyInterest(double bal) {

        return bal * (AIR / 1200);
    }

    void withdraw(double w_amount) {
        if (w_amount <= balance) {
            balance = balance - w_amount;
            System.out.println("withdrawal successful.");
        } else {
            System.out.println("Your account dose not have required minimum amount !");
        }
    }

    void deposit(double d_amount) {
        balance = balance + d_amount;
        System.out.println("Your Amount is deposited successfully.");
    }


    static class SavingAccount extends practical_4 {

        void swithdraw(double sw_amount) {
            super.withdraw(sw_amount);
        }


        void sdeposit(double sd_amount) {
            super.deposit(sd_amount);
        }
    }

    static class CheckingAccount extends practical_4 {

        void cwithdraw(double cw_amount) {
            if (cw_amount > 100) {
                super.withdraw(cw_amount);
            } else {
                System.out.println("minimum withdraw limit is 100 !!! ");
            }

        }


        void cdeposit(double cd_amount) {
            if (cd_amount > 200) {
                super.deposit(cd_amount);
            } else {
                System.out.println("minimum deposit limit is 200 !!! ");
            }

        }
    }

   static class main {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int aid;
            System.out.print("Enter ID : ");
            aid = sc.nextInt();
            practical_4 obj = new practical_4(aid);
            System.out.println("account created successfully");

            System.out.println("Account ID      : " + obj.getid());
            System.out.println("Account balance : " + obj.getBalance());
            System.out.print("Enter annualInterestRate   : ");
            double air = sc.nextDouble();
            obj.setair(air);
            System.out.println("MonthlyInterestRate      : " + obj.getMonthlyInterestRate() + "%");
            System.out.println("MonthlyInterest          : " + obj.getMonthlyInterest(obj.getBalance()));

            System.out.print("Enter deposit amount         : ");
            double x = sc.nextDouble();
            obj.deposit(x);
            System.out.println("Now your account balance   : " + obj.getBalance());
            System.out.print("Enter withdraw amount        : ");
            double y = sc.nextDouble();
            obj.withdraw(y);
            System.out.println("Now your account balance   : " + obj.getBalance());


            System.out.println("** For Saving Account **");
            SavingAccount sobj = new SavingAccount();
            System.out.print("Enter deposit amount         : ");
            double p = sc.nextDouble();
            sobj.sdeposit(p);
            System.out.println("Now your account balance   : " + sobj.getBalance());

            System.out.print("Enter Withdraw amount         : ");
            double q = sc.nextDouble();
            sobj.swithdraw(q);
            System.out.println("Now your account balance   : " + sobj.getBalance());

            System.out.println("** For Checking Account **");
            CheckingAccount cobj = new CheckingAccount();
            System.out.print("Enter deposit amount         : ");
            double i = sc.nextDouble();
            cobj.cdeposit(i);
            System.out.println("Now your account balance   : " + cobj.getBalance());

            System.out.print("Enter Withdraw amount         : ");
            double o = sc.nextDouble();
            cobj.cwithdraw(o);
            System.out.println("Now your account balance   : " + cobj.getBalance());
            System.out.println("21CE079-Dhruv Nasit");
        }
    }
}
