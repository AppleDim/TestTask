package com.digdes.school.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.digdes.school.utils.ParamsAnalyser.formListOfDisjunctionParameters;

public class DisjunctionLocator {
    public static List<Map<String, Object>> matchDisjunctionQueryParametersWithList(List<Map<String, Object>> data,
                                                        List<String> midtermList) throws Exception {
        List<Map<String, Object>> rows = new ArrayList<>();
        List<String> disParams = formListOfDisjunctionParameters(midtermList);

        for (Map<String, Object> datum : data) {
            for (Map.Entry<String, Object> entry : datum.entrySet()) {
                for (int i = 0; i < disParams.size(); i++) {
                    for (String disParam : disParams) {
                        if (disParam.matches("‘[Aa][Gg][Ee]’\\s*=\\s*[0-9]+")) {
                            if (entry.getKey().equals("age") && Integer.parseInt(disParam.split("\\s*=\\s*")[1])
                                    == Integer.parseInt(entry.getValue().toString())) {
                                rows.add(datum);
                            }

                        } else if (disParam.matches("‘[Aa][Gg][Ee]’\\s*!=\\s*[0-9]+")) {
                            if (entry.getKey().equals("age") && Integer.parseInt(disParam.split("\\s*!=\\s*")[1])
                                    != Integer.parseInt(entry.getValue().toString())) {
                                rows.add(datum);
                            }

                        } else if (disParam.matches("‘[Aa][Gg][Ee]’\\s*>=\\s*[0-9]+")) {
                            if (entry.getKey().equals("age") && Integer.parseInt(disParam.split("\\s*>=\\s*")[1])
                                    <= Integer.parseInt(entry.getValue().toString())) {
                                rows.add(datum);
                            }

                        } else if (disParam.matches("‘[Aa][Gg][Ee]’\\s*<=\\s*[0-9]+")) {
                            if (entry.getKey().equals("age") && Integer.parseInt(disParam.split("<=")[1])
                                    >= Integer.parseInt(entry.getValue().toString())) {
                                rows.add(datum);
                            }

                        } else if (disParam.matches("‘[Aa][Gg][Ee]’\\s*<\\s*[0-9]+")) {
                            if (entry.getKey().equals("age") && Integer.parseInt(disParam.split("\\s*<\\s*")[1])
                                    > Integer.parseInt(entry.getValue().toString())) {
                                rows.add(datum);
                            }

                        } else if (disParam.matches("‘[Aa][Gg][Ee]’\\s*>\\s*[0-9]+")) {
                            if (entry.getKey().equals("age") && Integer.parseInt(disParam.split("\\s*>\\s*")[1])
                                    < Integer.parseInt(entry.getValue().toString())) {
                                rows.add(datum);
                            }
                        } else if (disParam.matches("‘[Ii][Dd]’\\s*=\\s*[0-9]+")) {
                            if (entry.getKey().equals("id") && Integer.parseInt(disParam.split("=")[1])
                                    == Integer.parseInt(entry.getValue().toString())) {
                                rows.add(datum);
                            }

                        } else if (disParam.matches("‘[Ii][Dd]’\\s*!=\\s*[0-9]+")) {
                            if (entry.getKey().equals("id") && Integer.parseInt(disParam.split("\\s*!=\\s*")[1])
                                    != Integer.parseInt(entry.getValue().toString())) {
                                rows.add(datum);
                            }

                        } else if (disParam.matches("‘[Ii][Dd]’\\s*>=\\s*[0-9]+")) {
                            if (entry.getKey().equals("id") && Integer.parseInt(disParam.split("\\s*>=\\s*")[1])
                                    <= Integer.parseInt(entry.getValue().toString())) {
                                rows.add(datum);
                            }

                        } else if (disParam.matches("‘[Ii][Dd]’\\s*<=\\s*[0-9]+")) {
                            if (entry.getKey().equals("id") && Integer.parseInt(disParam.split("\\s*<=\\s*")[1])
                                    >= Integer.parseInt(entry.getValue().toString())) {
                                rows.add(datum);
                            }

                        } else if (disParam.matches("‘[Ii][Dd]’\\s*>\\s*[0-9]+")) {
                            if (entry.getKey().equals("id") && Integer.parseInt(disParam.split("\\s*>\\s*")[1])
                                    < Integer.parseInt(entry.getValue().toString())) {
                                rows.add(datum);
                            }

                        } else if (disParam.matches("‘[Ii][Dd]’\\s*<\\s*[0-9]+")) {
                            if (entry.getKey().equals("id") && Integer.parseInt(disParam.split("\\s*<\\s*")[1])
                                    > Integer.parseInt(entry.getValue().toString())) {
                                rows.add(datum);
                            }

                        } else if (disParam.matches("‘[Cc][Oo][Ss][Tt]’\\s*=\\s*[0-9]+\\.[0-9]+")) {
                            if (entry.getKey().equals("cost") && Double.parseDouble(disParam.split("\\s*=\\s*")[1])
                                    == Double.parseDouble(entry.getValue().toString())) {
                                rows.add(datum);
                            }

                        } else if (disParam.matches("‘[Cc][Oo][Ss][Tt]’\\s*!=\\s*[0-9]+\\.[0-9]+")) {
                            if (entry.getKey().equals("cost") && Double.parseDouble(disParam.split("\\s*=\\s*")[1])
                                    != Double.parseDouble(entry.getValue().toString())) {
                                rows.add(datum);
                            }

                        } else if (disParam.matches("‘[Cc][Oo][Ss][Tt]’\\s*>=\\s*[0-9]+\\.[0-9]+")) {
                            if (entry.getKey().equals("cost") && Double.parseDouble(disParam.split(">=")[1])
                                    <= Double.parseDouble(entry.getValue().toString())) {
                                rows.add(datum);
                            }

                        } else if (disParam.matches("‘[Cc][Oo][Ss][Tt]’\\s*<=\\s*[0-9]+\\.[0-9]+")) {
                            if (entry.getKey().equals("cost") && Double.parseDouble(disParam.split("\\s*<=\\s*")[1])
                                    >= Double.parseDouble(entry.getValue().toString())) {
                                rows.add(datum);
                            }

                        } else if (disParam.matches("‘[Cc][Oo][Ss][Tt]’\\s*>\\s*[0-9]+\\.[0-9]+")) {
                            if (entry.getKey().equals("cost") && Double.parseDouble(disParam.split("\\s*>\\s*")[1])
                                    < Double.parseDouble(entry.getValue().toString())) {
                                rows.add(datum);
                            }

                        } else if (disParam.matches("‘[Cc][Oo][Ss][Tt]’\\s*<\\s*[0-9]+\\.[0-9]+")) {
                            if (entry.getKey().equals("cost") && Double.parseDouble(disParam.split("\\s*<\\s*")[1])
                                    > Double.parseDouble(entry.getValue().toString())) {
                                rows.add(datum);
                            }

                        } else if (disParam.matches("‘[Aa][Cc][Tt][Ii][Vv][Ee]’\\s*=\\s*true")) {
                            if (entry.getKey().equals("active") && Boolean.parseBoolean(disParam.split("\\s*=\\s*")[1])) {
                                rows.add(datum);
                            }

                        } else if (disParam.matches("‘[Aa][Cc][Tt][Ii][Vv][Ee]’\\s*=\\s*false")) {
                            if (entry.getKey().equals("active") && !Boolean.parseBoolean(disParam.split("\\s*=\\s*")[1])) {
                                rows.add(datum);
                            }

                        } else if (disParam.matches("‘[Ll][Aa][Ss][Tt][Nn][Aa][Mm][Ee]’\\s*=\\s*‘[а-яА-Яa-zA-Z]+’")) {
                            if (entry.getKey().equals("lastName") && String.valueOf(disParam.split("\\s*=\\s*")[1])
                                    .equals(entry.getValue().toString())) {
                                rows.add(datum);
                            }

                        } else if (disParam.matches("‘[Ll][Aa][Ss][Tt][Nn][Aa][Mm][Ee]’\\s*!=\\s*‘[а-яА-Яa-zA-Z]+’")) {
                            if (entry.getKey().equals("lastName") && !String.valueOf(disParam.split("\\s*=\\s*")[1])
                                    .equals(entry.getValue().toString())) {
                                rows.add(datum);
                            }

                        } else if (disParam.matches("‘[Ll][Aa][Ss][Tt][Nn][Aa][Mm][Ee]’\\s+like\\s+‘[а-яА-Яa-zA-Z]+’")) {
                            if (entry.getKey().equals("lastName") && entry.getValue().toString()
                                    .contains(String.valueOf(disParam.split("\\s+like\\s+")[1]))
                                    && entry.getValue().toString().startsWith(disParam.split("\\s+like\\s+")[1])
                                    && entry.getValue().toString().endsWith(disParam.split("\\s+like\\s+")[1])) {
                                rows.add(datum);
                            }

                        } else if (disParam.matches("‘[Ll][Aa][Ss][Tt][Nn][Aa][Mm][Ee]’\\s+like\\s+‘%[а-яА-Яa-zA-Z]+’")) {
                            if (entry.getKey().equals("lastName") && entry.getValue().toString()
                                    .contains(disParam.split(" like ")[1].replace("%", "")
                                            .replace("‘", "").replace("’", ""))
                                    && entry.getValue().toString().endsWith(disParam.split("\\s+like\\s+")[1].replace("%", "")
                                    .replace("‘", "").replace("’", ""))
                                    && !entry.getValue().toString().startsWith(disParam.split("\\s+like\\s+")[1].replace("%", "")
                                    .replace("‘", "").replace("’", ""))) {
                                rows.add(datum);
                            }

                        } else if (disParam.matches("‘[Ll][Aa][Ss][Tt][Nn][Aa][Mm][Ee]’\\s+like\\s+‘[а-яА-Яa-zA-Z]+%’")) {
                            if (entry.getKey().equals("lastName") && entry.getValue().toString()
                                    .contains(disParam.split("\\s+like\\s+")[1].replace("%", "")
                                            .replace("‘", "").replace("’", ""))
                                    && entry.getValue().toString().startsWith(disParam.split("\\s+like\\s+")[1].replace("%", "")
                                    .replace("‘", "").replace("’", ""))
                                    && !entry.getValue().toString().endsWith(disParam.split("\\s+like\\s+")[1].replace("%", "")
                                    .replace("‘", "").replace("’", ""))) {
                                rows.add(datum);
                            }

                        } else if (disParam.matches("‘[Ll][Aa][Ss][Tt][Nn][Aa][Mm][Ee]’\\s+like\\s+‘%[а-яА-Яa-zA-Z]+%’")) {
                            if (entry.getKey().equals("lastName") && entry.getValue().toString()
                                    .contains(disParam.split("\\s+like\\s+")[1].replace("%", "")
                                            .replace("‘", "").replace("’", ""))
                                    && !entry.getValue().toString().startsWith(disParam.split("\\s+like\\s+")[1].replace("%", "")
                                    .replace("‘", "").replace("’", ""))
                                    && !entry.getValue().toString().endsWith(disParam.split("\\s+like\\s+")[1].replace("%", "")
                                    .replace("‘", "").replace("’", ""))) {
                                rows.add(datum);
                            }

                        } else if (disParam.matches("‘[Ll][Aa][Ss][Tt][Nn][Aa][Mm][Ee]’\\s+ilike\\s+‘[а-яА-Яa-zA-Z]+’")) {
                            if (entry.getKey().equals("lastName") && entry.getValue().toString().toLowerCase()
                                    .contains(disParam.split("\\s+ilike\\s+")[1].replace("%", "")
                                            .replace("‘", "").replace("’", "").toLowerCase())
                                    && entry.getValue().toString().toLowerCase().startsWith(disParam.split("\\s+ilike\\s+")[1].replace("%", "")
                                    .replace("‘", "").replace("’", "").toLowerCase())
                                    && entry.getValue().toString().toLowerCase().endsWith(disParam.split("\\s+ilike\\s+")[1].replace("%", "")
                                    .replace("‘", "").replace("’", "").toLowerCase())) {
                                rows.add(datum);
                            }

                        } else if (disParam.matches("‘[Ll][Aa][Ss][Tt][Nn][Aa][Mm][Ee]’\\s+ilike\\s+‘%[а-яА-Яa-zA-Z]+’")) {
                            if (entry.getKey().equals("lastName") && entry.getValue().toString().toLowerCase()
                                    .contains(disParam.split("\\s+ilike\\s+")[1].replace("%", "")
                                            .replace("‘", "").replace("’", "").toLowerCase())
                                    && entry.getValue().toString().endsWith(disParam.split("\\s+ilike\\s+")[1].replace("%", "")
                                    .replace("‘", "").replace("’", "").toLowerCase())
                                    && !entry.getValue().toString().startsWith(disParam.split("\\s+ilike\\s+")[1].replace("%", "")
                                    .replace("‘", "").replace("’", "").toLowerCase())) {
                                rows.add(datum);
                            }

                        } else if (disParam.matches("‘[Ll][Aa][Ss][Tt][Nn][Aa][Mm][Ee]’\\s+ilike\\s+‘[а-яА-Яa-zA-Z]+%’")) {
                            if (entry.getKey().equals("lastName") && entry.getValue().toString().toLowerCase()
                                    .contains(disParam.split("\\s+ilike\\s+")[1].replace("%", "")
                                            .replace("‘", "").replace("’", "").toLowerCase())
                                    && entry.getValue().toString().startsWith(disParam.split("\\s+ilike\\s+")[1].replace("%", "")
                                    .replace("‘", "").replace("’", "").toLowerCase())
                                    && !entry.getValue().toString().endsWith(disParam.split("\\s+ilike\\s+")[1].replace("%", "")
                                    .replace("‘", "").replace("’", "").toLowerCase())) {
                                rows.add(datum);
                            }

                        } else if (disParam.matches("‘[Ll][Aa][Ss][Tt][Nn][Aa][Mm][Ee]’\\s+ilike\\s+‘%[а-яА-Яa-zA-Z]+%’")) {
                            if (entry.getKey().equals("lastName") && entry.getValue().toString().toLowerCase()
                                    .contains(disParam.split(" ilike ")[1].replace("%", "")
                                            .replace("‘", "").replace("’", "").toLowerCase())
                                    && !entry.getValue().toString().startsWith(disParam.split("\\s+ilike\\s+")[1].replace("%", "")
                                    .replace("‘", "").replace("’", "").toLowerCase())
                                    && !entry.getValue().toString().endsWith(disParam.split("\\s+ilike\\s+")[1].replace("%", "")
                                    .replace("‘", "").replace("’", "").toLowerCase())) {
                                rows.add(datum);
                            }

                        } else {
                            throw new Exception();
                        }
                    }
                }
            }
        }
        return rows;
    }
}
