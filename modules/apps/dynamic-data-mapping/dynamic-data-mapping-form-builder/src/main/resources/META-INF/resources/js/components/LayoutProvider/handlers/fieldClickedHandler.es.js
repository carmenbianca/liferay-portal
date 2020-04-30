/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {FormSupport, PagesVisitor} from 'dynamic-data-mapping-form-renderer';

import {getParentFieldSet, localizeField} from '../../../util/fieldSupport.es';

const handleFieldClicked = (props, state, event) => {
	let {fieldName} = event;
	const {pages} = state;

	const parentFieldSet = getParentFieldSet(pages, fieldName);

	if (parentFieldSet) {
		fieldName = parentFieldSet.fieldName;
	}

	const fieldProperties = FormSupport.findFieldByFieldName(pages, fieldName);
	const {settingsContext} = fieldProperties;
	const visitor = new PagesVisitor(settingsContext.pages);

	const focusedField = {
		...fieldProperties,
		settingsContext: {
			...settingsContext,
			pages: visitor.mapFields(field => {
				const {fieldName} = field;
				const {defaultLanguageId, editingLanguageId} = props;

				if (fieldName === 'validation') {
					field = {
						...field,
						validation: {
							...field.validation,
							fieldName: fieldProperties.fieldName,
						},
					};
				}

				return localizeField(
					field,
					defaultLanguageId,
					editingLanguageId
				);
			}),
		},
	};

	return {
		focusedField,
		previousFocusedField: focusedField,
	};
};

export default handleFieldClicked;
