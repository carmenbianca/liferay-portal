<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
FragmentRendererController fragmentRendererController = (FragmentRendererController)request.getAttribute(FragmentActionKeys.FRAGMENT_RENDERER_CONTROLLER);

RenderFragmentEntryDisplayContext renderFragmentEntryDisplayContext = new RenderFragmentEntryDisplayContext(request);
%>

<%= fragmentRendererController.render(renderFragmentEntryDisplayContext.getDefaultFragmentRendererContext(), request, response) %>