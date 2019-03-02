package parser.main;

import java.util.ArrayList;

public class JSONTemplate {
	private int columns;
	private int occurencies;
	public String filename;
	private ArrayList data;

	public JSONTemplate(int columns, int occurencies, String filename, ArrayList data) {
		this.columns = columns;
		this.occurencies = occurencies;
		this.filename = filename;
		this.data = data;
	}

}
