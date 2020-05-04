<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<%@ page import="com.liferay.document.library.kernel.util.ImageProcessorUtil" %><%@
page import="com.liferay.document.library.kernel.util.PDFProcessorUtil" %><%@
page import="com.liferay.document.library.kernel.util.VideoProcessorUtil" %><%@
page import="com.liferay.document.library.util.DLURLHelperUtil" %><%@
page import="com.liferay.petra.string.StringPool" %><%@
page import="com.liferay.portal.kernel.repository.model.FileEntry" %><%@
page import="com.liferay.portal.kernel.repository.model.FileVersion" %><%@
page import="com.liferay.portal.kernel.util.WebKeys" %>

<%@ page import="java.util.Objects" %>

<liferay-theme:defineObjects />