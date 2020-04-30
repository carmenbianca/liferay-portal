/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

const setAttribute = (node, attributes) => {
	attributes.map(({key, value}) => node.setAttribute(key, value));

	return node;
};

const createElement = object => {
	const {attributes, tagname} = object;

	return setAttribute(document.createElement(tagname), attributes);
};

export default createElement;
