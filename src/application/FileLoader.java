package application;

import application.dialogs.DialogsUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class FileLoader implements Initializable {

    private Stage stage;
    public ArrayList<String> odczyt = new ArrayList<String>();

    public File plik;
    @FXML
    private Button btn;
    @FXML
    private MenuItem menu_zamknij;
    @FXML
    private TextArea textArea;

    

    @FXML
    private void otworzPlikAction(ActionEvent event) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Otwórz Plik");
        fileChooser.getExtensionFilters().add(new ExtensionFilter("Pliki TXT", "*.txt"));
        plik = fileChooser.showOpenDialog(stage);

        if (plik != null) {
            // Wyswietlenie  ścieżki do pliku.
            System.out.println("Plik: " + plik.getAbsolutePath());

        }
        read(plik);

    }

    public void read(File file) {
        BufferedReader br = null;
        Path sciezkaDoPliku = Paths.get(file.getAbsolutePath());

        try {
            // br = new BufferedReader(new
            // FileReader("E:\\projInz2\\StringSearching-application\\new2.txt"));
            String line;
            odczyt = (ArrayList) Files.readAllLines(sciezkaDoPliku);
            System.out.println(odczyt);
            // while ((line = br.readLine()) != null) {
            //
            // System.out.println(line);
//String tekst = "kaczaczka";
            String wzor1  = "kot";//nie dziala
String wzor = "dok";// dziala here
            // }
            RabinKarp_Algorithm rabinKarp_Algorithm = new RabinKarp_Algorithm();
            rabinKarp_Algorithm.RK_algo(odczyt.toString(), wzor);//wzor1
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println(odczyt + "tutajj");

    }

//	public void view(ActionEvent actionEvent) {
//	//	Parent root;
//        try {
//        	Parent root = FXMLLoader.load(getClass().getResource("Main2.fxml"));
//            Stage stage = new Stage();
//            //root = (Parent) fxmlLoader.load();
//            //
//
//            stage.setTitle("My New Stage Title");
//            stage.setScene(new Scene(root));
//           
//            stage.show();
//          ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
//           
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        
// }
//	}
    @FXML
    public void setText(ActionEvent actionEvent) {

        System.out.println(odczyt);
        String kaczka = odczyt.toString();
        textArea.setText(kaczka);
    }

    @FXML
    private void zamknijAplikacje(ActionEvent event) {
        Optional<ButtonType> result = DialogsUtils.confirmationDialog();
        if (result.get() == ButtonType.OK) {
            Platform.exit();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
