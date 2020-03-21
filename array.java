import java.util.Scanner;
public class array {
    public static void main(String []args)
    {
        Scanner sc  = new Scanner(System.in);
        System.out.println("Enter number:");
        int no= sc.nextInt();
        int []arr = new int[no];
        for(int i=0;i<no;i++)
        {
            arr[i] = sc.nextInt();
        }
        for(int i=0;i<no;i++)
        {
            System.out.println(arr[i]);
        }
    }
}
