<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String className = (String)request.getAttribute("addresses.className");
long classPK = (Long)request.getAttribute("addresses.classPK");

List<Address> addresses = Collections.emptyList();

if (classPK > 0) {
	addresses = AddressServiceUtil.getAddresses(className, classPK);
}
%>

<c:if test="<%= !addresses.isEmpty() %>">
	<h3 class="icon-home"><liferay-ui:message key="address" /></h3>

	<ul class="property-list">

		<%
		for (Address address : addresses) {
		%>

			<li class="<%= (address.isPrimary() && !addresses.isEmpty()) ? "icon-star" : StringPool.BLANK %>">
				<%@ include file="/common/addresses_address.jspf" %>
			</li>

		<%
		}
		%>

	</ul>
</c:if>