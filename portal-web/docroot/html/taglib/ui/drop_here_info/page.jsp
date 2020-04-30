<%--
/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/html/taglib/ui/drop_here_info/init.jsp" %>

<%
String message = GetterUtil.getString((String)request.getAttribute("liferay-ui:drop-here-info:message"));
%>

<div class="drop-here-info">
	<div class="drop-here-indicator">
		<div class="drop-icons">
			<aui:icon cssClass="drop-icon" image="picture" markupView="lexicon" />

			<aui:icon cssClass="drop-icon" image="picture" markupView="lexicon" />

			<aui:icon cssClass="drop-icon" image="picture" markupView="lexicon" />
		</div>

		<div class="drop-text">
			<liferay-ui:message key="<%= message %>" />
		</div>
	</div>
</div>