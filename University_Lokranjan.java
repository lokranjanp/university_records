import java.util.*;

public class University_Lokranjan
{    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        int number_ug,number_pg;
        System.out.print("Enter number of UG students :");
        number_ug = sc.nextInt();
        if(number_ug!=0)
        {
        while(number_ug<10)
        {    System.out.print("Enter number greater than 10 :");
             number_ug = sc.nextInt();
        }
        }
        UGStudent arr_ug[] = new UGStudent[number_ug];          //creating array of type UGStudent
        
        System.out.print("Enter number of PG students :");
        number_pg = sc.nextInt();
        if(number_pg!=0)
        {while(number_pg<10)
        {    System.out.print("Enter number greater than 10 :");
             number_pg = sc.nextInt();    
        }
        }
        PGStudent arr_pg[] = new PGStudent[number_pg];          //creating array of type PGStudent

        //ug record 
        if(number_ug!=0)
        {System.out.println("Enter details of UG Students");
        for(int i =0;i<number_ug;i++)
        {
            String usn,name,branch;
            int sem;
            System.out.print("Enter name of Student "+ (i+1) +" :");
            name = sc.next();
            System.out.print("Enter USN :");
            usn = sc.next();
            System.out.print("Enter semester :");
            sem = sc.nextInt();
            System.out.print("Enter branch :");
            branch = sc.next();

            arr_ug[i] = new UGStudent(usn, name, sem, branch); //parametrised constructor for UGStudent class

        }
        
        //operations on ug students array
        
        int choice;
        System.out.println("----Operations on the UG Students array----");          //menu driven program
        do{

        System.out.println("Options :\n1.Print all records\n2.Change name\n3.Change USN\n4.Change branch\n5.Skip");
        choice = sc.nextInt();

        switch(choice){

            case 1:         //Printing the array
                    for(int i =0; i<number_ug; i++)
                    {
                        System.out.println("Student "+(i+1));
                        System.out.println("    Name : "+arr_ug[i].getName());
                        System.out.println("    USN : "+arr_ug[i].getUSN());
                        System.out.println("    Semester : "+arr_ug[i].getSemester());
                        System.out.println("    Branch : "+arr_ug[i].getBranch());
                    }
                    break;
            
            case 2:         //Changing Student name
                    System.out.println("\nEnter Student USN whose name is to be changed");
                    String find = sc.next(); 
                    int target=-1;
                    for(int j = 0; j<number_ug; j++)
                    {
                        String search=arr_ug[j].getUSN();
                        if(find.equals(search))
                        {
                            target=j;
                            break;
                        }
                    }
                    if(target == -1 )
                        System.out.println("Enter valid USN");
                    else{
                        System.out.print("Enter new name : ");
                        String name = sc.next();
                        arr_ug[target].setName(name);
                        System.out.println("Name updated to \n"+arr_ug[target].getName());
                    }
                    break;

            case 3:         //changing Student USN
                    System.out.println("\nEnter student number whose USN is to be changed : ");
                    int i = sc.nextInt(); 
                    i--;
                    System.out.print("Enter new USN : ");
                    String usn = sc.next();
                    arr_ug[i].setUSN(usn);
                    System.out.println("USN updated\n");
                    break;
            
            case 4:         //changing Student Branch
                    System.out.println("\nEnter student USN whose branch is to be changed : ");
                    String find_usn = sc.next(); 
                    int target_idx=-1;
                    for(int j = 0; j<number_ug; j++)
                    {
                        String search=arr_ug[j].getUSN();
                        if(find_usn.equals(search))
                        {
                            target=j;
                            break;
                        }
                    }
                    if(target_idx == -1 )
                        System.out.println("Enter valid USN");
                    else{
                        System.out.print("Enter new branch : ");
                        String branch = sc.next();
                        arr_ug[target_idx].setBranch(branch);
                        System.out.println("Branch updated to \n"+arr_ug[target_idx].getBranch());
                    }
                    break;
        }
        }
        while(choice!=5);
        }
        //pg record
        System.out.println("Enter details of PG Students :");

        for(int a=0;a<number_pg;a++)
        {
            String usn_pg,name_pg,special,ugdeg;
            System.out.print("Enter name of Student "+ (a+1) +" :");
            name_pg = sc.next();
            System.out.print("Enter USN : ");
            usn_pg = sc.next();
            System.out.print("Enter specialisation :");
            special = sc.next();
            System.out.print("Enter  UG Degree : ");
            ugdeg = sc.next();
            arr_pg[a] = new PGStudent(usn_pg, name_pg, special, ugdeg); //parametrised constructor of PGStudent class

        }

