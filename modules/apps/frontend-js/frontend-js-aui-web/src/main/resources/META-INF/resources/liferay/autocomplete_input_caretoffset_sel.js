/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

/**
 * The Autocomplete Input Caretoffset Sel Component.
 *
 * @deprecated since 7.2, unused
 * @module liferay-autocomplete-input-caretoffset-sel
 */

AUI.add(
	'liferay-autocomplete-input-caretoffset-sel',
	A => {
		var Lang = A.Lang;

		var DOC = A.config.doc;

		var AutcompleteInputCaretOffset = function() {};

		AutcompleteInputCaretOffset.prototype = {
			_getCaretOffset(node) {
				var instance = this;

				node = node || instance.get('inputNode');

				node.focus();

				var range = DOC.selection.createRange();

				var xy = node.getXY();

				return {
					x: range.boundingLeft - xy[0],
					y:
						Lang.toInt(range.boundingTop) -
						xy[1] +
						node.get('scrollTop') +
						DOC.documentElement.scrollTop,
				};
			},
		};

		A.Base.mix(Liferay.AutoCompleteTextarea, [AutcompleteInputCaretOffset]);
	},
	'',
	{
		requires: ['liferay-autocomplete-textarea'],
	}
);
