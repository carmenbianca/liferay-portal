<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
DDMTemplate ddmTemplate = journalContentDisplayContext.getDDMTemplate();

Map<String, Object> data = HashMapBuilder.<String, Object>put(
	"destroyOnHide", true
).put(
	"id", HtmlUtil.escape(portletDisplay.getNamespace()) + "editAsset"
).put(
	"title", HtmlUtil.escape(ddmTemplate.getName(locale))
).build();
%>

<liferay-ui:icon
	data="<%= data %>"
	id="editTemplateIcon"
	message="edit-template"
	url="<%= journalContentDisplayContext.getURLEditTemplate() %>"
	useDialog="<%= true %>"
/>