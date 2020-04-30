<%--
/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/html/taglib/ui/table_iterator/init.jsp" %>

<%
int mod = list.size() % rowLength;

if (mod > 0) {
	for (int i = mod; i < rowLength; i++) {
%>

		<td></td>

	<%
	}
	%>

	</tr>

<%
}
%>

</table>