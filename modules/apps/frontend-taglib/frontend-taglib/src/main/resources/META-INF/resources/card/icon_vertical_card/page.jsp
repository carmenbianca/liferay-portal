<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/card/icon_vertical_card/init.jsp" %>

<%@ include file="/card/vertical_card/start.jspf" %>

<aui:icon cssClass="aspect-ratio-item-center-middle aspect-ratio-item-fluid card-type-asset-icon" image="<%= icon %>" markupView="lexicon" />

<c:if test="<%= Validator.isNotNull(stickerBottom) %>">
	<%= stickerBottom %>
</c:if>

<%@ include file="/card/vertical_card/end.jspf" %>