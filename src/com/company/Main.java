package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

	private static FileGenerator fileGenerator;

	public static void main(String[] args) {
	    List<Column> columns = new ArrayList<Column>();
		fileGenerator = new FileGenerator();
		String alias = "IzvestajTroskova";
	    HTMLGenerator generator = new HTMLGenerator(columns,"Master detail izvestaj",alias);
	    RepositoryGenerator repositoryGenerator = new RepositoryGenerator(alias,Config.ExampleSelect);
		fileGenerator.genenrateFile(Config.RepositoryPath+"//"+ generator.getAlias()+"Repository.java", repositoryGenerator.generateRepository());
	    System.out.println(repositoryGenerator.generateRepository());
	    ControllerGenerator controllerGenerator = new ControllerGenerator(alias);
	    //System.out.println(controllerGenerator.generateController());
		//fileGenerator.genenrateFile(Config.ControllerPath+"//"+ generator.getAlias()+"Controller.java", controllerGenerator.generateController());
		columns.add(new Column("BrUgovora","text"));
	    columns.add(new Column("SifKomint","text"));
	    columns.add(new Column("NazivKomint","text"));
	    columns.add(new Column("Mesto","text"));
	    columns.add(new Column("Datum","text"));
	    columns.add(new Column("DatumRok","text"));
		//generateHTML(generator);
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
		//System.out.println(sb.toString());
		fileGenerator.genenrateFile(Config.HTMLPagePath+"//"+ generator.getAlias()+".html", sb.toString());
	}
}
