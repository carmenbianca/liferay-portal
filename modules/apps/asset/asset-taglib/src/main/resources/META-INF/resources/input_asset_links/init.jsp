<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %><%@
taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page import="com.liferay.asset.kernel.model.AssetEntry" %><%@
page import="com.liferay.asset.taglib.internal.display.context.InputAssetLinksDisplayContext" %><%@
page import="com.liferay.portal.kernel.util.HtmlUtil" %><%@
page import="com.liferay.portal.kernel.util.UnicodeFormatter" %><%@
page import="com.liferay.staging.StagingGroupHelper" %><%@
page import="com.liferay.staging.StagingGroupHelperUtil" %>

<%@ page import="java.util.Map" %>

<liferay-theme:defineObjects />

<%
InputAssetLinksDisplayContext inputAssetLinksDisplayContext = new InputAssetLinksDisplayContext(pageContext);
StagingGroupHelper stagingGroupHelper = StagingGroupHelperUtil.getStagingGroupHelper();
%>