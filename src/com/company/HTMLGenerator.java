package com.company;

import java.text.MessageFormat;
import java.util.List;

public class HTMLGenerator {
    List<Column> columns;
    String tableName;
    String alias;

    public HTMLGenerator(List<Column> columns, String tableName, String alias) {
        this.columns = columns;
        this.tableName = tableName;
        this.alias = alias;
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

    public String header(){
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <!-- Latest compiled and minified CSS -->\n" +
                "    <link rel=\"stylesheet\" href=\"/css/bootstrap.min.css\">\n" +
                "\n" +
                "    <!-- jQuery library -->\n" +
                "    <script src=\"js/jquery.min.js\"></script>\n" +
                "    <link href=\"//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css\" rel=\"stylesheet\">\n" +
                "    <!-- Latest compiled JavaScript -->\n" +
                "    <script src=\"js/bootstrap.min.js\"></script>\n" +
                "    <script src=\"js/angular.js\"></script>\n" +
                "</head>\n" +
                "<body ng-app=\"myApp\">\n" +
                "<div ng-include=\"'fragments/navbar.htm'\"></div>\n" +
                "<div class=\"container\"  ng-controller=\"customeCtrl\">\n";
    }
    public String closer(){
        return "</div>\n" +
                "<script src=\"js/app.js\" type=\"text/javascript\" charset=\"utf-8\"></script>\n" +
                "<script src=\"js/navbar.js\" type=\"text/javascript\" charset=\"utf-8\"></script>\n" +
                "<script type=\"text/javascript\" charset=\"utf-8\">\n" +
                "    app.controller('customeCtrl', function($scope, $http, $rootScope) {\n" +
                "        $http.get(\""+alias+"Request\").then(function (response) {\n" +
                "            $scope.names = response.data;\n" +
                "            console.log($scope.names)\n" +
                "        })\n" +
                "    });\n" +
                "</script>\n" +
                "</body>\n" +
                "</html>";
    }

    public String heading(){
        return MessageFormat.format("<h1>{0}</h1>\n", tableName);
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
