<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
long trashEntryId = ParamUtil.getLong(request, "trashEntryId");

long classNameId = ParamUtil.getLong(request, "classNameId");

String className = StringPool.BLANK;

if (classNameId != 0) {
	className = PortalUtil.getClassName(classNameId);
}

long classPK = ParamUtil.getLong(request, "classPK");

TrashEntry trashEntry = null;

if (trashEntryId > 0) {
	trashEntry = TrashEntryLocalServiceUtil.getEntry(trashEntryId);
}
else if (Validator.isNotNull(className) && (classPK > 0)) {
	trashEntry = TrashEntryLocalServiceUtil.fetchEntry(className, classPK);
}

if (trashEntry != null) {
	className = trashEntry.getClassName();
	classPK = trashEntry.getClassPK();
}

TrashHandler trashHandler = TrashHandlerRegistryUtil.getTrashHandler(className);

TrashRenderer trashRenderer = trashHandler.getTrashRenderer(classPK);
%>

<liferay-asset:asset-display
	renderer="<%= trashRenderer %>"
/>