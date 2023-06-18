import java.util.PriorityQueue;

public class merge_2_sorted_lists {
    static Node mergeKList(Node[]a,int k)
    {
        Node head=null,itr=null;
        PriorityQueue<Node> q=new PriorityQueue<>((p,r)->{ return p.data-r.data;});
    
        for(int i=0;i<k;i++)
        q.add(a[i]);
    
        for (Node u: a)
        System.out.print(u.data+" ");
        while(q.size()>0)
        {
            Node temp=q.remove();
            Node n=new Node(temp.data);
            if(head==null)
            {
                head=n;
                itr=head;
            }
            else
            {
                itr.next=n;
                itr=itr.next;
            }
            temp=temp.next;
            if(temp!=null)
            q.add(temp);
        }
        return head;
    }
public static void main(String[] args) {
    Node h1=new Node(1);
    Node h2=new Node(2);
    Node h3=new Node(3);
    
    Node i1=new Node(4);
    Node i2=new Node(5);
    
    Node t1=new Node(5);
    Node t2=new Node(6);
    
    Node l1=new Node(7);
    Node l2=new Node(8);

    h1.next=h2;
    h2.next=h3;
    
    i1.next=i2;

    t1.next=t2;

    l1.next=l2;

    Node[]a={h1,i1,t1,l1};
    Node head=mergeKList(a,4);
    while(head!=null)
    {
        System.out.print(head.data+" ");
        head=head.next;
    }
}
    
}
class Node{
    int data;
    Node next;

    Node(int data){
        this.data=data;
        this.next=null;
    }
}
