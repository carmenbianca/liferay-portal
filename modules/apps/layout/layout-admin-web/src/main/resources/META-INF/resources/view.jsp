<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
portletDisplay.setShowStagingIcon(false);

LayoutsAdminManagementToolbarDisplayContext layoutsManagementToolbarDisplayContext = new LayoutsAdminManagementToolbarDisplayContext(request, liferayPortletRequest, liferayPortletResponse, layoutsAdminDisplayContext);
%>

<liferay-ui:success key='<%= portletDisplay.getPortletName() + "layoutUpdated" %>' message='<%= LanguageUtil.get(resourceBundle, "the-page-was-updated-succesfully") %>' />

<liferay-ui:success key="layoutPublished" message="the-page-was-published-succesfully" />

<liferay-ui:error embed="<%= false %>" exception="<%= GroupInheritContentException.class %>" message="this-page-cannot-be-deleted-and-cannot-have-child-pages-because-it-is-associated-with-a-site-template" />

<clay:management-toolbar
	displayContext="<%= layoutsManagementToolbarDisplayContext %>"
/>

<liferay-ui:error exception="<%= LayoutTypeException.class %>">

	<%
	LayoutTypeException lte = (LayoutTypeException)errorException;
	%>

	<c:if test="<%= lte.getType() == LayoutTypeException.FIRST_LAYOUT %>">
		<liferay-ui:message arguments='<%= "layout.types." + lte.getLayoutType() %>' key="the-first-page-cannot-be-of-type-x" />
	</c:if>
</liferay-ui:error>

<liferay-ui:error exception="<%= RequiredSegmentsExperienceException.MustNotDeleteSegmentsExperienceReferencedBySegmentsExperiments.class %>" message="this-page-cannot-be-deleted-because-it-has-ab-tests-in-progress" />

<aui:form cssClass="container-fluid-1280" name="fm">
	<c:choose>
		<c:when test="<%= layoutsAdminDisplayContext.hasLayouts() %>">
			<c:choose>
				<c:when test="<%= layoutsAdminDisplayContext.isSearch() %>">
					<liferay-util:include page="/flattened_view.jsp" servletContext="<%= application %>" />
				</c:when>
				<c:otherwise>

					<%
					MillerColumnsDisplayContext millerColumnsDisplayContext = (MillerColumnsDisplayContext)request.getAttribute(LayoutAdminWebKeys.MILLER_COLUMNS_DISPLAY_CONTEXT);
					%>

					<div>
						<react:component
							data="<%= millerColumnsDisplayContext.getLayoutData() %>"
							module="js/layout/Layout"
						/>
					</div>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			<liferay-frontend:empty-result-message
				actionDropdownItems="<%= layoutsAdminDisplayContext.isShowAddRootLayoutButton() ? layoutsAdminDisplayContext.getAddLayoutDropdownItems() : null %>"
				description='<%= LanguageUtil.get(request, "fortunately-it-is-very-easy-to-add-new-ones") %>'
				elementType='<%= LanguageUtil.get(request, "pages") %>'
			/>
		</c:otherwise>
	</c:choose>
</aui:form>

<liferay-frontend:component
	componentId="<%= layoutsManagementToolbarDisplayContext.getDefaultEventHandler() %>"
	module="js/LayoutsManagementToolbarDefaultEventHandler.es"
/>