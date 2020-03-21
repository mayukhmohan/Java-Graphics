import java.lang.Thread;
class A extends Thread
{
    public void run()
    {
        for(int i=0;i<5;i++)
        {
            System.out.println("A:"+i);
        }
        System.out.println("Exiting from A");
    }
}
class B extends Thread
{
    public void run()
    {
        for(int i=0;i<5;i++)
        {
            System.out.println("B:"+i);
        }
        System.out.println("Exiting from B");
    }
}
public class threading {
    public static void main(String []args){
        A a=new A();
        B b=new B();
        a.start();
        b.start();
    }
}
