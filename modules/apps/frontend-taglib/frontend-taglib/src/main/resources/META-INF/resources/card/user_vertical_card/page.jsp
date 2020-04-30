<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/card/user_vertical_card/init.jsp" %>

<%@ include file="/card/vertical_card/start.jspf" %>

<div class="aspect-ratio-item-center-middle aspect-ratio-item-fluid card-type-asset-icon">
	<liferay-ui:user-portrait
		user="<%= user2 %>"
	/>
</div>

<%@ include file="/card/vertical_card/end.jspf" %>