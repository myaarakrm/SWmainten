package mainten;

public class User {
    String name;
    String pass;
    int ID;
    
    public User(String name, String pass, int ID){
        this.name = name;
        this.pass = pass;
        this.ID = ID;  
    }
    
    public String getName()
    {
        return this.name;
    }
    public String getPass()
    {
        return this.pass;
       
    }
       public int getID()
    {
        return this.ID;
       
    }
    
    
}
