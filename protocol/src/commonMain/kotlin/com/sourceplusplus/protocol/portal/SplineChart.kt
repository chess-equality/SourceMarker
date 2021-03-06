package com.sourceplusplus.protocol.portal

import kotlinx.serialization.Serializable

/**
 * todo: description.
 *
 * @since 0.0.1
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
@Serializable
data class SplineChart(
    val metricType: MetricType,
    val timeFrame: QueryTimeFrame, //todo: use LocalDuration
    val seriesData: List<SplineSeriesData>
)
