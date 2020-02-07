/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package expressivo;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests for the Expression abstract data type.
 */
public class ExpressionTest {

    // Testing strategy
    //   TODO
    
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    
    @Test
    public void testEqualsFor_SingleVariable(){
        Expression a1 = Expression.parse("a");
        
        Expression b1 = Expression.parse("A");
        
        assertEquals(a1,a1);
        assertNotEquals(a1,b1);
        
        assertNotEquals(b1, a1);
        assertEquals(b1, b1);
    }
    
    @Test
    public void testEqualsFor_SingleNumber(){
        Expression a1 = Expression.parse("1");
        Expression a2 = Expression.parse("1.00");
        
        assertEquals(a1, a1);
        assertEquals(a1, a2);
        assertEquals(a2, a1);
        assertEquals(a2, a2);
    }
    
    @Test
    public void testEqualsFor_A_Plus_B(){
        Expression a1 = Expression.parse("a+b");
        
        Expression b1 = Expression.parse("b+a");
        
        assertNotEquals(a1, b1);
    }
    
    @Test
    public void testEqualsFor_A_Plus_A(){
        Expression a1 = Expression.parse("a+a");
        
        Expression b1 = Expression.parse("2*a");
        
        Expression c1 = Expression.parse("a+a+a");
        
        assertNotEquals(a1, b1);
        assertNotEquals(a1, c1);
        assertNotEquals(b1, a1);
        assertNotEquals(c1, a1);
    }
    
    @Test
    public void testEqualsFor_A_Plus_0(){
        Expression a1 = Expression.parse("a+0");
        
        Expression b1 = Expression.parse("a");
        
        Expression c1 = Expression.parse("0+a");
        
        assertNotEquals(a1, b1);
        assertNotEquals(a1, c1);
        assertNotEquals(b1, a1);
        assertNotEquals(c1, a1);
    }
    
    @Test
    public void testEqualsFor_2_Plus_2(){
        Expression a1 = Expression.parse("2+2.00");
        Expression a2 = Expression.parse("2.00+2");
        
        Expression b1 = Expression.parse("4");
        
        Expression c1 = Expression.parse("2*2");
        
        assertEquals(a1, a1);
        assertEquals(a1, a2);
        assertNotEquals(a1, b1);
        assertNotEquals(a1, c1);
        
        assertEquals(a2, a1);
        assertEquals(a2, a2);
        assertNotEquals(a2, b1);
        assertNotEquals(a2, c1);
        
        assertNotEquals(b1, a1);
        assertNotEquals(b1, a2);
        
        assertNotEquals(c1, a1);
        assertNotEquals(c1, a2);
    }
    
    @Test
    public void testEqualsFor_A_Times_B(){
        Expression a1 = Expression.parse("a*b");
        
        Expression b1 = Expression.parse("b*a");
        
        assertNotEquals(a1, b1);
        assertNotEquals(b1, a1);
    }
    
    @Test
    public void testEqualsFor_1_Times_A(){
        Expression a1 = Expression.parse("1*a");
        
        Expression b1 = Expression.parse("a*1");
        
        Expression c1 = Expression.parse("a");
        
        assertNotEquals(a1, b1);
        assertNotEquals(a1, c1);
        assertNotEquals(b1, a1);
        assertNotEquals(c1, a1);
    }
    
    @Test
    public void testEqualsFor_0_Times_A(){
        Expression a1 = Expression.parse("0*a");
        
        Expression b1 = Expression.parse("a*0");
        
        Expression c1 = Expression.parse("0");
        
        assertNotEquals(a1, b1);
        assertNotEquals(a1, c1);
        assertNotEquals(b1, a1);
        assertNotEquals(c1, a1);
    }
    
