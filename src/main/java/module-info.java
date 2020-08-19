module com.nzervu {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.nzervu to javafx.fxml;
    exports com.nzervu;
}