<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/react" prefix="react" %>

<%@ page import="com.liferay.bulk.selection.BulkSelectionRunner" %><%@
page import="com.liferay.document.library.configuration.DLConfiguration" %><%@
page import="com.liferay.document.library.kernel.model.DLVersionNumberIncrease" %><%@
page import="com.liferay.document.library.web.internal.bulk.selection.BulkSelectionRunnerUtil" %><%@
page import="com.liferay.document.library.web.internal.display.context.DLEditFileEntryTypeDisplayContext" %><%@
page import="com.liferay.document.library.web.internal.display.context.DLEditFileShortcutDisplayContext" %><%@
page import="com.liferay.document.library.web.internal.display.context.FolderActionDisplayContext" %><%@
page import="com.liferay.document.library.web.internal.search.DDMStructureRowChecker" %><%@
page import="com.liferay.document.library.web.internal.util.DLAssetHelperUtil" %><%@
page import="com.liferay.document.library.web.internal.util.RepositoryClassDefinitionUtil" %><%@
page import="com.liferay.dynamic.data.mapping.exception.RequiredStructureException" %><%@
page import="com.liferay.dynamic.data.mapping.util.DDMFormValuesToMapConverter" %><%@
page import="com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemList" %><%@
page import="com.liferay.portal.kernel.lock.Lock" %><%@
page import="com.liferay.portal.kernel.module.configuration.ConfigurationProviderUtil" %><%@
page import="com.liferay.portal.kernel.util.LinkedHashMapBuilder" %><%@
page import="com.liferay.portal.kernel.util.LocaleUtil" %><%@
page import="com.liferay.portal.kernel.uuid.PortalUUIDUtil" %><%@
page import="com.liferay.portal.util.RepositoryUtil" %>

<%@ page import="java.util.Collections" %><%@
page import="java.util.Objects" %>

<%
DLRequestHelper dlRequestHelper = new DLRequestHelper(request);

String portletId = dlRequestHelper.getResourcePortletId();

portletName = dlRequestHelper.getResourcePortletName();

DLAdminDisplayContext dlAdminDisplayContext = dlAdminDisplayContextProvider.getDLAdminDisplayContext(request, response);

DLAdminManagementToolbarDisplayContext dlAdminManagementToolbarDisplayContext = dlAdminDisplayContextProvider.getDLAdminManagementToolbarDisplayContext(request, response);

DLConfiguration dlConfiguration = ConfigurationProviderUtil.getSystemConfiguration(DLConfiguration.class);
DLGroupServiceSettings dlGroupServiceSettings = dlRequestHelper.getDLGroupServiceSettings();
DLPortletInstanceSettings dlPortletInstanceSettings = dlRequestHelper.getDLPortletInstanceSettings();

long rootFolderId = dlAdminDisplayContext.getRootFolderId();
String rootFolderName = dlAdminDisplayContext.getRootFolderName();

boolean showComments = ParamUtil.getBoolean(request, "showComments", true);
boolean showHeader = ParamUtil.getBoolean(request, "showHeader", true);
%>

<%@ include file="/document_library/init-ext.jsp" %>