/*
 * Represents a survey respondent
 */
public class eheh {

  private String name;         
  private String type1;         
  private String type2;      
  private int total;
  private boolean legend;

  /*
   * Sets name, type1, and type2 to the specified values
   */
  public eheh(String name, String type1, String type2, int total, boolean legend) {
    this.name = name;
    this.type1 = type1;
    this.type2 = type2;
    this.total = total;
    this.legend = legend;
  }

  /*
   * Returns the number of name per day the respondent listens to music
   */
  public String getName() {
    return name;
  }

  /*
   * Returns the favorite type1 of the respondent
   */
  public String getType1() {
    return type1;
  }

  /*
   * Returns whether or not music improves or worsens the respondent's mental health
   */
  public String getType2() {
    return type2;
  }

  public int getBst() {
    return total;
  }

  public boolean getLeg() {
    return legend;
  }

  /*
   * Returns a String containing the respondent's answers
   */
  public String toString() {
    return name + type1 + type2 + total + legend;
  }
  
}