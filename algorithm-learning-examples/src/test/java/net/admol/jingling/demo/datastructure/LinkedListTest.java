package net.admol.jingling.demo.datastructure;

import net.admol.jingling.demo.datastructure.linkedlist.SingleNode;
import org.junit.Test;

/**
 * @author : jingling
 * @Date : 2018/10/15
 */
public class LinkedListTest{

    @Test
    public void testL(){
        SingleNode nodeA = new SingleNode("A");
        SingleNode nodeB = new SingleNode("B");
        SingleNode nodeC = new SingleNode("C");
        nodeA.setNext(nodeB);
        nodeB.setNext(nodeC);
        printNode(nodeA);
        SingleNode resNode = reverseNodeList(nodeA);
        printNode(resNode);
        printNode(nodeA);

        SingleNode circleA = new SingleNode("A");
        SingleNode circleB = new SingleNode("B");
        SingleNode circleC = new SingleNode("C");
        SingleNode circleD = new SingleNode("D");
        SingleNode circleE = new SingleNode("E");
        circleA.setNext(circleB);
        circleB.setNext(circleC);
        circleC.setNext(circleD);
        circleD.setNext(circleE);
        circleE.setNext(circleA);
        System.out.println(checkCircle(circleA));
    }
    private static void printNode(SingleNode node){
        StringBuffer sb = new StringBuffer();
        while(node != null){
            sb.append(node.getData()+" ");
            node = node.getNext();
        }
        System.out.println(sb.toString());
    }
    private static SingleNode reverseNodeList(SingleNode node){
        SingleNode returnNode = null;
        while(node !=null){
            SingleNode preNode = node.getNext();
            node.setNext(returnNode);
            returnNode = node;
            node = preNode;
        }
        return returnNode;
    }
    //1. 4   5  5
    // 检测环
    public static boolean checkCircle(SingleNode list) {
        boolean result = false;
        if (list == null) return result;
        SingleNode fast = list.getNext();
        SingleNode slow = list;
        int count = 0;
        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            count++;
            if (slow == fast){
                result = true;
                break;
            }
        }
        System.out.println("count:"+count);
        return result;
    }
}
