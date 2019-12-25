package Lessons.Task2;


import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestStringProcessor {

    @Test
    public void TestMulStr() {
        String shortString = "1";
        String nullString = null;
        String longString = "11111111111111111111111111111111111111111111111111";
        Assert.assertEquals(StringProcessor.mulStr(shortString,5).length(),5);
        Assert.assertEquals(StringProcessor.mulStr(longString,5).length(),250);
        Assert.assertNotNull(assertThrows(Exception.class, () -> { StringProcessor.mulStr(nullString,5); }).getMessage());
        Assert.assertNotNull(assertThrows(Exception.class, () -> { StringProcessor.mulStr(shortString,-5); }).getMessage());
    }

    @Test
    public void TestCountOfSubstring() throws Exception {
        String shortString ="1";
        String nullString = null;
        String longString = "11111111111111111111111111111111111111111111111111";
        Assert.assertEquals(StringProcessor.countOfSubstring(longString,shortString),50);
        Assert.assertEquals(StringProcessor.countOfSubstring(shortString,shortString),1);

        Assert.assertEquals(StringProcessor.countOfSubstring("abc.bcd.","."),2);
        Assert.assertEquals(StringProcessor.countOfSubstring("vvvvv","vv"),4);
    }

    @Test
    public void TestCharToNumberReplace() throws Exception {
        Assert.assertEquals(StringProcessor.charToNumberReplace("1"),"one");
        Assert.assertEquals(StringProcessor.charToNumberReplace("2"),"two");
        Assert.assertEquals(StringProcessor.charToNumberReplace("3"),"three");
        Assert.assertEquals(StringProcessor.charToNumberReplace("aaaaaa1"),"aaaaaaone");
        Assert.assertEquals(StringProcessor.charToNumberReplace("2aa2aaa1"),"twoaatwoaaaone");

        Assert.assertNotNull(assertThrows(Exception.class, () -> { StringProcessor.charToNumberReplace(null); }).getMessage());
    }

   @Test
    public void TestEvenCharRemove() throws Exception {
        StringBuilder string1 = new StringBuilder("1 1 1 1 1 1 1 1 ");
        StringBuilder string2 = new StringBuilder("1212121212121212");
        StringBuilder string3 = new StringBuilder("space     space");
        StringProcessor.evenCharRemove(string1);
        Assert.assertEquals(string1.toString(),"11111111");
        StringProcessor.evenCharRemove(string2);
        Assert.assertEquals(string2.toString(),"11111111");
        StringProcessor.evenCharRemove(string3);
        Assert.assertEquals(string3.toString(),"sae  sae");

        Assert.assertNotNull(assertThrows(Exception.class, () -> { StringProcessor.evenCharRemove(null); }).getMessage());

    }

    @Test
    public void TestSwapWords() throws Exception {
        StringBuilder string1 = new StringBuilder("word1 word2    word3");
        StringBuilder string2 = new StringBuilder(" word1 word2 word3");
        StringBuilder string3 = new StringBuilder(" word1 word2 word3 ");
        StringBuilder string4 = new StringBuilder(" woooooord1 word2 word3");
        StringBuilder string5 = new StringBuilder("abc");
        StringBuilder string6 = new StringBuilder("a   def");
        Assert.assertEquals(StringProcessor.swapWords(string1).toString(),"word3 word2    word1");
        Assert.assertEquals(StringProcessor.swapWords(string2).toString()," word3 word2 word1");
        Assert.assertEquals(StringProcessor.swapWords(string3).toString()," word3 word2 word1 ");
        Assert.assertEquals(StringProcessor.swapWords(string4).toString()," word3 word2 woooooord1");
        Assert.assertEquals(StringProcessor.swapWords(string5).toString(),"abc");
        Assert.assertEquals(StringProcessor.swapWords(string6).toString(),"def   a");
        Assert.assertEquals(StringProcessor.swapWords(new StringBuilder("   ")).toString(),"   ");
        Assert.assertEquals(StringProcessor.swapWords(new StringBuilder("  abc ")).toString(),"  abc ");
        Assert.assertNotNull(assertThrows(Exception.class, () -> { StringProcessor.swapWords(null); }).getMessage());
    }
    @Test
    public void TestHexToDec() throws Exception {
        String string = "0x00000000";
        String string1 = "0x0000000f";
        String string2 = "0x";
        String string3 = "0x00110000011";
        String string5 = "abc0xAB dce 0xZ";
        Assert.assertEquals(StringProcessor.hexToDec(string),"0");
        Assert.assertEquals(StringProcessor.hexToDec(string1),"15");
        Assert.assertEquals(StringProcessor.hexToDec(string2),"0x");
        Assert.assertEquals(StringProcessor.hexToDec(string3),"1114112011");
        String string4 = "0x00000000 0x00000001 0x00000002    0x00000003 0x0";
        Assert.assertEquals(StringProcessor.hexToDec(string4),"0 1 2    3 0");
        Assert.assertEquals(StringProcessor.hexToDec(string5),"abc171 dce 0xZ");

    }
}
