module si.unilj.fi.uporabniskivmesniki {
    requires javafx.controls;
    requires javafx.fxml;


    opens si.unilj.fi.uporabniskivmesniki to javafx.fxml;
    exports si.unilj.fi.uporabniskivmesniki;
}