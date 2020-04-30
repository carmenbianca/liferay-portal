/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

const FIELD_NAME_REGEX = /(_\w+_)ddm\$\$(.+)\$(\w+)\$(\d+)\$\$(\w+)/;

const NESTED_FIELD_NAME_REGEX = /(_\w+_)ddm\$\$(.+)\$(\w+)\$(\d+)#(.+)\$(\w+)\$(\d+)\$\$(\w+)/;

export const generateInstanceId = () =>
	Math.random()
		.toString(36)
		.substr(2, 8);

export const generateName = (name, props = {}) => {
	const parsedName = parseName(name);
	const {
		editingLanguageId = parsedName.editingLanguageId,
		fieldName = parsedName.fieldName,
		instanceId = parsedName.instanceId,
		portletNamespace = parsedName.portletNamespace,
		repeatedIndex = parsedName.repeatedIndex,
	} = props;

	return `${portletNamespace}ddm$$${fieldName}$${instanceId}$${repeatedIndex}$$${editingLanguageId}`;
};

export const generateNestedFieldName = (name, parentFieldName) => {
	const parsedName = parseNestedFieldName(name);
	const parsedParentFieldName = parseName(parentFieldName);

	const {
		fieldName,
		instanceId,
		locale,
		portletNamespace,
		repeatedIndex,
	} = parsedName;

	return [
		portletNamespace,
		'ddm$$',
		parsedParentFieldName.fieldName,
		'$',
		parsedParentFieldName.instanceId,
		'$',
		parsedParentFieldName.repeatedIndex,
		'#',
		fieldName,
		'$',
		instanceId,
		'$',
		repeatedIndex,
		'$$',
		locale,
	].join('');
};

export const getRepeatedIndex = name => {
	let parsedName;

	if (NESTED_FIELD_NAME_REGEX.test(name)) {
		parsedName = parseNestedFieldName(name);
	}
	else {
		parsedName = parseName(name);
	}

	return parsedName.repeatedIndex;
};

export const parseName = name => {
	let parsed = {};
	const result = FIELD_NAME_REGEX.exec(name);

	if (result) {
		parsed = {
			editingLanguageId: result[5],
			fieldName: result[2],
			instanceId: result[3],
			portletNamespace: result[1],
			repeatedIndex: Number(result[4]),
		};
	}

	return parsed;
};

export const parseNestedFieldName = name => {
	let parsed = {};
	const result = NESTED_FIELD_NAME_REGEX.exec(name);

	if (result) {
		parsed = {
			fieldName: result[5],
			instanceId: result[6],
			locale: result[8],
			parentFieldName: result[2],
			parentInstanceId: result[3],
			parentRepeatedIndex: Number(result[4]),
			portletNamespace: result[1],
			repeatedIndex: Number(result[7]),
		};
	}

	return parsed;
};