    @Test
    public void testEqualsFor_A_Plus_B_Times_C(){
        Expression a1 = Expression.parse("a+b*c");
        Expression a2 = Expression.parse("((a)+(b*c))");
        Expression a3 = Expression.parse(" a + b * c ");
        
        Expression b1 = Expression.parse("(a+b)*c");
        Expression b2 = Expression.parse("((a+b)*c)");
        Expression b3 = Expression.parse(" ( a + b ) * c ");
        
        assertEquals(a1, a1);
        assertEquals(a1, a2);
        assertEquals(a1, a3);
        assertNotEquals(a1, b1);
        assertNotEquals(a1, b2);
        assertNotEquals(a1, b3);
        
        assertEquals(a2, a1);
        assertEquals(a2, a2);
        assertEquals(a2, a3);
        assertNotEquals(a2, b1);
        assertNotEquals(a2, b2);
        assertNotEquals(a2, b3);
        
        assertEquals(a3, a1);
        assertEquals(a3, a2);
        assertEquals(a3, a3);
        assertNotEquals(a3, b1);
        assertNotEquals(a3, b2);
        assertNotEquals(a3, b3);
        
        assertNotEquals(b1, a1);
        assertNotEquals(b1, a2);
        assertNotEquals(b1, a3);
        assertEquals(b1,b1);
        assertEquals(b1,b2);
        assertEquals(b1,b3);
        
        assertNotEquals(b2, a1);
        assertNotEquals(b2, a2);
        assertNotEquals(b2, a3);
        assertEquals(b2,b1);
        assertEquals(b2,b2);
        assertEquals(b2,b3);
        
        assertNotEquals(b3, a1);
        assertNotEquals(b3, a2);
        assertNotEquals(b3, a3);
        assertEquals(b3,b1);
        assertEquals(b3,b2);
        assertEquals(b3,b3);  
    }
    
    @Test
    public void testEqualsFor_A_Times_B_Plus_C(){
        Expression a1 = Expression.parse("a*c+b");
        Expression a2 = Expression.parse("((a*c)+(b))");
        Expression a3 = Expression.parse(" a * c + b ");
        
        Expression b1 = Expression.parse("a*(b+c)");
        Expression b2 = Expression.parse("((a)*((b+c)))");
        Expression b3 = Expression.parse(" a * ( b + c ) ");
        
        assertEquals(a1, a1);
        assertEquals(a1, a2);
        assertEquals(a1, a3);
        assertNotEquals(a1, b1);
        assertNotEquals(a1, b2);
        assertNotEquals(a1, b3);
        
        assertEquals(a2, a1);
        assertEquals(a2, a2);
        assertEquals(a2, a3);
        assertNotEquals(a2, b1);
        assertNotEquals(a2, b2);
        assertNotEquals(a2, b3);
        
        assertEquals(a3, a1);
        assertEquals(a3, a2);
        assertEquals(a3, a3);
        assertNotEquals(a3, b1);
        assertNotEquals(a3, b2);
        assertNotEquals(a3, b3);
        
        assertNotEquals(b1, a1);
        assertNotEquals(b1, a2);
        assertNotEquals(b1, a3);
        assertEquals(b1,b1);
        assertEquals(b1,b2);
        assertEquals(b1,b3);
        
        assertNotEquals(b2, a1);
        assertNotEquals(b2, a2);
        assertNotEquals(b2, a3);
        assertEquals(b2,b1);
        assertEquals(b2,b2);
        assertEquals(b2,b3);
        
        assertNotEquals(b3, a1);
        assertNotEquals(b3, a2);
        assertNotEquals(b3, a3);
        assertEquals(b3,b1);
        assertEquals(b3,b2);
        assertEquals(b3,b3);  
    }
    
    @Test
    public void testEqualsFor_A_Plus_B_Plus_C(){
        Expression a1 = Expression.parse("a+b+c");
        Expression a2 = Expression.parse("(a+b)+c");
        Expression a3 = Expression.parse("  a  +  b  +  c  ");
        
        Expression b1 = Expression.parse("a+(b+c)");
        Expression b2 = Expression.parse("((a)+((b+c)))");
        Expression b3 = Expression.parse("  a  +  (  b  +  c  )  ");
        
        assertEquals(a1, a1);
        assertEquals(a1, a2);
        assertEquals(a1, a3);
        assertNotEquals(a1, b1);
        assertNotEquals(a1, b2);
        assertNotEquals(a1, b3);
        
        assertEquals(a2, a1);
        assertEquals(a2, a2);
        assertEquals(a2, a3);
        assertNotEquals(a2, b1);
        assertNotEquals(a2, b2);
        assertNotEquals(a2, b3);
        
        assertEquals(a3, a1);
        assertEquals(a3, a2);
        assertEquals(a3, a3);
        assertNotEquals(a3, b1);
        assertNotEquals(a3, b2);
        assertNotEquals(a3, b3);
        
        assertNotEquals(b1, a1);
        assertNotEquals(b1, a2);
        assertNotEquals(b1, a3);
        assertEquals(b1,b1);
        assertEquals(b1,b2);
        assertEquals(b1,b3);
        
        assertNotEquals(b2, a1);
        assertNotEquals(b2, a2);
        assertNotEquals(b2, a3);
        assertEquals(b2,b1);
        assertEquals(b2,b2);
        assertEquals(b2,b3);
        
        assertNotEquals(b3, a1);
        assertNotEquals(b3, a2);
        assertNotEquals(b3, a3);
        assertEquals(b3,b1);
        assertEquals(b3,b2);
        assertEquals(b3,b3);
    }
    
