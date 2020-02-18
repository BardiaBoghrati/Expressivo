/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package expressivo;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests for the static methods of Commands.
 */
public class CommandsTest {

    // Testing strategy
    //   TODO
    
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    
    // TODO tests for Commands.differentiate() and Commands.simplify()
    
    @Test
    public void testCommandsDifferentiate_xWithRespectTox(){
        String a1 = Commands.differentiate("x", "x");
        String a2 = Commands.differentiate("(x)", "x");
        String a3 = Commands.differentiate("((x))", "x");
        
        Expression x = Expression.parse("x");
        Expression b1 = Expression.parse("x").differentiate(x);
        Expression b2 = Expression.parse("(x)").differentiate(x);
        Expression b3 = Expression.parse("((x))").differentiate(x);
        
        assertEquals(Expression.parse(a1), b1);
        assertEquals(Expression.parse(a2), b2);
        assertEquals(Expression.parse(a3), b3);
    }
    
    @Test
    public void testCommandsDifferentiate_yWithRespectTox(){
        String a1 = Commands.differentiate("y", "x");
        String a2 = Commands.differentiate("(y)", "x");
        String a3 = Commands.differentiate("((y))", "x");
        
        Expression x = Expression.parse("x");
        Expression b1 = Expression.parse("y").differentiate(x);
        Expression b2 = Expression.parse("(y)").differentiate(x);
        Expression b3 = Expression.parse("((y))").differentiate(x);
        
        assertEquals(Expression.parse(a1), b1);
        assertEquals(Expression.parse(a2), b2);
        assertEquals(Expression.parse(a3), b3);
    }
    
    @Test
    public void testCommandsDifferentiate_XWithRespectTox(){
        String a1 = Commands.differentiate("X", "x");
        String a2 = Commands.differentiate("(X)", "x");
        String a3 = Commands.differentiate("((X))", "x");
        
        Expression x = Expression.parse("x");
        Expression b1 = Expression.parse("X").differentiate(x);
        Expression b2 = Expression.parse("(X)").differentiate(x);
        Expression b3 = Expression.parse("((X))").differentiate(x);
        
        assertEquals(Expression.parse(a1), b1);
        assertEquals(Expression.parse(a2), b2);
        assertEquals(Expression.parse(a3), b3);
    }
    
    @Test
    public void testCommandsDifferentiate_IntegerWithRespectTox(){
        String a1 = Commands.differentiate("2", "x");
        String a2 = Commands.differentiate("(2)", "x");
        String a3 = Commands.differentiate("((2))", "x");
        String a4 = Commands.differentiate("2.00", "x");
        String a5 = Commands.differentiate("002", "x");
        
        Expression x = Expression.parse("x");
        Expression b1 = Expression.parse("2").differentiate(x);
        Expression b2 = Expression.parse("(2)").differentiate(x);
        Expression b3 = Expression.parse("((2))").differentiate(x);
        Expression b4 = Expression.parse("2.00").differentiate(x);
        Expression b5 = Expression.parse("002").differentiate(x);
        
        assertEquals(Expression.parse(a1), b1);
        assertEquals(Expression.parse(a2), b2);
        assertEquals(Expression.parse(a3), b3);
        assertEquals(Expression.parse(a4), b4);
        assertEquals(Expression.parse(a5), b5);
    }
    
    @Test
    public void testCommandsDifferentiate_ZeroWithRespectTox(){
        String a1 = Commands.differentiate("0", "x");
        String a2 = Commands.differentiate("(0)", "x");
        String a3 = Commands.differentiate("((0))", "x");
        String a4 = Commands.differentiate("0.00", "x");
        String a5 = Commands.differentiate("00", "x");
        
        Expression x = Expression.parse("x");
        Expression b1 = Expression.parse("0").differentiate(x);
        Expression b2 = Expression.parse("(0)").differentiate(x);
        Expression b3 = Expression.parse("((0))").differentiate(x);
        Expression b4 = Expression.parse("0.00").differentiate(x);
        Expression b5 = Expression.parse("00").differentiate(x);
        
        assertEquals(Expression.parse(a1), b1);
        assertEquals(Expression.parse(a2), b2);
        assertEquals(Expression.parse(a3), b3);
        assertEquals(Expression.parse(a4), b4);
        assertEquals(Expression.parse(a5), b5);
    }
    
