<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/process_error/init.jsp" %>

<c:if test="<%= authException %>">
	<%@ include file="/process_error/error/error_auth_exception.jspf" %>
</c:if>

<c:if test="<%= duplicateLockException %>">
	<%@ include file="/process_error/error/error_duplicate_lock_exception.jspf" %>
</c:if>

<c:if test="<%= illegalArgumentException %>">
	<%@ include file="/process_error/error/error_illegal_argument_exception.jspf" %>
</c:if>

<c:if test="<%= layoutPrototypeException %>">
	<%@ include file="/process_error/error/error_layout_prototype_exception.jspf" %>
</c:if>

<c:if test="<%= noSuchExceptions %>">
	<%@ include file="/process_error/error/error_no_such_exceptions.jspf" %>
</c:if>

<c:if test="<%= remoteExportException %>">
	<%@ include file="/process_error/error/error_remote_export_exception.jspf" %>
</c:if>

<c:if test="<%= remoteOptionsException %>">
	<%@ include file="/process_error/error/error_remote_options_exception.jspf" %>
</c:if>

<c:if test="<%= systemException %>">
	<%@ include file="/process_error/error/error_system_exception.jspf" %>
</c:if>