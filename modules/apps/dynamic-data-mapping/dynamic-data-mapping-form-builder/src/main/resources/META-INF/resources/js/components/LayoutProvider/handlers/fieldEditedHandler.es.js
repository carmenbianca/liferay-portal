/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {PagesVisitor} from 'dynamic-data-mapping-form-renderer/js/util/visitors.es';

import {updateRulesReferences} from '../util/rules.es';
import {
	updateField,
	updateSettingsContextProperty,
} from '../util/settingsContext.es';

export const updatePages = (props, pages, previousFieldName, newField) => {
	let parentFieldName;
	const visitor = new PagesVisitor(pages);

	const {fieldName: newFieldName} = newField;

	let newPages = visitor.mapFields(
		(field, fieldIndex, columnIndex, rowIndex, pageIndex, parentField) => {
			if (field.fieldName === previousFieldName) {
				if (parentField) {
					parentFieldName = parentField.fieldName;
				}

				return newField;
			}

			return field;
		},
		true,
		true
	);

	if (parentFieldName && previousFieldName !== newFieldName) {
		visitor.setPages(newPages);

		newPages = visitor.mapFields(
			field => {
				if (parentFieldName === field.fieldName) {
					const visitor = new PagesVisitor([{rows: field.rows}]);

					const layout = visitor.mapColumns(column => {
						return {
							...column,
							fields: column.fields.map(fieldName => {
								if (fieldName === previousFieldName) {
									return newFieldName;
								}

								return fieldName;
							}),
						};
					});

					const {rows} = layout[0];

					return {
						...field,
						rows,
						settingsContext: updateSettingsContextProperty(
							props.editingLanguageId,
							field.settingsContext,
							'rows',
							rows
						),
					};
				}

				return field;
			},
			true,
			true
		);
	}

	return newPages;
};

export const updateState = (props, state, propertyName, propertyValue) => {
	const {focusedField, pages, rules} = state;
	const {fieldName: previousFocusedFieldName} = focusedField;
	const newFocusedField = updateField(
		props,
		focusedField,
		propertyName,
		propertyValue
	);

	const newPages = updatePages(
		props,
		pages,
		previousFocusedFieldName,
		newFocusedField
	);

	return {
		focusedField: newFocusedField,
		pages: newPages,
		rules: updateRulesReferences(
			rules || [],
			focusedField,
			newFocusedField
		),
	};
};

export const handleFieldEdited = (props, state, event) => {
	const {propertyName, propertyValue} = event;
	let newState = {};

	if (propertyName !== 'name' || propertyValue !== '') {
		newState = updateState(props, state, propertyName, propertyValue);
	}

	return newState;
};

export default handleFieldEdited;
