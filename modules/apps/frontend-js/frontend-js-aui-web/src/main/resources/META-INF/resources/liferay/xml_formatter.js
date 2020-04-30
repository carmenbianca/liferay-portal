/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

/**
 * The XML Formatter Utility
 *
 * @deprecated As of Athanasius(7.3.x), replaced by Liferay.Util.formatXML
 * @module liferay-xml-formatter
 */

AUI.add(
	'liferay-xml-formatter',
	A => {
		var Lang = A.Lang;

		var XMLFormatter = A.Component.create({
			ATTRS: {
				lineIndent: {
					validator: Lang.isString,
					value: '\r\n',
				},

				tagIndent: {
					validator: Lang.isString,
					value: '\t',
				},
			},

			EXTENDS: A.Base,

			NAME: 'liferayxmlformatter',

			prototype: {
				format(content) {
					var instance = this;

					var tagIndent = instance.get('tagIndent');

					var lineIndent = instance.get('lineIndent');

					return Liferay.Util.formatXML(content, {
						lineIndent,
						tagIndent,
					});
				},
			},
		});

		Liferay.XMLFormatter = XMLFormatter;
	},
	'',
	{
		requires: ['aui-base'],
	}
);
