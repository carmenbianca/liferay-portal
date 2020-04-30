<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/export_import_entity_search_container_mapping/init.jsp" %>

<div id="<portlet:namespace /><%= searchContainerMappingId %>">

	<%
	List<ResultRow> resultRows = searchContainer.getResultRows();

	for (ResultRow resultRow : resultRows) {
		StagedModel stagedModel = (StagedModel)resultRow.getObject();

		Map<String, Object> data = HashMapBuilder.<String, Object>put(
			"classNameId", ExportImportClassedModelUtil.getClassNameId(stagedModel)
		).put(
			"groupId", BeanPropertiesUtil.getLong(stagedModel, "groupId")
		).put(
			"rowPK", resultRow.getPrimaryKey()
		).put(
			"uuid", stagedModel.getUuid()
		).build();
	%>

		<div <%= HtmlUtil.buildData(data) %>></div>

	<%
	}
	%>

</div>