package com.sourceplusplus.protocol.artifact

/**
 * todo: description.
 *
 * @since 0.0.1
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
enum class ArtifactInfoType {
    QUALIFIED_NAME,
    CREATE_DATE,
    LAST_UPDATED,
    ENDPOINT;

    val id = name.toLowerCase()
    val description = id.split("_").joinToString(" ") { it.capitalize() }
}
