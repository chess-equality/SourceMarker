package com.sourceplusplus.protocol.artifact.trace

import kotlinx.serialization.Serializable

/**
 * todo: description.
 *
 * @since 0.0.1
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
//todo: remove ?s
@Serializable
data class TraceSpan(
    val traceId: String,
    val segmentId: String,
    val spanId: Int,
    val parentSpanId: Int,
    val refs: List<TraceSpanRef> = emptyList(),
    val serviceCode: String,
    val serviceInstanceName: String? = null,
    val startTime: Long,
    val endTime: Long,
    val endpointName: String? = null,
    val artifactQualifiedName: String? = null,
    val type: String,
    val peer: String? = null,
    val component: String? = null,
    val error: Boolean? = null,
    val childError: Boolean = false,
    val hasChildStack: Boolean? = null,
    val layer: String? = null,
    val tags: Map<String, String> = emptyMap(),
    val logs: List<TraceSpanLogEntry> = emptyList()
)