    @Test
    public void testCommandsDifferentiate_OneWithRespectTox(){
        String a1 = Commands.differentiate("1", "x");
        String a2 = Commands.differentiate("(1)", "x");
        String a3 = Commands.differentiate("((1))", "x");
        String a4 = Commands.differentiate("1.00", "x");
        String a5 = Commands.differentiate("001", "x");
        
        Expression x = Expression.parse("x");
        Expression b1 = Expression.parse("1").differentiate(x);
        Expression b2 = Expression.parse("(1)").differentiate(x);
        Expression b3 = Expression.parse("((1))").differentiate(x);
        Expression b4 = Expression.parse("1.00").differentiate(x);
        Expression b5 = Expression.parse("001").differentiate(x);
        
        assertEquals(Expression.parse(a1), b1);
        assertEquals(Expression.parse(a2), b2);
        assertEquals(Expression.parse(a3), b3);
        assertEquals(Expression.parse(a4), b4);
        assertEquals(Expression.parse(a5), b5);
    }
    
    @Test
    public void testCommandsDifferentiate_DecimalWithRespectTox(){
        String a1 = Commands.differentiate("0.5", "x");
        String a2 = Commands.differentiate("(0.5)", "x");
        String a3 = Commands.differentiate("((0.5))", "x");
        String a4 = Commands.differentiate("0.500", "x");
        String a5 = Commands.differentiate("00.5", "x");
        
        Expression x = Expression.parse("x");
        Expression b1 = Expression.parse("0.5").differentiate(x);
        Expression b2 = Expression.parse("(0.5)").differentiate(x);
        Expression b3 = Expression.parse("((0.5))").differentiate(x);
        Expression b4 = Expression.parse("0.500").differentiate(x);
        Expression b5 = Expression.parse("00.5").differentiate(x);
        
        assertEquals(Expression.parse(a1), b1);
        assertEquals(Expression.parse(a2), b2);
        assertEquals(Expression.parse(a3), b3);
        assertEquals(Expression.parse(a4), b4);
        assertEquals(Expression.parse(a5), b5);
    }
    
    @Test
    public void testCommandsDifferentiate_xPlusxRespectTox(){
        String a1 = Commands.differentiate("x+x", "x");
        String a2 = Commands.differentiate(" x + x ", "x");
        String a3 = Commands.differentiate("(x+x)", "x");
        String a4 = Commands.differentiate("(x)+x", "x");
        String a5 = Commands.differentiate("x+(x)", "x");
        String a6 = Commands.differentiate("(x)+(x)", "x");
        
        Expression x = Expression.parse("x");
        Expression b1 = Expression.parse("x+x").differentiate(x);
        Expression b2 = Expression.parse(" x + x ").differentiate(x);
        Expression b3 = Expression.parse("(x+x)").differentiate(x);
        Expression b4 = Expression.parse("(x)+x").differentiate(x);
        Expression b5 = Expression.parse("x+(x)").differentiate(x);
        Expression b6 = Expression.parse("(x)+(x)").differentiate(x);
        
        assertEquals(Expression.parse(a1), b1);
        assertEquals(Expression.parse(a2), b2);
        assertEquals(Expression.parse(a3), b3);
        assertEquals(Expression.parse(a4), b4);
        assertEquals(Expression.parse(a5), b5);
        assertEquals(Expression.parse(a6), b6);
    }
    
