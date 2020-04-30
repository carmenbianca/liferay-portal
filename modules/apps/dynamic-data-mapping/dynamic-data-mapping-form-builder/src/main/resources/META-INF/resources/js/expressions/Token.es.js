/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

/**
 * Token.
 */

class Token {
	constructor(type, value) {
		this.type = type;
		this.value = value;
	}
}

Token.FUNCTION = 'Function';
Token.LEFT_PARENTHESIS = 'Left Parenthesis';
Token.LITERAL = 'Literal';
Token.OPERATOR = 'Operator';
Token.RIGHT_PARENTHESIS = 'Right Parenthesis';
Token.VARIABLE = 'Variable';

export default Token;
