package com.digdes.school.operations;

import java.util.*;

import static com.digdes.school.utils.ConjunctionLocator.matchConjunctionQueryParametersWithList;
import static com.digdes.school.utils.DisjunctionLocator.matchDisjunctionQueryParametersWithList;
import static com.digdes.school.utils.ParamsAnalyser.putValuesFromQuery;

public class Update {
    public static List<Map<String, Object>> update(String request, List<Map<String, Object>> data) throws Exception {
        if (request.matches("[Uu][Pp][Dd][Aa][Tt][Ee]\\s+[Vv][Aa][Ll][Uu][Ee][Ss].+")) {
            String[] params = request.replaceAll("[Uu][Pp][Dd][Aa][Tt][Ee]\\s+[Vv][Aa][Ll][Uu][Ee][Ss]\\s+", "")
                    .replaceAll("\\s+", "").split(","); //массив параметров, разделённых запятой

            if (!request.replaceAll("[Uu][Pp][Dd][Aa][Tt][Ee]\\s+[Vv][Aa][Ll][Uu][Ee][Ss]\\s+", "")
                    .toLowerCase().contains("where")) {

                updateRows(data, params);

            } else {
                String midRequest = request.replaceAll("[Aa][Nn][Dd]", "and").replaceAll("[Oo][Rr]", "or");

                String str = midRequest.replaceAll("[Uu][Pp][Dd][Aa][Tt][Ee]\\s+[Vv][Aa][Ll][Uu][Ee][Ss]\\s+", "")
                        .replaceAll("\\s{2,}", "")
                        .replaceAll("[Ww][Hh][Ee][Rr][Ee]\\s+‘", "where ‘");

                List<String> midtermList = List.of(str.split("where "));

                List<Map<String, Object>> rows = new ArrayList<>();
                List<Map<String, Object>> conjRows = matchConjunctionQueryParametersWithList(data, List.of(midtermList.get(1).split("\\s+and\\s+")));
                List<Map<String, Object>> disRows = matchDisjunctionQueryParametersWithList(data, List.of(midtermList.get(1).split("\\s+and\\s+")));
                rows.addAll(conjRows);
                rows.addAll(disRows);

                params = midtermList.get(0).split(", ");

                updateRows(rows, params);
            }
        }
        return data;

    }

    private static void updateRows(List<Map<String, Object>> data, String[] params) throws Exception {
        Map<String, Object> queryMatches;
        queryMatches = putValuesFromQuery(new HashMap<>(), params);

        for (Map<String, Object> row : data) {
            for (Map.Entry<String, Object> rowParameter : row.entrySet()) {
                for (Map.Entry<String, Object> entry : queryMatches.entrySet()) {
                    if (rowParameter.getKey().equals(entry.getKey()) && entry.getValue() != null) {
                        row.replace(rowParameter.getKey(), rowParameter.getValue(), entry.getValue());
                    }
                }
            }
        }
    }
}
