/*
 * Main Menu
 *  - Stack[/]
 *  - Queue[]
 *  - Quit[/]
 *
 * Stack
 *  - Push to stack[/]
 *  - Pop from stack[/]
 *  - Display stack[/]
 *
 * Queue
 *  - Queue[]
 *  - Dequeue[]
 *  - Display[]
 */

/*Sources (used to refresh my memory and also write the introduction)
 *  - Javatpoint: https://www.javatpoint.com/java-priorityqueue
 *  - Jenkov.com: http://tutorials.jenkov.com/java-collections/stack.html
 *  - StackOverflow: https://stackoverflow.com/questions/37604338/unchecked-call-to-pushe-as-a-member-of-the-raw-type-stack
 */

//Modules required
import java.util.Scanner;
import java.util.Stack; /* Holds functions for stacks*/
import java.util.LinkedList; /*Internal module used to edit queues*/
import java.util.Queue; /*Contains functions for queues*/

/* Introduction:
 * What is a Stack?:
 *      - A collection of memory blocks held one on top of the other (TL;DR)
 *      - A type of data structure in many programming languages (including Java)
 *      - Considered a "secondary data structure" as it is coded over either an array or a linked list
 *      - Used in solving problems dealing with recursion or anything with the
 *      LIFO (Last-in, First-out) architecture
 *      == Also called a "Memory Stack" or in some cases a "Node Stack" but these are often used in other contexts
 *      X A stack is NOT a Heap
 *
 *      - Illustration: A stack of characters
 *              [A] <-- Top
 *              [B]
 *              [C]
 *              [D]
 *              [E]
 *
 * What is a Queue?:
 *      - A collection of memory blocks held end-to-end of one another (TL;DR)
 *      - A type of data structure in many programming languages (including Java)
 *      - Considered a "secondary data structure" as it is coded over either an array or a linked list
 *      - Used in solving problems dealing with ordered operations or anything with the
 *      FIFO (First-in, First-out) architecture
 *      - Helpful when dealing with problems that need multiple streams open which need to communicate to one another
 *      - A classic example would be the "Producer - Consumer" problem
 *      <> A queue can be implemented in multiple ways
 *          1. Linked List <-- I Used this one because it was the easiest to implement (in my opinion)
 *          2. Priority Queue
 *          3. Blocking Queue
 *      == Also called a "Circular Queue" if it can wrap around to the start once it finishes
 *      X A queue is NOT an array
 *
 *      - Illustration: A queue of numbers
 *              [10][20][30][40][50]
 *               ^                ^
 *               |                |
 *               |                |
 *              Tail            Head
 *
 * Common themes:
 *      - Any one item in a stack or queue is called an Element
 *      - A stack/queue can only hold one type of data unless instructed otherwise (usually in the case of struts)
 */

