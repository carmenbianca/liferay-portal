<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String className = (String)request.getAttribute("contact_information.jsp-className");
long classPK = (long)request.getAttribute("contact_information.jsp-classPK");

long addressId = ParamUtil.getLong(request, "addressId");
%>

<liferay-ui:icon-menu
	direction="left-side"
	icon="<%= StringPool.BLANK %>"
	markupView="lexicon"
	message="<%= StringPool.BLANK %>"
	showWhenSingleIcon="<%= true %>"
>

	<%
	PortletURL editURL = liferayPortletResponse.createRenderURL();

	editURL.setParameter("mvcPath", "/common/edit_address.jsp");
	editURL.setParameter("redirect", currentURL);
	editURL.setParameter("className", className);
	editURL.setParameter("classPK", String.valueOf(classPK));
	editURL.setParameter("primaryKey", String.valueOf(addressId));
	%>

	<liferay-ui:icon
		message="edit"
		url="<%= editURL.toString() %>"
	/>

	<%
	PortletURL portletURL = renderResponse.createActionURL();

	portletURL.setParameter(ActionRequest.ACTION_NAME, "/users_admin/update_contact_information");
	portletURL.setParameter("redirect", currentURL);
	portletURL.setParameter("className", className);
	portletURL.setParameter("classPK", String.valueOf(classPK));
	portletURL.setParameter("listType", ListTypeConstants.ADDRESS);
	portletURL.setParameter("primaryKey", String.valueOf(addressId));

	PortletURL makePrimaryURL = PortletURLUtil.clone(portletURL, renderResponse);

	makePrimaryURL.setParameter(Constants.CMD, "makePrimary");
	%>

	<liferay-ui:icon
		message="make-primary"
		url="<%= makePrimaryURL.toString() %>"
	/>

	<%
	PortletURL removeAddressURL = PortletURLUtil.clone(portletURL, renderResponse);

	removeAddressURL.setParameter(Constants.CMD, Constants.DELETE);
	%>

	<liferay-ui:icon
		message="remove"
		url="<%= removeAddressURL.toString() %>"
	/>
</liferay-ui:icon-menu>