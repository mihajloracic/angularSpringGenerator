package com.company;

import java.text.MessageFormat;

public class RepositoryGenerator {
    String alias;
    String querry;

    public RepositoryGenerator(String alias, String querry) {
        this.alias = alias;
        this.querry = querry;
    }
    public String generateRepository(){
        String line = MessageFormat.format("package {0}repository;\n" +
                "\n" +
                "import org.json.JSONArray;\n" +
                "import org.springframework.stereotype.Repository;\n" +
                "\n" +
                "import java.util.List;\n" +
                "import java.util.Map;\n" +
                "@Repository\n" +
                "public class {1}Repository extends GeneralRepository '{'\n" +
                "\n" +
                "    public JSONArray findlAll()'{'\n" +
                "        final List<Map<String, Object>> rows = jdbcTemplate.queryForList(\"{2}\");\n" +
                "        return getObjects(rows);\n" +
                "    '}'\n" +
                "'}'\n",Config.Package,alias,querry);

        return  line;
    }
}
