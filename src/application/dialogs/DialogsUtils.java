package application.dialogs;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class DialogsUtils {
    
    public static Optional<ButtonType> confirmationDialog() {
        Alert potwierdz = new Alert(Alert.AlertType.CONFIRMATION);
        potwierdz.setTitle("Wyjście");
        potwierdz.setHeaderText("Czy na pewno chcesz wyjść??");
        Optional<ButtonType> result = potwierdz.showAndWait();
        return result;

    }
    
    
}


package application.dialogs;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class DialogsUtils {
    
    public static Optional<ButtonType> confirmationDialog() {
        Alert potwierdz = new Alert(Alert.AlertType.CONFIRMATION);
        potwierdz.setTitle("Wyjście");
        potwierdz.setHeaderText("Czy na pewno chcesz wyjść??");
        Optional<ButtonType> result = potwierdz.showAndWait();
        return result;

    }
    
    
}

