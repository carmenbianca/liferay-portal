<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/checkbox/init.jsp" %>

<liferay-util:buffer
	var="extendedLabel"
>
	<%@ include file="/checkbox/extended_label.jspf" %>
</liferay-util:buffer>

<aui:input checked="<%= checked %>" data-qa-id="<%= name %>" disabled="<%= disabled %>" id="<%= id %>" ignoreRequestValue="<%= true %>" label="<%= extendedLabel %>" name="<%= name %>" type="checkbox" />