package yell13.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anton Krupnov
 */
public class Category {

  private String name;
  private List<Item> items = new ArrayList<Item>();

  public Category(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name + " category";
  }

  public List<Item> getItems() {
    return items;
  }
}
