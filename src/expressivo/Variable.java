package expressivo;

import java.util.Map;

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
        if(this.equals(x)){
            return new Number(1);
        }else{
            return new Number(0);
        }
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
