import java.util.Scanner;
import java.util.ArrayList;
This is test comment.
class MaxPalindrome
{
    public static Boolean PalinDrome(String s)
    {
        int flag=0;
        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i) != s.charAt(((s.length()-1)-i)))
            {
                flag=1;
                break;
            }
        }
        if(flag==0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static int count(ArrayList<String> A, int i)
    {
        int count2=1;
        for(int j=0; j<A.size(); j++)
        {
             if(A.get(i).length()<A.get(j).length())
            {
                break;
            }
            else if(j==i)
            {
                continue;
            }
            else if(A.get(i).equals(A.get(j)))
            {
                count2=count2+1;
            }
        }
        return count2;
    }
    public static void main(String []args)
    {
        System.out.println("Enter Your String:-");
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int l=0;
        int count=0;
        int count1=0;
        boolean x;
        ArrayList<String> A=new ArrayList<String>();
        for(int i=2; i<=s.length(); i++)
        {
            int k=1;
            for(int j=0; j<s.length(); j++)
            {
                if(k==i)
                {
                    String s1=s.substring(l, j+1);
                    x=PalinDrome(s1);
                    if(x==true)
                    {
                        A.add(s1);
                        count1=count1+1;  
                    } 
                    l=l+1;
                    k=1; 
                    count=1; 
                }
                if(count!=0)
                {
                    k=i;
                }
                else
                {
                    k=k+1;
                }
            }
            l=0;
            count=0;
        }
        if(count1!=0)
        {
            System.out.println("All possible PalinDrome Strings is/are:-");
            for(int i=0; i<A.size(); i++)
            {
                System.out.print("'"+A.get(i)+"' ");
            }
            System.out.println("\nDifferent PalinDrome String and how much time they come is/are:-");
            int flag=0;
            int count2=0;
            for(int i=0; i<A.size(); i++)
            {
                if(i==0)
                {
                    count2=count(A,i);
                    System.out.print("'"+A.get(i)+"'"+":-"+count2+" ");
                }
                else
                {
                    count2=count(A,i);
                    for(int j=i-1; j>=0; j--)
                    {
                        if(A.get(j).equals(A.get(i)))
                        {
                            flag=1;
                            break;
                        }
                    }
                    if(flag==1)
                    {
                        flag=0;
                        continue;
                    }
                    System.out.print("'"+A.get(i)+"'"+":-"+count2+" ");
                    count2=1;
                }
            }
            System.out.println("\nThe Maximum size of Palindrome String is:-"+A.get(A.size()-1).length());
            System.out.println("Maximum size Palindrome Strings is/are:-");
            for(int i=0; i<A.size(); i++)
            {
                if(A.get(i).length()==A.get(A.size()-1).length())
                {
                    System.out.print("'"+A.get(i)+"'"+" ");
                }    
            }
        }
        else if(s.length()!=0)
        {
            System.out.println("Given String has no Palindrome String");
        }
        else
        {
            System.out.println("Given input is wrong");
        }
    }
}