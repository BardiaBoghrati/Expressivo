package expressivo;

public class Variable implements Expression {
    private final String name;
    
    // Abstract function:
    //  represents variable with name: this.name
    // Representation invariant:
    //  name is non-empty case-insensitive sequence of letters
    // Safety from rep exposure:
    //  all fields are immutable and final
    
    private void checkRep(){
        assert name.matches("[a-zA-z]+");
    }
    
    public Variable(String name){
        this.name = name;
        
        checkRep();
    }
    
    @Override
    public String toString(){
        return name;
    }
    
    @Override
    public boolean equals(Object that){
        if(that instanceof Variable){
            return this.name.equals(((Variable)that).name);
        }
        
        return false;
    }
    
    @Override
    public int hashCode(){
        return name.hashCode();
    }

    @Override
    public Expression differentiate(Expression x) {
        throw new RuntimeException("method not implemented");
    }
}
