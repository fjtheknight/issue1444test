//%% NEW FILE Academy BEGINS HERE %%

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4260.b21abf3a3 modeling language!*/


import java.util.*;
import java.io.Serializable;

/**
 * This example demonstrates two cases of sorted
 * associations. The main program adds items out
 * of order. But when they are printed the output
 * will be sorted
 * Mixin with main program and toString method
 */
// line 6 "model.ump"
// line 42 "model.ump"
// line 78 "model.ump"
public class Academy implements java.io.Serializable
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Academy Attributes
  private transient Comparator<Course> coursesPriority;
  private transient Comparator<Student> registrantsPriority;

  //Academy Associations
  private List<Course> courses;
  private List<Student> registrants;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Academy()
  {
    coursesPriority = 
      Comparator.comparing(Course::getCode);
    registrantsPriority = 
      Comparator.comparing(Student::getId);
    courses = new ArrayList<Course>();
    registrants = new ArrayList<Student>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCoursesPriority(Comparator<Course> aCoursesPriority)
  {
    boolean wasSet = false;
    coursesPriority = aCoursesPriority;
    wasSet = true;
    return wasSet;
  }

  public boolean setRegistrantsPriority(Comparator<Student> aRegistrantsPriority)
  {
    boolean wasSet = false;
    registrantsPriority = aRegistrantsPriority;
    wasSet = true;
    return wasSet;
  }

  public Comparator<Course> getCoursesPriority()
  {
    return coursesPriority;
  }

  public Comparator<Student> getRegistrantsPriority()
  {
    return registrantsPriority;
  }
  /* Code from template association_GetMany */
  public Course getCourse(int index)
  {
    Course aCourse = courses.get(index);
    return aCourse;
  }

  public List<Course> getCourses()
  {
    List<Course> newCourses = Collections.unmodifiableList(courses);
    return newCourses;
  }

  public int numberOfCourses()
  {
    int number = courses.size();
    return number;
  }

  public boolean hasCourses()
  {
    boolean has = courses.size() > 0;
    return has;
  }

  public int indexOfCourse(Course aCourse)
  {
    int index = courses.indexOf(aCourse);
    return index;
  }
  /* Code from template association_GetMany */
  public Student getRegistrant(int index)
  {
    Student aRegistrant = registrants.get(index);
    return aRegistrant;
  }

  public List<Student> getRegistrants()
  {
    List<Student> newRegistrants = Collections.unmodifiableList(registrants);
    return newRegistrants;
  }

  public int numberOfRegistrants()
  {
    int number = registrants.size();
    return number;
  }

  public boolean hasRegistrants()
  {
    boolean has = registrants.size() > 0;
    return has;
  }

  public int indexOfRegistrant(Student aRegistrant)
  {
    int index = registrants.indexOf(aRegistrant);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfCourses()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Course addCourse(String aCode)
  {
    return new Course(aCode, this);
  }

  public boolean addCourse(Course aCourse)
  {
    boolean wasAdded = false;
    if (courses.contains(aCourse)) { return false; }
    Academy existingAcademy = aCourse.getAcademy();
    boolean isNewAcademy = existingAcademy != null && !this.equals(existingAcademy);
    if (isNewAcademy)
    {
      aCourse.setAcademy(this);
    }
    else
    {
      courses.add(aCourse);
    }
    wasAdded = true;
    if(wasAdded)
        Collections.sort(courses, coursesPriority);
    
    return wasAdded;
  }

  public boolean removeCourse(Course aCourse)
  {
    boolean wasRemoved = false;
    //Unable to remove aCourse, as it must always have a academy
    if (!this.equals(aCourse.getAcademy()))
    {
      courses.remove(aCourse);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfRegistrants()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Student addRegistrant(int aId, String aName)
  {
    return new Student(aId, aName, this);
  }

  public boolean addRegistrant(Student aRegistrant)
  {
    boolean wasAdded = false;
    if (registrants.contains(aRegistrant)) { return false; }
    Academy existingAcademy = aRegistrant.getAcademy();
    boolean isNewAcademy = existingAcademy != null && !this.equals(existingAcademy);
    if (isNewAcademy)
    {
      aRegistrant.setAcademy(this);
    }
    else
    {
      registrants.add(aRegistrant);
    }
    wasAdded = true;
    if(wasAdded)
        Collections.sort(registrants, registrantsPriority);
    
    return wasAdded;
  }

  public boolean removeRegistrant(Student aRegistrant)
  {
    boolean wasRemoved = false;
    //Unable to remove aRegistrant, as it must always have a academy
    if (!this.equals(aRegistrant.getAcademy()))
    {
      registrants.remove(aRegistrant);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  /* Code from template association_sorted_serializable_readObject */ 
  private void readObject(java.io.ObjectInputStream in)
  throws Exception
  {
    in.defaultReadObject();

    coursesPriority = 
      Comparator.comparing(Course::getCode);
    registrantsPriority = 
      Comparator.comparing(Student::getId);
  }
  
  public void delete()
  {
    for(int i=courses.size(); i > 0; i--)
    {
      Course aCourse = courses.get(i - 1);
      aCourse.delete();
    }
    for(int i=registrants.size(); i > 0; i--)
    {
      Student aRegistrant = registrants.get(i - 1);
      aRegistrant.delete();
    }
  }

  // line 44 "model.ump"
   public String toString(){
    String result="Students:\n";
    for (Student s: getRegistrants()) {
      result +=s + "\n";
    }
    result +="Courses:\n";
    for (Course c: getCourses()) {
      result +=c + "\n";
    }

    return result;
  }

}