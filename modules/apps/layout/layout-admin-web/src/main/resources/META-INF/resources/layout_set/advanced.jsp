<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
Group guestGroup = GroupLocalServiceUtil.getGroup(company.getCompanyId(), GroupConstants.GUEST);

boolean mergeGuestPublicPages = PropertiesParamUtil.getBoolean(layoutsAdminDisplayContext.getGroupTypeSettings(), request, "mergeGuestPublicPages");
%>

<liferay-ui:error-marker
	key="<%= WebKeys.ERROR_SECTION %>"
	value="advanced"
/>

<c:choose>
	<c:when test="<%= !layoutsAdminDisplayContext.isPrivateLayout() && (layoutsAdminDisplayContext.getLiveGroupId() != guestGroup.getGroupId()) %>">
		<aui:input helpMessage='<%= LanguageUtil.format(request, "you-can-configure-the-top-level-pages-of-this-public-site-to-merge-with-the-top-level-pages-of-the-public-x-site", HtmlUtil.escape(guestGroup.getDescriptiveName(locale)), false) %>' label='<%= LanguageUtil.format(request, "merge-x-public-pages", HtmlUtil.escape(guestGroup.getDescriptiveName(locale)), false) %>' name="mergeGuestPublicPages" type="checkbox" value="<%= mergeGuestPublicPages %>" />
	</c:when>
	<c:otherwise>
		<div class="alert alert-info">
			<liferay-ui:message key="there-are-no-available-advanced-settings-for-these-pages" />
		</div>
	</c:otherwise>
</c:choose>