    @Test
    public void testEqualsFor_A_Times_B_Times_C(){
        Expression a1 = Expression.parse("a*b*c");
        Expression a2 = Expression.parse("(a*b)*c");
        Expression a3 = Expression.parse("  a  *  b  *  c  ");
        
        Expression b1 = Expression.parse("a*(b*c)");
        Expression b2 = Expression.parse("((a)*((b*c)))");
        Expression b3 = Expression.parse("  a  *  (  b  *  c  )  ");
        
        assertEquals(a1, a1);
        assertEquals(a1, a2);
        assertEquals(a1, a3);
        assertNotEquals(a1, b1);
        assertNotEquals(a1, b2);
        assertNotEquals(a1, b3);
        
        assertEquals(a2, a1);
        assertEquals(a2, a2);
        assertEquals(a2, a3);
        assertNotEquals(a2, b1);
        assertNotEquals(a2, b2);
        assertNotEquals(a2, b3);
        
        assertEquals(a3, a1);
        assertEquals(a3, a2);
        assertEquals(a3, a3);
        assertNotEquals(a3, b1);
        assertNotEquals(a3, b2);
        assertNotEquals(a3, b3);
        
        assertNotEquals(b1, a1);
        assertNotEquals(b1, a2);
        assertNotEquals(b1, a3);
        assertEquals(b1,b1);
        assertEquals(b1,b2);
        assertEquals(b1,b3);
        
        assertNotEquals(b2, a1);
        assertNotEquals(b2, a2);
        assertNotEquals(b2, a3);
        assertEquals(b2,b1);
        assertEquals(b2,b2);
        assertEquals(b2,b3);
        
        assertNotEquals(b3, a1);
        assertNotEquals(b3, a2);
        assertNotEquals(b3, a3);
        assertEquals(b3,b1);
        assertEquals(b3,b2);
        assertEquals(b3,b3);
    }
    
    
    @Test
    public void tesHashCodeFor_Variable_SingleLetter(){
        Expression a1 = Expression.parse("a");
        Expression a2 = Expression.parse("((a))");
        
        assertEquals(a1.hashCode(), a2.hashCode());
    }
    
    @Test
    public void tesHashCodeFor_Variable_MultipleLetter(){
        Expression a1 = Expression.parse("abc");
        Expression a2 = Expression.parse(" ( abc ) ");
        
        assertEquals(a1.hashCode(), a2.hashCode());
    }
    
    @Test
    public void testHashCodeFor_Integer(){
        Expression a1 = Expression.parse("1");
        Expression a2 = Expression.parse("1.00");
        
        assertEquals(a1.hashCode(), a2.hashCode());
    }
    
    @Test
    public void testHashCodeFor_Decimal(){
        Expression a1 = Expression.parse("1.5");
        Expression a2 = Expression.parse("1.500");
        
        assertEquals(a1.hashCode(), a2.hashCode());
    }
    
    @Test
    public void testHashCodeFor_Variable_Plus_Variable(){
        Expression a1 = Expression.parse("a+b");
        Expression a2 = Expression.parse("((a)+(b))");
        
        assertEquals(a1, a2);
    }
    
    @Test
    public void testHashCodeFor_Variable_Plus_Number(){
        Expression a1 = Expression.parse("a+2");
        Expression a2 = Expression.parse("(a+2)");
        
        assertEquals(a1.hashCode(), a2.hashCode());
    }
    
