module si.unilj.fri.uporabniskivmesniki {
    requires javafx.controls;
    requires javafx.fxml;


    opens si.unilj.fri.uporabniskivmesniki to javafx.fxml;
    exports si.unilj.fri.uporabniskivmesniki;
}