    @Test
    public void testCommandsDifferentiate_xPlusyRespectTox(){
        String a1 = Commands.differentiate("x+y", "x");
        String a2 = Commands.differentiate(" x + y ", "x");
        String a3 = Commands.differentiate("(x+y)", "x");
        String a4 = Commands.differentiate("(x)+y", "x");
        String a5 = Commands.differentiate("x+(y)", "x");
        String a6 = Commands.differentiate("(x)+(y)", "x");
        
        Expression x = Expression.parse("x");
        Expression b1 = Expression.parse("x+y").differentiate(x);
        Expression b2 = Expression.parse(" x + y ").differentiate(x);
        Expression b3 = Expression.parse("(x+y)").differentiate(x);
        Expression b4 = Expression.parse("(x)+y").differentiate(x);
        Expression b5 = Expression.parse("x+(y)").differentiate(x);
        Expression b6 = Expression.parse("(x)+(y)").differentiate(x);
        
        assertEquals(Expression.parse(a1), b1);
        assertEquals(Expression.parse(a2), b2);
        assertEquals(Expression.parse(a3), b3);
        assertEquals(Expression.parse(a4), b4);
        assertEquals(Expression.parse(a5), b5);
        assertEquals(Expression.parse(a6), b6);
    }
    
    @Test
    public void testCommandsDifferentiate_yPlusxRespectTox(){
        String a1 = Commands.differentiate("y+x", "x");
        String a2 = Commands.differentiate(" y + x ", "x");
        String a3 = Commands.differentiate("(y+x)", "x");
        String a4 = Commands.differentiate("(y)+x", "x");
        String a5 = Commands.differentiate("y+(x)", "x");
        String a6 = Commands.differentiate("(y)+(x)", "x");
        
        Expression x = Expression.parse("x");
        Expression b1 = Expression.parse("y+x").differentiate(x);
        Expression b2 = Expression.parse(" y + x ").differentiate(x);
        Expression b3 = Expression.parse("(y+x)").differentiate(x);
        Expression b4 = Expression.parse("(y)+x").differentiate(x);
        Expression b5 = Expression.parse("y+(x)").differentiate(x);
        Expression b6 = Expression.parse("(y)+(x)").differentiate(x);
        
        assertEquals(Expression.parse(a1), b1);
        assertEquals(Expression.parse(a2), b2);
        assertEquals(Expression.parse(a3), b3);
        assertEquals(Expression.parse(a4), b4);
        assertEquals(Expression.parse(a5), b5);
        assertEquals(Expression.parse(a6), b6);
    }
    
    @Test
    public void testCommandsDifferentiate_yPlusyRespectTox(){
        String a1 = Commands.differentiate("y+y", "x");
        String a2 = Commands.differentiate(" y + y ", "x");
        String a3 = Commands.differentiate("(y+y)", "x");
        String a4 = Commands.differentiate("(y)+y", "x");
        String a5 = Commands.differentiate("y+(y)", "x");
        String a6 = Commands.differentiate("(y)+(y)", "x");
        
        Expression x = Expression.parse("x");
        Expression b1 = Expression.parse("y+y").differentiate(x);
        Expression b2 = Expression.parse(" y + y ").differentiate(x);
        Expression b3 = Expression.parse("(y+y)").differentiate(x);
        Expression b4 = Expression.parse("(y)+y").differentiate(x);
        Expression b5 = Expression.parse("y+(y)").differentiate(x);
        Expression b6 = Expression.parse("(y)+(y)").differentiate(x);
        
        assertEquals(Expression.parse(a1), b1);
        assertEquals(Expression.parse(a2), b2);
        assertEquals(Expression.parse(a3), b3);
        assertEquals(Expression.parse(a4), b4);
        assertEquals(Expression.parse(a5), b5);
        assertEquals(Expression.parse(a6), b6);
    }
    
