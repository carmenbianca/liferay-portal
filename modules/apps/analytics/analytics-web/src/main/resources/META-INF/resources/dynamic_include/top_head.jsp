<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String analyticsClientConfig = (String)request.getAttribute(AnalyticsWebKeys.ANALYTICS_CLIENT_CONFIG);
%>

<script data-senna-track="temporary" type="text/javascript">
	var runMiddlewares = function() {
		<liferay-util:dynamic-include key="/dynamic_include/top_head.jsp#analytics" />
	};
</script>

<script data-senna-track="permanent" id="liferayAnalyticsScript" type="text/javascript">
	(function(u, c, a, m, o, l) {
		o = 'script';
		l = document;
		a = l.createElement(o);
		m = l.getElementsByTagName(o)[0];
		a.async = 1;
		a.src = u;
		a.onload = c;
		m.parentNode.insertBefore(a, m);
	})('https://analytics-js-cdn.liferay.com', function() {
		var config = <%= analyticsClientConfig %>;

		Analytics.create(config);

		Analytics.registerMiddleware(function(request) {
			request.context.canonicalUrl = themeDisplay.getCanonicalURL();
			request.context.groupId = themeDisplay.getScopeGroupIdOrLiveGroupId();

			return request;
		});

		if (themeDisplay.isSignedIn()) {
			Analytics.setIdentity({
				email: themeDisplay.getUserEmailAddress(),
				name: themeDisplay.getUserName(),
			});
		}

		runMiddlewares();

		Analytics.send('pageViewed', 'Page');

		<c:if test="<%= GetterUtil.getBoolean(PropsUtil.get(PropsKeys.JAVASCRIPT_SINGLE_PAGE_APPLICATION_ENABLED)) %>">
			Liferay.on('endNavigate', function(event) {
				Analytics.dispose();

				if (!themeDisplay.isControlPanel()) {
					Analytics.create(config);

					Analytics.registerMiddleware(function(request) {
						request.context.canonicalUrl = themeDisplay.getCanonicalURL();
						request.context.groupId = themeDisplay.getScopeGroupIdOrLiveGroupId();

						return request;
					});

					if (themeDisplay.isSignedIn()) {
						Analytics.setIdentity({
							email: themeDisplay.getUserEmailAddress(),
							name: themeDisplay.getUserName(),
						});
					}

					runMiddlewares();

					Analytics.send('pageViewed', 'Page', {page: event.path});
				}
			});
		</c:if>
	});
</script>