package application;

import application.dialogs.DialogsUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.StringTokenizer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class FileLoader implements Initializable {

    private Stage stage;
    public ArrayList<String> lista = new ArrayList<String>();

    public File plik;
    @FXML
    private Button btn;
    @FXML
    private MenuItem menu_zamknij;
    @FXML
    private TextArea textArea;
    @FXML
    private TextField textFieldTag;

    

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

            //odczyt = (ArrayList) Files.readAllLines(sciezkaDoPliku);
            //System.out.println(odczyt);
            Scanner odczyt = new Scanner(file);
            StringTokenizer token;
            while(odczyt.hasNextLine()){
                token = new StringTokenizer(odczyt.nextLine(),",");
                while(token.hasMoreElements()){
                    lista.add(token.nextToken());
                }
            }
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


    }

    @FXML
    public void setText(ActionEvent actionEvent) {

        //for(String kaczka:lista)
        String kaczka = lista.toString();
        textArea.setText(kaczka);
        
        String tag;
        String tekst;
        int m, n, i, j, t;
        int P[] = new int[100];//maksymalna dlugosc wzorca to 100 symboli
        tekst = lista.toString();
        System.out.println("Tekst "+tekst);
        tag = textFieldTag.getText();
        System.out.println("Wzorzec "+tag);
        n = tekst.length();
        m = tag.length();
        System.out.println("Indeksy poczatku wzorca w tekscie");

//      obliczenie tablicy P
        P[0] = 0;
        P[1] = 0;
        t = 0;
        for (j = 2; j <= m; j++) {
            while ((t > 0) && (tag.charAt(t) != tag.charAt(j - 1))) {
                t = P[t];
            }
            if (tag.charAt(t) == tag.charAt(j - 1)) {
                t++;
            }
            P[j] = t;
        }

//      algorytm KMP
        i = 1;
        j = 0;
        while (i <= n - m + 1) {
            j = P[j];
            while ((j < m) && (tag.charAt(j) == tekst.charAt(i + j - 1))) {
                j++;
            }
            if (j == m) {
                System.out.println(i);
            }
            i = i + Math.max(1, j - P[j]);
        }
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