    @Test
    public void testCommandsDifferentiate_xPlus0RespectTox(){
        String a1 = Commands.differentiate("x+0", "x");
        String a2 = Commands.differentiate("x+0.0", "x");
        String a3 = Commands.differentiate("(x+0)", "x");
        String a4 = Commands.differentiate("(x)+0", "x");
        String a5 = Commands.differentiate("x+(0)", "x");
        String a6 = Commands.differentiate("(x)+(0)", "x");
        
        Expression x = Expression.parse("x");
        Expression b1 = Expression.parse("x+0").differentiate(x);
        Expression b2 = Expression.parse("x+0.0").differentiate(x);
        Expression b3 = Expression.parse("(x+0)").differentiate(x);
        Expression b4 = Expression.parse("(x)+0").differentiate(x);
        Expression b5 = Expression.parse("x+(0)").differentiate(x);
        Expression b6 = Expression.parse("(x)+(0)").differentiate(x);
        
        assertEquals(Expression.parse(a1), b1);
        assertEquals(Expression.parse(a2), b2);
        assertEquals(Expression.parse(a3), b3);
        assertEquals(Expression.parse(a4), b4);
        assertEquals(Expression.parse(a5), b5);
        assertEquals(Expression.parse(a6), b6);
    }
    
    @Test
    public void testCommandsDifferentiate_0PlusxRespectTox(){
        String a1 = Commands.differentiate("0+x", "x");
        String a2 = Commands.differentiate("0.0+x", "x");
        String a3 = Commands.differentiate("(0+x)", "x");
        String a4 = Commands.differentiate("(0)+x", "x");
        String a5 = Commands.differentiate("0+(x)", "x");
        String a6 = Commands.differentiate("(0)+(x)", "x");
        
        Expression x = Expression.parse("x");
        Expression b1 = Expression.parse("0+x").differentiate(x);
        Expression b2 = Expression.parse("0.0+x").differentiate(x);
        Expression b3 = Expression.parse("(0+x)").differentiate(x);
        Expression b4 = Expression.parse("(0)+x").differentiate(x);
        Expression b5 = Expression.parse("0+(x)").differentiate(x);
        Expression b6 = Expression.parse("(0)+(x)").differentiate(x);
        
        assertEquals(Expression.parse(a1), b1);
        assertEquals(Expression.parse(a2), b2);
        assertEquals(Expression.parse(a3), b3);
        assertEquals(Expression.parse(a4), b4);
        assertEquals(Expression.parse(a5), b5);
        assertEquals(Expression.parse(a6), b6);
    }
    
    @Test
    public void testCommandsDifferentiate_xPlus1RespectTox(){
        String a1 = Commands.differentiate("x+1", "x");
        String a2 = Commands.differentiate("x+1.000", "x");
        String a3 = Commands.differentiate("(x+1)", "x");
        String a4 = Commands.differentiate("(x)+1", "x");
        String a5 = Commands.differentiate("x+(1)", "x");
        String a6 = Commands.differentiate("(x)+(1)", "x");
        
        Expression x = Expression.parse("x");
        Expression b1 = Expression.parse("x+1").differentiate(x);
        Expression b2 = Expression.parse("x+1.000").differentiate(x);
        Expression b3 = Expression.parse("(x+1)").differentiate(x);
        Expression b4 = Expression.parse("(x)+1").differentiate(x);
        Expression b5 = Expression.parse("x+(1)").differentiate(x);
        Expression b6 = Expression.parse("(x)+(1)").differentiate(x);
        
        assertEquals(Expression.parse(a1), b1);
        assertEquals(Expression.parse(a2), b2);
        assertEquals(Expression.parse(a3), b3);
        assertEquals(Expression.parse(a4), b4);
        assertEquals(Expression.parse(a5), b5);
        assertEquals(Expression.parse(a6), b6);
    }
    
