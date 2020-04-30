<%--
/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/html/taglib/init.jsp" %>

<%
String cssClass = GetterUtil.getString((String)request.getAttribute("liferay-ui:input-checkbox:cssClass"));
String param = (String)request.getAttribute("liferay-ui:input-checkbox:param");
String id = (String)request.getAttribute("liferay-ui:input-checkbox:id");
Boolean defaultValue = (Boolean)request.getAttribute("liferay-ui:input-checkbox:defaultValue");
String onClick = GetterUtil.getString((String)request.getAttribute("liferay-ui:input-checkbox:onClick"));
boolean disabled = GetterUtil.getBoolean((String)request.getAttribute("liferay-ui:input-checkbox:disabled"));

boolean value = ParamUtil.getBoolean(request, param, defaultValue.booleanValue());

if (Validator.isNull(id)) {
	id = namespace + param;
}
%>

<input <%= value ? "checked" : "" %> class="<%= cssClass %>" <%= disabled ? "disabled=\"disabled\"" : "" %> id="<%= HtmlUtil.escapeAttribute(id) %>" name="<%= namespace %><%= param %>" onClick="<%= onClick %>" type="checkbox" />