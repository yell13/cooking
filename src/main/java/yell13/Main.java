package yell13;

import yell13.model.Category;
import yell13.model.Item;
import yell13.model.User;

/**
 * @author Anton Krupnov
 */
public class Main {

  public static void main(String[] args) {
    Window window = new Window(createTempUser());
    window.setSize(900, 500);
    window.setLocation(100, 100);
    window.setVisible(true);
  }

  private static User createTempUser() {
    User user = new User();
    user.getCategories().add(createCategory("Category 1", 4));
    user.getCategories().add(createCategory("Category with one item", 1));
    user.getCategories().add(createCategory("Category 3", 2));
    user.getCategories().add(createCategory("Favourite category", 3));
    return user;
  }

  private static Category createCategory(String name, int numberOfItems) {
    Category category = new Category(name);
    for (int i = 0; i < numberOfItems; i++) {
      category.getItems().add(createItem());
    }
    return category;
  }

  private static Item createItem() {
    Item item = new Item();
    item.setName("Item Name");
    item.setText("Item Text");
    return item;
  }

}
