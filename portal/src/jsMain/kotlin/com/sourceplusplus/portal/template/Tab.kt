package com.sourceplusplus.portal.template

import com.sourceplusplus.protocol.artifact.trace.TraceOrderType
import com.sourceplusplus.protocol.portal.PageType
import kotlinx.html.*

fun FlowContent.tabs(block: FlowContent.() -> Unit) {
    block()
}

fun FlowContent.tabItem(pageType: PageType, isActive: Boolean, block: (FlowContent.() -> Unit)? = null) {
    when (pageType) {
        PageType.OVERVIEW -> apply {
            if (isActive) {
                a(classes = "ui dropdown item active_tab") {
                    i("icon demo-icon satellite")
                }
            } else {
                a(classes = "ui item hide_on_toggle") {
                    id = "overview_link"
                    href = "/"
                    i("icon demo-icon satellite inactive_tab")
                }
            }
        }
        PageType.ACTIVITY -> apply {
            if (isActive) {
                a(classes = "ui dropdown item active_tab") {
                    i("icon demo-icon dashboard")
                }
            } else {
                a(classes = "ui item hide_on_toggle") {
                    id = "activity_link"
                    href = "activity.html"
                    i("icon demo-icon dashboard inactive_tab")
                }
            }
        }
        PageType.TRACES -> apply {
            var activeClass = "active_tab"
            if (!isActive) {
                activeClass = "inactive_tab"
            }
            div("ui dropdown item $activeClass") {
                unsafe {
                    +"""<z class="displaynone">Traces</z>"""
                }
                i("icon demo-icon code")
                block?.let { it() }
            }
        }
        PageType.CONFIGURATION -> apply {
            if (isActive) {
                a(classes = "ui dropdown item active_tab") {
                    i("icon configure")
                }
            } else {
                a(classes = "ui item hide_on_toggle") {
                    id = "configuration_link"
                    href = "configuration.html"
                    i("icon configure inactive_tab")
                }
            }
        }
    }
}

fun FlowContent.subTabItem(vararg traceOrderTypes: TraceOrderType = arrayOf()) {
    div("menu secondary_background_color") {
        for (traceType in traceOrderTypes) {
            a(classes = "item") {
                id = "traces_link_${traceType.id}"
                href = traceType.id
                span("menu_tooltip_text") { +traceType.description }
            }
        }
    }
}