    @Test
    public void testCommandsDifferentiate_1PlusxRespectTox(){
        String a1 = Commands.differentiate("1+x", "x");
        String a2 = Commands.differentiate("1.000+x", "x");
        String a3 = Commands.differentiate("(1+x)", "x");
        String a4 = Commands.differentiate("(1)+x", "x");
        String a5 = Commands.differentiate("1+(x)", "x");
        String a6 = Commands.differentiate("(1)+(x)", "x");
        
        Expression x = Expression.parse("x");
        Expression b1 = Expression.parse("1+x").differentiate(x);
        Expression b2 = Expression.parse("1.000+x").differentiate(x);
        Expression b3 = Expression.parse("(1+x)").differentiate(x);
        Expression b4 = Expression.parse("(1)+x").differentiate(x);
        Expression b5 = Expression.parse("1+(x)").differentiate(x);
        Expression b6 = Expression.parse("(1)+(x)").differentiate(x);
        
        assertEquals(Expression.parse(a1), b1);
        assertEquals(Expression.parse(a2), b2);
        assertEquals(Expression.parse(a3), b3);
        assertEquals(Expression.parse(a4), b4);
        assertEquals(Expression.parse(a5), b5);
        assertEquals(Expression.parse(a6), b6);
    }
    
    @Test
    public void testCommandsDifferentiate_xPlusHalfRespectTox(){
        String a1 = Commands.differentiate("x+0.5", "x");
        String a2 = Commands.differentiate("x+00.50", "x");
        String a3 = Commands.differentiate("(x+0.5)", "x");
        String a4 = Commands.differentiate("(x)+0.5", "x");
        String a5 = Commands.differentiate("x+(0.5)", "x");
        String a6 = Commands.differentiate("(x)+(0.5)", "x");
        
        Expression x = Expression.parse("x");
        Expression b1 = Expression.parse("x+0.5").differentiate(x);
        Expression b2 = Expression.parse("x+00.50").differentiate(x);
        Expression b3 = Expression.parse("(x+0.5)").differentiate(x);
        Expression b4 = Expression.parse("(x)+0.5").differentiate(x);
        Expression b5 = Expression.parse("x+(0.5)").differentiate(x);
        Expression b6 = Expression.parse("(x)+(0.5)").differentiate(x);
        
        assertEquals(Expression.parse(a1), b1);
        assertEquals(Expression.parse(a2), b2);
        assertEquals(Expression.parse(a3), b3);
        assertEquals(Expression.parse(a4), b4);
        assertEquals(Expression.parse(a5), b5);
        assertEquals(Expression.parse(a6), b6);
    }

    @Test
    public void testCommandsDifferentiate_HalfPlusxRespectTox(){
        String a1 = Commands.differentiate("0.5+x", "x");
        String a2 = Commands.differentiate("00.50+x", "x");
        String a3 = Commands.differentiate("(0.5+x)", "x");
        String a4 = Commands.differentiate("(0.5)+x", "x");
        String a5 = Commands.differentiate("0.5+(x)", "x");
        String a6 = Commands.differentiate("(0.5)+(x)", "x");
        
        Expression x = Expression.parse("x");
        Expression b1 = Expression.parse("0.5+x").differentiate(x);
        Expression b2 = Expression.parse("00.50+x").differentiate(x);
        Expression b3 = Expression.parse("(0.5+x)").differentiate(x);
        Expression b4 = Expression.parse("(0.5)+x").differentiate(x);
        Expression b5 = Expression.parse("0.5+(x)").differentiate(x);
        Expression b6 = Expression.parse("(0.5)+(x)").differentiate(x);
        
        assertEquals(Expression.parse(a1), b1);
        assertEquals(Expression.parse(a2), b2);
        assertEquals(Expression.parse(a3), b3);
        assertEquals(Expression.parse(a4), b4);
        assertEquals(Expression.parse(a5), b5);
        assertEquals(Expression.parse(a6), b6);
    }
    
