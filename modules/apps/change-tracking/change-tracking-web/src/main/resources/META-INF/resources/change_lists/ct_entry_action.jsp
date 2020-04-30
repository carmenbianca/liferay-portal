<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/change_lists/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

CTEntry ctEntry = (CTEntry)row.getObject();

ViewChangesDisplayContext viewChangesDisplayContext = (ViewChangesDisplayContext)request.getAttribute(CTWebKeys.VIEW_CHANGES_DISPLAY_CONTEXT);

CTCollection ctCollection = viewChangesDisplayContext.getCtCollection();
%>

<liferay-ui:icon-menu
	direction="left-side"
	icon="<%= StringPool.BLANK %>"
	markupView="lexicon"
	message="<%= StringPool.BLANK %>"
	showWhenSingleIcon="<%= true %>"
>

	<%
	String editURL = ctDisplayRendererRegistry.getEditURL(request, ctEntry);
	%>

	<c:if test="<%= Validator.isNotNull(editURL) && (ctCollection.getCtCollectionId() == changeListsDisplayContext.getCtCollectionId()) %>">
		<liferay-ui:icon
			message="edit"
			url="<%= editURL %>"
		/>
	</c:if>

	<%
	PortletURL diffURL = renderResponse.createRenderURL();

	diffURL.setParameter("mvcRenderCommandName", "/change_lists/view_diff");
	diffURL.setParameter("ctEntryId", String.valueOf(ctEntry.getCtEntryId()));

	diffURL.setWindowState(LiferayWindowState.POP_UP);
	%>

	<liferay-ui:icon
		message="view-diff"
		url='<%= StringBundler.concat("javascript:Liferay.Util.openWindow({dialog: {destroyOnHide: true}, title: '", ctDisplayRendererRegistry.getEntryTitle(ctEntry, request), "', uri: '", diffURL.toString(), "'});") %>'
	/>
</liferay-ui:icon-menu>