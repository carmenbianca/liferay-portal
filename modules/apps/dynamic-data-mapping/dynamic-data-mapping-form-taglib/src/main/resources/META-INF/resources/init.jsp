<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

@generated
--%>

<%@ page import="com.liferay.portal.json.JSONFactoryImpl" %><%@
page import="com.liferay.portal.kernel.json.JSONFactoryUtil" %><%@
page import="com.liferay.portal.kernel.util.GetterUtil" %><%@
page import="com.liferay.portal.kernel.util.StringUtil" %>

<%@ page import="java.util.ArrayList" %><%@
page import="java.util.HashMap" %><%@
page import="java.util.Map" %>

<%!
private static ArrayList<Object> _toArrayList(Object obj) {
	return (ArrayList<Object>)_deserialize(obj);
}

private static HashMap<String, Object> _toHashMap(Object obj) {
	return (HashMap<String, Object>)_deserialize(obj);
}

public static void _initJSONFactoryUtil() {
	if (JSONFactoryUtil.getJSONFactory() == null) {
		(new JSONFactoryUtil()).setJSONFactory(new JSONFactoryImpl());
	}
}

private static Object _deserialize(Object obj) {
	if (obj != null) {
		String json = JSONFactoryUtil.looseSerialize(obj);

		json = StringUtil.unquote(json);

		return JSONFactoryUtil.looseDeserialize(json);
	}

	return null;
}
%>

<%
_initJSONFactoryUtil();
%>