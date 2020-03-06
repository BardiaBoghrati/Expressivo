/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package expressivo;

import java.util.Map;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import expressivo.parser.ExpressionLexer;
import expressivo.parser.ExpressionParser;

/**
 * An immutable data type representing a polynomial expression of:
 *   + and *
 *   nonnegative integers and floating-point numbers
 *   variables (case-sensitive nonempty strings of letters)
 * 
 * <p>PS3 instructions: this is a required ADT interface.
 * You MUST NOT change its name or package or the names or type signatures of existing methods.
 * You may, however, add additional methods, or strengthen the specs of existing methods.
 * Declare concrete variants of Expression in their own Java source files.
 */
public interface Expression {
    
    // Datatype definition
    //   Expression = Number(numb:double) + Variable(name:String) + 
    //                Sum(left:Expression, right:Expression) + 
    //                Product(left:Expression, right:Expression)
    
    /**
     * Parse an expression.
     * @param input expression to parse, as defined in the PS3 handout.
     * @return expression AST for the input
     * @throws IllegalArgumentException if the expression is invalid
     */
    public static Expression parse(String input) {
        // create a stream of characters from string
        CharStream stream = new ANTLRInputStream(input);
        
        // make a lexer
        ExpressionLexer lexer = new ExpressionLexer(stream);
        lexer.reportErrorsAsExceptions();
        
        // read tokens from stream
        TokenStream tokens = new CommonTokenStream(lexer);
        
        // parser the token stream
        ExpressionParser parser = new ExpressionParser(tokens);
        parser.reportErrorsAsExceptions();
        
        // use parser to create parse tree matching the entire input
        ParseTree tree;
        try {
            tree = parser.root();
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("ParseError: invalid expression");
        }
        
        // traverse the parse tree and construct a Expression object
        ParseTreeWalker walker = new ParseTreeWalker();
        MakeExpression exprMaker = new MakeExpression();
        walker.walk(exprMaker, tree);
        
        return exprMaker.getExpression();
    }
    
    /**
     * @return a parsable representation of this expression, such that
     * for all e:Expression, e.equals(Expression.parse(e.toString())).
     */
    @Override 
    public String toString();

    /**
     * @param thatObject any object
     * @return true if and only if this and thatObject are structurally-equal
     * Expressions, as defined in the PS3 handout.
     */
    @Override
    public boolean equals(Object thatObject);
    
    /**
     * @return hash code value consistent with the equals() definition of structural
     * equality, such that for all e1,e2:Expression,
     *     e1.equals(e2) implies e1.hashCode() == e2.hashCode()
     */
    @Override
    public int hashCode();
    
    /**
     * Differentiates this expression with respect to variable x.
     * <p>
     * The result is an expression with structure exactly matching expansion of this expression according to
     * the differentiation rules with no simplification:
     * </p>
     * <pre>
     * d(this)/dx = 0 if this = c where c is a constant or variable other than x
     *            = 1 if this = x
     *            = du/dx + dv/dx if this = u + v
     *            = u*(dv/dx) + v*(du/dx) if this = u*v
     * </pre>
     * <p>For example,</p>
     * <pre>
     * if this represents expression 2*(x + y), then
     * d(2*(x + y))/dx = 2*d(x + y)/dx + (x + y)*d(2)/dx
     *                 = 2*(dx/dx + dy/dx) + (x + y)*0
     *                 = 2*(1 + 0) + (x + y)*0
     * </pre>
     * <p>The result will be and ATS structurally equivalent to to the representation "2*(1 + 0) + (x + y)*0"</p>
     * @param x must be an expression representing a variable
     * @return an expression structurally equivalent to expansion of this expression according to the rules above.
     */
    public Expression differentiate(Expression x);
    
    /**
     * Simplify an expression.
     * @param expression the expression to simplify
     * @param environment maps variables to values.  So it is required that Expressions in the environment represent
     *        variables, that is, case-sensitive non-empty string of letters.  The set of variables in environment is allowed to be different than the 
     *         set of variables actually found in expression.  Values must be nonnegative numbers.
     * @return an expression equal to the input, but after substituting every variable v that appears in both
     *         the expression and the environment with its value, environment.get(v).  If there are no
     *         variables left in this expression after substitution, it must be evaluated to a single number.
     *         Additional simplifications to the expression may be done at the implementor's discretion.
     */
    public Expression simplify(Map<Expression, Double> environment);
    
}
