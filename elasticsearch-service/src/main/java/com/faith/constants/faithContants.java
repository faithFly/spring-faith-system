package com.faith.constants;

/**
 * @description:
 * @author:faith
 * @time:2023/5/3017:28
 */
public class faithContants {
    public static final String MAPPING_TEMPLATE="{\n" +
            "  \"mappings\": {\n" +
            "    \"properties\": {\n" +
            "      \"info\":{\n" +
            "      \"type\":\"text\",\n" +
            "      \"analyzer\":\"ik_smart\"\n" +
            "      },\n" +
            "      \"email\":{\n" +
            "      \"type\":\"keyword\",\n" +
            "      \"index\":false\n" +
            "    },\n" +
            "      \"name\":{\n" +
            "      \"type\":\"object\",\n" +
            "      \"properties\": {\n" +
            "        \"firstName\":{\n" +
            "          \"type\":\"keyword\"\n" +
            "        },\n" +
            "        \"lastName\":{\n" +
            "          \"type\":\"keyword\"\n" +
            "        }\n" +
            "      }\n" +
            "    }\n" +
            "    }\n" +
            "  }\n" +
            "}";
}
