package com.company;

import java.text.MessageFormat;

public class ControllerGenerator {
    String alias;

    public ControllerGenerator(String alias) {
        this.alias = alias;
    }
    public String generateController(){
        String line = MessageFormat.format("package {0}controller;\n" +
                "\n" +
                "import {0}repository.{1}Repository;\n" +
                "import org.springframework.beans.factory.annotation.Autowired;\n" +
                "import org.springframework.web.bind.annotation.GetMapping;\n" +
                "import org.springframework.web.bind.annotation.RestController;\n" +
                "\n" +
                "@RestController\n" +
                "public class {1}Controller '{'\n" +
                "\n" +
                "    @Autowired\n" +
                "    {1}Repository repository;\n" +
                "\n" +
                "    @GetMapping(value = \"/{1}Request\")\n" +
                "    public String getAllmasterdetail()'{'\n" +
                "        return repository.findlAll().toString();\n" +
                "    '}'\n" +
                "\n" +
                "'}'\n",Config.Package,alias);
        return line;
    }
}
