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
        throw new RuntimeException("not implemented");
    }

    @Override
    public boolean isNumber() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public double getValue() throws UnsupportedOperationException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isVariable() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public String getName() throws UnsupportedOperationException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isSum() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isProduct() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Expression getLeftExpression() throws UnsupportedOperationException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Expression getRightExpression() throws UnsupportedOperationException {
        // TODO Auto-generated method stub
        return null;
    }
    
}
