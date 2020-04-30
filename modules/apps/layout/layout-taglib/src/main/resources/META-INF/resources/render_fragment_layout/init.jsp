<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%@ page import="com.liferay.fragment.constants.FragmentActionKeys" %><%@
page import="com.liferay.fragment.model.FragmentEntryLink" %><%@
page import="com.liferay.fragment.renderer.DefaultFragmentRendererContext" %><%@
page import="com.liferay.fragment.renderer.FragmentRendererController" %><%@
page import="com.liferay.fragment.service.FragmentEntryLinkLocalServiceUtil" %><%@
page import="com.liferay.layout.taglib.internal.display.context.RenderFragmentLayoutDisplayContext" %><%@
page import="com.liferay.layout.util.structure.CollectionItemLayoutStructureItem" %><%@
page import="com.liferay.layout.util.structure.CollectionLayoutStructureItem" %><%@
page import="com.liferay.layout.util.structure.ColumnLayoutStructureItem" %><%@
page import="com.liferay.layout.util.structure.ContainerLayoutStructureItem" %><%@
page import="com.liferay.layout.util.structure.DropZoneLayoutStructureItem" %><%@
page import="com.liferay.layout.util.structure.FragmentLayoutStructureItem" %><%@
page import="com.liferay.layout.util.structure.LayoutStructure" %><%@
page import="com.liferay.layout.util.structure.LayoutStructureItem" %><%@
page import="com.liferay.layout.util.structure.RootLayoutStructureItem" %><%@
page import="com.liferay.layout.util.structure.RowLayoutStructureItem" %><%@
page import="com.liferay.petra.string.StringBundler" %><%@
page import="com.liferay.petra.string.StringPool" %><%@
page import="com.liferay.portal.kernel.util.WebKeys" %>

<%@ page import="java.util.List" %><%@
page import="java.util.Map" %><%@
page import="java.util.Objects" %>