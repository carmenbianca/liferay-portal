<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/html/common/themes/init.jsp" %>

<portlet:defineObjects />

<%
String tilesPortletContent = GetterUtil.getString(request.getAttribute(WebKeys.PORTLET_CONTENT_JSP));

Portlet portlet = (Portlet)request.getAttribute(WebKeys.RENDER_PORTLET);

PortletPreferences portletSetup = portletDisplay.getPortletSetup();

LiferayRenderResponse liferayRenderResponse = (LiferayRenderResponse)LiferayPortletUtil.getLiferayPortletResponse(renderResponse);

// Portlet title

String portletTitle = PortletConfigurationUtil.getPortletTitle(portletSetup, themeDisplay.getLanguageId());

if (portletDisplay.isActive() && Validator.isNull(portletTitle)) {
	portletTitle = liferayRenderResponse.getTitle();
}

if (Validator.isNull(portletTitle)) {
	portletTitle = PortalUtil.getPortletTitle(portlet, application, locale);
}

portletDisplay.setTitle(portletTitle);

// Portlet description

if (Validator.isNull(portletDisplay.getDescription())) {
	String portletDescription = PortalUtil.getPortletDescription(portlet, application, locale);

	portletDisplay.setDescription(portletDescription);
}

Group group = layout.getGroup();
%>

<c:choose>
	<c:when test="<%= themeDisplay.isStateExclusive() %>">
		<%@ include file="/html/common/themes/portlet_content_wrapper.jspf" %>
	</c:when>
	<c:when test="<%= themeDisplay.isStatePopUp() %>">
		<div class="portlet-body">
			<c:if test='<%= !tilesPortletContent.endsWith("/error.jsp") %>'>
				<liferay-theme:portlet-messages
					group="<%= group %>"
					portlet="<%= portlet %>"
				/>
			</c:if>

			<c:choose>
				<c:when test="<%= Validator.isNotNull(tilesPortletContent) %>">
					<liferay-util:include page="<%= StrutsUtil.TEXT_HTML_DIR + tilesPortletContent %>" />
				</c:when>
				<c:otherwise>

					<%
					pageContext.getOut().print(renderRequest.getAttribute(WebKeys.PORTLET_CONTENT));
					%>

				</c:otherwise>
			</c:choose>
		</div>
	</c:when>
	<c:otherwise>
		<liferay-theme:wrap-portlet
			page="portlet.jsp"
		>
			<div class="<%= portletDisplay.isStateMin() ? "hide" : "" %> portlet-content-container">
				<%@ include file="/html/common/themes/portlet_content_wrapper.jspf" %>
			</div>
		</liferay-theme:wrap-portlet>
	</c:otherwise>
</c:choose>