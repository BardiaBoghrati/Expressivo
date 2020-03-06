package expressivo;

import java.util.Map;

public class Product implements Expression {
    private final Expression left;
    private final Expression right;
    
    // Abstract function:
    //  represents product of two expressions left * right
    // Representation invariant:
    //  true
    // Safety from rep exposure:
    //  all fields are immutable and final
    
    public Product(Expression left, Expression right){
        this.left = left;
        this.right = right;
    }
    
    @Override
    public String toString(){
        return "("+left+")*("+right+")";
    }
    
    @Override
    public boolean equals(Object that){
        if(that instanceof Product){
            return this.left.equals(((Product) that).left) &&
                    this.right.equals(((Product) that).right);
        }
        
        return false;
    }
    
    @Override
    public int hashCode(){
        return left.hashCode() * right.hashCode();
    }

    @Override
    public Expression differentiate(Expression x) {
        return new Sum(new Product(left, right.differentiate(x)), new Product(right, left.differentiate(x)));
    }

    @Override
    public Expression simplify(Map<Expression, Double> environment) {
        throw new RuntimeException("not implemented");
    }
}
