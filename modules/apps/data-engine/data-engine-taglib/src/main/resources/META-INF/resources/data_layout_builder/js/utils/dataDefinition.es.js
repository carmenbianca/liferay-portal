/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

export const containsFieldSet = (dataDefinition, dataDefinitionId) => {
	let hasFieldSet = false;

	forEachDataDefinitionField(dataDefinition, dataDefinitionField => {
		const {customProperties, fieldType} = dataDefinitionField;

		if (
			fieldType === 'section' &&
			customProperties &&
			customProperties.dataDefinitionId == dataDefinitionId
		) {
			hasFieldSet = true;
		}

		return hasFieldSet;
	});

	return hasFieldSet;
};

export const forEachDataDefinitionField = (
	dataDefinition = {dataDefinitionFields: []},
	fn
) => {
	const {dataDefinitionFields = []} = dataDefinition;

	for (let i = 0; i < dataDefinitionFields.length; i++) {
		const field = dataDefinitionFields[i];

		if (fn(field)) {
			return true;
		}

		if (
			forEachDataDefinitionField(
				{
					dataDefinitionFields:
						field.nestedDataDefinitionFields || [],
				},
				fn
			)
		) {
			return true;
		}
	}

	return false;
};

export const getDataDefinitionField = (
	dataDefinition = {dataDefinitionFields: []},
	fieldName
) => {
	let field = null;

	forEachDataDefinitionField(dataDefinition, currentField => {
		if (currentField.name === fieldName) {
			field = currentField;

			return true;
		}

		return false;
	});

	return field;
};

export const getFieldLabel = (dataDefinition, fieldName) => {
	const field = getDataDefinitionField(dataDefinition, fieldName);

	return field ? field.label[themeDisplay.getLanguageId()] : fieldName;
};

export const getOptionLabel = (options = {}, value) => {
	return (options[themeDisplay.getLanguageId()] || []).reduce(
		(result, option) => {
			if (option.value === value) {
				return option.label;
			}

			return result;
		},
		value
	);
};
