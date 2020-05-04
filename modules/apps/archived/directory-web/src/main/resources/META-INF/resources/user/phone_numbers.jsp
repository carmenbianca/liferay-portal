<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
List<Organization> organizations = (List<Organization>)request.getAttribute("user.organizations");

String className = (String)request.getAttribute("phones.className");
long classPK = (Long)request.getAttribute("phones.classPK");

List<Phone> personalPhones = Collections.emptyList();
List<Phone> organizationPhones = new ArrayList<Phone>();

if (classPK > 0) {
	personalPhones = PhoneServiceUtil.getPhones(className, classPK);
}

for (int i = 0; i < organizations.size(); i++) {
	try {
		organizationPhones.addAll(PhoneServiceUtil.getPhones(Organization.class.getName(), organizations.get(i).getOrganizationId()));
	}
	catch (Exception e) {
	}
}
%>

<c:if test="<%= !personalPhones.isEmpty() || !organizationPhones.isEmpty() %>">
	<h3 class="icon-phone-sign"><liferay-ui:message key="phones" /></h3>

	<c:if test="<%= !organizationPhones.isEmpty() %>">
		<h4><liferay-ui:message key="organization-phones" /></h4>

		<ul class="property-list">

			<%
			for (Phone phone : organizationPhones) {
			%>

				<li class="<%= (phone.isPrimary() && !organizationPhones.isEmpty()) ? "icon-star" : StringPool.BLANK %>">
					<%= HtmlUtil.escape(phone.getNumber()) %> <%= phone.getExtension() %> <%= LanguageUtil.get(request, phone.getType().getName()) %>
				</li>

			<%
			}
			%>

		</ul>
	</c:if>

	<c:if test="<%= !personalPhones.isEmpty() %>">
		<h4><liferay-ui:message key="personal-phones" /></h4>

		<ul class="property-list">

			<%
			for (Phone phone : personalPhones) {
			%>

				<li class="<%= (phone.isPrimary() && !personalPhones.isEmpty()) ? "icon-star" : StringPool.BLANK %>">
					<%= HtmlUtil.escape(phone.getNumber()) %> <%= phone.getExtension() %> <%= LanguageUtil.get(request, phone.getType().getName()) %>
				</li>

			<%
			}
			%>

		</ul>
	</c:if>
</c:if>