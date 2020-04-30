<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/dynamic_include/init.jsp" %>

<aui:script sandbox="<%= true %>">
	var onDestroyPortlet = function() {
		Liferay.detach('messagePosted', onMessagePosted);
		Liferay.detach('destroyPortlet', onDestroyPortlet);
	};

	Liferay.on('destroyPortlet', onDestroyPortlet);

	var onMessagePosted = function(event) {
		if (window.Analytics) {
			Analytics.send('posted', 'Comment', {
				className: event.className,
				classPK: event.classPK,
				commentId: event.commentId,
				text: event.text,
			});
		}
	};

	Liferay.on('messagePosted', onMessagePosted);
</aui:script>