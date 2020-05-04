<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<aui:script require="metal-dom/src/all/dom as dom">
	function handleIframeMessage(event) {
		if (event.data) {
			var virtualDocument = document.createElement('html');

			virtualDocument.innerHTML = JSON.parse(event.data).data;

			var virtualBody = virtualDocument.querySelector('.portlet-body');

			if (virtualBody) {
				document.querySelector('.portlet-body').innerHTML =
					virtualBody.innerHTML;
			}

			dom.globalEval.runScriptsInElement(virtualBody);
		}
	}

	window.addEventListener('message', handleIframeMessage);
</aui:script>