    @Test
    public void testCommandsDifferentiate_yPlus0RespectTox(){
        String a1 = Commands.differentiate("y+0", "x");
        String a2 = Commands.differentiate(" y+00.00 ", "x");
        String a3 = Commands.differentiate("(y+0)", "x");
        String a4 = Commands.differentiate("(y)+0", "x");
        String a5 = Commands.differentiate("y+(0)", "x");
        String a6 = Commands.differentiate("(y)+(0)", "x");
        
        Expression x = Expression.parse("x");
        Expression b1 = Expression.parse("y+0").differentiate(x);
        Expression b2 = Expression.parse(" y + 0 ").differentiate(x);
        Expression b3 = Expression.parse("(y+0)").differentiate(x);
        Expression b4 = Expression.parse("(y)+0").differentiate(x);
        Expression b5 = Expression.parse("y+(0)").differentiate(x);
        Expression b6 = Expression.parse("(y)+(0)").differentiate(x);
        
        assertEquals(Expression.parse(a1), b1);
        assertEquals(Expression.parse(a2), b2);
        assertEquals(Expression.parse(a3), b3);
        assertEquals(Expression.parse(a4), b4);
        assertEquals(Expression.parse(a5), b5);
        assertEquals(Expression.parse(a6), b6);
    }
    
    @Test
    public void testCommandsDifferentiate_2Plus1RespectTox(){
        String a1 = Commands.differentiate("2+1", "x");
        String a2 = Commands.differentiate(" 2 + 1 ", "x");
        String a3 = Commands.differentiate("(2+1)", "x");
        String a4 = Commands.differentiate("(2)+1", "x");
        String a5 = Commands.differentiate("2+(1)", "x");
        String a6 = Commands.differentiate("(2)+(1)", "x");
        
        Expression x = Expression.parse("x");
        Expression b1 = Expression.parse("2+1").differentiate(x);
        Expression b2 = Expression.parse(" 2 + 1 ").differentiate(x);
        Expression b3 = Expression.parse("(2+1)").differentiate(x);
        Expression b4 = Expression.parse("(2)+1").differentiate(x);
        Expression b5 = Expression.parse("2+(1)").differentiate(x);
        Expression b6 = Expression.parse("(2)+(1)").differentiate(x);
        
        assertEquals(Expression.parse(a1), b1);
        assertEquals(Expression.parse(a2), b2);
        assertEquals(Expression.parse(a3), b3);
        assertEquals(Expression.parse(a4), b4);
        assertEquals(Expression.parse(a5), b5);
        assertEquals(Expression.parse(a6), b6);
    }
    
    @Test
    public void testCommandsDifferentiate_HalfPlusHalfRespectTox(){
        String a1 = Commands.differentiate("0.5+0.5", "x");
        String a2 = Commands.differentiate(" 0.5 + 0.5 ", "x");
        String a3 = Commands.differentiate("(0.5+0.5)", "x");
        String a4 = Commands.differentiate("(0.5)+0.5", "x");
        String a5 = Commands.differentiate("0.5+(0.5)", "x");
        String a6 = Commands.differentiate("(0.5)+(0.5)", "x");
        
        Expression x = Expression.parse("x");
        Expression b1 = Expression.parse("0.5+0.5").differentiate(x);
        Expression b2 = Expression.parse(" 0.5 + 0.5 ").differentiate(x);
        Expression b3 = Expression.parse("(0.5+0.5)").differentiate(x);
        Expression b4 = Expression.parse("(0.5)+0.5").differentiate(x);
        Expression b5 = Expression.parse("0.5+(0.5)").differentiate(x);
        Expression b6 = Expression.parse("(0.5)+(0.5)").differentiate(x);
        
        assertEquals(Expression.parse(a1), b1);
        assertEquals(Expression.parse(a2), b2);
        assertEquals(Expression.parse(a3), b3);
        assertEquals(Expression.parse(a4), b4);
        assertEquals(Expression.parse(a5), b5);
        assertEquals(Expression.parse(a6), b6);
    }
    
