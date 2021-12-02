module com.example.f21comp1011lhassignment2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires com.google.gson;
    requires java.net.http;



    opens com.example.f21comp1011lhassignment2 to javafx.fxml, com.google.gson;
    exports com.example.f21comp1011lhassignment2;
    exports com.example.f21comp1011lhassignment2.Controllers;
    opens com.example.f21comp1011lhassignment2.Controllers to com.google.gson, javafx.fxml;
    exports com.example.f21comp1011lhassignment2.Utilities;
    opens com.example.f21comp1011lhassignment2.Utilities to com.google.gson, javafx.fxml;
    exports com.example.f21comp1011lhassignment2.Models;
    opens com.example.f21comp1011lhassignment2.Models to com.google.gson, javafx.fxml;
}