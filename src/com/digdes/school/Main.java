package com.digdes.school;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        JavaSchoolStarter starter = new JavaSchoolStarter();

        try {
            //execute(String request) - выполняется для начальной таблицы
            //execute(String request, List<Map<String, Object>> result) - выполняется для таблицы,
            //над которой совершилась операция, результатом которой был result
            List<Map<String, Object>> result1 = starter.execute("INSERT VALUES ‘lastName’ = ‘Федоров’, ‘id’=3, ‘age’=40, ‘active’=true");
            List<Map<String, Object>> result2 = starter.execute("SELECT", result1);
            List<Map<String, Object>> result3 = starter.execute("UPDATE VALUES ‘active’=true, ‘cost’=10.1   WHere ‘id’>1 AND ‘age’!=500 OR ‘lastName’ = ‘Иванов’", result2);
            List<Map<String, Object>> result4 = starter.execute("SELECT WHERE ‘age’>15 OR ‘id’>1 and ‘cost’>4.3 AND ‘lastName’ ilike ‘%АНо%’", result3);
            List<Map<String, Object>> result5 = starter.execute("DELETE WHERE ‘age’<30 OR ‘id’>4", result4);
            starter.execute("SELECT WHERE ‘id’ = 1 and ‘age’>0", result5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

