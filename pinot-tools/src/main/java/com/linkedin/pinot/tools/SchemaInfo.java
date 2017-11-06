/**
 * Copyright (C) 2014-2016 LinkedIn Corp. (pinot-core@linkedin.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.linkedin.pinot.tools;

import java.util.Arrays;
import java.util.List;

public final class SchemaInfo {
    /* Zookeeper Configurations */
    public static String DEFAULT_ZOOKEEPER_ADDRESS = "localhost:2181";

    /* Pinot Broker Configurations */
    public static int DEFAULT_BROKER_PORT = 8099;

    /* Pinot Controller Configurations */
    public static String DEFAULT_DATA_DIR = "/tmp/pinotController";
    public static String DEFAULT_CONTROLLER_PORT = "9000";

    /* Pinot Server Configurations */
    public static int DEFAULT_SERVER_PORT = 8098;
    public static String DATA_DIR = "/tmp/data";
    public static String SEGMENT_DIR = "/tmp/segment";

    public static final List<String> SCHEMAS = Arrays.asList("new_data/jobSchema.json", "new_data/adsSchema.json",
            "new_data/articlesSchema.json", "new_data/viewsSchema.json");
    public static final List<String> SCHEMAS_ANNOTATIONS = Arrays.asList("new_data/jobSchemaAnnotation.json",
            "new_data/adsSchemaAnnotation.json", "new_data/articlesSchemaAnnotation.json", "new_data/viewsSchemaAnnotation.json");
    public static final List<Integer> NUM_RECORDS = Arrays.asList(1000000, 30, 30, 30);
    public static final List<Integer> NUM_SEGMENTS = Arrays.asList(4, 4, 4, 4);
    public static final List<String> DATA_DIRS = Arrays.asList("jobs", "ads", "articles", "views");
    public static final String SEGMENT_NAME = "segment";
    public static final List<String> TABLE_NAMES = Arrays.asList("Job", "Ads", "Articles", "Views");
    public static final List<String> TABLE_DEFINITIONS = Arrays.asList("new_data/jobTable.json",
            "new_data/adsTable.json", "new_data/articlesTable.json", "new_data/viewsTable.json");

}
