package edu.westga.cs1302.javafx_sample_starter_lab3.views;

import edu.westga.cs1302.javafx_sample_starter_lab3.model.Bill;
import edu.westga.cs1302.javafx_sample_starter_lab3.model.BillItem;
import edu.westga.cs1302.javafx_sample_starter_lab3.views.BillView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;



/**
 * Controller class for drawing various things to our canvas window.
 * 

 * @author CS 1302
 * @version Fall 2025
 */
public class MainWindow {
    
  /*from the sample project the week before
  * 
   * @FXML
  private TextField input;

  @FXML
  private TextArea output;

  @FXML
  void displayText(ActionEvent event) {
    String input = this.input.getText();
    this.output.setText(input);
  }*/

  @FXML
  private TextField amount;

  @FXML
  private TextField name;

  @FXML
  private TextArea output;

  private Bill bill;

  private BillView receipt;

  @FXML
  void addItem(ActionEvent event) {
    double amountDub = Double.parseDouble(this.amount.getText());
    BillItem item = new BillItem(this.name.getText(), amountDub);
    this.bill.addItem(item);
    this.receipt = new BillView();
    this.output.setText(this.receipt.getText(this.bill));
  }

  /**
  * Perform any needed initialization of UI components and underlying objects.
  */
  public void initialize() {
    this.bill = new Bill();
  }
}
