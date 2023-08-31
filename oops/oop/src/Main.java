public class Main{
    public static void main(String[] args) {
        Student st1=new Student();//this st1 is called using Student() function
        //st1.rno=10;
        //st1.marks=90.0f;
        //st1.name="Ashwin";

        Student st2=new Student(15, "Abc", 90.5f); //this is called using student(parameters) function


        System.out.println(st2.rno+"  "+st2.marks+"  "+st2.name);
        System.out.println(st1.rno+"  "+st1.marks+"  "+st1.name);
    }
}
 //student class should be outside of Main class       
 class Student{
        int rno;
        String name;
        float marks;

       Student(){
         this.rno=10;
         this.name="Ashwin";
         this.marks=90.0f;
        }

        Student(int rno,String name,float marks){
            this.rno=rno;
            this.name=name;
            this.marks=marks;
        }
    }
