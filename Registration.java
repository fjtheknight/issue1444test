//%% NEW FILE Registration BEGINS HERE %%

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4260.b21abf3a3 modeling language!*/


import java.io.Serializable;

// line 20 "model.ump"
// line 83 "model.ump"
public class Registration implements java.io.Serializable
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Registration Associations
  private Student student;
  private Course course;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Registration(Student aStudent, Course aCourse)
  {
    boolean didAddStudent = setStudent(aStudent);
    if (!didAddStudent)
    {
      throw new RuntimeException("Unable to create registration due to student");
    }
    boolean didAddCourse = setCourse(aCourse);
    if (!didAddCourse)
    {
      throw new RuntimeException("Unable to create registration due to course");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  /**
   * Derived delegated attribute used for sorting
   * printing
   */

  public String getName()
  {
    return getStudent().getName();
  }

  /**
   * Derived delegated attribute used for sorting
   * printing
   */

  public String getCode()
  {
    return getCourse().getCode();
  }
  /* Code from template association_GetOne */
  public Student getStudent()
  {
    return student;
  }
  /* Code from template association_GetOne */
  public Course getCourse()
  {
    return course;
  }
  /* Code from template association_SetOneToMany */
  public boolean setStudent(Student aStudent)
  {
    boolean wasSet = false;
    if (aStudent == null)
    {
      return wasSet;
    }

    Student existingStudent = student;
    student = aStudent;
    if (existingStudent != null && !existingStudent.equals(aStudent))
    {
      existingStudent.removeRegistration(this);
    }
    student.addRegistration(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setCourse(Course aCourse)
  {
    boolean wasSet = false;
    if (aCourse == null)
    {
      return wasSet;
    }

    Course existingCourse = course;
    course = aCourse;
    if (existingCourse != null && !existingCourse.equals(aCourse))
    {
      existingCourse.removeRegistration(this);
    }
    course.addRegistration(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Student placeholderStudent = student;
    this.student = null;
    if(placeholderStudent != null)
    {
      placeholderStudent.removeRegistration(this);
    }
    Course placeholderCourse = course;
    this.course = null;
    if(placeholderCourse != null)
    {
      placeholderCourse.removeRegistration(this);
    }
  }

  // line 36 "model.ump"
   public String toString(){
    return "Registration: " + getName()
      + ":" + getCode();
  }

}