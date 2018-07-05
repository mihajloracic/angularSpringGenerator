package com.company;

import java.text.MessageFormat;
import java.util.List;

public class HTMLGenerator {
    List<Column> columns;

    public HTMLGenerator(List<Column> columns) {
        this.columns = columns;
    }

    public String generateHeader(){
        StringBuilder sb = new StringBuilder();
        for (Column c: columns) {
            String line = MessageFormat.format("<td><a href=\"#\" ng-click=\"orderByMe(''{0}'')\">{0}</a> <span ng-show=\"myOrderBy == ''{0}''\" ng-class=\"'{''fa fa-caret-down'': ascending,''fa fa-caret-up'': !ascending'}'\"></span></td>\n", c.getName());
            sb.append(line);
        }
        return sb.toString();
    }
    public String generateFilterInputs(){
        StringBuilder sb = new StringBuilder();
        for (Column c: columns) {
            String line = MessageFormat.format("<th><input type=\"text\" ng-model=\"filter{0}\" class=\"form-control\"></th>\n", c.getName());
            sb.append(line);
        }
        return sb.toString();
    }
    public String closeRow(){
        return "</tr>";
    }
    public String openRow(){
        return "<tr>";
    }
    public String closeHead(){
        return "</thead>";
    }
    public String generateFilters(){
        StringBuilder sb = new StringBuilder();
        sb.append("<tr ng-repeat=\"x in names  | orderBy:myOrderBy:ascending ");
        for (Column c: columns) {
            String line = MessageFormat.format("| filter : '{'{0}:filter{0}'}'", c.getName());
            sb.append(line);
        }
        sb.append("\">");
        return sb.toString();
    }
    public String generateValues(){
        StringBuilder sb = new StringBuilder();
        for (Column c: columns) {
            String line = MessageFormat.format("<td>'{{' x.{0} '}}'</td>\n", c.getName());
            sb.append(line);
        }
        return sb.toString();
    }

    public String openTable(){
        return "<table class=\"table table-striped table-bordered\">\n" +
                "<thead>\n" +
                "<tr>";
    }
    public String closeTable(){
        return "</table>";
    }
}
