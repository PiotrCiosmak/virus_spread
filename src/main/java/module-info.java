module com.ciosmak.virus_spread {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.ciosmak.virus_spread to javafx.fxml;
    exports com.ciosmak.virus_spread;
}