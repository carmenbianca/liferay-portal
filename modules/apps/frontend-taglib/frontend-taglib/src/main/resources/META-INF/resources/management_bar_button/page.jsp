<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/management_bar_button/init.jsp" %>

<aui:a cssClass="<%= cssClass %>" data="<%= data %>" href="<%= href %>" iconCssClass="<%= iconCssClass %>" id="<%= id %>">
	<c:if test="<%= Validator.isNotNull(icon) %>">
		<aui:icon cssClass="icon-monospaced" image="<%= icon %>" markupView="lexicon" />
	</c:if>

	<span class="<%= labelCssClass %>"><liferay-ui:message key="<%= label %>" /></span>
</aui:a>