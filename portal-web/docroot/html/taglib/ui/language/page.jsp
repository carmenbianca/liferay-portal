<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/html/taglib/ui/language/init.jsp" %>

<%
Map<String, Object> contextObjects = HashMapBuilder.<String, Object>put(
	"formAction", formAction
).put(
	"formName", formName
).put(
	"languageId", languageId
).put(
	"name", name
).put(
	"namespace", namespace
).build();
%>

<c:if test="<%= !languageEntries.isEmpty() %>">

	<%
	String renderedDDMTemplate = StringPool.BLANK;

	DDMTemplate portletDisplayDDMTemplate = PortletDisplayTemplateManagerUtil.getDDMTemplate(displayStyleGroupId, PortalUtil.getClassNameId(LanguageEntry.class), displayStyle, true);

	if (portletDisplayDDMTemplate != null) {
		renderedDDMTemplate = PortletDisplayTemplateManagerUtil.renderDDMTemplate(request, response, portletDisplayDDMTemplate.getTemplateId(), languageEntries, contextObjects);
	}
	%>

	<%= renderedDDMTemplate %>
</c:if>