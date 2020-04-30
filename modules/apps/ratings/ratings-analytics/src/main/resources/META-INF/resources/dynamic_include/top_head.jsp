<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/dynamic_include/init.jsp" %>

<aui:script sandbox="<%= true %>">
	var onVote = function(event) {
		if (window.Analytics) {
			Analytics.send('VOTE', 'Ratings', {
				className: event.className,
				classPK: event.classPK,
				ratingType: event.ratingType,
				score: event.score,
			});
		}
	};

	var onDestroyPortlet = function() {
		Liferay.detach('ratings:vote', onVote);
		Liferay.detach('destroyPortlet', onDestroyPortlet);
	};

	Liferay.on('ratings:vote', onVote);
	Liferay.on('destroyPortlet', onDestroyPortlet);
</aui:script>