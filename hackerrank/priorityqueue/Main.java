package hackerrank.priorityqueue;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    // make a main method to check
    public static void main(String[] args)
    {
        // make a new Priorities object
        Priorities priorities = new Priorities();

        // make a list of events
        List<String> events = new ArrayList<String>();

        // add the events to the list
        events.add("ENTER John 3.75 50");
        events.add("ENTER Mark 3.8 24");
        events.add("ENTER Shafaet 3.7 35");
        events.add("SERVED");
        events.add("SERVED");
        events.add("ENTER Samiha 3.85 36");
        events.add("SERVED");
        events.add("ENTER Ashley 3.9 42");
        events.add("ENTER Maria 3.6 46");
        events.add("ENTER Anik 3.95 49");
        events.add("ENTER Dan 3.95 50");
        events.add("SERVED");

        // get the students from the events
        List<Student> students = priorities.getStudents(events);

        // loop through the students
        for (Student student : students)
        {
            // print the student
            System.out.println(student.getName());
        }
    }
}
