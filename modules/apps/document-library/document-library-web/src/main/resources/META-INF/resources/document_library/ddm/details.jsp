<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/document_library/init.jsp" %>

<%
DLFileEntryType fileEntryType = (DLFileEntryType)request.getAttribute(WebKeys.DOCUMENT_LIBRARY_FILE_ENTRY_TYPE);

com.liferay.dynamic.data.mapping.model.DDMStructure ddmStructure = (com.liferay.dynamic.data.mapping.model.DDMStructure)request.getAttribute(WebKeys.DOCUMENT_LIBRARY_DYNAMIC_DATA_MAPPING_STRUCTURE);
%>

<aui:model-context bean="<%= fileEntryType %>" model="<%= DLFileEntryType.class %>" />

<aui:field-wrapper>
	<c:if test="<%= (ddmStructure != null) && (ddmStructure.getGroupId() != scopeGroupId) %>">
		<div class="alert alert-warning">
			<liferay-ui:message key="this-document-type-does-not-belong-to-this-site.-you-may-affect-other-sites-if-you-edit-this-document-type" />
		</div>
	</c:if>
</aui:field-wrapper>

<aui:input name="name" />

<aui:input name="description" />