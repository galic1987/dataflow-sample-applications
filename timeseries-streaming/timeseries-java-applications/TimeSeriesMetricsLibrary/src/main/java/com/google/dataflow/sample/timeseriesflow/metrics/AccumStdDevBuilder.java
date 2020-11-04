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
package com.google.dataflow.sample.timeseriesflow.metrics;

import com.google.dataflow.sample.timeseriesflow.FSITechnicalDerivedAggregations.FsiTechnicalIndicators;
import com.google.dataflow.sample.timeseriesflow.TimeSeriesData.Data;
import com.google.dataflow.sample.timeseriesflow.TimeSeriesData.TSAccum;
import com.google.dataflow.sample.timeseriesflow.datamap.AccumCoreMetadataBuilder;
import org.apache.beam.sdk.annotations.Experimental;

/** Builder for the {@link MA} type 2 computation data store */
@Experimental
class AccumStdDevBuilder extends AccumCoreMetadataBuilder {
  public AccumStdDevBuilder(TSAccum tsAccum) {
    super(tsAccum);
  }

  public Data getMovementCount() {
    return getValueOrNull(FsiTechnicalIndicators.SUM_MOVEMENT_COUNT.name());
  }

  public Data getStdDev() {
    return getValueOrNull(FsiTechnicalIndicators.STANDARD_DEVIATION.name());
  }

  public AccumStdDevBuilder setMovementCount(Data data) {
    setValue(FsiTechnicalIndicators.SUM_MOVEMENT_COUNT.name(), data);
    return this;
  }

  public AccumStdDevBuilder setStdDev(Data data) {
    setValue(FsiTechnicalIndicators.STANDARD_DEVIATION.name(), data);
    return this;
  }
}
