package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import application.dialogs.DialogsUtils;
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
import java.util.regex.*;

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
	private TextField wzor;

	@FXML
	private void otworzPlikAction(ActionEvent event) {

		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Otwórz Plik");
		fileChooser.getExtensionFilters().add(new ExtensionFilter("Pliki TXT", "*.txt"));
		plik = fileChooser.showOpenDialog(stage);

		if (plik != null) {
			// Wyswietlenie ścieżki do pliku.
			System.out.println("Plik: " + plik.getAbsolutePath());

		}
		read(plik);

	}

	RabinKarp_Algorithm rabinKarp_Algorithm = new RabinKarp_Algorithm();
	KnuthMorrisPrattAalgorithm knuthMorrisPrattAalgorithm = new KnuthMorrisPrattAalgorithm();

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
			// String tekst = "kaczaczka";
			String wzor1 = "kot";// nie dziala
			// String wzor = "dok";// dziala here
			// }

			// wzor1
			// System.out.println("indeks" + rabinKarp_Algorithm.getI());

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

	@FXML
	public void setText(ActionEvent actionEvent) {

		System.out.println(odczyt);
		String kaczka = odczyt.toString();
		regexChecker("([\\;,])", odczyt.toString());
		textArea.setText(kaczka);
		textArea.setWrapText(true);

	}

	@FXML
	public void highlightText() {
		//if dosn't exist key-word
		//knuthMorrisPrattAalgorithm.search(wzor.getText().toString(),odczyt.toString());
	System.out.println("RK");
		rabinKarp_Algorithm.RK_algo(odczyt.toString(),wzor.getText().toString());
		int start, stop;
		start = rabinKarp_Algorithm.getI();
		stop = wzor.getText().length();
		stop = start + stop;
		//
		textArea.selectRange(start, stop);
	}
	@FXML
	public void highlightText2() {
		//if dosn't exist key-word
		knuthMorrisPrattAalgorithm.search(wzor.getText().toString(),odczyt.toString());
	
	
		int start, stop;
		start = knuthMorrisPrattAalgorithm.getInd()-1;
		stop = wzor.getText().length();
		stop = start + stop;
		//
		textArea.selectRange(start, stop);
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
	public static void regexChecker(String theRegex, String str2Check) { 
		Pattern pattern = Pattern.compile(theRegex);
		Matcher regexMatcher = pattern.matcher(str2Check);
		while(regexMatcher.find()) {
			if(regexMatcher.group().length() !=0){
				if(regexMatcher.group().equals(";"));
				System.out.println("\n");
				
			}
		}
	}
}