    @Test
    public void testHashCodeFor_Variable_Times_Variable(){
        Expression a1 = Expression.parse("a*b");
        Expression a2 = Expression.parse("((a)*(b))");
        
        assertEquals(a1, a2);
    }
    
    @Test
    public void testHashCodeFor_Variable_Times_Number(){
        Expression a1 = Expression.parse("a * 2");
        Expression a2 = Expression.parse("((a * 2))");
        
        assertEquals(a1, a2);
    }
    
    @Test
    public void testHashCodeFor_Decimal_Plus_Decimal(){
        Expression a1 = Expression.parse("0.50+0.5");
        Expression a2 = Expression.parse("0.5+0.50");
        
        assertEquals(a1.hashCode(), a2.hashCode());
    }
    
    @Test
    public void testHashCodeFor_Integer_Plus_Integer(){
        Expression a1 = Expression.parse("1+2");
        Expression a2 = Expression.parse("1.0+2.00");
        
        assertEquals(a1, a2);
    }
    
    @Test
    public void testHashCodeFor_Decimal_Times_Decimal(){
        Expression a1 = Expression.parse("0.50*0.5");
        Expression a2 = Expression.parse("0.5*0.50");
        
        assertEquals(a1.hashCode(), a2.hashCode());
    }
    
    @Test
    public void testHashCodeFor_Integer_Times_Integer(){
        Expression a1 = Expression.parse("1*2");
        Expression a2 = Expression.parse("1.0*2.00");
        
        assertEquals(a1, a2);
    }
    
    @Test
    public void testHashCodeFor_3Array_Grouping(){
        Expression a1 = Expression.parse("1 + a * 0.5");
        Expression a2 = Expression.parse("1 + (a * 0.5)");
        
        assertEquals(a1, a2);
    }
    
    
    @Test
    public void testToStringFor_SingleInteger(){
        Expression a1 = Expression.parse("1");
        Expression a2 = Expression.parse("1.00");
        
        assertEquals(Expression.parse(a1.toString()), a1);
        assertEquals(a1.toString(), a2.toString());
    }
    
    @Test
    public void testToStringFor_SingleDecimal(){
        Expression a1 = Expression.parse("0.5");
        Expression a2 = Expression.parse("0.500");
        
        assertEquals(Expression.parse(a1.toString()), a1);
        assertEquals(a1.toString(), a2.toString());
    }
    
    @Test
    public void testToStringFor_SingleVariable(){
        Expression a1 = Expression.parse("a");
        
        Expression b1 = Expression.parse("A");
        
        assertEquals(Expression.parse(a1.toString()), a1);
        assertEquals(Expression.parse(b1.toString()), b1);
    }

    @Test
    public void testToStringFor_Sum_Plus_Term(){
        Expression a1 = Expression.parse("a+b+c");
        Expression a2 = Expression.parse("(a+b)+c");
        
        assertEquals(Expression.parse(a1.toString()), a1);
        assertEquals(a1.toString(), a2.toString());
    }
    
    @Test
    public void testToStringFor_Term_Plus_Sum(){
        Expression a1 = Expression.parse("a+(b+c)");
        Expression a2 = Expression.parse("a + ( b + c )");
        
        assertEquals(Expression.parse(a1.toString()), a1);
        assertEquals(a1.toString(), a2.toString());
    }
    
    @Test
    public void testToStringFor_Product_Plus_Term(){
        Expression a1 = Expression.parse("a*b+c");
        Expression a2 = Expression.parse("(a*b)+c");
        
        assertEquals(Expression.parse(a1.toString()), a1);
        assertEquals(a1.toString(), a2.toString());
    }
    
    @Test
    public void testToStringFor_Term_Times_Sum(){
        Expression a1 = Expression.parse("a*(b+c)");
        Expression a2 = Expression.parse("((a)*((b+c)))");
        
        assertEquals(Expression.parse(a1.toString()), a1);
        assertEquals(a1.toString(), a2.toString());
    }
    
    @Test
    public void testToStringFor_Product_Times_Term(){
        Expression a1 = Expression.parse("a*b*c");
        Expression a2 = Expression.parse("(a*b)*c");
        
        assertEquals(Expression.parse(a1.toString()), a1);
        assertEquals(a1.toString(), a2.toString());
    }
    
