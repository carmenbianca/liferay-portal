<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/document_library/init.jsp" %>

<div class="form-search">
	<liferay-ui:input-search
		placeholder='<%= LanguageUtil.get(request, "keywords") %>'
		title='<%= LanguageUtil.get(request, "search-documents") %>'
	/>
</div>