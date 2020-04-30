<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/document_library/init.jsp" %>

<div>

	<%
	Map<String, Object> data =
		HashMapBuilder.<String, Object>put(
			"dlVersionNumberIncreaseValues",
			HashMapBuilder.<String, Object>put(
				"MAJOR", DLVersionNumberIncrease.MAJOR
				).put(
					"MINOR", DLVersionNumberIncrease.MINOR
				).put(
					"NONE", DLVersionNumberIncrease.NONE
				).build()
		).put(
			"checkedOut", GetterUtil.getBoolean(request.getAttribute("edit_file_entry.jsp-checkedOut"))
		).build();
	%>

	<react:component
		data="<%= data %>"
		module="document_library/js/checkin/Checkin.es"
	/>
</div>