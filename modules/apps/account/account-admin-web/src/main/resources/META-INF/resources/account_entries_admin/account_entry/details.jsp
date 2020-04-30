<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
AccountEntryDisplay accountEntryDisplay = (AccountEntryDisplay)request.getAttribute(AccountWebKeys.ACCOUNT_ENTRY_DISPLAY);

String backURL = ParamUtil.getString(request, "backURL", String.valueOf(renderResponse.createRenderURL()));

portletDisplay.setShowBackIcon(true);
portletDisplay.setURLBack(backURL);

renderResponse.setTitle((accountEntryDisplay == null) ? LanguageUtil.get(request, "add-account") : LanguageUtil.format(request, "edit-x", accountEntryDisplay.getName(), false));
%>

<portlet:actionURL name="/account_admin/edit_account_entry" var="editAccountURL" />

<liferay-frontend:edit-form
	action="<%= editAccountURL %>"
>
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= (accountEntryDisplay == null) ? Constants.ADD : Constants.UPDATE %>" />
	<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />
	<aui:input name="accountEntryId" type="hidden" value='<%= (accountEntryDisplay == null) ? "0" : String.valueOf(accountEntryDisplay.getAccountEntryId()) %>' />

	<liferay-frontend:edit-form-body>
		<h2 class="sheet-title">
			<%= LanguageUtil.get(request, "information") %>
		</h2>

		<liferay-frontend:fieldset-group>
			<liferay-util:include page="/account_entries_admin/account_entry/display_data.jsp" servletContext="<%= application %>" />

			<liferay-util:include page="/account_entries_admin/account_entry/domains.jsp" servletContext="<%= application %>" />

			<liferay-util:include page="/account_entries_admin/account_entry/parent_account_entry.jsp" servletContext="<%= application %>" />
		</liferay-frontend:fieldset-group>
	</liferay-frontend:edit-form-body>

	<liferay-frontend:edit-form-footer>
		<aui:button type="submit" />

		<aui:button href="<%= backURL %>" type="cancel" />
	</liferay-frontend:edit-form-footer>
</liferay-frontend:edit-form>