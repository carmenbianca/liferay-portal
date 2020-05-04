<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/popover/init.jsp" %>

<c:if test="<%= Validator.isNotNull(text) %>">
	<span class="staging-taglib-popover" id="<%= domId %>">
		<span class="staging-taglib-popover-icon-holder">
			<clay:icon
				symbol="question-circle-full"
			/>
		</span>

		<div class="bs-popover-right popover">
			<div class="arrow"></div>
			<div class="inline-scroller">
				<div class="popover-header"><%= title %></div>
				<div class="popover-body">
					<p><%= text %></p>
				</div>
			</div>
		</div>
	</span>

	<aui:script use="aui-base">
		A.ready('aui-base', function(A) {
			var popoverNode = A.one('#<%= domId %>');

			var popover = popoverNode.one('.popover');

			var arrow = popover.one('.arrow');

			var dx = arrow.width();
			var dy = arrow.height() / 2;

			var iconHolderNode = popoverNode.one('.staging-taglib-popover-icon-holder');

			iconHolderNode.on('hover', function alignPopoverToIcon(event) {
				if ('visible' !== popover.get('visibility')) {
					popover.setXY([
						iconHolderNode.getX() + iconHolderNode.width() + dx,
						iconHolderNode.getY() - dy,
					]);
				}
			});
		});
	</aui:script>
</c:if>