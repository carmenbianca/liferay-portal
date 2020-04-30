<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/card/image_card/init.jsp" %>

<div class="taglib-vertical-card <%= cssClass %>" <%= AUIUtil.buildData(data) %>>
	<div>
		<div class="card">
			<div class="aspect-ratio aspect-ratio-bg-center aspect-ratio-bg-cover" style="<%= "background-image: url('" + imageUrl + "')" %>">
				<img alt="" class="<%= imageCSSClass %> sr-only" src="<%= imageUrl %>" />
			</div>
		</div>
	</div>
</div>