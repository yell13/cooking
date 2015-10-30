package yell13.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anton Krupnov
 */
public class User {

  private List<Category> categories = new ArrayList<Category>();

  public List<Category> getCategories() {
    return categories;
  }

}
