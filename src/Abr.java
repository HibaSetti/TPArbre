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
    public Abr GetFG()
    {
        return (Fg);
    }
    //GetFilsDroit
    public Abr GetFD()
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
            if (GetFG() != null)
                GetFG().insertion(value);
            else
                Fg = new Abr(value);
        }
        if (value > GetValue()) {
            if (GetFD() != null)
                GetFD().insertion(value);
            else
                Fd = new Abr(value);
        }
    }
    public void ParcoursPrefixe() {
        System.out.println(GetValue());
        if (GetFG() != null)
            GetFG().ParcoursPrefixe();
        if (GetFD() != null)
            GetFD().ParcoursPrefixe();
    }
    public void ParcoursInfixe() {
        if (GetFG() != null)
            GetFG().ParcoursInfixe();
        System.out.println(GetValue()+"\n");
        System.out.println("/");
        System.out.println("/");

        if (GetFD() != null)
            GetFD().ParcoursInfixe();
    }
}

