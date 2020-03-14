package expressivo;

import java.util.Map;

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
    
    @Override
    public Expression differentiate(Expression x){
        return new Number(0);
    }
    
    @Override
    public Expression simplify(Map<Expression, Double> environment) {
        return this;
    }

    @Override
    public boolean isNumber() {
        return true;
    }

    @Override
    public double getValue() throws UnsupportedOperationException {
        return number;
    }

    @Override
    public boolean isVariable() {
        return false;
    }

    @Override
    public String getName() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("operation is undedfined on numbers");
    }

    @Override
    public boolean isSum() {
        return false;
    }

    @Override
    public boolean isProduct() {
        return false;
    }

    @Override
    public Expression getLeftExpression() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("operation is undedfined on numbers");
    }

    @Override
    public Expression getRightExpression() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("operation is undedfined on numbers");
    }
    
}
