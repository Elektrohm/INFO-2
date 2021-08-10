import org.junit.Test;
import static org.junit.Assert.*;

public class TestSuite{


    //Théo recommence les tests d'abord en faisant le dessin des noeuds sur une feuille
    //ça t'évitera de faire 10 millions de tests car tu vas couvrir justes les différents chemin possible
    //et passe une bonne journée, tu es le meilleur ;)

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testFirstOutofBound(){
        char[] in = new char[]{'0','1','2'};
        int offset = 2;
        int len=1;

        BigDecimal.parseExp(in,offset,len);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testSecondOutofBound(){
        char[] in = new char[]{'0','+'};
        int offset = 0;
        int len=1;

        BigDecimal.parseExp(in,offset,len);
    }

    @Test(expected = NumberFormatException.class)
    public void testLen0If(){
        char[] in = new char[]{'0','+','2'};
        int offset = 0;
        int len=2;

        BigDecimal.parseExp(in,offset,len);
    }

    @Test(expected = NumberFormatException.class)
    public void testLen0Else(){
        char[] in = new char[]{'0','1','2'};
        int offset = 0;
        int len=1;

        BigDecimal.parseExp(in,offset,len);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testThirdOutOfBound(){
        char[] in = new char[]{'0','0','0'};
        int offset = 1;
        int len = 12;

        BigDecimal.parseExp(in,offset,len);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testThirdOutOfBoundBis(){
        char[] in = new char[]{'0','+','0'};
        int offset = 0;
        int len = 12;

        BigDecimal.parseExp(in,offset,len);
    }

    @Test(expected = NumberFormatException.class)
    public void testLen10If(){
        char[] in = new char[]{'0','+','0','1','1'};
        int offset = 0;
        int len = 14;

        BigDecimal.parseExp(in,offset,len);
    }

    @Test(expected = NumberFormatException.class)
    public void testLen10bisIf(){
        char[] in = new char[]{'0','+','1','1','1'};
        int offset = 0;
        int len = 14;

        BigDecimal.parseExp(in,offset,len);
    }

    @Test(expected = NumberFormatException.class)
    public void testLen10Else(){
        char[] in = new char[]{'0','0','0','1','1'};
        int offset = 0;
        int len = 14;

        BigDecimal.parseExp(in,offset,len);
    }

    @Test(expected = NumberFormatException.class)
    public void testLen10bisElse(){
        char[] in = new char[]{'0','1','1','1','1'};
        int offset = 0;
        int len = 14;

        BigDecimal.parseExp(in,offset,len);
    }

    @Test(expected = NumberFormatException.class)
    public void testNotADigit(){
        char[] in = new char[]{'0','+','0','a','0'};
        int offset = 0;
        int len = 13;

        BigDecimal.parseExp(in,offset,len);
    }

    @Test(expected = NumberFormatException.class)
    public void testNotAdigitbis(){
        char[] in = new char[]{'0','+','a','1','1'};
        int offset = 0;
        int len = 12;

        BigDecimal.parseExp(in,offset,len);
    }

    @Test(expected = NumberFormatException.class)
    public void testIfNotAdigit(){
        char[] in = new char[]{'0','+','0','1','a'};
        int offset = 0;
        int len = 13;

        BigDecimal.parseExp(in,offset,len);
    }

    @Test
    public void testForLoopDirectlyOut(){
        char[] in = new char[]{'0','+','1','1','a'};
        int offset = 0;
        int len = 3;

        assertEquals(1,BigDecimal.parseExp(in,offset,len));

    }

    @Test
    public void testForLoopPlus(){
        char[] in = new char[]{'0','+','1','1','a'};
        int offset = 0;
        int len = 4;

        assertEquals(BigDecimal.parseExp(in,offset,len),11);
    }

    @Test
    public void testForLoopOpposite(){
        char[] in = new char[]{'0','-','1','1','a'};
        int offset = 0;
        int len = 4;

        assertEquals(BigDecimal.parseExp(in,offset,len),-11);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void fourthOutOfBound(){
        char[] in = new char[]{'0','-','1','1','1'};
        int offset = 0;
        int len = 7;

        BigDecimal.parseExp(in,offset,len);
    }
}