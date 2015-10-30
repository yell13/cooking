package yell13.model;

/**
 * @author Anton Krupnov
 */
public class Item {

  private String name;
  private String text;

  @Override
  public String toString() {
    return getName();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
