<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/change_lists_configuration/init.jsp" %>

<clay:navigation-bar
	inverted="<%= true %>"
	navigationItems="<%= changeListsConfigurationDisplayContext.getViewNavigationItems() %>"
/>

<div class="container-fluid container-fluid-max-xl container-form-lg">
	<aui:form action="<%= changeListsConfigurationDisplayContext.getActionURL() %>" method="post" name="fm">
		<aui:input name="navigation" type="hidden" value="<%= changeListsConfigurationDisplayContext.getNavigation() %>" />
		<aui:input name="redirectToOverview" type="hidden" value="<%= false %>" />

		<div class="sheet sheet-lg">
			<%@ include file="/change_lists_configuration/global_settings.jspf" %>
		</div>
	</aui:form>
</div>