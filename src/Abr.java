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
        a=null;
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

    /*Ajouter Noeud
    public Abr Insert(Abr a, int x)
    {
        if ( a!= null)
        {
            if ( x == GetValue())
                System.out.println(" la valeur existe déja");
            else
            {
                if (x > GetValue())


            }
        }
        else {
            a.val = x;
        }
    }
    */
    public void insertion(int value) {
        if (value == GetValue())
            return;  // la valeur est deja dans l'arbre
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

}

