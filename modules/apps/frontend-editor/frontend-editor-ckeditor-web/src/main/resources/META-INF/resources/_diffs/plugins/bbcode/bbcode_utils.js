/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

(function() {
	var A = AUI();

	var LString = A.Lang.String;

	var entities = A.merge(Liferay.Util.MAP_HTML_CHARS_ESCAPED, {
		'(': '&#40;',
		')': '&#41;',
		'[': '&#91;',
		']': '&#93;',
	});

	var BBCodeUtil = Liferay.namespace('BBCodeUtil');

	BBCodeUtil.escape = A.rbind('escapeHTML', LString, true, entities);
	BBCodeUtil.unescape = A.rbind('unescapeHTML', LString, entities);
})();
