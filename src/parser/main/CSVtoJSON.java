/*package parser.main;

import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;

public class CSVtoJSON {
	public static void main(String args[]) throws IOException {
		File root = null;
		File paths[];
		File files[];

		try {
			root = new File("C:\\Users\\BPRR9335\\Desktop\\Data Arvalis\\Arvalis\\L1\\L1_data\\");

			paths = root.listFiles();

			for (File folder : paths) {
				System.out.println("Traitement du dossier : " + folder);
				files = folder.listFiles();

				for (File file : files) {
					String ext = FilenameUtils.getExtension(file.getName());
					if (ext.equals("csv")) {
						System.out.println("Conversion du fichier : " + file.getName());
						//System.out.println(file.getAbsolutePath());
						convert(file.getAbsolutePath(), file.getName());
					}
				}
				System.out.println();
			}

		} catch (Exception e) {
			// if any error occurs
			e.printStackTrace();
		}

	}

	public static void convert(String inputFile, String filename) throws IOException {
		CSVReader parse = new CSVReader(inputFile);
		parse.read();

		JSONSerializer jsoner = new JSONSerializer();
		JSONTemplate jtmp = new JSONTemplate(parse.getNum_cols(), parse.getDataSize(), parse.getFilename(), parse.getData());
		jsoner.serializeToFile(jtmp);

	}

}
*/