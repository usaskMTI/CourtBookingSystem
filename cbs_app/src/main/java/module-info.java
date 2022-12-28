module com.example.cmpt381_assignment2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cbs to javafx.fxml;
    exports com.example.cbs;
}