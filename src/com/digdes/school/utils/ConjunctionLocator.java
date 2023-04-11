package com.digdes.school.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.digdes.school.utils.ParamsAnalyser.formListOfConjunctionParameters;

public class ConjunctionLocator {
    public static List<Map<String, Object>> matchConjunctionQueryParametersWithList(List<Map<String, Object>> data,
                                                                             List<String> midtermList) throws Exception {
        List<Map<String, Object>> rows = new ArrayList<>();
        List<String> conjParams = formListOfConjunctionParameters(midtermList);

        for (Map<String, Object> datum : data) {
            int countCorrectConditions = 0;
            for (Map.Entry<String, Object> entry : datum.entrySet()) {
                for (int i = 0; i < conjParams.size(); i++) {
                    if (conjParams.get(i).matches("‘[Aa][Gg][Ee]’\\s*=\\s*[0-9]+")) {
                        if (entry.getKey().equals("age") && Integer.parseInt(conjParams.get(i).split("\\s*=\\s*")[1])
                                == Integer.parseInt(entry.getValue().toString())) {
                            countCorrectConditions++;
                            if (countCorrectConditions == conjParams.size()) {
                                rows.add(datum);
                            }
                        }

                    } else if (conjParams.get(i).matches("‘[Aa][Gg][Ee]’\\s*!=\\s*[0-9]+")) {
                        if (entry.getKey().equals("age") && Integer.parseInt(conjParams.get(i).split("\\s*!=\\s*")[1])
                                != Integer.parseInt(entry.getValue().toString())) {
                            countCorrectConditions++;
                            if (countCorrectConditions == conjParams.size()) {
                                rows.add(datum);
                            }
                        }

                    } else if (conjParams.get(i).matches("‘[Aa][Gg][Ee]’\\s*>\\s*=\\s*[0-9]+")) {
                        if (entry.getKey().equals("age") && Integer.parseInt(conjParams.get(i).split("\\s*>=\\s*")[1])
                                <= Integer.parseInt(entry.getValue().toString())) {
                            countCorrectConditions++;
                            if (countCorrectConditions == conjParams.size()) {
                                rows.add(datum);
                            }
                        }

                    } else if (conjParams.get(i).matches("‘[Aa][Gg][Ee]’\\s*<=\\s*[0-9]+")) {
                        if (entry.getKey().equals("age") && Integer.parseInt(conjParams.get(i).split("\\s*<=\\s*")[1])
                                >= Integer.parseInt(entry.getValue().toString())) {
                            countCorrectConditions++;
                            if (countCorrectConditions == conjParams.size()) {
                                rows.add(datum);
                            }
                        }

                    } else if (conjParams.get(i).matches("‘[Aa][Gg][Ee]’\\s*<\\s*[0-9]+")) {
                        if (entry.getKey().equals("age") && Integer.parseInt(conjParams.get(i).split("\\s*<\\s*")[1])
                                > Integer.parseInt(entry.getValue().toString())) {
                            countCorrectConditions++;
                            if (countCorrectConditions == conjParams.size()) {
                                rows.add(datum);
                            }
                        }
                    } else if (conjParams.get(i).matches("‘[Aa][Gg][Ee]’\\s*>\\s*[0-9]+")) {
                        if (entry.getKey().equals("age") && Integer.parseInt(conjParams.get(i).split("\\s*>\\s*")[1])
                                < Integer.parseInt(entry.getValue().toString())) {
                            countCorrectConditions++;
                            if (countCorrectConditions == conjParams.size()) {
                                rows.add(datum);
                            }
                        }
                    } else if (conjParams.get(i).matches("‘[Ii][Dd]’\\s*=\\s*[0-9]+")) {
                        if (entry.getKey().equals("id") && Integer.parseInt(conjParams.get(i).split("\\s*=\\s*")[1])
                                == Integer.parseInt(entry.getValue().toString())) {
                            countCorrectConditions++;
                            if (countCorrectConditions == conjParams.size()) {
                                rows.add(datum);
                            }
                        }

                    } else if (conjParams.get(i).matches("‘[Ii][Dd]’\\s*!=\\s*[0-9]+")) {
                        if (entry.getKey().equals("id") && Integer.parseInt(conjParams.get(i).split("\\s*!=\\s*")[1])
                                != Integer.parseInt(entry.getValue().toString())) {
                            countCorrectConditions++;
                            if (countCorrectConditions == conjParams.size()) {
                                rows.add(datum);
                            }
                        }

                    } else if (conjParams.get(i).matches("‘[Ii][Dd]’\\s*>=\\s*[0-9]+")) {
                        if (entry.getKey().equals("id") && Integer.parseInt(conjParams.get(i).split("\\s*>=\\s*")[1])
                                <= Integer.parseInt(entry.getValue().toString())) {
                            countCorrectConditions++;
                            if (countCorrectConditions == conjParams.size()) {
                                rows.add(datum);
                            }
                        }

                    } else if (conjParams.get(i).matches("‘[Ii][Dd]’\\s*<=\\s*[0-9]+")) {
                        if (entry.getKey().equals("id") && Integer.parseInt(conjParams.get(i).split("\\s*<=\\s*")[1])
                                >= Integer.parseInt(entry.getValue().toString())) {
                            countCorrectConditions++;
                            if (countCorrectConditions == conjParams.size()) {
                                rows.add(datum);
                            }
                        }

                    } else if (conjParams.get(i).matches("‘[Ii][Dd]’\\s*>\\s*[0-9]+")) {
                        if (entry.getKey().equals("id") && Integer.parseInt(conjParams.get(i).split("\\s*>\\s*")[1])
                                < Integer.parseInt(entry.getValue().toString())) {
                            countCorrectConditions++;
                            if (countCorrectConditions == conjParams.size()) {
                                rows.add(datum);
                            }
                        }

                    } else if (conjParams.get(i).matches("‘[Ii][Dd]’\\s*<\\s*[0-9]+")) {
                        if (entry.getKey().equals("id") && Integer.parseInt(conjParams.get(i).split("\\s*<\\s*")[1])
                                > Integer.parseInt(entry.getValue().toString())) {
                            countCorrectConditions++;
                            if (countCorrectConditions == conjParams.size()) {
                                rows.add(datum);
                            }
                        }

                    } else if (conjParams.get(i).matches("‘[Cc][Oo][Ss][Tt]’\\s*=\\s*[0-9]+\\.[0-9]+")) {
                        if (entry.getKey().equals("cost") && Double.parseDouble(conjParams.get(i).split("\\s*=\\s*")[1])
                                == Double.parseDouble(entry.getValue().toString())) {
                            countCorrectConditions++;
                            if (countCorrectConditions == conjParams.size()) {
                                rows.add(datum);
                            }
                        }

                    } else if (conjParams.get(i).matches("‘[Cc][Oo][Ss][Tt]’\\s*!=\\s*[0-9]+\\.[0-9]+")) {
                        if (entry.getKey().equals("cost") && Double.parseDouble(conjParams.get(i).split("\\s*=\\s*")[1])
                                != Double.parseDouble(entry.getValue().toString())) {
                            countCorrectConditions++;
                            if (countCorrectConditions == conjParams.size()) {
                                rows.add(datum);
                            }
                        }
                    } else if (conjParams.get(i).matches("‘[Cc][Oo][Ss][Tt]’\\s*>=\\s*[0-9]+\\.[0-9]+")) {
                        if (entry.getKey().equals("cost") && Double.parseDouble(conjParams.get(i).split("\\s*>=\\s*")[1])
                                <= Double.parseDouble(entry.getValue().toString())) {
                            countCorrectConditions++;
                            if (countCorrectConditions == conjParams.size()) {
                                rows.add(datum);
                            }
                        }

                    } else if (conjParams.get(i).matches("‘[Cc][Oo][Ss][Tt]’\\s*<=\\s*[0-9]+\\.[0-9]+")) {
                        if (entry.getKey().equals("cost") && Double.parseDouble(conjParams.get(i).split("\\s*<=\\s*")[1])
                                >= Double.parseDouble(entry.getValue().toString())) {
                            countCorrectConditions++;
                            if (countCorrectConditions == conjParams.size()) {
                                rows.add(datum);
                            }
                        }

                    } else if (conjParams.get(i).matches("‘[Cc][Oo][Ss][Tt]’\\s*>\\s*[0-9]+\\.[0-9]+")) {
                        if (entry.getKey().equals("cost") && Double.parseDouble(conjParams.get(i).split("\\s*>\\s*")[1])
                                < Double.parseDouble(entry.getValue().toString())) {
                            countCorrectConditions++;
                            if (countCorrectConditions == conjParams.size()) {
                                rows.add(datum);
                            }
                        }

                    } else if (conjParams.get(i).matches("‘[Cc][Oo][Ss][Tt]’\\s*<\\s*[0-9]+\\.[0-9]+")) {
                        if (entry.getKey().equals("cost") && Double.parseDouble(conjParams.get(i).split("\\s*<\\s*")[1])
                                > Double.parseDouble(entry.getValue().toString())) {
                            countCorrectConditions++;
                            if (countCorrectConditions == conjParams.size()) {
                                rows.add(datum);
                            }
                        }

                    } else if (conjParams.get(i).matches("‘[Aa][Cc][Tt][Ii][Vv][Ee]’\\s*=\\s*true")) {
                        if (entry.getKey().equals("active") && Boolean.parseBoolean(conjParams.get(i).split("\\s*=\\s*")[1])) {
                            countCorrectConditions++;
                            if (countCorrectConditions == conjParams.size()) {
                                rows.add(datum);
                            }
                        }

                    } else if (conjParams.get(i).matches("‘[Aa][Cc][Tt][Ii][Vv][Ee]’\\s*=\\s*false")) {
                        if (entry.getKey().equals("active") && !Boolean.parseBoolean(conjParams.get(i).split("\\s*=\\s*")[1])) {
                            countCorrectConditions++;
                            if (countCorrectConditions == conjParams.size()) {
                                rows.add(datum);
                            }
                        }

                    } else if (conjParams.get(i).matches("‘[Ll][Aa][Ss][Tt][Nn][Aa][Mm][Ee]’\\s*=\\s*‘[а-яА-Яa-zA-Z]+’")) {
                        if (entry.getKey().equals("lastName") && String.valueOf(conjParams.get(i).split("\\s*=\\s*")[1])
                                .equals(entry.getValue().toString())) {
                            countCorrectConditions++;
                            if (countCorrectConditions == conjParams.size()) {
                                rows.add(datum);
                            }
                        }

                    } else if (conjParams.get(i).matches("‘[Ll][Aa][Ss][Tt][Nn][Aa][Mm][Ee]’\\s*!=\\s*‘[а-яА-Яa-zA-Z]+’")) {
                        if (entry.getKey().equals("lastName") && !String.valueOf(conjParams.get(i).split("\\s*=\\s*")[1])
                                .equals(entry.getValue().toString())) {
                            countCorrectConditions++;
                            if (countCorrectConditions == conjParams.size()) {
                                rows.add(datum);
                            }
                        }

                    } else if (conjParams.get(i).matches("‘[Ll][Aa][Ss][Tt][Nn][Aa][Mm][Ee]’\\s+like\\s*‘[а-яА-Яa-zA-Z]+’")) {
                        if (entry.getKey().equals("lastName") && entry.getValue().toString()
                                .contains(String.valueOf(conjParams.get(i).split("\\s+like\\s+")[1]))
                                && entry.getValue().toString().startsWith(conjParams.get(i).split("\\s+like\\s+")[1])
                                && entry.getValue().toString().endsWith(conjParams.get(i).split("\\s+like\\s+")[1])) {
                            countCorrectConditions++;
                            if (countCorrectConditions == conjParams.size()) {
                                rows.add(datum);
                            }
                        }

                    } else if (conjParams.get(i).matches("‘[Ll][Aa][Ss][Tt][Nn][Aa][Mm][Ee]’\\s+like\\s+‘%[а-яА-Яa-zA-Z]+’")) {
                        if (entry.getKey().equals("lastName") && entry.getValue().toString()
                                .contains(conjParams.get(i).split("\\s+like\\s+")[1].replace("%", "")
                                        .replace("‘", "").replace("’", ""))
                                && entry.getValue().toString().endsWith(conjParams.get(i).split("\\s+like\\s+")[1].replace("%", "")
                                .replace("‘", "").replace("’", ""))
                                && !entry.getValue().toString().startsWith(conjParams.get(i).split("\\s+like\\s+")[1].replace("%", "")
                                .replace("‘", "").replace("’", ""))) {
                            countCorrectConditions++;
                            if (countCorrectConditions == conjParams.size()) {
                                rows.add(datum);
                            }
                        }

                    } else if (conjParams.get(i).matches("‘[Ll][Aa][Ss][Tt][Nn][Aa][Mm][Ee]’\\s+like\\s+‘[а-яА-Яa-zA-Z]+%’")) {
                        if (entry.getKey().equals("lastName") && entry.getValue().toString()
                                .contains(conjParams.get(i).split("\\s+like\\s+")[1].replace("%", "")
                                        .replace("‘", "").replace("’", ""))
                                && entry.getValue().toString().startsWith(conjParams.get(i).split("\\s+like\\s+")[1].replace("%", "")
                                .replace("‘", "").replace("’", ""))
                                && !entry.getValue().toString().endsWith(conjParams.get(i).split("\\s+like\\s+")[1].replace("%", "")
                                .replace("‘", "").replace("’", ""))) {
                            countCorrectConditions++;
                            if (countCorrectConditions == conjParams.size()) {
                                rows.add(datum);
                            }
                        }

                    } else if (conjParams.get(i).matches("‘[Ll][Aa][Ss][Tt][Nn][Aa][Mm][Ee]’\\s+like\\s+‘%[а-яА-Яa-zA-Z]+%’")) {
                        if (entry.getKey().equals("lastName") && entry.getValue().toString()
                                .contains(conjParams.get(i).split("\\s+like\\s+")[1].replace("%", "")
                                        .replace("‘", "").replace("’", ""))
                                && !entry.getValue().toString().startsWith(conjParams.get(i).split("\\s+like\\s+")[1].replace("%", "")
                                .replace("‘", "").replace("’", ""))
                                && !entry.getValue().toString().endsWith(conjParams.get(i).split("\\s+like\\s+")[1].replace("%", "")
                                .replace("‘", "").replace("’", ""))) {
                            countCorrectConditions++;
                            if (countCorrectConditions == conjParams.size()) {
                                rows.add(datum);
                            }
                        }

                    } else if (conjParams.get(i).matches("‘[Ll][Aa][Ss][Tt][Nn][Aa][Mm][Ee]’\\s+ilike\\s+‘[а-яА-Яa-zA-Z]+’")) {
                        if (entry.getKey().equals("lastName") && entry.getValue().toString().toLowerCase()
                                .contains(conjParams.get(i).split("\\s+ilike\\s+")[1].replace("%", "")
                                        .replace("‘", "").replace("’", "").toLowerCase())
                                && entry.getValue().toString().toLowerCase().startsWith(conjParams.get(i).split("\\s+ilike\\s+")[1].replace("%", "")
                                .replace("‘", "").replace("’", "").toLowerCase())
                                && entry.getValue().toString().toLowerCase().endsWith(conjParams.get(i).split("\\s+ilike\\s+")[1].replace("%", "")
                                .replace("‘", "").replace("’", "").toLowerCase())) {
                            countCorrectConditions++;
                            if (countCorrectConditions == conjParams.size()) {
                                rows.add(datum);
                            }
                        }

                    } else if (conjParams.get(i).matches("‘[Ll][Aa][Ss][Tt][Nn][Aa][Mm][Ee]’\\s+ilike\\s+‘%[а-яА-Яa-zA-Z]+’")) {
                        if (entry.getKey().equals("lastName") && entry.getValue().toString().toLowerCase()
                                .contains(conjParams.get(i).split("\\s+ilike\\s+")[1].replace("%", "")
                                        .replace("‘", "").replace("’", "").toLowerCase())
                                && entry.getValue().toString().endsWith(conjParams.get(i).split("\\s+ilike\\s+")[1].replace("%", "")
                                .replace("‘", "").replace("’", "").toLowerCase())
                                && !entry.getValue().toString().startsWith(conjParams.get(i).split("\\s+ilike\\s+")[1].replace("%", "")
                                .replace("‘", "").replace("’", "").toLowerCase())) {
                            countCorrectConditions++;
                            if (countCorrectConditions == conjParams.size()) {
                                rows.add(datum);
                            }
                        }

                    } else if (conjParams.get(i).matches("‘[Ll][Aa][Ss][Tt][Nn][Aa][Mm][Ee]’\\s+ilike\\s+‘[а-яА-Яa-zA-Z]+%’")) {
                        if (entry.getKey().equals("lastName") && entry.getValue().toString().toLowerCase()
                                .contains(conjParams.get(i).split("\\s+ilike\\s+")[1].replace("%", "")
                                        .replace("‘", "").replace("’", "").toLowerCase())
                                && entry.getValue().toString().startsWith(conjParams.get(i).split("\\s+ilike\\s+")[1].replace("%", "")
                                .replace("‘", "").replace("’", "").toLowerCase())
                                && !entry.getValue().toString().endsWith(conjParams.get(i).split("\\s+ilike\\s+")[1].replace("%", "")
                                .replace("‘", "").replace("’", "").toLowerCase())) {
                            countCorrectConditions++;
                            if (countCorrectConditions == conjParams.size()) {
                                rows.add(datum);
                            }
                        }

                    } else if (conjParams.get(i).matches("‘[Ll][Aa][Ss][Tt][Nn][Aa][Mm][Ee]’\\s+ilike\\s+‘%[а-яА-Яa-zA-Z]+%’")) {
                        if (entry.getKey().equals("lastName") && entry.getValue().toString().toLowerCase()
                                .contains(conjParams.get(i).split("\\s+ilike\\s+")[1].replace("%", "")
                                        .replace("‘", "").replace("’", "").toLowerCase())
                                && !entry.getValue().toString().startsWith(conjParams.get(i).split("\\s+ilike\\s+")[1].replace("%", "")
                                .replace("‘", "").replace("’", "").toLowerCase())
                                && !entry.getValue().toString().endsWith(conjParams.get(i).split("\\s+ilike\\s+")[1].replace("%", "")
                                .replace("‘", "").replace("’", "").toLowerCase())) {
                            countCorrectConditions++;
                            if (countCorrectConditions == conjParams.size()) {
                                rows.add(datum);
                            }
                        }
                    } else {
                        throw new Exception();
                    }
                }
            }
        }
        return rows;
    }
}
