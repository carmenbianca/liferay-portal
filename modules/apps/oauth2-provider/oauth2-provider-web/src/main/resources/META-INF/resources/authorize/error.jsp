<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/authorize/init.jsp" %>

<liferay-ui:error-header />

<liferay-ui:error key="clientIdInvalid" message="invalid-client-id" />

<liferay-ui:error key="redirectURIMissing" message="missing-redirect-uri" />

<liferay-ui:error-principal />