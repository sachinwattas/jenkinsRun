public class StringsConcepts {

    public static void main(String [] args)
    {
        String A= "CBC";

        String b= new String();

        System.out.println(A.length());

        System.out.println(b.length());


        //Reverse a string
        for(int i= A.length()-1; i>=0; i--)
        {
            b= b+ A.charAt(i);
            System.out.println(A.charAt(i));
        }

        System.out.println(b);

        if(A==b)
            System.out.println("Strings are equal");

        else
            System.out.println("Strings are not equal");

        //Replace the string
        System.out.println(A.replace('C', 'D'));

        //uppercase A string
        System.out.println(A.toLowerCase());

        //Character to String

        char[]chars= {'a','b','c'};
        String c= "SSS";


    }
}
