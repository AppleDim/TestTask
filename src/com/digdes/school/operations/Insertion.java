package com.digdes.school.operations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.digdes.school.utils.ParamsAnalyser.putValuesFromQuery;

public class Insertion {
    public static List<Map<String, Object>> insert(String request, List<Map<String, Object>> data) throws Exception {
        String[] params = request.replaceAll("[Ii][Nn][Ss][Ee][Rr][Tt]\\s+[Vv][Aa][Ll][Uu][Ee][Ss]\\s+", "")
                .replaceAll("\\s+", "").split(","); //массив параметров, разделённых запятой

        Map<String, Object> rows = putValuesFromQuery(new HashMap<>(), params);

        if (!rows.isEmpty()) {
            data.add(rows);
        }

        return data;
    }
}
