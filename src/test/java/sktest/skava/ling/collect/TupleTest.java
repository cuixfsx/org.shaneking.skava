package sktest.skava.ling.collect;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.shaneking.skava.ling.collect.Tuple;
import org.shaneking.skava.ling.lang.String0;
import sktest.skava.SKUnit;

import java.text.MessageFormat;
import java.util.List;

public class TupleTest extends SKUnit {
  private String elevenString = "[1,2,3,4,5,6,7,8,9,10,11]";
  private String elevenString2 = "[1,2,3,4,5,[1,2,3,4,5,6,7,8,9,10,11],7,8,9,10,11]";
  private Tuple elevenTuple = Tuple.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
  private Tuple elevenTuple2 = Tuple.of(1, 2, 3, 4, 5, Tuple.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11), 7, 8, 9, 10, 11);
  private ObjectMapper objectMapper = new ObjectMapper();
  private Tuple.TupleJoiner tupleJoiner = null;

  @Before
  public void setUp() {
    super.setUp();
    elevenTuple = Tuple.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
    elevenTuple2 = Tuple.of(1, 2, 3, 4, 5, Tuple.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11), 7, 8, 9, 10, 11);
    tupleJoiner = new Tuple.TupleJoiner(String0.OPEN_BRACKET, String0.DOT, String0.CLOSE_BRACKET);
  }

  @After
  public void tearDown() {
    super.tearDown();
  }

  @Test
  public void testJsonStringLevel1() throws Exception {
    Assert.assertEquals(elevenString, objectMapper.writeValueAsString(elevenTuple));
    Assert.assertEquals(elevenString, String.valueOf(elevenTuple));
    Assert.assertEquals(elevenString, objectMapper.writeValueAsString(objectMapper.readValue(elevenString, List.class)));
  }

  @Test
  public void testJsonStringLevel2() throws Exception {
    Assert.assertEquals(elevenString2, objectMapper.writeValueAsString(elevenTuple2));
    Assert.assertEquals(elevenString2, String.valueOf(elevenTuple2));
    Assert.assertEquals(elevenString2, objectMapper.writeValueAsString(objectMapper.readValue(elevenString2, List.class)));
  }

