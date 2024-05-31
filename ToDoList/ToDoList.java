package ToDoList;

public class ToDoList {
    private Node head;

    public ToDoList() {
        this.head = null;
    }

    public void addToDo(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void markToDoAsCompleted(String title) {
        Node current = head;
        while (current != null) {
            if (current.task.getTitle().equals(title)) {
                current.task.markCompleted();
                return;
            }
            current = current.next;
        }
        System.out.println("Task with title '" + title + "' not found.");
    }

    public void viewToDoList() {
        Node current = head;
        while (current != null) {
            Task task = current.task;
            System.out.println("Title: " + task.getTitle());
            System.out.println("Description: " + task.getDescription());
            System.out.println("Completed: " + task.isCompleted());
            System.out.println("-------------------------");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();

        // Adding tasks
        toDoList.addToDo(new Task("Task 1", "Description for Task 1"));
        toDoList.addToDo(new Task("Task 2", "Description for Task 2"));
        toDoList.addToDo(new Task("Task 3", "Description for Task 3"));

        // Viewing tasks
        System.out.println("To-Do List:");
        toDoList.viewToDoList();

        // Marking a task as completed
        toDoList.markToDoAsCompleted("Task 2");

        // Viewing tasks again to see the changes
        System.out.println("To-Do List after marking 'Task 2' as completed:");
        toDoList.viewToDoList();
    }
}

