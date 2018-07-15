package com.company;

import java.util.List;

public class Table {
    List<Column> columns;
    String name;//pretty name
    String alias;
    String sql;
    boolean date;//da li ima na pocetku od do datum za selekt
}
