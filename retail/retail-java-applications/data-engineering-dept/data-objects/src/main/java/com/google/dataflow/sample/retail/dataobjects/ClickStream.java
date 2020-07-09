/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.dataflow.sample.retail.dataobjects;

import com.google.auto.value.AutoValue;
import org.apache.beam.sdk.schemas.AutoValueSchema;
import org.apache.beam.sdk.schemas.JavaFieldSchema;
import org.apache.beam.sdk.schemas.annotations.DefaultSchema;
import org.apache.beam.sdk.schemas.annotations.SchemaFieldName;

import javax.annotation.Nullable;

/**
 * Objects used for dealing with clickstream within the pipeline and schemas for I/O of clickstream events.
 */
public class ClickStream {

  @AutoValue
  @DefaultSchema(AutoValueSchema.class)
  /**
   * The Clickstream event represents actions that a user has taken on the website or mobile
   * application.
   */
  public abstract static class ClickStreamEvent {

    // TODO : Add IP , remove Lat Lng

    @SchemaFieldName("timestamp")
    public @Nullable abstract Long getTimestamp();

    @SchemaFieldName("uid")
    public @Nullable abstract Long getUid();

    @SchemaFieldName("sessionId")
    public @Nullable abstract String getSessionId();

    @SchemaFieldName("pageRef")
    public @Nullable abstract String getPageRef();

    @SchemaFieldName("pageTarget")
    public @Nullable abstract String getPageTarget();

    @SchemaFieldName("lat")
    public @Nullable abstract Double getLat();

    @SchemaFieldName("lng")
    public @Nullable abstract Double getLng();

    @SchemaFieldName("agent")
    public @Nullable abstract String getAgent();

    @SchemaFieldName("event")
    public @Nullable abstract String getEvent();

    public abstract Builder toBuilder();

    public static Builder builder() {
      return new AutoValue_ClickStream_ClickStreamEvent.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {

      public abstract Builder setTimestamp(Long value);

      public abstract Builder setUid(Long value);

      public abstract Builder setSessionId(String value);

      public abstract Builder setPageRef(String value);

      public abstract Builder setPageTarget(String value);

      public abstract Builder setLat(Double value);

      public abstract Builder setLng(Double value);

      public abstract Builder setAgent(String value);

      public abstract Builder setEvent(String value);

      public abstract ClickStreamEvent build();
    }
  }

  // -----------------------------------
  // Schema used for dealing with page views when working with BigTable.
  // -----------------------------------
  /** This class hosts the strings used for the row being stored in BigTable. */
  public static class ClickStreamBigTableSchema {
    public static final String PAGE_VIEW_AGGREGATION_COL_FAMILY = "pageViewAgg";
    public static final String PAGE_VIEW_AGGREGATION_COL_PAGE_VIEW_REF = "pageViewRef";
    public static final String PAGE_VIEW_AGGREGATION_COL_PAGE_VIEW_COUNT = "pageViewCount";
  }

  // TODO convert to hand built schema as POJO is not needed
  @DefaultSchema(JavaFieldSchema.class)
  public static class PageViewAggregator {
    @Nullable public Long durationMS;
    @Nullable public Long startTime;
    @Nullable public String pageRef;
    @Nullable public Long count;
  }
}
