import java.util.Random;

public class Main {

    public static void main(String args[])
    {
        Abr a =new Abr(6);
        int b = (int) (Math.random() * 10 );
      for(int i=0;i<10;i++)
      {
          a.insertion(b);
          b = (int) (Math.random() * 10 );
      }

        a.ParcoursInfixe();
      System.out.println("la hauteur est :"+ Abr.hauteur(a));
       if( a.recherche(31) == true )
           System.out.println("le nombre existe");
       else
           System.out.println(" n'existe pas");
    }
}
