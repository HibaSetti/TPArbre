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
    public boolean recherche(int value) {
        if (value == GetValue())
            return true;
        if ((value < GetValue()) && (FG() != null))
            return (FG().recherche(value));
        if ((value > GetValue()) && (FD() != null))
            return (FD().recherche(value));
        return false;
    }
}

