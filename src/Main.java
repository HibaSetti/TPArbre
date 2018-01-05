public class Main {

    public static void main(String args[])
    {
        Abr a =new Abr(6);
        a.insertion(5);
        a.insertion(7);
        a.insertion(8);
        a.insertion(3);
        a.insertion(1);

        a.ParcoursInfixe();
       // System.out.println("la hauteur est :"+ Abr.hauteur(a));
       if( a.recherche(31) == true )
           System.out.println("le nombre existe");
       else
           System.out.println(" n'existe pas");
    }
}
