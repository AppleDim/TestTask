package com.digdes.school;

import java.util.*;

import static com.digdes.school.operations.Deletion.delete;
import static com.digdes.school.operations.Insertion.insert;
import static com.digdes.school.operations.Selection.select;
import static com.digdes.school.operations.Update.update;

public class JavaSchoolStarter {

    //Дефолтный конструктор
    public JavaSchoolStarter() {

    }

    //На вход запрос, на выход результат выполнения запроса
    public List<Map<String, Object>> execute(String request) throws Exception {
        Map<String, Object> row1 = new HashMap<>();
        row1.put("id", 1);
        row1.put("lastName", "Петров");
        row1.put("age", 30);
        row1.put("cost", 5.4);
        row1.put("active", true);

        Map<String, Object> row2 = new HashMap<>();
        row2.put("id", 2);
        row2.put("lastName", "Иванов");
        row2.put("age", 25);
        row2.put("cost", 4.3);
        row2.put("active", false);

        List<Map<String, Object>> data = new ArrayList<>();
        data.add(row1);
        data.add(row2);
        return matchKeyWords(request, data);
    }

    public List<Map<String, Object>> execute(String request, List<Map<String, Object>> data) throws Exception {
        return matchKeyWords(request, data);
    }

    private List<Map<String, Object>> matchKeyWords(String request, List<Map<String, Object>> data) throws Exception {
        select(request, data);
        update(request, data);
        if (request.matches("[Ii][Nn][Ss][Ee][Rr][Tt]\\s+[Vv][Aa][Ll][Uu][Ee][Ss].+")) {
            return insert(request, data);
        }
        if (request.matches("[Dd][Ee][Ll][Ee][Tt][Ee]")) {
            data.clear();
            return data;

        } else if (request.matches("[Dd][Ee][Ll][Ee][Tt][Ee]\\s+[Ww][Hh][Ee][Rr][Ee].+")) {
            return delete(request, data);
        }
        return data;
    }
}


