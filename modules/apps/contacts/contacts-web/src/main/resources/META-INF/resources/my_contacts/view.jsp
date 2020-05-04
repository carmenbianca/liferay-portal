<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<c:choose>
	<c:when test="<%= scopeGroup.isUser() %>">

		<%
		List<User> users = UserLocalServiceUtil.getSocialUsers(scopeGroup.getClassPK(), SocialRelationConstants.TYPE_BI_CONNECTION, StringPool.EQUAL, 0, 10, new UserLastNameComparator());

		PortletURL portletURL = null;

		try {
			long contactsPlid = PortalUtil.getPlidFromPortletId(scopeGroup.getGroupId(), false, ContactsPortletKeys.CONTACTS_CENTER);

			if (contactsPlid > 0) {
				portletURL = PortletURLFactoryUtil.create(request, ContactsPortletKeys.CONTACTS_CENTER, contactsPlid, PortletRequest.RENDER_PHASE);
			}
		}
		catch (Exception e) {
		}
		%>

		<c:choose>
			<c:when test="<%= users.isEmpty() %>">
				<div class="alert alert-info">
					<liferay-ui:message arguments="<%= HtmlUtil.escape(scopeGroup.getDescriptiveName(locale)) %>" key="x-has-no-connections" translateArguments="<%= false %>" />
				</div>
			</c:when>
			<c:otherwise>
				<aui:row>
					<aui:col cssClass="my-contacts" width="<%= 100 %>">

						<%
						for (User user2 : users) {
						%>

							<aui:row>
								<aui:col cssClass="lfr-contact-grid-item" width="<%= 100 %>">
									<div class="lfr-contact-thumb">
										<a href="<%= user2.getDisplayURL(themeDisplay) %>"><img alt="<%= HtmlUtil.escapeAttribute(user2.getFullName()) %>" src="<%= user2.getPortraitURL(themeDisplay) %>" /></a>
									</div>

									<div class="lfr-contact-info">
										<div class="lfr-contact-name">
											<a href="<%= user2.getDisplayURL(themeDisplay) %>"><%= HtmlUtil.escape(user2.getFullName()) %></a>
										</div>

										<div class="lfr-contact-job-title">
											<%= HtmlUtil.escape(user2.getJobTitle()) %>
										</div>
									</div>

									<div class="clear"><!-- --></div>
								</aui:col>
							</aui:row>

						<%
						}
						%>

						<c:if test="<%= portletURL != null %>">
							<a class="lfr-contact-grid-item" href="<%= portletURL %>"><liferay-ui:message arguments="<%= HtmlUtil.escape(scopeGroup.getDescriptiveName(locale)) %>" key="view-all-x-connections" translateArguments="<%= false %>" /></a>
						</c:if>
					</aui:col>
				</aui:row>
			</c:otherwise>
		</c:choose>
	</c:when>
	<c:otherwise>
		<div class="alert alert-danger">
			<liferay-ui:message key="this-application-only-functions-when-placed-on-a-user-page" />
		</div>
	</c:otherwise>
</c:choose>