//Begin main class
public class ShainaMidtermsStackType
{
    //Fixed C type declaration of args
    public static void main(String[] args)
    {
        //Start scanner
        Scanner input = new Scanner(System.in);
        char cChoice; /*Renamed to follow standard coding convention*/

        //Begin main loop
        do
        {
            //Main Menu
            System.out.print("What Would You like To Do?\n---------------------------------------------------" +
                    "\n\tA - Stack\n\tB - Queue \n\tC - Exit\n   " +
                    "------------------------------------- \n\nInput Choice: ");

            cChoice = input.next().charAt(0);

            //User chooses to manipulate a stack
            if (cChoice == 'a' || cChoice == 'A')
            {
                //Gets use input for how big the stack will be
                //We do this here because we need to check for fullness/emptiness in the succeeding functions
                int nMaxStack;
                System.out.println("How big will the stack be?");
                nMaxStack = input.nextInt();

                /*"Stack" is a datatype which, when paired with the diamond operator,
                 * can be designated to hold a certain type of element or left empty to hold generic data
                 * but this often results in a warning.
                 *
                 * A stack is created the same way most objects in java are created:
                 *      Stack<datatype> [StackName] = new Stack<>(); <-- For specific data
                 *      Stack [StackName] = new Stack(); <-- For generic data
                 *
                 * Below is initialized an empty stack of numbers
                 */
                Stack<Integer> stack = new Stack<>();

                //We set up a catch to tell us when the user is done editing the stack
                boolean bEditingStack = true;

                //Begin stack loop and stack functions
                while(bEditingStack)
                {
                    //Stack Menu
                    System.out.print("What Would You like To Do To The Stack?\n---------------------------------------------------" +
                            "\n\tA - Push\n\tB - Pop \n\tC - Display \n\tD - Exit\n   " +
                            "------------------------------------- \n\nInput Choice: ");
                    char cStackChoice = input.next().charAt(0);

                    //Push to stack
                    if (cStackChoice =='a'||cStackChoice =='A')
                    {
                        /*First we check if the stack is allowed to accept another member
                         * by comparing the current size of the stack to the previous value
                         * set by the user we can evaluate if we are allowed to add another
                         * element to the stack
                         */
                        if(stack.size() < nMaxStack)
                        {
                            //Get number from user
                            System.out.println("Enter a number: ");
                            int nStackValue = input.nextInt();
                            /*The push function allows us to "push" elements into a stack,
                             *  effectively pushing any other elements already in the stack further down.
                             *  This is why, when we retrieve an element from the stack, we always get the
                             *  last element "pushed" onto/into the stack.
                             *
                             *  We push elements onto a stack by calling the stack and using the in-built push function:
                             *       [StackName].push([Element to be pushed]);
                             *
                             *  Below we push the element stored in "nStackValue"
                             */
                            stack.push(nStackValue);

                            /*The peek function allows us to "peek at" the element on top of the stack,
                             *  without deleting the element. The peek function is a safe alternative to
                             *  the pop function, which deletes the element which it "pops"
                             *
                             *  We peek at a stack by calling the stack and using the in-built peek function:
                             *       [StackName].peek(); <-- Returns the top element of the stack
                             *
                             *  Below we print the element stored at the top of the stack
                             */
                            System.out.println("Pushed " + stack.peek() + " to stack");
                        }

                        //If we are not allowed to add any elements we prompt the user with this info
                        else
                            System.out.println("The stack is full");
                    }

                    //Pop from stack
                    else if (cStackChoice == 'b' || cStackChoice =='B')
                    {
                        if (!stack.isEmpty())
                        {
                            //We peek first because once the number on top of the stack is popped it's
                            //gone forever.
                            System.out.println("Popped " + stack.peek() + " from stack");
                            /*The pop function allows us to remove elements from the top of a stack,
                             *  effectively pulling any other elements already in the stack further up.
                             *  So the element that was entered before the element that was "popped" is now
                             *  on top of the stack.
                             *
                             *  We pop elements from a stack by calling the stack and using the in-built pop function:
                             *       [StackName].pop();
                             *
                             *  Below we pop whatever element is current stored at the top of the stack
                             */
                            stack.pop();
                        }

                        //If the stack is empty we prompt the user with this info
                        else
                            System.out.println("The stack is empty");
                    }

                    //Display stack, via implicit display
                    else if(cStackChoice == 'c' || cStackChoice =='C')
                    {
                        if (!stack.isEmpty())
                        {
                            /*Displaying a stack can be done in this fashion;
                             * It is VERY IMPORTANT to note though, this does not obey the LIFO order, but rather the
                             * FIFO order. This means that instead of printing the stack from top to bottom it does the
                             * opposite and prints it from bottom to top.
                             */
                            System.out.println("Stack contains: " + stack);
                        }

                        //If the stack is empty we prompt the user with this info
                        else
                            System.out.println("The stack is empty");
                    }

                    //If the user decides he is done with this particular stack we exit the stack loop
                    else
                        bEditingStack = false;
                }
            }

            else if(cChoice == 'b' || cChoice == 'B')
            {
                //Gets use input for how big the queue will be
                //We do this here because we need to check for fullness/emptiness in the succeeding functions
                int nMaxQueue;
                System.out.println("How big will the queue be?");
                nMaxQueue = input.nextInt();

                /*"Queue" is a datatype which, is a subtype of the Collections class of java
                 * it can be used much like stack and even has a similar initialization sequence.
                 * But the difference of a queue is the order by which operations are done to it.
                 * Where a stack is LIFO, a queue is FIFO.
                 *
                 * A queue is created the same way a stack is created, with one key difference:
                 *      Queue<datatype> [QueueName] = new LinkedList<>(); <-- LinkedList is what makes FIFO happen
                 *
                 * Below is initialized an empty waiting queue of numbers
                 */
                Queue<Integer> queue = new LinkedList<>();

                //We set up a catch to tell us when the user is done editing the queue
                boolean bEditingQueue = true;

                //Begin queue loop and queue functions
                while(bEditingQueue)
                {
                    //Queue Menu
                    System.out.print("What Would You like To Do To The Queue?\n---------------------------------------------------" +
                            "\n\tA - Enqueue\n\tB - Dequeue \n\tC - Display \n\tD - Exit\n   " +
                            "------------------------------------- \n\nInput Choice: ");
                    char cQueueChoice = input.next().charAt(0);

                    //Enqueue, via the add method
                    if(cQueueChoice == 'a' || cQueueChoice == 'A')
                    {
                        if(queue.size() < nMaxQueue)
                        {
                            System.out.println("Enter a number: ");
                            int nQueueValue = input.nextInt();
                            queue.add(nQueueValue);
                            //This only serves to inform the user, since it doesn't actually refer to the queue
                            System.out.println("Enqueued " + nQueueValue + " to queue");
                        }

                        else
                            System.out.println("Queue is full");
                    }

                    //Dequeue, via the poll method
                    else if(cQueueChoice == 'b' || cQueueChoice == 'B')
                    {
                        if(queue.size() > 0)
                        {
                            /*We can call this because even though queue.poll() removes the element at the tail
                             * of the queue it also return said element allowing us to use it or store it after
                             * it has been removed.
                             */
                            System.out.println("Successfully Dequeued " + queue.poll() + " from queue");
                        }

                        else
                            System.out.println("Queue is empty");
                    }

                    //Display, via implicit display
                    else if(cQueueChoice == 'c' || cQueueChoice == 'C')
                    {
                        if(!queue.isEmpty())
                            System.out.println("Queue: " + queue);
                        else
                            System.out.println("Queue is empty");
                    }

                    else
                        bEditingQueue = false;
                }
            }
        }
        //Terminate the loop if the user has chosen to exit the program
        while (!(cChoice == 'c' || cChoice == 'C'));
        //Exit the program
        System.exit(0);
    }
}