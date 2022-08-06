import java.util.ArrayList;
import java.util.Scanner;
public class practical_3 {
    private String id;
    private double balance=300;
    practical_3(String setid)
    {
        id=setid;
    }


    void setid(String si)
    {
        id=si;
    }
    String getid()
    {
        return id;
    }


    void setBalance(double sb)
    {
        balance=sb;
    }
    double getBalance()
    {
        return balance;
    }

    void withdraw(double w_amount)
    {
        if(w_amount<balance){
            balance=balance-w_amount;
            System.out.println("withdrawal successful.");
        }
        else
        {
            System.out.println("Your account dose not have required minimum amount !!!");
        }
    }
    void deposit(double d_amount)
    {
        balance=balance+ d_amount;
        System.out.println("Your Amount is deposited successfully !!!");
    }

    void moneytransfer(practical_3 x,double mta)
    {
        if(getBalance()<mta)
        {
            System.out.println("Your account dose not have required mimimum amount !!!");
        }
        else {
            double xb= x.getBalance()+mta;
            double b= getBalance()-mta;
            setBalance(b);
            x.setBalance(xb);
            System.out.println("money transfered successfully !!!");
        }


    }

}

class Mainabc{

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        ArrayList<practical_3> list = new ArrayList<practical_3>(10);
        practical_3 AC001= new practical_3("AC001");
        practical_3 AC002= new practical_3("AC002");
        practical_3 AC003= new practical_3("AC003");
        practical_3 AC004= new practical_3("AC004");
        practical_3 AC005= new practical_3("AC005");
        practical_3 AC006= new practical_3("AC006");
        practical_3 AC007= new practical_3("AC007");
        practical_3 AC008= new practical_3("AC008");
        practical_3 AC009= new practical_3("AC009");
        practical_3 AC0010= new practical_3("AC0010");

        list.add(AC001);
        list.add(AC002);
        list.add(AC003);
        list.add(AC004);
        list.add(AC005);
        list.add(AC006);
        list.add(AC007);
        list.add(AC008);
        list.add(AC009);
        list.add(AC0010);

        System.out.print("Enter ID : ");
        String mid=sc.next();
        int flag=0;
        int index=0;
        for(int i=0;i<10;i++)
        {
            practical_3 a=list.get(i);

            if(mid.equals(a.getid()))
            {
                flag++;
                index=i;
                break;
            }

        }

        if(flag==1)
        {
            practical_3 temp;
            temp= list.get(index);
            System.out.println("----choose any option from following list----");
            System.out.println("1. Balance inquiry");
            System.out.println("2. Withdraw money [Maintain minimum balance 300₹]");
            System.out.println("3. Deposit money");
            System.out.println("4. Money Transfer");
            System.out.println("5. Create Account");
            System.out.println("6. Deactivate Account");
            System.out.println("7. Exit");
            System.out.println("8. ANOTHER account's Balance");

            for (int i=1;i<20;i++) {

                System.out.print("->");
                int option = sc.nextInt();
                if(option==7)
                {
                    break;
                }

                switch (option) {
                    case 1:
                        System.out.println("[1]Balance inquiry");
                        System.out.println("Your balance : " + temp.getBalance());
                        break;

                    case 2:
                        System.out.println("[2]Withdraw money");
                        System.out.print("Enter withdraw amount : ");
                        double wa = sc.nextDouble();
                        temp.withdraw(wa);
                        break;
                    case 3:
                        System.out.println("[3]Deposit money");
                        System.out.print("Enter deposit amount : ");
                        double da= sc.nextDouble();
                        temp.deposit(da);
                        break;
                    case 4:
                        System.out.println("[4]Money Transfer");
                        System.out.print("Enter Destination account id for Money Transfer : ");
                        String tsid= sc.next();
                        practical_3 tid=new practical_3("AC001");

                        for(int x=0;x<10;x++)
                        {
                            practical_3 temp1=list.get(x);
                            if(tsid.equals(temp1.getid()))
                            {
                                tid=list.get(x);
                                break;
                            }
                        }
                        System.out.print("Enter Transfer amount : ");
                        double ta=sc.nextDouble();
                        temp.moneytransfer(tid,ta);
                        list.set(i,tid);
                        // System.out.println(tid.getBalance());

                        break;

                    case 5:
                        System.out.println("[5]Create Account");
                        System.out.print("Enter new unique account ID : ");
                        String newid=sc.next();
                        practical_3 nid= new practical_3(newid);
                        list.add(nid);
                        System.out.println("New Account Created successfully !!!");
                        break;
                    case 6:
                        System.out.println("[6]Deactivate Account");
                        System.out.print("Enter account ID for Deactivation : ");
                        String dsid= sc.next();
                        practical_3 did=new practical_3("AC001");
                        int x;
                        for(x=0;x<10;x++)
                        {
                            practical_3 temp1=list.get(x);
                            if(dsid.equals(temp1.getid()))
                            {
                                did=list.get(x);
                                break;
                            }
                        }

                        list.remove(x);
                        System.out.println("ID Deactivated successfully. ");
                        break;


                }
                System.out.println("");
            }

        }
        else {
            System.out.println("ID IS NOT AVAILABLE !");

        }

        System.out.println("21CE079-Dhruv Nasit");


    }
}


