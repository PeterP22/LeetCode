package hackerrank.priorityqueue;
import java.util.*;

public class Priorities
{
    public List<Student> getStudents(List<String> events)
    {
        // make a priority queue
        PriorityQueue<Student> queue = new PriorityQueue<Student>(
                // comparator to reverse the order of the queue
                Comparator.comparing(Student::getCGPA).reversed()
                        .thenComparing(Student::getName)
                        .thenComparing(Student::getID)
        );
        // for each event in events
        for (String event : events)
        {
            // split the parts of the event by space
            String[] parts = event.split(" ");

            // now check the first part of the event
            if (parts[0].equals("ENTER"))
            {
                String name = parts[1];
                double cgpa = Double.parseDouble(parts[2]);
                int id = Integer.parseInt(parts[3]);

                // make a new student
                Student student = new Student(id, name, cgpa);

                // add the student to the queue
                queue.add(student);
            }
            else if (parts[0].equals("SERVED"))
            {
                // remove the student from the queue
                queue.poll();
            }
        }

        // make a list of students
        List<Student> students = new ArrayList<Student>();

        // while loop to add students to the list
        while (!queue.isEmpty())
        {
            students.add(queue.poll());
        }

        // return the list of students
        return students;
    }

}
