/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {
	PagesVisitor,
	normalizeFieldName,
} from 'dynamic-data-mapping-form-renderer';
import {findFieldByFieldName} from 'dynamic-data-mapping-form-renderer/js/components/FormRenderer/FormSupport.es';

export const generateFieldName = (pages, desiredName, currentName = null) => {
	let counter = 0;
	let fieldName = normalizeFieldName(desiredName);

	let existingField = findFieldByFieldName(pages, fieldName);

	while (existingField && existingField.fieldName !== currentName) {
		if (counter > 0) {
			fieldName = normalizeFieldName(desiredName) + counter;
		}

		existingField = findFieldByFieldName(pages, fieldName);

		counter++;
	}

	return normalizeFieldName(fieldName);
};

export const getFieldValue = (pages, fieldName) => {
	return getFieldProperty(pages, fieldName, 'value');
};

export const getFieldProperty = (pages, fieldName, propertyName) => {
	const visitor = new PagesVisitor(pages);
	let propertyValue;

	visitor.mapFields(field => {
		if (field.fieldName === fieldName) {
			propertyValue = field[propertyName];
		}
	});

	return propertyValue;
};

export const getField = (pages, fieldName) => {
	const visitor = new PagesVisitor(pages);
	let field;

	visitor.mapFields(currentField => {
		if (currentField.fieldName === fieldName) {
			field = currentField;
		}
	});

	return field;
};

export const getFieldLocalizedValue = (pages, fieldName, locale) => {
	const fieldLocalizedValue = getFieldProperty(
		pages,
		fieldName,
		'localizedValue'
	);

	return fieldLocalizedValue[locale];
};

export const updateFieldValidationProperty = (
	pages,
	fieldName,
	propertyName,
	propertyValue
) => {
	const visitor = new PagesVisitor(pages);

	return visitor.mapFields(field => {
		if (field.fieldName === 'validation' && field.value) {
			const expression = field.value.expression;

			if (
				propertyName === 'fieldName' &&
				expression &&
				expression.value
			) {
				expression.value = expression.value.replace(
					fieldName,
					propertyValue
				);
			}

			field = {
				...field,
				validation: {
					...field.validation,
					[propertyName]: propertyValue,
				},
				value: {
					...field.value,
					expression,
				},
			};
		}

		return field;
	});
};
