import java.io.*;

class SerializableAssociationsTest 
{ 
  public static void main(String[] args) 
  { 
    Academy ac = new Academy(); 
    String filename = "file.ser"; 

    Student j = ac.addRegistrant(12,"Jim");
    Student a = ac.addRegistrant(4,"Ali");
    Course c = ac.addCourse("CS191");
    j.addRegistration(c);
    a.addRegistration(c);
    System.out.println("ac : \n" + ac);
    
    // Serialization 
    try
    { 
      //Saving of object in a file 
      FileOutputStream file = new FileOutputStream(filename); 
      ObjectOutputStream out = new ObjectOutputStream(file); 
      
      // Method for serialization of object 
      out.writeObject(ac); 
      
      out.close(); 
      file.close(); 
      
      System.out.println("academy has been serialized"); 

    } 
    
    catch(Exception ex) 
    { 
      System.out.println("Exception is caught"); 
    } 


    Academy ac2 = null; 

    // Deserialization 
    try
    { 
      // Reading the object from a file 
      FileInputStream file = new FileInputStream(filename); 
      ObjectInputStream in = new ObjectInputStream(file); 
      
      // Method for deserialization of object 
      ac2 = (Academy)in.readObject(); 
      
      in.close(); 
      file.close(); 
      
      System.out.println("Academy has been deserialized \n"); 
      System.out.println("ac2 : \n" + ac2); 
      System.out.println("Adding new elements to ac2 : \n"); 


      Student m = ac2.addRegistrant(8,"Mary");
      Student f = ac2.addRegistrant(3,"Francois");
      Course c2 = ac2.addCourse("AN234"); 
      m.addRegistration(c2);
      f.addRegistration(c2);

      System.out.println("***************"); 
      System.out.println("ac2 : \n" + ac2); 
    } 
    
    catch(Exception ex) 
    { 
      System.out.println("Exception is caught"); 
    } 

    System.out.println("Adding same elements to ac : \n"); 

    Student m2 = ac.addRegistrant(8,"Mary");
    Student f2 = ac.addRegistrant(3,"Francois");
    Course c22 = ac.addCourse("AN234"); 
    m2.addRegistration(c22);
    f2.addRegistration(c22);

    System.out.println("***************"); 
    System.out.println("ac : \n" + ac); 

  } 
} 