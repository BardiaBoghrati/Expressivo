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
}
