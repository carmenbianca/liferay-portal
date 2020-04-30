<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<portlet:actionURL name="emptyTrash" var="emptyTrashURL">
	<portlet:param name="groupId" value="<%= String.valueOf(themeDisplay.getScopeGroupId()) %>" />
</portlet:actionURL>

<liferay-util:buffer
	var="onClickFn"
>
	if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-empty-the-recycle-bin" />')) {
		submitForm(document.hrefFm, '<%= emptyTrashURL.toString() %>');
	}
</liferay-util:buffer>

<liferay-ui:icon
	id="emptyRecycleBinButton"
	message="empty-the-recycle-bin"
	onClick="<%= onClickFn %>"
	url="javascript:;"
/>