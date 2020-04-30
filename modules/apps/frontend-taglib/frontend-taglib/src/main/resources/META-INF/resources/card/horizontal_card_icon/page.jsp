<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/card/horizontal_card_icon/init.jsp" %>

<%
Object bodyContent = request.getAttribute("liferay-frontend:horizontal-card-icon:bodyContent");

String bodyContentString = StringPool.BLANK;

if (bodyContent != null) {
	bodyContentString = bodyContent.toString();
}
%>

<c:choose>
	<c:when test="<%= Validator.isNotNull(bodyContentString) %>">
		<%= bodyContentString %>
	</c:when>
	<c:otherwise>
		<div class="sticker sticker-secondary">
			<aui:icon image="<%= icon %>" markupView="lexicon" />
		</div>
	</c:otherwise>
</c:choose>