//  @Test
//  public void joinWith1() {
//    Assert.assertEquals(String.valueOf(Tuple.joinWith(String0.DOT)), "TupleJoiner{open='(', separator='.', close=')'}");
//  }
//
//  @Test
//  public void joinWith3() {
//    Assert.assertEquals(String.valueOf(Tuple.joinWith(String0.OPEN_BRACKET, String0.DOT, String0.CLOSE_BRACKET)), "TupleJoiner{open='[', separator='.', close=']'}");
//  }

  @Test
  public void of() {
    Assert.assertEquals(String.valueOf(Tuple.of()), MessageFormat.format("{0}{1}", Tuple.BEGIN, Tuple.END));
  }

  @Test
  public void of1() {
    Assert.assertEquals(String.valueOf(Tuple.of(1)), MessageFormat.format("{0}1{1}", Tuple.BEGIN, Tuple.END));
  }

  @Test
  public void of2() {
    Assert.assertEquals(String.valueOf(Tuple.of(1, 2)), MessageFormat.format("{0}1,2{1}", Tuple.BEGIN, Tuple.END));
  }

  @Test
  public void of3() {
    Assert.assertEquals(String.valueOf(Tuple.of(1, 2, 3)), MessageFormat.format("{0}1,2,3{1}", Tuple.BEGIN, Tuple.END));
  }

  @Test
  public void of4() {
    Assert.assertEquals(String.valueOf(Tuple.of(1, 2, 3, 4)), MessageFormat.format("{0}1,2,3,4{1}", Tuple.BEGIN, Tuple.END));
  }

  @Test
  public void of5() {
    Assert.assertEquals(String.valueOf(Tuple.of(1, 2, 3, 4, 5)), MessageFormat.format("{0}1,2,3,4,5{1}", Tuple.BEGIN, Tuple.END));
  }

  @Test
  public void of6() {
    Assert.assertEquals(String.valueOf(Tuple.of(1, 2, 3, 4, 5, 6)), MessageFormat.format("{0}1,2,3,4,5,6{1}", Tuple.BEGIN, Tuple.END));
  }

  @Test
  public void of7() {
    Assert.assertEquals(String.valueOf(Tuple.of(1, 2, 3, 4, 5, 6, 7)), MessageFormat.format("{0}1,2,3,4,5,6,7{1}", Tuple.BEGIN, Tuple.END));
  }

  @Test
  public void of8() {
    Assert.assertEquals(String.valueOf(Tuple.of(1, 2, 3, 4, 5, 6, 7, 8)), MessageFormat.format("{0}1,2,3,4,5,6,7,8{1}", Tuple.BEGIN, Tuple.END));
  }

  @Test
  public void of9() {
    Assert.assertEquals(String.valueOf(Tuple.of(1, 2, 3, 4, 5, 6, 7, 8, 9)), MessageFormat.format("{0}1,2,3,4,5,6,7,8,9{1}", Tuple.BEGIN, Tuple.END));
  }

  @Test
  public void of10() {
    Assert.assertEquals(String.valueOf(Tuple.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)), MessageFormat.format("{0}1,2,3,4,5,6,7,8,9,10{1}", Tuple.BEGIN, Tuple.END));
  }

  @Test
  public void of11() {
    Assert.assertEquals(String.valueOf(Tuple.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)), MessageFormat.format("{0}1,2,3,4,5,6,7,8,9,10,11{1}", Tuple.BEGIN, Tuple.END));
  }

  @Test
  public void getFirst() {
    Assert.assertEquals(String.valueOf(Tuple.getFirst(elevenTuple)), "1");
  }

  @Test
  public void getSecond() {
    Assert.assertEquals(String.valueOf(Tuple.getSecond(elevenTuple)), "2");
  }

  @Test
  public void getThird() {
    Assert.assertEquals(String.valueOf(Tuple.getThird(elevenTuple)), "3");
  }

  @Test
  public void getFourth() {
    Assert.assertEquals(String.valueOf(Tuple.getFourth(elevenTuple)), "4");
  }

  @Test
  public void getFifth() {
    Assert.assertEquals(String.valueOf(Tuple.getFifth(elevenTuple)), "5");
  }

  @Test
  public void getSixth() {
    Assert.assertEquals(String.valueOf(Tuple.getSixth(elevenTuple)), "6");
  }

  @Test
  public void getSeventh() {
    Assert.assertEquals(String.valueOf(Tuple.getSeventh(elevenTuple)), "7");
  }

  @Test
  public void getEighth() {
    Assert.assertEquals(String.valueOf(Tuple.getEighth(elevenTuple)), "8");
  }

  @Test
  public void getNinth() {
    Assert.assertEquals(String.valueOf(Tuple.getNinth(elevenTuple)), "9");
  }

  @Test
  public void getTenth() {
    Assert.assertEquals(String.valueOf(Tuple.getTenth(elevenTuple)), "10");
  }

  @Test
  public void getN() {
    Assert.assertEquals("4", String.valueOf(Tuple.<Integer>getN(elevenTuple, 3)));
  }

  @Test
  public void prepend() {
    Assert.assertEquals(String.valueOf(elevenTuple.prepend(0)), MessageFormat.format("{0}0,{1}1,2,3,4,5,6,7,8,9,10,11{2}{3}", Tuple.BEGIN, Tuple.BEGIN, Tuple.END, Tuple.END));
  }

  @Test
  public void testEquals11() {
    Assert.assertEquals(elevenTuple, elevenTuple);
  }

  @Test
  public void testEquals12() {
    Assert.assertEquals(Tuple.of(127, 0, 0, 1), Tuple.of(127, 0, 0, 1));
  }

  @Test
  public void testEquals21() {
    Assert.assertNotEquals(Tuple.of(127, 0, 0, 1), null);
  }

  @Test
  public void testEquals22() {
    Assert.assertEquals(Tuple.of(127, 0, 0, 1), Tuple.of(127, 0, 0, 1));
  }

  @Test
  public void testEquals31() {
    Assert.assertNotEquals(elevenTuple, new Object());
  }

  @Test
  public void testEquals41() {
    Assert.assertNotEquals(elevenTuple, Tuple.of(127, 0, 0, 1));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(Tuple.of(127, 0, 0, 1).hashCode(), 4706979);
  }

  @Test
  public void toString0() {
    Assert.assertEquals(elevenTuple.toString(String0.DOT), MessageFormat.format("{0}1.2.3.4.5.6.7.8.9.10.11{1}", Tuple.BEGIN, Tuple.END));
  }

  @Test
  public void toString1() {
    Assert.assertEquals(elevenTuple.toString(String0.OPEN_BRACKET, String0.DOT, String0.CLOSE_BRACKET), MessageFormat.format("{0}1.2.3.4.5.6.7.8.9.10.11{1}", Tuple.BEGIN, Tuple.END));
  }

  @Test
  public void toString2() {
    Assert.assertEquals(elevenTuple.toString(tupleJoiner), MessageFormat.format("{0}1.2.3.4.5.6.7.8.9.10.11{1}", Tuple.BEGIN, Tuple.END));
  }

}
