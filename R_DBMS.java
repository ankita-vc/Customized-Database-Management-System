import java.util.*;

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// Class of Student table with column names or Schema.

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class Student
{
    public int rno;
    public String name;
    public int age;
    public int marks;

    public static int Generator;

    static
    {
        Generator= 0;
    }

    public Student(String str, int X, int Y)
    {
        this.rno= ++Generator;
        this.name= str; 
        this.age= X; 
        this.marks= Y;
    }

    public void display()
    {
        System.out.println(this.rno + " " + this.name + " " + this.age + " " + this.marks + " ");
    }
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// DataBase Management System

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class DBMS
{
    public LinkedList <Student> lobj = new LinkedList <Student>();

    public void StartDBMS()
    {
        System.out.println("Started..");
        System.out.println("Table Schema Stared");

        String Query;
        String Tokens[];
        Scanner sobj= new Scanner(System.in);
        int TokensCount= 0;

        while(true)
        {
            System.out.print("R_DBMS:> ");
            Query= sobj.nextLine();

            Tokens= Query.split(" ");
            TokensCount= Tokens.length;

            if(TokensCount == 1)
            {
                if("exit".equals(Tokens[0]))
                {
                    System.out.println("Thank you for using R_DBMS..");
                    break;
                }
                
            }
            else if(TokensCount == 2)
            {
                if("drop".equals(Tokens[0]))
                {
                    System.out.println("Table has been deleted.");
                    break;
                }
            }
            else if(TokensCount == 4)
            {
                if("select".equals(Tokens[0]))
                {
                    SelectFrom();
                }
            }
            else if(TokensCount == 5)
            {
                if("select".equals(Tokens[0]))
                {
                    if("Max".equals(Tokens[1]))
                    {
                        System.out.println("Maximum marks are: "+ Aggregate_Max());
                    }
                    if("Min".equals(Tokens[1]))
                    {
                        System.out.println("Minimum marks are: "+ Aggregate_Min());
                    }
                    if("Avg".equals(Tokens[1]))
                    {
                        System.out.println("Average marks are: "+ Aggregate_Avg());
                    }
                    if("Sum".equals(Tokens[1]))
                    {
                        System.out.println("Summation of marks is: "+ Aggregate_Summation());
                    }
                    else if("Count".equals(Tokens[1]))
                    {
                        System.out.println("Number of students are: "+(Aggregate_Count() - 1));
                    }
                }
            }
            else if(TokensCount == 7)
            {
                if("insert".equals(Tokens[0]))
                {
                    InsertIntoTable(Tokens[4], Integer.parseInt(Tokens[5]),Integer.parseInt(Tokens[6]));
                }
                else if("delete".equals(Tokens[0]))
                {
                    DeleteFrom(Integer.parseInt(Tokens[6]));
                }
                

            }
            else if(TokensCount == 8)
            {
                if("select".equals(Tokens[0]))
                {
                    if("rno".equals(Tokens[5]))
                    {
                        SelectFrom(Integer.parseInt(Tokens[7]));
                    }
                    else if("name".equals(Tokens[5]))
                    {
                        SelectFrom(Tokens[7]);
                    }
                    else if("age".equals(Tokens[5]))
                    {
                        if("=".equals(Tokens[6]))
                        {
                            SelectAgeE(Integer.parseInt(Tokens[7]));
                        }
                        else if(">".equals(Tokens[6]))
                        {
                            SelectAgeG(Integer.parseInt(Tokens[7]));
                        }
                        else if("<".equals(Tokens[6]))
                        {
                            SelectAgeL(Integer.parseInt(Tokens[7]));
                        }
                    }
                    else if("marks".equals(Tokens[5]))
                    {
                        if("=".equals(Tokens[6]))
                        {
                            SelectAgeE(Integer.parseInt(Tokens[7]));
                        }
                        else if(">".equals(Tokens[6]))
                        {
                            SelectMarksG(Integer.parseInt(Tokens[7]));
                        }
                        else if("<".equals(Tokens[6]))
                        {
                            SelectMarksL(Integer.parseInt(Tokens[7]));
                        }
                    }  
                }
            }
            else if(TokensCount == 9)    
            {
                if("count".equals(Tokens[1]))
                {
                    if("marks".equals(Tokens[2]))
                    {
                        if("=".equals(Tokens[7]))
                        {
                            System.out.println(CountMarksE(Integer.parseInt(Tokens[8])));
                        }
                        else if(">".equals(Tokens[7]))
                        {
                            System.out.println(CountMarksG(Integer.parseInt(Tokens[8])));
                        }
                        else if("<".equals(Tokens[7]))
                        {
                            System.out.println(CountMarksL(Integer.parseInt(Tokens[8])));
                        }
                    }
                    else if("age".equals(Tokens[2]))
                    {
                        if("=".equals(Tokens[7]))
                        {
                            System.out.println(CountAgeE(Integer.parseInt(Tokens[8])));
                        }
                        else if(">".equals(Tokens[7]))
                        {
                            System.out.println(CountAgeG(Integer.parseInt(Tokens[8])));
                        }
                        else if("<".equals(Tokens[7]))
                        {
                            System.out.println(CountAgeL(Integer.parseInt(Tokens[8])));
                        }
                    }
                    else if("name".equals(Tokens[2]))
                    {
                        if("=".equals(Tokens[7]))
                        {
                            System.out.println(CountName((Tokens[8])));
                        }
                    }
                }
                
            }
        }
    }

    // insert into table_name values(value1, value2,.....);
    public void InsertIntoTable(String name, int age, int marks)
    {
        Student sobj= new Student(name, age, marks);
        lobj.add(sobj);
    }

    // select * from Student;
    public void SelectFrom()
    {
        System.out.println("Record from the student database are:");

        for(Student sref : lobj)
        {
            sref.display();
        }
    }

    // select * from Student where rno = value;
    public void SelectFrom(int No)
    {
        int i= 0;
        System.out.println("Record from the student database with rno "+ No+" is:");

        for(Student sref : lobj)
        {
            if(sref.rno == No)
            {
                sref.display();
            }
            i++;
        }
    }

    // select * from Student where age = value;
    public void SelectAgeE(int No)
    {
        int i= 0;
        System.out.println("Record from studemt database with age is: ");

        for(Student sref : lobj)
        {
            if(sref.age == No)
            {
                sref.display();
            }
            i++;
        }
    }

    // select * from Student where age > value;
    public void SelectAgeG(int No)
    {
        int i= 0;
        System.out.println("Record from studemt database with age is: ");

        for(Student sref : lobj)
        {
            if(sref.age > No)
            {
                sref.display();
            }
            i++;
        }
    }

    // select * from Student where age < value;
    public void SelectAgeL(int No)
    {
        int i= 0;
        System.out.println("Record from studemt database with age is: ");

        for(Student sref : lobj)
        {
            if(sref.age < No)
            {
                sref.display();
            }
            i++;
        }
    }

    // select * from Student where Name = value;
    public void SelectFrom(String str)
    {
        int i =0;

        System.out.println("Record from the student database with Name "+ str +" is:");

        for(Student sref : lobj)
        {
            if(str.equals(sref.name))
            {
                sref.display();
                break;
            }
            i++;
        }
    }

    //select * from Student where marks = value;
    public void SelectMarksE(int No)
    {
        int i= 0;
        System.out.println("Record from studemt database with age is: ");

        for(Student sref : lobj)
        {
            if(sref.marks == No)
            {
                sref.display();
            }
            i++;
        }
    }

    // select * from Student where marks > value;
    public void SelectMarksG(int No)
    {
        int i= 0;
        System.out.println("Record from studemt database with age is: ");

        for(Student sref : lobj)
        {
            if(sref.marks > No)
            {
                sref.display();
            }
            i++;
        }
    }

    // select * from Student where marks < value;
    public void SelectMarksL(int No)
    {
        int i= 0;
        System.out.println("Record from studemt database with age is: ");

        for(Student sref : lobj)
        {
            if(sref.marks < No)
            {
                sref.display();
            }
            i++;
        }
    }


    // Select max column_name from student;
    public int Aggregate_Max()
    {
        Student temp= lobj.get(0);
        int iMax= temp.marks;

        for(Student sref : lobj)
        {
            if(sref.marks > iMax)
            {
                iMax = sref.marks;
            }
        }
        return iMax;
    }

    // Select min column_name from student;
    public int Aggregate_Min()
    {
        Student temp= lobj.get(0);
        int iMin= temp.marks;

        for(Student sref : lobj)
        {
            if(sref.marks < iMin)
            {
                iMin = sref.marks;
            }
        }
        return iMin;
    }

    // Select avg column_name from student;
    public double Aggregate_Avg()
    {
        double iSum= 0.0;

        for(Student sref : lobj)
        {
            iSum= iSum + sref.marks;
        }
        return (iSum/lobj.size());
    }

    // Select sum column_name from student;
    public int Aggregate_Summation()
    {
        int iSum= 0;

        for(Student sref : lobj)
        {
            iSum= iSum + sref.marks;
        }
        return iSum;
    }

    // Select count column_name from student;
    public int Aggregate_Count()
    {
        int iCount1= 0;

        for(Student sref : lobj)
        {
            iCount1 =sref.rno;
            iCount1++;
        }
        return iCount1;
    }

    // Select count(marks) from table_name where marks = value;   // *********
    public int CountMarksE(int No)
    {
        int iCount= 0;
        for(Student sref : lobj)
        {
            if(sref.marks == No)
            {
                iCount++;
            }
        }
        return iCount;
    }

    // Select count(marks) from table_name where marks > value;   // *********
    public int CountMarksG(int No)
    {
        int iCount= 0;
        for(Student sref : lobj)
        {
            if(sref.marks > No)
            {
                iCount++;
            }
        }
        return iCount;
    }

    // Select count(marks) from table_name where marks < value;   // *********
    public int CountMarksL(int No)
    {
        int iCount= 0;
        for(Student sref : lobj)
        {
            if(sref.marks < No)
            {
                iCount++;
            }
        }
        return iCount;
    }

    // Select count(marks) from table_name where age = value;   // *********
    public int CountAgeE(int No)
    {
        int iCount= 0;
        for(Student sref : lobj)
        {
            if(sref.age == No)
            {
                iCount++;
            }
        }
        return iCount;
    }

    // Select count(marks) from table_name where age > value;   // *********
    public int CountAgeG(int No)
    {
        int iCount= 0;
        for(Student sref : lobj)
        {
            if(sref.age > No)
            {
                iCount++;
            }
        }
        return iCount;
    }

    // Select count(marks) from table_name where age < value;   // *********
    public int CountAgeL(int No)
    {
        int iCount= 0;
        for(Student sref : lobj)
        {
            if(sref.age < No)
            {
                iCount++;
            }
        }
        return iCount;
    }

    // Select count(marks) from table_name where name = value;   // *********
    public int CountName(String str)
    {
        int iCount= 0;
        for(Student sref : lobj)
        {
            if(sref.name == str)
            {
                iCount++;
            }
        }
        return iCount;
    }

    // delete from table_name where CONDITION;
    public void DeleteFrom(int No)
    {
        int i= 0;

        for(Student sref : lobj)
        {
            if(sref.rno == No)
            {
                lobj.remove(i);
                break;
            }
            i++;
        }

        System.out.println(No+ " is deleted");
    }
}

class R_DBMS
{
    public static void main(String arg[])
    {
        DBMS obj= new DBMS();
        obj.StartDBMS();
    }
}