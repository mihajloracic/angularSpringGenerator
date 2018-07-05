package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
	    List<Column> columns = new ArrayList<Column>();
	    HTMLGenerator generator = new HTMLGenerator(columns);
	    columns.add(new Column("Nazivkomint","text"));
	    columns.add(new Column("Mesto","text"));
	    columns.add(new Column("SifKomint","text"));
	    columns.add(new Column("SaldoKupac","text"));
	    columns.add(new Column("k432xx","text"));
	    columns.add(new Column("k14000","text"));
	    columns.add(new Column("SaldoDobavljac","text"));
	    columns.add(new Column("Saldo","text"));
	    columns.add(new Column("Kupac","text"));
	    columns.add(new Column("KupAv","text"));
	    columns.add(new Column("Dobavljac","text"));
	    columns.add(new Column("DobAv","text"));
	    columns.add(new Column("StatusKom","text"));
	    columns.add(new Column("Poslovnica","text"));
	    columns.add(new Column("Referent","text"));
	    columns.add(new Column("Ime","text"));
	    columns.add(new Column("ReferentDob","text"));
	    columns.add(new Column("ReferentDobavljaca","text"));
		generateHTML(generator);
    }

	private static void generateHTML(HTMLGenerator generator) {
		StringBuilder sb = new StringBuilder();
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
		System.out.println(sb.toString());
	}
}
