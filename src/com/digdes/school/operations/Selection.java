package com.digdes.school.operations;

import java.util.*;

import static com.digdes.school.utils.ConjunctionLocator.matchConjunctionQueryParametersWithList;
import static com.digdes.school.utils.DisjunctionLocator.matchDisjunctionQueryParametersWithList;

public class Selection {
    public static void select(String request, List<Map<String, Object>> data) throws Exception {
        if (request.matches("[Ss][Ee][Ll][Ee][Cc][Tt]")) {
            System.out.println(data);

        } else if (request.matches("[Ss][Ee][Ll][Ee][Cc][Tt]\\s+[Ww][Hh][Ee][Rr][Ee].+")) {
            String midRequest = request.replaceAll("[Aa][Nn][Dd]", "and").replaceAll("[Oo][Rr]", "or");

            List<String> midtermList = List.of(midRequest.replaceAll("[Ss][Ee][Ll][Ee][Cc][Tt]\\s+[Ww][Hh][Ee][Rr][Ee]\\s+", "")
                    .split("\\s+and\\s+"));

            Set<Object> rows = new HashSet<>();
            List<Map<String, Object>> conjRows = matchConjunctionQueryParametersWithList(data, midtermList);
            List<Map<String, Object>> disRows = matchDisjunctionQueryParametersWithList(data, midtermList);
            rows.addAll(conjRows);
            rows.addAll(disRows);

            System.out.println(rows);
        }
    }
}
