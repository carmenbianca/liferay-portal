<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
Group group = (Group)request.getAttribute("site.group");

LayoutSet privateLayoutSet = LayoutSetLocalServiceUtil.getLayoutSet(group.getGroupId(), true);
LayoutSet publicLayoutSet = LayoutSetLocalServiceUtil.getLayoutSet(group.getGroupId(), false);

LayoutSetPrototype privateLayoutSetPrototype = null;

boolean privateLayoutSetPrototypeLinkEnabled = false;

LayoutSetPrototype publicLayoutSetPrototype = null;

boolean publicLayoutSetPrototypeLinkEnabled = false;

if (Validator.isNotNull(privateLayoutSet.getLayoutSetPrototypeUuid())) {
	privateLayoutSetPrototype = LayoutSetPrototypeLocalServiceUtil.getLayoutSetPrototypeByUuidAndCompanyId(privateLayoutSet.getLayoutSetPrototypeUuid(), company.getCompanyId());

	privateLayoutSetPrototypeLinkEnabled = privateLayoutSet.isLayoutSetPrototypeLinkEnabled();
}

if (Validator.isNotNull(publicLayoutSet.getLayoutSetPrototypeUuid())) {
	publicLayoutSetPrototype = LayoutSetPrototypeLocalServiceUtil.getLayoutSetPrototypeByUuidAndCompanyId(publicLayoutSet.getLayoutSetPrototypeUuid(), company.getCompanyId());

	publicLayoutSetPrototypeLinkEnabled = publicLayoutSet.isLayoutSetPrototypeLinkEnabled();
}
%>

<liferay-ui:error-marker
	key="<%= WebKeys.ERROR_SECTION %>"
	value="site-tempate"
/>

<c:if test="<%= publicLayoutSetPrototype != null %>">
	<aui:fieldset label="public-site-template">
		<c:choose>
			<c:when test="<%= publicLayoutSetPrototypeLinkEnabled %>">

				<%
				boolean layoutsUpdateable = GetterUtil.getBoolean(publicLayoutSetPrototype.getSettingsProperty("layoutsUpdateable"), true);
				%>

				<liferay-ui:message arguments="<%= new Object[] {HtmlUtil.escape(publicLayoutSetPrototype.getName(locale))} %>" key="these-pages-are-linked-to-site-template-x" translateArguments="<%= false %>" />

				<aui:field-wrapper label="site-template-settings">
					<aui:input disabled="<%= true %>" label="active" name="siteTemplateActive" type="checkbox" value="<%= publicLayoutSetPrototype.isActive() %>" />
					<aui:input disabled="<%= true %>" label="site-template-allows-modifications" name="siteTemplateAllowsModifications" type="checkbox" value="<%= layoutsUpdateable %>" />
				</aui:field-wrapper>
			</c:when>
			<c:otherwise>
				<liferay-ui:message arguments='<%= new Object[] {"<em>" + HtmlUtil.escape(publicLayoutSetPrototype.getName(locale)) + "</em>"} %>' key="these-pages-are-linked-to-site-template-x-without-propagation-of-changes" translateArguments="<%= false %>" />
			</c:otherwise>
		</c:choose>
	</aui:fieldset>
</c:if>

<c:if test="<%= privateLayoutSetPrototype != null %>">
	<aui:fieldset label="private-site-template">
		<c:choose>
			<c:when test="<%= privateLayoutSetPrototypeLinkEnabled %>">

				<%
				boolean layoutsUpdateable = GetterUtil.getBoolean(privateLayoutSetPrototype.getSettingsProperty("layoutsUpdateable"), true);
				%>

				<liferay-ui:message arguments="<%= new Object[] {HtmlUtil.escape(privateLayoutSetPrototype.getName(locale))} %>" key="these-pages-are-linked-to-site-template-x" translateArguments="<%= false %>" />

				<aui:field-wrapper label="site-template-settings">
					<aui:input disabled="<%= true %>" label="active" name="siteTemplateActive" type="checkbox" value="<%= privateLayoutSetPrototype.isActive() %>" />
					<aui:input disabled="<%= true %>" label="site-template-allows-modifications" name="siteTemplateAllowsModifications" type="checkbox" value="<%= layoutsUpdateable %>" />
				</aui:field-wrapper>
			</c:when>
			<c:otherwise>
				<liferay-ui:message arguments='<%= new Object[] {"<em>" + HtmlUtil.escape(privateLayoutSetPrototype.getName(locale)) + "</em>"} %>' key="these-pages-are-linked-to-site-template-x-without-propagation-of-changes" translateArguments="<%= false %>" />
			</c:otherwise>
		</c:choose>
	</aui:fieldset>
</c:if>