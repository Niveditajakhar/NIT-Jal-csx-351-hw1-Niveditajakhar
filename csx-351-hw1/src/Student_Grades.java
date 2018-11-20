
import java.io.*;
import java.util.*;
public class Student_Gradesss{
public static void main(String[] args) throws FileNotFoundException,IOException{
//reading input file
//opening HW1-data.txt file
File file=new File("E:\\javaLabExperiments\\HW1-startup-master\\HW1-data.txt");
int tot_pts=0,tot_Tot=0,tot_perc=0,ct=0,max=0; //variable declared to store total stats of students
Map<Character,Integer> Grade_ct=new HashMap<Character,Integer>();
//Map to grade count
Grade_ct.put('A',0);
Grade_ct.put('B',0);
Grade_ct.put('C',0);
Grade_ct.put('D',0);
Grade_ct.put('F',0);
Student_Details stu = new Student_Details(); //Object of the class
Student_Details
Scanner sc=new Scanner(file); //read fil scanned in sc
PrintWriter fw=new PrintWriter("E:\\javaLabExperiments\\HW1-startupmaster\\HW1-output-16103050.txt"); //Output File opened
fw.println("Stdnt Id Ex -------- assignments -------- Tot Mi Fin CL Pts PctGr");
fw.println("-------- -- ----------------------------- --- -- --- -- --- --- --");
//Reading data File
while (sc.hasNextLine()){
String[] str=sc.nextLine().split("\\s+"); //Splitting string in str
array
//storing student details in object of Student_Details
stu.studentId=Integer.parseInt(str[0]);
stu.labEx=Integer.parseInt(str[1]);
for(int i=0;i<10;i++){
stu.assign[i]=Integer.parseInt(str[i+2]);
}
stu.midTerm=Integer.parseInt(str[12]);
stu.fin=Integer.parseInt(str[13]);
stu.codeLab=Integer.parseInt(str[14]);
printRecord(stu, fw); //function called
tot_Tot+=stu.tot;
tot_perc+=stu.perc;
if(max < stu.points)
max=stu.points;
tot_pts+=stu.points;
Grade_ct.put(stu.grd,Grade_ct.get(stu.grd)+1);
ct++;
}
fw.println();
fw.println("Average total of all students = "+tot_Tot/ct);
fw.println("Average points of all students = "+tot_pts/ct);
fw.println("Average percent of all students = "+tot_perc/ct);
fw.println();
for(Character key:Grade_ct.keySet()){
fw.println("Number of "+key+"'s = "+Grade_ct.get(key));
 }
fw.println();
fw.println("Maximum points = "+max);
sc.close();
fw.close();
System.out.println("Completed Successfully");
}
//Function to print student record
public static void printRecord(Student_Details stu,PrintWriter fw){
try{
stu.tot=total(stu.assign,stu.assign.length); //Function called to calculate total
stu.points=points(stu);
//Function called to calculate points
stu.perc=percent(stu.points);
//Function called to calculate percent
stu.grd=grade(stu.perc);
//Function called to calculate grade
String out=String.format("%08d %d ",stu.studentId,stu.labEx);
for(int i=0;i<10;i++){
out+=String.format("%2d ",stu.assign[i]);
}
out+=String.format(" %d %d ",stu.tot,stu.midTerm);
out+=String.format("%3d %2d %d",stu.fin,stu.codeLab,stu.points);
out+=String.format(" %3d %2c",stu.perc,stu.grd);
fw.println(out);
//Record printed in file
}catch (Exception e){
e.printStackTrace();
System.out.println("Exception occured..");
}
}
//Function to count total
public static int total(int a[],int n){
int points=0;
for(int i=0;i<n;i++)
points+=a[i];
return points;
}
//Function to calculate points
public static int points(Student_Details st){
int pts=0;
pts= st.labEx+st.tot+st.midTerm+st.fin+st.codeLab;
return pts;
}
//Function to calculate percent
public static int percent(int p){
float per=0;
per=((float)p*100)/420;
per=Math.round(per); //Roundoff
return (int)per;
}
//Function to calculate grade
public static char grade(int a){
if(a>=90)
return 'A';
else if(a>=78)
return 'B';
else if(a>=62)
return 'C';
else if(a>=46)
return 'D';
else
return 'F';
}
}
