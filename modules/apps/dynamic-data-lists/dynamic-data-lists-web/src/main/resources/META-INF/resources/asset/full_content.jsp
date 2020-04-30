<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/asset/init.jsp" %>

<%
DDLRecordVersion recordVersion = (DDLRecordVersion)request.getAttribute(DDLWebKeys.DYNAMIC_DATA_LISTS_RECORD_VERSION);

DDLRecord record = (DDLRecord)request.getAttribute(DDLWebKeys.DYNAMIC_DATA_LISTS_RECORD);

DDLRecordSet recordSet = record.getRecordSet();

DDMStructure ddmStructure = recordSet.getDDMStructure();

DDMFormValues ddmFormValues = recordVersion.getDDMFormValues();
%>

<liferay-ddm:html
	classNameId="<%= PortalUtil.getClassNameId(DDMStructure.class) %>"
	classPK="<%= ddmStructure.getPrimaryKey() %>"
	ddmFormValues="<%= ddmFormValues %>"
	groupId="<%= ddmStructure.getGroupId() %>"
	readOnly="<%= true %>"
	requestedLocale="<%= locale %>"
/>