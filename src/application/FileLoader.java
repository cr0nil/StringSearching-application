package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

public class FileLoader {

	public FileLoader() {

	}

	public void read() {
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader("E:\\projInz2\\StringSearching-application\\new2.txt"));
			String line;

			while ((line = br.readLine()) != null) {

				System.out.println(line);

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

}
