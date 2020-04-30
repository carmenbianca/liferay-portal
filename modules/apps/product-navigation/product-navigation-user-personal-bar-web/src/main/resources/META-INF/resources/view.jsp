<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<c:choose>
	<c:when test="<%= themeDisplay.isSignedIn() %>">
		<span class="user-avatar-link">
			<liferay-product-navigation:personal-menu
				size="lg"
				user="<%= user %>"
			/>

			<%
			int notificationsCount = GetterUtil.getInteger(request.getAttribute(ProductNavigationUserPersonalBarWebKeys.NOTIFICATIONS_COUNT));
			%>

			<c:if test="<%= notificationsCount > 0 %>">

				<%
				String notificaitonsPortletId = PortletProviderUtil.getPortletId(UserNotificationEvent.class.getName(), PortletProvider.Action.VIEW);

				String notificationsURL = PersonalApplicationURLUtil.getPersonalApplicationURL(request, notificaitonsPortletId);
				%>

				<aui:a href="<%= (notificationsURL != null) ? notificationsURL : null %>">
					<span class="badge badge-danger panel-notifications-count">
						<span class="badge-item badge-item-expand"><%= notificationsCount %></span>
					</span>
				</aui:a>
			</c:if>
		</span>
	</c:when>
	<c:otherwise>

		<%
		Map<String, Object> anchorData = HashMapBuilder.<String, Object>put(
			"redirect", String.valueOf(PortalUtil.isLoginRedirectRequired(request))
		).build();
		%>

		<span class="sign-in text-default" role="presentation">
			<aui:icon cssClass="sign-in text-default" data="<%= anchorData %>" image="user" label="sign-in" markupView="lexicon" url="<%= themeDisplay.getURLSignIn() %>" />
		</span>
	</c:otherwise>
</c:choose>