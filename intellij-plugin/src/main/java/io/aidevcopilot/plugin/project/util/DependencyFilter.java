package io.aidevcopilot.plugin.project.util;

import java.util.Set;

public final class DependencyFilter {

    private static final Set<String> IGNORED_TYPES =
            Set.of(

                    "String",

                    "Integer",
                    "Long",
                    "Short",
                    "Byte",

                    "Double",
                    "Float",

                    "Boolean",

                    "Character",

                    "Object",

                    "List",
                    "Set",
                    "Map",
                    "Collection",

                    "Optional",

                    "BigDecimal",
                    "BigInteger",

                    "LocalDate",
                    "LocalDateTime",
                    "LocalTime",
                    "Date",

                    "UUID"

            );

    private DependencyFilter() {
    }

    public static boolean shouldIgnore(
            String type
    ) {

        if (type == null ||
                type.isBlank()) {
            return true;
        }

        if (IGNORED_TYPES.contains(type)) {
            return true;
        }

        return switch (type) {

            case "int",
                 "long",
                 "double",
                 "float",
                 "boolean",
                 "char",
                 "byte",
                 "short" -> true;

            default -> false;

        };

    }

}