        int choice_pg;
        System.out.println("----Operations on the PG Students array----");      //menu driven block
        do
        {
        System.out.println("Options :\n1.Print all records\n2.Change name\n3.Change USN\n4.Change Specialization\n5.Exit");
        choice_pg = sc.nextInt();
        switch(choice_pg)
        {
            case 1:         //Printing complete array contents
                    for(int i_pg =0; i_pg<number_pg; i_pg++)
                    {
                        System.out.println("Student "+ (i_pg+1));
                        System.out.println("    Name : "+arr_pg[i_pg].getName());
                        System.out.println("    USN : "+arr_pg[i_pg].getUSN());
                        System.out.println("    Specialisation : "+arr_pg[i_pg].getSpecialization());
                        System.out.println("    UG Degree : "+arr_pg[i_pg].getUGDegree());
                    }
                    break;
            case 2:         //Changing Student name
                    System.out.println("\nEnter Student USN whose name is to be changed");
                    String find = sc.next(); 
                    int target=-1;
                    for(int j = 0; j<number_pg; j++)
                    {
                        String search=arr_pg[j].getUSN();
                        if(find.equals(search))
                        {   
                            target=j;
                            break;
                        }
                    }
                    if(target == -1 )
                        System.out.println("Enter valid USN");
                    else{
                        System.out.print("Enter new name : ");
                        String name = sc.next();
                        arr_pg[target].setName(name);
                        System.out.println("Name updated\n");
                        break;
                    }
                    break;
            
            case 3:         //changing PG USN
                    System.out.print("\nEnter student number whose USN is to be changed : ");
                    int i = sc.nextInt(); 
                    i--;
                    System.out.print("Enter new USN : ");
                    String usn = sc.next();
                    arr_pg[i].setUSN(usn);
                    System.out.println("USN updated\n");
                    
                    break;

            case 4:         //modifying Student specialization
                    System.out.print("\nEnter Student USN whose specilization is to be changed");
                    String find_usn = sc.next(); 
                    int target_idx=-1;
                    for(int j = 0; j<number_pg; j++)
                    {
                        String search=arr_pg[j].getUSN();
                        System.out.println(search);
                        
                        if(find_usn.equals(search))
                        {   
                            target_idx=j;
                            break;
                        }
                    }
                    if(target_idx == -1 )
                        System.out.println("Enter valid USN");
                    else{
                        System.out.print("Enter new specialization : ");
                        String new_spec = sc.next();
                        arr_pg[target_idx].setSpecialization(new_spec);
                        System.out.println("Specialization updated\n");
                        break;
                    }
                    break;

        }
    }
        while(choice_pg!=5);
        sc.close();
	}
    
}


class Student
{
    private String USN;
    private String S_name;

    Student(String usn, String name)                //parameterised constructor
    {
        this.S_name = name;
        this.USN = usn;
    }
    Student(){}

    //methods in student class
    public void setUSN(String usn)
    {
        this.USN = usn;
    }

    public String getUSN()
    {
        return this.USN;
    }

    public void setName(String name)
    {
        this.S_name = name;
    }

    public String getName()
    {
        return this.S_name;
    }

}

class UGStudent extends Student             //inherits from class Student
{
    private int semester;
    private String branch;

    UGStudent(String usn, String name,int sem, String branch)       //UGStudent parameterised constructor
    {
        setName(name);
        setUSN(usn);
        setSemester(sem);
        setBranch(branch);
    }

    //methods in UGStudent class
    public void setSemester(int sem)
    {
        this.semester = sem;
    }

    public int getSemester()
    {
        return this.semester;
    }

    public void setBranch(String branch)
    {
        this.branch = branch;
    }

    public String getBranch()
    {
        return this.branch;
    }

}

class PGStudent extends Student             //inherits from class Student
{
    private String specialization;
    private String UGDegree;

    PGStudent(String usn, String name, String specialization, String UGDegree)      //parametrised constructor
    {
        setUSN(usn);
        setName(name);
        setUGDegree(UGDegree);
        setSpecialization(specialization);
    }

    public void setSpecialization(String specialization)
    {
        this.specialization = specialization;
    }

    public String getSpecialization()
    {
        return this.specialization;
    }
 
    public final void setUGDegree(String UGDegree)
    {
    this.UGDegree = UGDegree;  
    }

    public String getUGDegree()
    {
       return this.UGDegree;
    }
}


/*Developed and submitted by LOKRANJAN P , 4th semester ISE branch NIE Mysore */ 