<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/change_lists/init.jsp" %>

<div class="container-fluid">

	<%
	long ctEntryId = ParamUtil.getLong(request, "ctEntryId");

	CTEntry ctEntry = CTEntryLocalServiceUtil.fetchCTEntry(ctEntryId);

	ctDisplayRendererRegistry.renderCTEntry(request, response, ctEntry, ctEntry.getCtCollectionId());
	%>

</div>