    @Test
    public void testToStringFor_Term_Times_Product(){
        Expression a1 = Expression.parse("a*(b*c)");
        Expression a2 = Expression.parse("((a*(b*c)))");
        
        assertEquals(Expression.parse(a1.toString()), a1);
        assertEquals(a1.toString(), a2.toString());
    }
    
    
    @Test
    public void testParse_CaseSensitivity(){
        Expression a1 = Expression.parse("aB");
        Expression a2 = Expression.parse("ab");
        
        assertNotEquals(a1, a2);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testParse_EmptyExpression(){
        Expression.parse("");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testParse_InvalidCharacter(){
        Expression.parse("$");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testParse_InvalidVariableName1(){
        Expression.parse("x1");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testParse_InvalidVariableName2(){
        Expression.parse("x_y");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testParse_MissingOperatorNumberTimesVariable(){
        Expression.parse("3x");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testParse_MissingOperatorBetweenVariables(){
        Expression.parse("x y");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testParse_MissingOperatorBetweenGroupings(){
        Expression.parse("(a)(b)");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testParse_SpacedOutNumberRepresentation1(){
        Expression.parse("2 . 0");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testParse_SpacedOutNumberRepresentation2(){
        Expression.parse("2 4");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testParse_UnmatchedBracket1(){
        Expression.parse("(3");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testParse_UnmatchedBracket2(){
        Expression.parse("3)");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testParse_EmptyBracket(){
        Expression.parse("()");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testParse_InvalidBracket(){
        Expression.parse("[3]");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testParse_NegativeNumber(){
        Expression.parse("-1.00");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testParse_Negation(){
        Expression.parse("-(a)");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testParse_Subtraction(){
        Expression.parse("2 - 3");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testParse_Exponentiation(){
        Expression.parse("x^2");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testParse_Division(){
        Expression.parse("4 / 2");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testParse_Modulus(){
        Expression.parse("10 % 5");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testParse_InvalidNumberRepresentation(){
        Expression.parse("6.02e23");
    }
    
    
    @Test
    public void testDifferentiate_Integer(){
        Expression a1 = Expression.parse("2");
        Expression a2 = Expression.parse("2.00");
        Expression x = Expression.parse("x");
        
        Expression d1 = a1.differentiate(x);
        Expression d2 = a2.differentiate(x);
        Expression expected = Expression.parse("0");
        
        assertEquals(d1, expected);
        assertEquals(d2, d1);
    }
    
    @Test
    public void testDifferentiate_Decimal(){
        Expression a1 = Expression.parse("0.5");
        Expression a2 = Expression.parse("0.500");
        Expression x = Expression.parse("x");
        
        Expression d1 = a1.differentiate(x);
        Expression d2 = a2.differentiate(x);
        Expression expected = Expression.parse("0");
        
        assertEquals(d1, expected);
        assertEquals(d2, d1);
    }
    
    @Test
    public void testDifferentiate_Zero(){
        Expression a1 = Expression.parse("0");
        Expression a2 = Expression.parse("0.0");
        Expression x = Expression.parse("x");
        
        Expression d1 = a1.differentiate(x);
        Expression d2 = a2.differentiate(x);
        Expression expected = Expression.parse("0");
        
        assertEquals(d1, expected);
        assertEquals(d2, d1);
    }
    
    @Test
    public void testDifferentiate_One(){
        Expression a1 = Expression.parse("1");
        Expression a2 = Expression.parse("1.00");
        Expression x = Expression.parse("x");
        
        Expression d1 = a1.differentiate(x);
        Expression d2 = a2.differentiate(x);
        Expression expected = Expression.parse("0");
        
        assertEquals(d1, expected);
        assertEquals(d2, d1);
    }
    
    @Test
    public void testDifferentiate_VariableWithRespectToDifferentVariable(){
        Expression a1 = Expression.parse("y");
        Expression a2 = Expression.parse("X");
        Expression x = Expression.parse("x");
        
        Expression d1 = a1.differentiate(x);
        Expression d2 = a2.differentiate(x);
        Expression expected = Expression.parse("0");
        
        assertEquals(d1, expected);
        assertEquals(d2, expected);
    }
    
    @Test
    public void testDifferentiate_VariableWithRespectToSameVariable(){
        Expression a1 = Expression.parse("x");
        Expression a2 = Expression.parse("(x)");
        Expression x = Expression.parse("x");
        
        Expression d1 = a1.differentiate(x);
        Expression d2 = a2.differentiate(x);
        Expression expected = Expression.parse("1");
        
        assertEquals(d1, expected);
        assertEquals(d1, d2);
    }
    
    @Test
    public void testDifferentiate_xPlusxWithRepectTox(){
        Expression a1 = Expression.parse("x+x");
        Expression x = Expression.parse("x"); 
        
        Expression d1 = a1.differentiate(x);
        Expression expected = Expression.parse("(1)+(1)");
        
        assertEquals(d1, expected);
    }
    
    @Test
    public void testDifferentiate_xPlusyWithRespectTox(){
        Expression a1 = Expression.parse("x+y");
        Expression x = Expression.parse("x"); 
        
        Expression d1 = a1.differentiate(x);
        Expression expected = Expression.parse("(1)+(0)");
        
        assertEquals(d1, expected); 
    }
    
    @Test
    public void testDifferentiate_yPlusxWithRespectTox(){
        Expression a1 = Expression.parse("y+x");
        Expression x = Expression.parse("x"); 
        
        Expression d1 = a1.differentiate(x);
        Expression expected = Expression.parse("(0)+(1)");
        
        assertEquals(d1, expected);
    }
    
    @Test
    public void testDifferentiate_0PlusxWithRespectTox(){
        Expression a1 = Expression.parse("0+x");
        Expression x = Expression.parse("x"); 
        
        Expression d1 = a1.differentiate(x);
        Expression expected = Expression.parse("(0)+(1)");
        
        assertEquals(d1, expected);
    }
    
    @Test
    public void testDifferentiate_1PlusxWithRespectTox(){
        Expression a1 = Expression.parse("1+x");
        Expression x = Expression.parse("x"); 
        
        Expression d1 = a1.differentiate(x);
        Expression expected = Expression.parse("(0)+(1)");
        
        assertEquals(d1, expected);
    }
    
    @Test
    public void testDifferentiate_yPluszWithRespectTox(){
        Expression a1 = Expression.parse("y+z");
        Expression x = Expression.parse("x"); 
        
        Expression d1 = a1.differentiate(x);
        Expression expected = Expression.parse("(0)+(0)");
        
        assertEquals(d1, expected);
    }
    
    @Test
    public void testDifferentiate_NumberPlusNumberWithRespectTox(){
        Expression a1 = Expression.parse("2+0.5");
        Expression a2 = Expression.parse("0.5+2");
        Expression x = Expression.parse("x");
        
        Expression d1 = a1.differentiate(x);
        Expression d2 = a2.differentiate(x);
        Expression expected = Expression.parse("(0)+(0)");
        
        assertEquals(d1, expected);
        assertEquals(d2, expected);
    }
    
    @Test
    public void testDifferentiate_xTimesxWithRespectTox(){
        Expression a1 = Expression.parse("x*x");
        Expression x = Expression.parse("x"); 
        
        Expression d1 = a1.differentiate(x);
        Expression expected = Expression.parse("x*(1) + x*(1)");
        
        assertEquals(d1, expected);
    }
    
    @Test
    public void testDifferentiate_xTimesyWithRespectTox(){
        Expression a1 = Expression.parse("x*y");
        Expression x = Expression.parse("x"); 
        
        Expression d1 = a1.differentiate(x);
        Expression expected = Expression.parse("x*(0) + y*(1)");
        
        assertEquals(d1, expected);
    }
    
    @Test
    public void testDifferentiate_yTimesxWithRespectTox(){
        Expression a1 = Expression.parse("y*x");
        Expression x = Expression.parse("x"); 
        
        Expression d1 = a1.differentiate(x);
        Expression expected = Expression.parse("y*(1) + x*(0)");
        
        assertEquals(d1, expected);
    }
    
    @Test
    public void testDifferentiate_0TimesxWithRespectTox(){
        Expression a1 = Expression.parse("0*x");
        Expression x = Expression.parse("x"); 
        
        Expression d1 = a1.differentiate(x);
        Expression expected = Expression.parse("0*(1) + x*(0)");
        
        assertEquals(d1, expected);
    }
    
    @Test
    public void testDifferentiate_1TimesxWithRespectTox(){
        Expression a1 = Expression.parse("1*x");
        Expression x = Expression.parse("x"); 
        
        Expression d1 = a1.differentiate(x);
        Expression expected = Expression.parse("1*(1) + x*(0)");
        
        assertEquals(d1, expected);
    }
    
    @Test
    public void testDifferentiate_yTimeszWithRespectTox(){
        Expression a1 = Expression.parse("y*z");
        Expression x = Expression.parse("x"); 
        
        Expression d1 = a1.differentiate(x);
        Expression expected = Expression.parse("y*(0) + z*(0)");
        
        assertEquals(d1, expected);
    }
    
    @Test
    public void testDifferentiate_NumberTimesNumberWithRespectTox(){
        Expression a1 = Expression.parse("2*0.5");
        Expression a2 = Expression.parse("0.5*2");
        Expression x = Expression.parse("x");
        
        Expression d1 = a1.differentiate(x);
        Expression d2 = a2.differentiate(x);
        Expression expected1 = Expression.parse("2*(0) + 0.5*(0)");
        Expression expected2 = Expression.parse("0.5*(0) + 2*(0)");
        
        assertEquals(d1, expected1);
        assertEquals(d2, expected2);
    }
    
    @Test
    public void testDifferentiate_xPlusx_Plusx_WithRespectTox(){
        Expression a1 = Expression.parse("x+x+x");
        Expression a2 = Expression.parse("(x+x)+x");
        Expression x = Expression.parse("x");
        
        Expression d1 = a1.differentiate(x);
        Expression d2 = a2.differentiate(x);
        Expression expected = Expression.parse("((1) + (1)) + (1)");
        
        assertEquals(d1, expected);
        assertEquals(d1, d2);
    }
    
    @Test
    public void testDifferentiate_xPlus_xPlusx_WithRespectTox(){
        Expression a1 = Expression.parse("x+(x+x)");
        Expression a2 = Expression.parse("(x+(x+x))");
        Expression x = Expression.parse("x");
        
        Expression d1 = a1.differentiate(x);
        Expression d2 = a2.differentiate(x);
        Expression expected = Expression.parse("(1) + ((1) + (1))");
        
        assertEquals(d1, expected);
        assertEquals(d1, d2);
    }
    
    @Test
    public void testDifferentiate_xPlus_xTimesx_WithRespectTox(){
        Expression a1 = Expression.parse("x+x*x");
        Expression a2 = Expression.parse("x+(x*x)");
        Expression x = Expression.parse("x");
        
        Expression d1 = a1.differentiate(x);
        Expression d2 = a2.differentiate(x);
        Expression expected = Expression.parse("(1) + (x*(1) + x*(1))");
        
        assertEquals(d1, expected);
        assertEquals(d1, d2);
    }
    
    @Test
    public void testDifferentiate_xPlusx_Timesx_WithRespectTox(){
        Expression a1 = Expression.parse("(x+x)*x");
        Expression a2 = Expression.parse("((x+x)*x)");
        Expression x = Expression.parse("x");
        
        Expression d1 = a1.differentiate(x);
        Expression d2 = a2.differentiate(x);
        Expression expected = Expression.parse("(x + x)*1 + x*((1) + (1))");
        
        assertEquals(d1, expected);
        assertEquals(d1, d2);
    }
    
    @Test
    public void testDifferentiate_xTimesx_Timesx_WithRespectTox(){
        Expression a1 = Expression.parse("x*x*x");
        Expression a2 = Expression.parse("(x*x)*x");
        Expression x = Expression.parse("x");
        
        Expression d1 = a1.differentiate(x);
        Expression d2 = a2.differentiate(x);
        Expression expected = Expression.parse("(x*x)*(1) + x*(x*1 + x*1)");
        
        assertEquals(d1, expected);
        assertEquals(d1, d2);
    }
    
    @Test
    public void testDifferentiate_xTimes_xTimesx_WithRespectTox(){
        Expression a1 = Expression.parse("x*(x*x)");
        Expression a2 = Expression.parse("(x*(x*x))");
        Expression x = Expression.parse("x");
        
        Expression d1 = a1.differentiate(x);
        Expression d2 = a2.differentiate(x);
        Expression expected = Expression.parse("x*(x*1 + x*1) + (x*x)*1");
        
        assertEquals(d1, expected);
        assertEquals(d1, d2);
    }

}
