package com.digdes.school.operations;

import java.util.*;

import static com.digdes.school.utils.ConjunctionLocator.matchConjunctionQueryParametersWithList;
import static com.digdes.school.utils.DisjunctionLocator.matchDisjunctionQueryParametersWithList;

public class Deletion {
    public static List<Map<String, Object>> addRowsToDelete(String request, List<Map<String, Object>> data) throws Exception {
        String midRequest = request.replaceAll("[Aa][Nn][Dd]", "and").replaceAll("[Oo][Rr]", "or");

        List<String> midtermList = List.of(midRequest.replaceAll("[Dd][Ee][Ll][Ee][Tt][Ee]\\s+[Ww][Hh][Ee][Rr][Ee]\\s+", "")
                .split("\\s+and\\s+"));

        List<Map<String, Object>> rows = new ArrayList<>();

        List<Map<String, Object>> conjRows = matchConjunctionQueryParametersWithList(data, midtermList);
        List<Map<String, Object>> disRows = matchDisjunctionQueryParametersWithList(data, midtermList);
        rows.addAll(conjRows);
        rows.addAll(disRows);

        return rows;
    }


    //метод для удаления из списка строк тех, которые подошли по условию
    public static List<Map<String, Object>> delete(String request, List<Map<String, Object>> data) throws Exception  {
        List<Map<String, Object>> rows = addRowsToDelete(request, data);

        for (Map<String, Object> o: rows) {
            data.remove(o);
        }
        return data;
    }
}