    public void testCommandsDifferentiate_APlusB_PlusCWithRespectTox(){
        String a1 = Commands.differentiate("a+b+c", "x");
        String a2 = Commands.differentiate("(a+b)+c", "x");
        
        Expression x = Expression.parse("x");
        Expression b1 = Expression.parse("a+b+c").differentiate(x);
        Expression b2 = Expression.parse("(a+b)+c").differentiate(x);
        
        assertEquals(Expression.parse(a1), b1);
        assertEquals(Expression.parse(a2), b2);
    }
    
    public void testCommandsDifferentiate_APlus_BPlusCWithRespectTox(){
        String a1 = Commands.differentiate("a+(b+c)", "x");
        
        Expression x = Expression.parse("x");
        Expression b1 = Expression.parse("a+(b+c)").differentiate(x);
        
        assertEquals(Expression.parse(a1), b1);
    }
    
    public void testCommandsDifferentiate_APlusB_TimesCWithRespectTox(){
        String a1 = Commands.differentiate("(a+b)*c", "x");
        
        Expression x = Expression.parse("x");
        Expression b1 = Expression.parse("(a+b)*c").differentiate(x);
        
        assertEquals(Expression.parse(a1), b1);
    }
    
    public void testCommandsDifferentiate_APlus_BTimesCWithRespectTox(){
        String a1 = Commands.differentiate("a+b*c", "x");
        String a2 = Commands.differentiate("a+(b*c)", "x");
        
        Expression x = Expression.parse("x");
        Expression b1 = Expression.parse("a+b*c").differentiate(x);
        Expression b2 = Expression.parse("a+(b*c)").differentiate(x);
        
        assertEquals(Expression.parse(a1), b1);
        assertEquals(Expression.parse(a2), b2);
    }
    
    public void testCommandsDifferentiate_ATimesB_TimesCWithRespectTox(){
        String a1 = Commands.differentiate("a*b*c", "x");
        String a2 = Commands.differentiate("(a*b)*c", "x");
        
        Expression x = Expression.parse("x");
        Expression b1 = Expression.parse("a*b*c").differentiate(x);
        Expression b2 = Expression.parse("(a*b)*c").differentiate(x);
        
        assertEquals(Expression.parse(a1), b1);
        assertEquals(Expression.parse(a2), b2);
    }
    
    public void testCommandsDifferentiate_ATimes_BTimesCWithRespectTox(){
        String a1 = Commands.differentiate("a*(b*c)", "x");
        
        Expression x = Expression.parse("x");
        Expression b1 = Expression.parse("a*(b*c)").differentiate(x);
        
        assertEquals(Expression.parse(a1), b1);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCommandsDifferentiate_InvalidExpressionUnmatchedParentheses(){
        Commands.differentiate("(a+b", "x");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCommandsDifferentiate_InvalidExpressionMissingOperation(){
        Commands.differentiate("3a", "x");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCommandsDifferentiate_InvalidExpressionNumberFormat(){
        Commands.differentiate("2 . 3", "x");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCommandsDifferentiate_EmptyExpression(){
        Commands.differentiate("", "x");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCommandsDifferentiate_EmptyParentheses(){
        Commands.differentiate("2*()", "x");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCommandsDifferentiate_InvalidVariableName(){
        Commands.differentiate("x", "x1");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCommandsDifferentiate_NumberInsteadOfVariable(){
        Commands.differentiate("x", "2");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCommandsDifferentiate_SumInsteadOfVariable(){
        Commands.differentiate("x+y", "x+y");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCommandsDifferentiate_ProductInsteadOfVariable(){
        Commands.differentiate("x*y", "x*y");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCommandsDifferentiate_ParenthesisedVariable(){
        Commands.differentiate("x", "(x)");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCommandsDifferentiate_EmptyVariable(){
        Commands.differentiate("x", "");
    }

}
