module com.example.f21comp1011lhassignment2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.f21comp1011lhassignment2 to javafx.fxml;
    exports com.example.f21comp1011lhassignment2;
}