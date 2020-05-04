<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/info_bar/init.jsp" %>

			</div>

			<c:if test="<%= Validator.isNotNull(buttons) %>">
				<div class="management-bar-header-right">
					<%= buttons %>
				</div>
			</c:if>
		</div>
	</div>
</div>

<c:if test="<%= fixed %>">
	<aui:script require="metal-affix/src/Affix">
		new metalAffixSrcAffix.default({
			element: '.info-bar-container',
			offsetTop: 15,
		});
	</aui:script>
</c:if>