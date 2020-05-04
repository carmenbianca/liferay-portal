/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

(function() {
	// eslint-disable-next-line no-control-regex
	var REGEX_BBCODE = /(?:\[((?:[a-z]|\*){1,16})(?:[=\s]([^\x00-\x1F'<>[\]]{1,2083}))?\])|(?:\[\/([a-z]{1,16})\])/gi;

	var Lexer = function(data) {
		var instance = this;

		instance._data = data;
	};

	Lexer.prototype = {
		constructor: Lexer,

		getLastIndex() {
			return REGEX_BBCODE.lastIndex;
		},

		getNextToken() {
			var instance = this;

			return REGEX_BBCODE.exec(instance._data);
		},
	};

	Liferay.BBCodeLexer = Lexer;
})();
