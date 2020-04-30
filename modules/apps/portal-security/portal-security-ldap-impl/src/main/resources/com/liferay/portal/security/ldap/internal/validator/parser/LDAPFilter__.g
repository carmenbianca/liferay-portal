lexer grammar LDAPFilter;
options {
  language=Java;

}
@members {
	@Override
	public void reportError(RecognitionException e) {
		throw new RuntimeException(e);
	}
}
@header {
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.ldap.internal.validator.parser;
}

T11 : '(' ;
T12 : ')' ;
T13 : '&' ;
T14 : '|' ;
T15 : '!' ;
T16 : '=' ;
T17 : '~=' ;
T18 : '>=' ;
T19 : '<=' ;
T20 : ':dn' ;
T21 : ':=' ;
T22 : '*' ;
T23 : ';' ;

// $ANTLR src "LDAPFilter.g" 152
fragment ASCII_LETTER
	: 'a'..'z'
	|'A'..'Z'
	;
// $ANTLR src "LDAPFilter.g" 156
fragment DIGIT:  '0'..'9';
// $ANTLR src "LDAPFilter.g" 157
fragment DASH: '-';

// $ANTLR src "LDAPFilter.g" 159
DOT: '.';
// $ANTLR src "LDAPFilter.g" 160
COLON: ':';
// $ANTLR src "LDAPFilter.g" 161
UTF: '\u0080'..'\ufffe';
// $ANTLR src "LDAPFilter.g" 162
ASCII_LATIN1: '\u0000'..'\u007f';