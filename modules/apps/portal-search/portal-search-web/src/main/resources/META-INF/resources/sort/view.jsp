<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/ddm" prefix="liferay-ddm" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.portal.kernel.util.HashMapBuilder" %><%@
page import="com.liferay.portal.kernel.util.WebKeys" %><%@
page import="com.liferay.portal.search.web.internal.sort.configuration.SortPortletInstanceConfiguration" %><%@
page import="com.liferay.portal.search.web.internal.sort.display.context.SortDisplayContext" %><%@
page import="com.liferay.portal.search.web.internal.sort.display.context.SortTermDisplayContext" %>

<%@ page import="java.util.List" %><%@
page import="java.util.Map" %>

<liferay-theme:defineObjects />

<%
SortDisplayContext sortDisplayContext = (SortDisplayContext)java.util.Objects.requireNonNull(request.getAttribute(WebKeys.PORTLET_DISPLAY_CONTEXT));

if (sortDisplayContext.isRenderNothing()) {
	return;
}

SortPortletInstanceConfiguration sortPortletInstanceConfiguration = sortDisplayContext.getSortPortletInstanceConfiguration();

Map<String, Object> contextObjects = HashMapBuilder.<String, Object>put(
	"sortDisplayContext", sortDisplayContext
).build();

List<SortTermDisplayContext> sortTermDisplayContexts = sortDisplayContext.getSortTermDisplayContexts();
%>

<c:choose>
	<c:when test="<%= sortDisplayContext.isRenderNothing() %>">
		<div class="alert alert-info text-center">
			<liferay-ui:message key="this-widget-is-not-visible-to-users-yet" />

			<aui:a href="javascript:;" onClick="<%= portletDisplay.getURLConfigurationJS() %>"><liferay-ui:message key="complete-its-configuration-to-make-it-visible" /></aui:a>
		</div>
	</c:when>
	<c:otherwise>
		<aui:form method="post" name="fm">
			<aui:input cssClass="sort-parameter-name" name="sort-parameter-name" type="hidden" value="<%= sortDisplayContext.getParameterName() %>" />

			<liferay-ddm:template-renderer
				className="<%= SortDisplayContext.class.getName() %>"
				contextObjects="<%= contextObjects %>"
				displayStyle="<%= sortPortletInstanceConfiguration.displayStyle() %>"
				displayStyleGroupId="<%= sortDisplayContext.getDisplayStyleGroupId() %>"
				entries="<%= sortTermDisplayContexts %>"
			>
				<aui:fieldset>
					<aui:select class="sort-term" label="sort-by" name="sortSelection">

						<%
						for (SortTermDisplayContext sortTermDisplayContext : sortDisplayContext.getSortTermDisplayContexts()) {
						%>

							<aui:option label="<%= sortTermDisplayContext.getLabel() %>" selected="<%= sortTermDisplayContext.isSelected() %>" value="<%= sortTermDisplayContext.getField() %>" />

						<%
						}
						%>

					</aui:select>
				</aui:fieldset>
			</liferay-ddm:template-renderer>
		</aui:form>
	</c:otherwise>
</c:choose>

<aui:script use="liferay-search-sort-util">
AUI().ready('aui-base', 'node', 'event', function(A) {
	A.one('#<portlet:namespace />sortSelection').on('change', function() {
		var selections = [];

		var sortSelect = A.one('#<portlet:namespace />sortSelection').get(
			'value'
		);

		selections.push(sortSelect);

		var key = A.one('#<portlet:namespace />sort-parameter-name').get(
			'value'
		);

		document.location.search = Liferay.Search.SortUtil.updateQueryString(
			key,
			selections,
			document.location.search
		);
	});
});
</aui:script>