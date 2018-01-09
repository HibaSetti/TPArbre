public class Abr {
int val;
Abr Fg,Fd,Pere;


//constructor
public Abr (int x)
{
    val=x;
}
    //Creer un arbre
    public void CreerArbre ( Abr a)
    {
        a.Pere=null;
        a.Fg=null;
        a.Fd=null;
    }
    // GetFils Gauche
    public Abr FG()
    {
        return (Fg);
    }
    //GetFilsDroit
    public Abr FD()
    {
        return (Fd);
    }
    //GetValue
    public int GetValue()
    {
        return val;
    }
    //Affecter val
    public void AffInfo (Abr a, int x)
    {
        a.val=x;
    }
    //Affecter fils gauche a l'arbre a
    public Abr AffFg(Abr a, Abr b)
    {
        a.Fg=b;
        return a;
    }
    //Affecter fils droit a l'arbre a
    public Abr AffFd(Abr a, Abr b)
    {
        a.Fd=b;
        return a;
    }
    public Abr AffPere(Abr a,Abr b)
    {
        a.Pere=b.Pere;
        return a;
    }


    public void insertion(int value) {
        if (value == GetValue())
            System.out.println(" la valeur existe déja");
        if (value < GetValue()) {
            if (FG() != null)
                FG().insertion(value);
            else
                Fg = new Abr(value);
        }
        if (value > GetValue()) {
            if (FD() != null)
                FD().insertion(value);
            else
                Fd = new Abr(value);
        }
    }
    public void ParcoursPrefixe() {
        System.out.println(GetValue());
        if (FG() != null)
            FG().ParcoursPrefixe();
        if (FD() != null)
            FD().ParcoursPrefixe();
    }
    public void ParcoursInfixe() {
        if (FG() != null)
            FG().ParcoursInfixe();
        System.out.println(GetValue());


        if (FD() != null)
            FD().ParcoursInfixe();
    }
    public static int hauteur(Abr a) {
        if (a == null)
            return 0;
        else
            return (1 + Math.max(hauteur(a.FG()), hauteur(a.FD())));
    }
    //fct recherche
    public boolean recherche(int value) {
        if (value == GetValue())
            return true;
        if ((value < GetValue()) && (FG() != null))
            return (FG().recherche(value));
        if ((value > GetValue()) && (FD() != null))
            return (FD().recherche(value));
        return false;
    }
    public  Abr PlusPetitGauche(Abr a)
    {
        Abr Tree=new Abr(0);
        if ((a.Fd==null)&&(a.Fg==null))
        {
            AffInfo(Tree,a.val);
            AffFg(Tree,a);
            AffFd(Tree,a);
            AffPere(Tree,a);
        }
        else
        {
            PlusPetitGauche(a.Fg);
        }
        return Tree;
    }
    public Abr PapaPPG(Abr a)
    {
        Abr Tree=new Abr(0);
        if ((a.Fd.Fd==null)&&(a.Fd.Fg==null))

        {
            return (Tree.Fd);
        }
        else
            {


              PapaPPG(a.Fd);
              return(null);
            }
    }
    public void SuppressionCasDeuxFils(Abr a)
    {
        Abr Tree=new Abr(0);
        Tree= PlusPetitGauche(a);
        AffPere(Tree,a);
        AffFg(Tree,a);
        AffFd(Tree,a);
        AffInfo(Tree,a.val);
        AffFd(a.Pere,Tree);
        a=null;


    }
    public void suppression (Abr a,int Valeur){
    Abr Tree =new Abr(0);

        if (Valeur < a.val)//recherche au niveau de sous arbre gauche
        {   if(a.Fg==null)
                {
                   System.out.println("La valeur n'xiste pas");
                }
             else
        {


                 if(Valeur == Fg.val)
                 {

                     /* CORRECTE ****/

                     if((Fg.Fg==null)&&(Fg.Fd==null))
                     {
                        Fg.Pere=null;
                        a.Fg=null;

                     }
                     else
                     {


                         /* CORRECTE */
                        if((Fg.Fg!= null)&&(Fg.Fd==null))
                        {
                            Fg.Pere=null;
                            a.Fg=Fg.Fg;
                            Fg.Fg=a;
                            Fg.Fg=null;


                        }
                        /* CORRECTE */
                        else if((Fg.Fd!= null)&&(Fg.Fg==null))
                        {
                            Fg.Pere=null;
                            a.Fg=Fg.Fd;
                            a.Fg.Pere=a;
                            Fg.Fd=null;

                        }
                        else //avoir deux fils revoir
                        {


                            SuppressionCasDeuxFils(a.Fd);

                        }


                     }
                 }
                 else
                     suppression(Fg,Valeur);
        }
        }
        else if (Valeur >a.val)
        {
            if(a.Fd==null)
            {
                System.out.println("la valeur n'existe pas");
            }
            else
            {


                    if(Valeur==Fd.val)
                    {
                            if((Fd.Fd==null)&&(Fd.Fg==null))
                            {
                               Fd.Pere=null;
                               a.Fd=null;
                            }


                            else
                            {
                                if((Fd.Fd== null)&&(Fd.Fg!=null))
                                {
                                    //remplir
                                }
                                else
                                {
                                    if ((Fd.Fd!=null)&&(Fd.Fg==null))
                                    {
                                            Fd.Pere=null;
                                            a.Fd=Fd.Fd;
                                            Fd.Fd=a;
                                            Fd.Fd=null;

                                    }
                                    else if((Fd.Fd!=null)&&(Fd.Fg!=null))
                                    {

                                        SuppressionCasDeuxFils(a.Fd);
                                    }
                                }
                            }
                    }
                    else
                    {

                        suppression(Fd,Valeur);
                    }
        }
        }
        else  // égualité
        {
            if((a.Pere==null)&&(a.Fd==null)&&(a.Fg==null))
            {
                a=null;
            }
        }

    }
}

