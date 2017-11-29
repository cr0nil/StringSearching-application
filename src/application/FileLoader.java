package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

//import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.scene.Node;

public class FileLoader {
	@FXML
	private Stage stage;
	@FXML
	private Label lbl;
	public ArrayList<String> odczyt = new ArrayList<String>();
	
	public File plik;

	public FileLoader() {
		
	}

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
                
                System.out.print("test test test");

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

			// }

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
		System.out.println(odczyt+"tutajj");
		
	
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


	
	public void setText(ActionEvent actionEvent) {
		
		System .out.println(odczyt+"    a  "+odczyt.toString());
	String kaczka  = odczyt.toString();
		lbl.setText(kaczka);
	}


}
