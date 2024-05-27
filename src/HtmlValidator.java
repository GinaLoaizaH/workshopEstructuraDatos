import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class HtmlValidator {

    public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> queue) {

        /* IMPLEMENT THIS METHOD! */

        Stack<HtmlTag> stack = new Stack<>();


        while (!queue.isEmpty()) {


            if (!queue.peek().isSelfClosing()) {

                if (queue.peek().isOpenTag()) {
                    stack.push(queue.remove());
                } else {
                    if (!stack.isEmpty()) {
                        if (!queue.peek().matches(stack.peek())) {
                            return stack;
                        } else {
                            stack.pop();
                            queue.remove();
                        }
                    } else {
                        return null;
                    }
                }
            } else {
                queue.remove();

            }

        }
        return stack;
    }
}