package expressivo;

public class Number implements Expression {
    private final double number;
    
    // Abstract function:
    //  this.number represents real valued number
    // Representation Invariant:
    //  this.number >= 0
    // Safety from rep exposure:
    //  all fields are immutable and final
    
    private void checkRep(){
        assert this.number >= 0;
    }
    
    public Number(double number){
        this.number = number;
        
        checkRep();
    }
    
    @Override
    public String toString(){
        return String.valueOf(number);
    }
    
    @Override
    public boolean equals(Object that){
        if(that instanceof Number){
            return this.number == ((Number)that).number;
        }
        
        return false;
    }
    
    @Override
    public int hashCode(){
        return Double.hashCode(number);
    }
}
