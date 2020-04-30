/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {PagesVisitor} from 'dynamic-data-mapping-form-renderer';
import Form from 'dynamic-data-mapping-form-renderer/js/containers/Form/Form.es';

export const getEvents = (dispatchEvent, settingsContext) => {
	const handleFieldBlurred = ({fieldInstance, value}) => {
		if (fieldInstance && !fieldInstance.isDisposed()) {
			const {fieldName} = fieldInstance;

			dispatchEvent('fieldBlurred', {
				editingLanguageId: settingsContext.editingLanguageId,
				propertyName: fieldName,
				propertyValue: value,
			});
		}
	};

	const handleFieldEdited = ({fieldInstance, value}) => {
		if (fieldInstance && !fieldInstance.isDisposed()) {
			const {fieldName} = fieldInstance;

			dispatchEvent('fieldEdited', {
				editingLanguageId: settingsContext.editingLanguageId,
				propertyName: fieldName,
				propertyValue: value,
			});
		}
	};

	const handleFormAttached = function() {
		this.evaluate();
	};

	return {
		attached: handleFormAttached,
		fieldBlurred: handleFieldBlurred,
		fieldEdited: handleFieldEdited,
	};
};

export const getFilteredSettingsContext = ({config, settingsContext}) => {
	const unsupportedTabs = [...config.disabledTabs];

	const pages = settingsContext.pages.filter(
		page => !unsupportedTabs.includes(page.title)
	);

	const visitor = new PagesVisitor(pages);

	const unsupportedProperties = [
		...config.unimplementedProperties,
		...config.disabledProperties,
	];

	return {
		...settingsContext,
		pages: visitor.mapColumns(column => {
			return {
				...column,
				fields: column.fields
					.filter(
						({fieldName}) =>
							!unsupportedProperties.includes(fieldName)
					)
					.map(field => {
						if (field.fieldName === 'dataSourceType') {
							field = {
								...field,
								predefinedValue: '["manual"]',
								readOnly: true,
							};
						}

						return field;
					}),
			};
		}),
	};
};

export default (events, settingsContext, container) => {
	const spritemap = `${Liferay.ThemeDisplay.getPathThemeImages()}/lexicon/icons.svg`;

	return new Form(
		{
			...settingsContext,
			editable: true,
			events,
			spritemap,
		},
		container
	);
};
