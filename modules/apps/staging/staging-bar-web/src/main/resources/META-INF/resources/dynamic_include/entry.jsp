<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/dynamic_include/init.jsp" %>

<div class="staging">
	<liferay-portlet:runtime
		portletName="<%= StagingBarPortletKeys.STAGING_BAR %>"
	/>
</div>