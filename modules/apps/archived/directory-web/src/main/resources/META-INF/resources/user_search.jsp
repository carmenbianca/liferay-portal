<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String viewUsersRedirect = ParamUtil.getString(request, "viewUsersRedirect");

PortletURL portletURL = (PortletURL)request.getAttribute("view.jsp-portletURL");

if (Validator.isNotNull(viewUsersRedirect)) {
	portletURL.setParameter("viewUsersRedirect", viewUsersRedirect);
}

UserSearch searchContainer = new UserSearch(renderRequest, portletURL);

UserDisplayTerms displayTerms = (UserDisplayTerms)searchContainer.getDisplayTerms();
%>

<liferay-ui:search-toggle
	buttonLabel="search"
	displayTerms="<%= displayTerms %>"
	id='<%= renderResponse.getNamespace() + "toggle_id_user_search" %>'
	markupView="lexicon"
>
	<aui:fieldset>
		<aui:input inlineField="<%= true %>" name="<%= UserDisplayTerms.FIRST_NAME %>" size="20" type="text" value="<%= displayTerms.getFirstName() %>" />

		<aui:input inlineField="<%= true %>" name="<%= UserDisplayTerms.MIDDLE_NAME %>" size="20" type="text" value="<%= displayTerms.getMiddleName() %>" />

		<aui:input inlineField="<%= true %>" name="<%= UserDisplayTerms.LAST_NAME %>" size="20" type="text" value="<%= displayTerms.getLastName() %>" />
	</aui:fieldset>

	<aui:fieldset>
		<aui:input inlineField="<%= true %>" name="<%= UserDisplayTerms.SCREEN_NAME %>" size="20" type="text" value="<%= displayTerms.getScreenName() %>" />

		<aui:input inlineField="<%= true %>" name="<%= UserDisplayTerms.EMAIL_ADDRESS %>" size="20" type="text" value="<%= displayTerms.getEmailAddress() %>" />
	</aui:fieldset>
</liferay-ui:search-toggle>