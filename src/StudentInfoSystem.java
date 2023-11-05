package src;

import java.util.Scanner;
import java.util.Set;
public class StudentInfoSystem {
    static int response1=0;
    static String response2="";
    static Scanner scan=new Scanner(System.in);
    static int num=0;
    static String [] name = new String[100000];
    static int [] matricNo = new int[100000];
    static double [] courseworkMark = new double[100000];
    static double []finalexamMark = new double[100000];
    static String[] gradeobtained = new String[100000];
    static String[] program=new String[100000];
    static int Aplus =0,A=0,Aminus=0,Bplus=0,B=0,Bminus=0,Cplus=0,C=0,Cminus=0,Dplus=0,D=0,F=0;
    static double totalmarks[] =new double [100000];
    static int courseresponse=0;
    public static void main(String[] args) {
        performAction();
    }
    public static void performAction() {
        boolean run =true;
        while(run) {
            System.out.println("Which action to perform?");
            System.out.println("-------------------------------------------------");
            System.out.println("1-Add a student data");
            System.out.println("2-Display all information");
            System.out.println("3-Search a student based on matric num");
            System.out.println("4-Show the grade distribution");
            System.out.println("5-Edit data");
            System.out.println("6-Stop");
            System.out.println("-------------------------------------------------");
            System.out.print("Reply:");
            int response2 = scan.nextInt();
            if(response2==1){
                run=false;
                ++num;
                recordData();
            }
            if(response2==2) {
                run=false;
                displayInformation();
            }if(response2==3) {
                run=false;
                System.out.println("Insert a matric num");
                int matricno = scan.nextInt();
                searches(matricNo,matricno);
                performAction();
            }if(response2==4) {
                grade(courseworkMark,finalexamMark);
                System.out.println("A+ obtained = "+Aplus);
                System.out.println("A obtained = "+A);
                System.out.println("A- obtained = "+Aminus);
                System.out.println("B+ obtained = "+Bplus);
                System.out.println("B obtained = "+B);
                System.out.println("B- obtained = "+Bminus);
                System.out.println("C+ obtained = "+Cplus);
                System.out.println("C obtained = "+C);
                System.out.println("C- obtained = "+Cminus);
                System.out.println("D+ obtained = "+Dplus);
                System.out.println("D obtained = "+D);
                System.out.println("F obtained = "+F);
                performAction();
            }if(response2==5) {
                run=false;
                System.out.println("Enter a matric num to start editing data");
                int editval =scan.nextInt();
                edit(courseworkMark,finalexamMark,matricNo,program,editval);
            }if(response2==6) {
                System.out.println("Thank you for using our system!");
                System.exit(0);
            }
        }
    }public static int check(int matric,int[] matrics) {
        for (int i =0 ;i<num;i++) {
            if(matric==matrics[i]) {
                System.out.println("matric num is repeat!");
                return 1;
            }
        }
        return -1;
    }
    public static void keyinmatricno() {
        System.out.println("Enter a matric num of student "+num);
        int n = scan.nextInt();
        if(check(n,matricNo)==1) {
            keyinmatricno();
        }else if(check(n,matricNo)==-1) {
            matricNo[num-1]=n;
        }
    }
    public static void recordData() {
        for(int i =num-1;i<num;i++) {
            scan.nextLine();
            System.out.println("Enter a name of student "+num);
            name[i]=scan.nextLine();
            keyinmatricno();
            scan.nextLine();
            System.out.println("Enter a program code of student "+num);
            System.out.println("-----------------------");
            System.out.println("1-Decision Science");
            System.out.println("2-Risk Management");
            System.out.println("3-Education in IT");
            System.out.println("-----------------------");
            courseresponse=scan.nextInt();
            while((courseresponse!=1)&&(courseresponse!=2)&&(courseresponse!=3)) {
                System.out.println("Invalid course number, please enter again!");
                courseresponse=scan.nextInt();
            }if(courseresponse==1) {
                program[i]="Decision Science";
            }else if(courseresponse==2) {
                program[i]="Risk Management";
            }else if(courseresponse==3) {
                program[i]="Education in IT";
            }
            System.out.println("Enter coursework mark of student "+num);
            courseworkMark[i]=scan.nextDouble();
            while((courseworkMark[i]<0)||(courseworkMark[i]>100)) {
                System.out.println("Enter coursework mark between range 0-100");
                courseworkMark[i]=scan.nextDouble();
            }
            System.out.println("Enter finalexammark of student "+num);
            finalexamMark[i]=scan.nextDouble();
            while((finalexamMark[i]<0)||(finalexamMark[i]>100)) {
                System.out.println("Enter finalexam mark between range 0-100");
                finalexamMark[i]=scan.nextDouble();
            }
            scan.nextLine();
            performAction();
        }
    }public static void displayInformation() {
        for(int i=0;i<num;i++) {
            System.out.println("The name of student "+(i+1)+" = "+name[i]);
            System.out.println("The matric num of student "+(i+1)+" = "+matricNo[i]);
            System.out.println("The program of student "+(i+1)+" = "+program[i]);
            System.out.println("The coursework mark of student "+(i+1)+" = "+courseworkMark[i]);
            System.out.println("The finalexam mark of student "+(i+1)+" = "+finalexamMark[i]);
            grade(courseworkMark,finalexamMark);
            System.out.println("The grade obtained of student "+(i+1)+" = "+gradeobtained[i]);
            System.out.println("----------------------------------------------------------------");
        }performAction();
    }
    public static void searches(int[]matricNo,int matricno) {
        int location=-1;
        grade(courseworkMark,finalexamMark);
        for(int i=0;i<num;i++) {
            if(matricno==matricNo[i]) {
                location=i;
                System.out.println("matric num found!");
                System.out.println("The name of student "+(location+1)+" = "+name[location]);
                System.out.println("The matric num of student "+(location+1)+" = "+matricNo[location]);
                System.out.println("The program of student "+(location+1)+" = "+program[location]);
                System.out.println("The coursework mark of student "+(location+1)+" = "+courseworkMark[location]);
                System.out.println("The finalexam mark of student "+(location+1)+" = "+finalexamMark[location]);
                System.out.println("The grade obtained of student "+(location+1)+" = "+gradeobtained[location]);
                break;
            }
        }if(location==-1) {
            System.out.println("matric num not found!");
        }
    }
    public static String grade(double[] courseworkMark, double[] finalexamMark) {
        String grade ="";
        Aplus=0;A=0;Aminus=0;Bplus=0;B=0;Bminus=0;Cplus=0;C=0;Cminus=0;Dplus=0;D=0;F=0;
        for(int i =0;i<num;i++){
            totalmarks[i]=0.6*courseworkMark[i]+0.4*finalexamMark[i];
            if((totalmarks[i]>=90)&&(totalmarks[i]<=100)) {
                grade= "A+";
                Aplus++;
            }else if((totalmarks[i]<90)&&(totalmarks[i]>=80)) {
                grade= "A";
                A++;
            }else if((totalmarks[i]>=75)&&(totalmarks[i]<80)) {
                grade= "A-";
                Aminus++;
            }else if((totalmarks[i]>=70)&&(totalmarks[i]<75)) {
                grade= "B+";
                Bplus++;
            }else if((totalmarks[i]>=65)&&(totalmarks[i]<70)) {
                grade= "B";
                B++;
            }else if((totalmarks[i]>=60)&&(totalmarks[i]<65)){
                grade= "B-";
                Bminus++;
            }else if((totalmarks[i]>=55)&&(totalmarks[i]<60)) {
                grade= "C+";
                Cplus++;
            }else if((totalmarks[i]>=50)&&(totalmarks[i]<55)) {
                grade= "C";
                C++;
            }else if((totalmarks[i]>=45)&&(totalmarks[i]<50)) {
                grade="C-";
                Cminus++;
            }else if((totalmarks[i]>=40)&&(totalmarks[i]<45)) {
                grade="D+";
                Dplus++;
            }else if((totalmarks[i]>=35)&&(totalmarks[i]<40)) {
                grade="D";
                D++;
            }else if((totalmarks[i]>=0)&&(totalmarks[i]<35)){
                grade="F";
                F++;
            }
            gradeobtained[i]=grade;
        }
        return grade;
    }
    public static void edit(double[]courseworkmark,double[]finalexammark,int[]matricNo,String[]program,int matricno) {
        int location =-1;
        for(int i=0;i<num;i++) {
            if(matricno==matricNo[i]) {
                location=i;
                System.out.println("What would you like to edit?");
                System.out.println("----------------------------");
                System.out.println("1-Program");
                System.out.println("2-Coursework mark");
                System.out.println("3-Finalexam mark");
                System.out.println("----------------------------");
                int response=scan.nextInt();
                while((response!=1)&&(response!=2)&&(response!=3)) {
                    System.out.println("Please provide a valid response!");
                    response=scan.nextInt();
                }
                if(response==1) {
                    System.out.println("Enter a program code of student "+matricno);
                    System.out.println("-----------------------");
                    System.out.println("1-Decision Science");
                    System.out.println("2-Risk Management");
                    System.out.println("3-Education in IT");
                    System.out.println("-----------------------");
                    int newprogram=scan.nextInt();
                    while((newprogram!=1)&&(newprogram!=2)&&(newprogram!=3)) {
                        System.out.println("Invalid course number, please enter again!");
                        newprogram=scan.nextInt();
                    }if(newprogram==1) {
                        program[i]="Decision Science";
                    }else if(newprogram==2) {
                        program[i]="Risk Management";
                    }else if(newprogram==3) {
                        program[i]="Education in IT";
                    }
                    performAction();
                }else if(response==2) {
                    System.out.println("Enter the courseworkmark for student with matric num of "+matricno);
                    double newcoursework=scan.nextDouble();
                    while((newcoursework<0)||(newcoursework>100)) {
                        System.out.println("Enter coursework mark between range 0-100");
                        newcoursework=scan.nextDouble();
                    }
                    courseworkmark[i]=newcoursework;
                    scan.nextLine();
                    performAction();
                }else if(response==3) {
                    System.out.println("Enter the finalexammark for student with matric num of "+matricno);
                    double finalexammarks=scan.nextDouble();
                    while((finalexammarks<0)||(finalexammarks>100)) {
                        System.out.println("Enter finalexam mark between range 0-100");
                        finalexammarks=scan.nextDouble();
                    }
                    finalexammark[i]=finalexammarks;
                    scan.nextLine();
                    performAction();
                }
                performAction();
            }
        }if (location ==-1){
            System.out.println("matric num does not exist!");
            performAction();
        }
    }
}