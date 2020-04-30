<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/dynamic_include/init.jsp" %>

<aui:script sandbox="<%= true %>">
	var onShare = function(data) {
		if (window.Analytics) {
			Analytics.send('shared', 'SocialBookmarks', {
				className: data.className,
				classPK: data.classPK,
				type: data.type,
				url: data.url,
			});
		}
	};

	var onDestroyPortlet = function() {
		Liferay.detach('socialBookmarks:share', onShare);
		Liferay.detach('destroyPortlet', onDestroyPortlet);
	};

	Liferay.on('socialBookmarks:share', onShare);
	Liferay.on('destroyPortlet', onDestroyPortlet);
</aui:script>