package com.sourceplusplus.mentor.impl.task

import com.sourceplusplus.mentor.base.MentorJob
import com.sourceplusplus.mentor.base.MentorTask
import com.sourceplusplus.mentor.MentorTest
import com.sourceplusplus.mentor.impl.task.monitor.GetTraces
import com.sourceplusplus.protocol.artifact.trace.TraceOrderType
import com.sourceplusplus.protocol.portal.QueryTimeFrame
import io.vertx.core.Vertx
import io.vertx.kotlin.coroutines.dispatcher
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertNotNull
import org.junit.Test

class GetTracesTest : MentorTest() {

    @Test(timeout = 5000)
    fun latestTraces() {
        val emptyJob = object : MentorJob() {
            override val vertx: Vertx = this@GetTracesTest.vertx
            override val tasks: List<MentorTask> = listOf()
        }

        runBlocking(vertx.dispatcher()) {
            GetTraces(
                orderType = TraceOrderType.LATEST_TRACES,
                timeFrame = QueryTimeFrame.LAST_15_MINUTES
            ).executeTask(emptyJob)

            assertNotNull(emptyJob.context.get(GetTraces.TRACE_RESULT))
        }
    }
}