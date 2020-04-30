<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
OrganizationScreenNavigationDisplayContext organizationScreenNavigationDisplayContext = (OrganizationScreenNavigationDisplayContext)request.getAttribute(UsersAdminWebKeys.ORGANIZATION_SCREEN_NAVIGATION_DISPLAY_CONTEXT);
%>

<aui:form action="<%= organizationScreenNavigationDisplayContext.getEditOrganizationActionURL() %>" cssClass="portlet-users-admin-edit-organization" method="post" name="fm">
	<div class="sheet sheet-lg">
		<c:if test="<%= organizationScreenNavigationDisplayContext.isShowTitle() %>">
			<div class="sheet-header">
				<h2 class="sheet-title"><%= organizationScreenNavigationDisplayContext.getFormLabel() %></h2>
			</div>
		</c:if>

		<div class="sheet-section">
			<liferay-util:include page="<%= organizationScreenNavigationDisplayContext.getJspPath() %>" servletContext="<%= application %>" />
		</div>

		<c:if test="<%= organizationScreenNavigationDisplayContext.isShowControls() %>">
			<div class="sheet-footer">
				<aui:button primary="<%= true %>" type="submit" />

				<aui:button href="<%= organizationScreenNavigationDisplayContext.getBackURL() %>" type="cancel" />
			</div>
		</c:if>
	</div>
</aui:form>