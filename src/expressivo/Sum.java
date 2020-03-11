package expressivo;

import java.util.Map;

public class Sum implements Expression {
    private final Expression left;
    private final Expression right;
    
    // Abstract function:
    //  represents sum of two expressions left + right
    // Representation invariant:
    //  true
    // Safety from rep exposure:
    //  all fields are immutable and final
    
    public Sum(Expression left, Expression right){
        this.left = left;
        this.right = right;
    }
    
    @Override
    public String toString(){
        return "("+left+")+("+right+")";
    }
    
    @Override
    public boolean equals(Object that){
        if(that instanceof Sum){
            return this.left.equals(((Sum) that).left) &&
                    this.right.equals(((Sum) that).right);
        }
        
        return false;
    }
    
    @Override
    public int hashCode(){
        return left.hashCode() + right.hashCode();
    }

    @Override
    public Expression differentiate(Expression x) {
        return new Sum(left.differentiate(x), right.differentiate(x));
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
