package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
	    List<Column> columns = new ArrayList<Column>();
	    HTMLGenerator generator = new HTMLGenerator(columns,"Master detail izvestaj","masterdetail");
	    columns.add(new Column("godina","text"));
	    columns.add(new Column("BrUgovora","text"));
	    columns.add(new Column("VR","text"));
	    columns.add(new Column("Rbr","text"));
	    columns.add(new Column("Datum","text"));
	    columns.add(new Column("Valuta","text"));
	    columns.add(new Column("IznosRobe","text"));
	    columns.add(new Column("IznosPoreza","text"));
	    columns.add(new Column("IznosRabata","text"));
	    columns.add(new Column("IznosKupac","text"));
	    columns.add(new Column("IznosAvansa","text"));
	    columns.add(new Column("RbrTendera","text"));



		generateHTML(generator);
    }

	private static void generateHTML(HTMLGenerator generator) {
		StringBuilder sb = new StringBuilder();
		sb.append(generator.header());
		sb.append(generator.heading());
    	sb.append(generator.openTable());
		sb.append(generator.generateHeader());
		sb.append(generator.closeRow());
		sb.append(generator.openRow());
		sb.append(generator.generateFilterInputs());
		sb.append(generator.closeRow());
		sb.append(generator.closeHead());
		sb.append("<tbody>");
		sb.append(generator.generateFilters());
		sb.append(generator.generateValues());
		sb.append(generator.closeRow());
		sb.append("</tbody>");
		sb.append(generator.closeTable());
		sb.append(generator.closer());
		System.out.println(sb.toString());
	}
}
