<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/clay" prefix="clay" %><%@
taglib uri="http://liferay.com/tld/ddm" prefix="liferay-ddm" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %><%@
page import="com.liferay.portal.kernel.util.HashMapBuilder" %><%@
page import="com.liferay.portal.kernel.util.HtmlUtil" %><%@
page import="com.liferay.portal.kernel.util.StringUtil" %><%@
page import="com.liferay.portal.kernel.util.WebKeys" %><%@
page import="com.liferay.portal.search.web.internal.custom.filter.configuration.CustomFilterPortletInstanceConfiguration" %><%@
page import="com.liferay.portal.search.web.internal.custom.filter.display.context.CustomFilterDisplayContext" %>

<%@ page import="java.util.ArrayList" %><%@
page import="java.util.Map" %>

<portlet:defineObjects />

<%
CustomFilterDisplayContext customFilterDisplayContext = (CustomFilterDisplayContext)java.util.Objects.requireNonNull(request.getAttribute(WebKeys.PORTLET_DISPLAY_CONTEXT));

CustomFilterPortletInstanceConfiguration
	customFilterPortletInstanceConfiguration = customFilterDisplayContext.getCustomFilterPortletInstanceConfiguration();

Map<String, Object> contextObjects = HashMapBuilder.<String, Object>put(
	"customFilterDisplayContext", customFilterDisplayContext
).put(
	"namespace", renderResponse.getNamespace()
).build();
%>

<c:if test="<%= !customFilterDisplayContext.isRenderNothing() %>">
	<aui:form action="<%= customFilterDisplayContext.getSearchURL() %>" method="get" name="fm">
		<liferay-ddm:template-renderer
			className="<%= CustomFilterDisplayContext.class.getName() %>"
			contextObjects="<%= contextObjects %>"
			displayStyle="<%= customFilterPortletInstanceConfiguration.displayStyle() %>"
			displayStyleGroupId="<%= customFilterDisplayContext.getDisplayStyleGroupId() %>"
			entries="<%= new ArrayList<CustomFilterDisplayContext>() %>"
		>
			<liferay-ui:panel-container
				extended="<%= true %>"
				id='<%= renderResponse.getNamespace() + "filterCustomPanelContainer" %>'
				markupView="lexicon"
				persistState="<%= true %>"
			>
				<liferay-ui:panel
					collapsible="<%= true %>"
					cssClass="search-facet"
					id='<%= renderResponse.getNamespace() + "filterCustomPanel" %>'
					markupView="lexicon"
					persistState="<%= true %>"
					title="<%= HtmlUtil.escapeAttribute(customFilterDisplayContext.getHeading()) %>"
				>
					<aui:input cssClass="custom-filter-value-input" data-qa-id="customFilterValueInput" disabled="<%= customFilterDisplayContext.isImmutable() %>" id="<%= renderResponse.getNamespace() + StringUtil.randomId() %>" label="" name="<%= HtmlUtil.escapeAttribute(customFilterDisplayContext.getParameterName()) %>" useNamespace="<%= false %>" value="<%= HtmlUtil.escapeAttribute(customFilterDisplayContext.getFilterValue()) %>" />

					<clay:button
						ariaLabel='<%= LanguageUtil.get(request, "apply") %>'
						disabled="<%= customFilterDisplayContext.isImmutable() %>"
						elementClasses="custom-filter-apply-button"
						label='<%= LanguageUtil.get(request, "apply") %>'
						size="sm"
						style="secondary"
						type="submit"
					/>
				</liferay-ui:panel>
			</liferay-ui:panel-container>
		</liferay-ddm:template-renderer>
	</aui:form>

	<aui:script use="liferay-search-custom-filter">
		new Liferay.Search.CustomFilter(A.one('#<portlet:namespace/>fm'));
	</aui:script>
</c:if>