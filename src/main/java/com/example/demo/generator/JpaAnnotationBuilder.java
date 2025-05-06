package com.example.demo.generator;

public class JpaAnnotationBuilder {

    public static String buildFor(String fieldName, String javaType, boolean isEnum, boolean isRelation, String relationType, boolean isRequired) {
        StringBuilder sb = new StringBuilder();

        String columnName = toSnakeCase(fieldName);

        if (isRelation && !isEnum) {
            switch (relationType) {
                case "OneToOne" -> sb.append("@OneToOne\n")
                                     .append("	@JoinColumn(name = \"")
                                     .append(columnName)
                                     .append("\")");
                case "OneToMany" -> sb.append("@OneToMany\n")
                                      .append("	@JoinColumn(name = \"")
                                      .append(columnName)
                                      .append("\")");
            }
        } else {
            sb.append("@Column(name = \"")
              .append(columnName)
              .append("\"");
            if (!isRequired) sb.append(", nullable = true");
            sb.append(")");
        }

        if (isEnum) {
            sb.append("\n	@Enumerated(EnumType.STRING)");
        }

        return sb.toString();
    }

    private static String toSnakeCase(String input) {
        if (input == null || input.isEmpty()) return input;
        return input
            .replaceAll("([a-z])([A-Z])", "$1_$2")
            .replaceAll("([A-Z]+)([A-Z][a-z])", "$1_$2")
            .toLowerCase();
    }
}
