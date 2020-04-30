<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/discussion/init.jsp" %>

<%
String contents = GetterUtil.getString(request.getAttribute("liferay-comment:editor:contents"));
String name = GetterUtil.getString(request.getAttribute("liferay-comment:editor:name"));
String onChangeMethod = GetterUtil.getString(request.getAttribute("liferay-comment:editor:onChangeMethod"));
String placeholder = GetterUtil.getString(request.getAttribute("liferay-comment:editor:placeholder"));
%>

<liferay-editor:editor
	autoCreate="<%= true %>"
	configKey="commentEditor"
	contents="<%= contents %>"
	cssClass="form-control"
	editorName='<%= PropsUtil.get("editor.wysiwyg.portal-web.docroot.html.taglib.ui.discussion.jsp") %>'
	name="<%= name %>"
	onChangeMethod="<%= onChangeMethod %>"
	placeholder="<%= placeholder %>"
	showSource="<%= false %>"
	skipEditorLoading="<%= true %>"
/>