module edu.westga.cs1302.investment_projector {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens edu.westga.cs1302.investment_projector.view to javafx.fxml;
    exports edu.westga.cs1302.investment_projector;
}
