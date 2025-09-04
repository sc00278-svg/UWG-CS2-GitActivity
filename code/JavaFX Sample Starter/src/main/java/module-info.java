module edu.westga.cs1302.javafx_sample_starter_lab3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens edu.westga.cs1302.javafx_sample_starter_lab3.views to javafx.fxml;
    exports edu.westga.cs1302.javafx_sample_starter_lab3;
}
