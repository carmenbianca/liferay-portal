<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
DepotApplicationDisplayContext depotApplicationDisplayContext = (DepotApplicationDisplayContext)request.getAttribute(DepotAdminWebKeys.DEPOT_APPLICATION_DISPLAY_CONTEXT);
%>

<div class="container-fluid container-fluid-max-xl pt-4">
	<div class="alert alert-info">
		<span class="alert-indicator">
			<svg class="lexicon-icon lexicon-icon-info-circle" focusable="false" role="presentation">
				<use xlink:href="<%= themeDisplay.getPathThemeImages() %>/lexicon/icons.svg#info-circle" />
			</svg>
		</span>

		<strong class="lead">Info:</strong><%= depotApplicationDisplayContext.getMessage() %>
	</div>
</div>