package parser.test;

import parser.main.CSVReader;

public class TestCSVReader {
	public static void main(String args[]) {
		String path = "C:\\Users\\JackMesss\\IdeaProjects\\factory-app\\GestionStock\\Application";
		String file = "chaines.csv";
		CSVReader parse = new CSVReader(path+file);
		parse.read();


		System.exit(0);
	}

}
