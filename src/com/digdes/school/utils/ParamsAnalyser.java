package com.digdes.school.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParamsAnalyser {
    public static List<String> formListOfConjunctionParameters(List<String> midtermList) {
        List<String> conjParams = new ArrayList<>(); //список условий с конъюнкцией (AND)

        for (String str : midtermList) { //заполнение списков
            if (str.contains("or ‘")) {
                conjParams.add(str.split("\\s+or\\s+")[0]);
            } else {
                conjParams.add(str);
            }
        }
        return conjParams;
    }

    public static List<String> formListOfDisjunctionParameters(List<String> midtermList) {
        List<String> disParams = new ArrayList<>(); //список условий с дизъюнкцией (OR)

        for (String str : midtermList) { //заполнение списков
            if (str.contains("or ‘")) {
                disParams.add(str.split("\\s+or\\s+")[1]);
            }
        }
        return disParams;
    }

    public static Map<String, Object> putValuesFromQuery(Map<String, Object> queryMatches, String[] params) throws Exception {
        for (String param : params) {
            if (param.matches("‘[Ll][Aa][Ss][Tt][Nn][Aa][Mm][Ee]’\\s*=\\s*‘[а-яА-Яa-zA-Z]+’")) {
                queryMatches.put("lastName", param.split("=")[1].replace("‘", "").replace("’", ""));
            } else if (param.matches("‘[Ii][Dd]’\\s*=\\s*[0-9]+")) {
                queryMatches.put("id", param.split("=")[1]);

            } else if (param.matches("‘[Aa][Gg][Ee]’\\s*=\\s*[0-9]+")) {
                queryMatches.put("age", param.split("=")[1]);

            } else if (param.matches("‘[Cc][Oo][Ss][Tt]’\\s*=\\s*[0-9]+\\.[0-9]+")) {
                queryMatches.put("cost", param.split("=")[1]);

            } else if (param.matches("‘[Aa][Cc][Tt][Ii][Vv][Ee]’\\s*=\\s*true")) {
                queryMatches.put("active", true);

            } else if (param.matches("‘[Aa][Cc][Tt][Ii][Vv][Ee]’\\s*=\\s*false")) {
                queryMatches.put("active", false);

            } else throw new Exception();
        }
        return queryMatches;
    }
}
