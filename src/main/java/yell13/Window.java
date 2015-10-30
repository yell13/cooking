package yell13;

import yell13.model.Category;
import yell13.model.Item;
import yell13.model.User;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.WindowConstants;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

/**
 * @author Anton Krupnov
 */
public class Window extends JDialog {

  private final JTextArea jTextArea;

  public Window(User user) {
    this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    this.setLayout(new BorderLayout());
    JPanel leftPanel = new JPanel();
    leftPanel.setMinimumSize(new Dimension(100, 200));
    DefaultMutableTreeNode root = new DefaultMutableTreeNode();
    final JTree tree = new JTree(root);
    for (Category category : user.getCategories()) {
      DefaultMutableTreeNode categoryNode = new DefaultMutableTreeNode(category, true);
      root.add(categoryNode);
      for (Item item : category.getItems()) {
        categoryNode.add(new DefaultMutableTreeNode(item, false));
      }
    }
    for (int i = 0; i < tree.getRowCount(); i++) {
      tree.expandRow(i);
    }
    tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
    tree.addTreeSelectionListener(new TreeSelectionListener() {
      @Override
      public void valueChanged(TreeSelectionEvent e) {
        jTextArea.setText("");
        Object lastSelectedPathComponent = tree.getLastSelectedPathComponent();
        if (e == null || lastSelectedPathComponent == null) {
          return;
        }

        if (lastSelectedPathComponent instanceof DefaultMutableTreeNode
            && ((DefaultMutableTreeNode) lastSelectedPathComponent).getUserObject() != null
            && ((DefaultMutableTreeNode) lastSelectedPathComponent).getUserObject() instanceof Item) {
          Item item = (Item) ((DefaultMutableTreeNode) lastSelectedPathComponent).getUserObject();
          jTextArea.setText(item.getText());
        }
      }
    });
    leftPanel.add(tree);
    this.add(leftPanel, BorderLayout.LINE_START);

    JPanel centralPanel = new JPanel();
    jTextArea = new JTextArea();
    jTextArea.setMinimumSize(new Dimension(100, 100));
    centralPanel.add(jTextArea);
    this.add(centralPanel);
  }
}
