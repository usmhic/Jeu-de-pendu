package Socket;

public class Var {
    
    public int val;
    public boolean pretaecrire;
    
    public Var(){
        val=0;
        pretaecrire=true;
    }
    
    public int lire(){
        while(pretaecrire==true){}
        pretaecrire=true;
        return val;
    }
    
    public void ecrire(int v){
        while (pretaecrire==false){}
        pretaecrire=false;
        val=v;
    }
}