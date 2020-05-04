<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
User selUser = (User)request.getAttribute("user.selUser");
Contact selContact = (Contact)request.getAttribute("user.selContact");
List<Organization> organizations = (List<Organization>)request.getAttribute("user.organizations");

String organizationsHTML = StringPool.BLANK;

if (!organizations.isEmpty()) {
	organizationsHTML = organizations.get(0).getName();
}

for (int i = 1; i < organizations.size(); i++) {
	organizationsHTML += ", " + organizations.get(i).getName();
}
%>

<h2><%= selUser.getFullName() %></h2>

<div class="details">
	<liferay-ui:user-portrait
		user="<%= selUser %>"
	/>

	<dl class="property-list">
		<c:if test="<%= Validator.isNotNull(selUser.getDisplayEmailAddress()) %>">
			<dt>
				<liferay-ui:message key="email-address" />
			</dt>
			<dd>
				<%= selUser.getDisplayEmailAddress() %>
			</dd>
		</c:if>

		<c:if test="<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.FIELD_ENABLE_COM_LIFERAY_PORTAL_KERNEL_MODEL_CONTACT_BIRTHDAY) %>">
			<dt>
				<liferay-ui:message key="birthday" />
			</dt>
			<dd>
				<%= dateFormatDate.format(selUser.getBirthday()) %>
			</dd>
		</c:if>

		<c:if test="<%= Validator.isNotNull(selContact.getJobTitle()) %>">
			<dt>
				<liferay-ui:message key="job-title" />
			</dt>
			<dd>
				<%= HtmlUtil.escape(selContact.getJobTitle()) %>
			</dd>
		</c:if>

		<c:if test="<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.FIELD_ENABLE_COM_LIFERAY_PORTAL_KERNEL_MODEL_CONTACT_MALE) %>">
			<dt>
				<liferay-ui:message key="gender" />
			</dt>
			<dd>
				<%= LanguageUtil.get(request, selUser.isMale() ? "male" : "female") %>
			</dd>
		</c:if>

		<c:if test="<%= !organizations.isEmpty() %>">
			<dt>
				<c:choose>
					<c:when test="<%= organizations.size() > 1 %>">
						<liferay-ui:message key="organizations" />
					</c:when>
					<c:otherwise>
						<liferay-ui:message key="organization" />
					</c:otherwise>
				</c:choose>
			</dt>
			<dd>
				<%= HtmlUtil.escape(organizationsHTML) %>
			</dd>
		</c:if>
	</dl>
</div>