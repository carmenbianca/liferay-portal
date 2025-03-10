/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

import classNames from 'classnames';
import FormBuilderWithLayoutProvider from 'dynamic-data-mapping-form-builder';
import {PagesVisitor} from 'dynamic-data-mapping-form-renderer';
import core from 'metal';
import React from 'react';

import {getDataDefinitionField} from '../utils/dataDefinition.es';
import EventEmitter from './EventEmitter.es';
import saveDefinitionAndLayout from './saveDefinitionAndLayout.es';

/**
 * Data Layout Builder.
 * @extends React.Component
 */
class DataLayoutBuilder extends React.Component {
	constructor(props) {
		super(props);

		this.containerRef = React.createRef();
		this.eventEmitter = new EventEmitter();
		this.state = {};
	}

	componentDidMount() {
		const {
			config,
			dataLayoutBuilderId,
			fieldTypes,
			localizable,
			portletNamespace,
		} = this.props;

		const context = this._setContext(this.props.context);

		this.formBuilderWithLayoutProvider = new FormBuilderWithLayoutProvider(
			{
				events: {
					attached: () => {
						this.props.onLoad(this);

						Liferay.component(dataLayoutBuilderId, this);
					},
				},
				formBuilderProps: {
					fieldTypes,
					portletNamespace,
					ref: 'builder',
				},
				layoutProviderProps: {
					...this.props,
					allowMultiplePages: config.allowMultiplePages,
					allowSuccessPage: config.allowSuccessPage,
					context,
					defaultLanguageId: themeDisplay.getDefaultLanguageId(),
					editingLanguageId: themeDisplay.getDefaultLanguageId(),
					initialPages: context.pages,
					ref: 'layoutProvider',
					rules: context.rules,
				},
			},
			this.containerRef.current
		);

		if (localizable) {
			this._localeChangedHandler = Liferay.after(
				'inputLocalized:localeChanged',
				this._onLocaleChange.bind(this)
			);
		}
	}

	componentWillUnmount() {
		const {dataLayoutBuilderId} = this.props;
		const {formBuilderWithLayoutProvider} = this;

		if (formBuilderWithLayoutProvider) {
			formBuilderWithLayoutProvider.dispose();
		}

		if (this._localeChangedHandler) {
			this._localeChangedHandler.detach();
		}

		Liferay.destroyComponent(dataLayoutBuilderId);
	}

	dispatch(event, payload) {
		const layoutProvider = this.getLayoutProvider();

		if (layoutProvider && layoutProvider.dispatch) {
			layoutProvider.dispatch(event, payload);
		}
	}

	dispatchAction(action) {
		const {appContext} = this.props;
		const [, dispatch] = appContext;

		if (dispatch) {
			dispatch(action);
		}
	}

	emit(event, payload, error = false) {
		this.eventEmitter.emit(event, payload, error);
	}

	getDataDefinitionAndDataLayout(pages) {
		const {
			defaultLanguageId = themeDisplay.getDefaultLanguageId(),
		} = this.props;
		const availableLanguageIds = this.state.availableLanguageIds ||
			this.props.availableLanguageIds || [
				themeDisplay.getDefaultLanguageId(),
			];
		const fieldDefinitions = [];
		const pagesVisitor = new PagesVisitor(pages);

		const newPages = pagesVisitor.mapFields((field) => {
			fieldDefinitions.push(this.getDataDefinitionField(field));

			return field.fieldName;
		}, false);

		return {
			definition: {
				availableLanguageIds,
				dataDefinitionFields: fieldDefinitions,
				defaultLanguageId,
			},
			layout: {
				dataLayoutPages: newPages.map((page) => {
					const rows = page.rows.map((row) => {
						const columns = row.columns.map((column) => {
							return {
								columnSize: column.size,
								fieldNames: column.fields,
							};
						});

						return {
							dataLayoutColumns: columns,
						};
					});

					return {
						dataLayoutRows: rows,
						description: page.localizedDescription,
						title: page.localizedTitle,
					};
				}),
				paginationMode: 'wizard',
			},
		};
	}

	getDataDefinitionField({nestedFields = [], settingsContext}) {
		const fieldConfig = {
			customProperties: {},
			nestedDataDefinitionFields: nestedFields.map((nestedField) =>
				this.getDataDefinitionField(nestedField)
			),
		};
		const settingsContextVisitor = new PagesVisitor(settingsContext.pages);

		settingsContextVisitor.mapFields(
			({dataType, fieldName, localizable, localizedValue, value}) => {
				if (fieldName === 'predefinedValue') {
					fieldName = 'defaultValue';
				}
				else if (fieldName === 'type') {
					fieldName = 'fieldType';
				}

				if (localizable) {
					if (this._isCustomProperty(fieldName)) {
						fieldConfig.customProperties[
							fieldName
						] = localizedValue;
					}
					else {
						fieldConfig[fieldName] = localizedValue;
					}
				}
				else {
					const formattedValue = this.getDataDefinitionFieldFormattedValue(
						dataType,
						value
					);

					if (this._isCustomProperty(fieldName)) {
						fieldConfig.customProperties[
							fieldName
						] = formattedValue;
					}
					else {
						fieldConfig[fieldName] = formattedValue;
					}
				}
			},
			false
		);

		return fieldConfig;
	}

	getDataDefinitionFieldFormattedValue(dataType, value) {
		if (dataType === 'json' && typeof value !== 'string') {
			return JSON.stringify(value);
		}

		return value;
	}

	getDDMForm(
		dataDefinition,
		dataLayout = this.getDefaultDataLayout(dataDefinition)
	) {
		const {editingLanguageId = themeDisplay.getLanguageId()} = this.props;

		return {
			description: dataDefinition.description[editingLanguageId],
			id: dataDefinition.id,
			localizedDescription: dataDefinition.description,
			localizedTitle: dataDefinition.name,
			pages: dataLayout.dataLayoutPages.map((dataLayoutPage) => ({
				rows: dataLayoutPage.dataLayoutRows.map((dataLayoutRow) => ({
					columns: dataLayoutRow.dataLayoutColumns.map(
						({columnSize, fieldNames}) => ({
							fields: fieldNames.map((fieldName) =>
								this.getDDMFormField(dataDefinition, fieldName)
							),
							size: columnSize,
						})
					),
				})),
			})),
			title: dataDefinition.name[editingLanguageId],
		};
	}

	getDDMFormField(dataDefinition, fieldName) {
		const dataDefinitionField = getDataDefinitionField(
			dataDefinition,
			fieldName
		);

		if (dataDefinitionField.fieldType === 'ddm-text-html') {
			dataDefinitionField.fieldType = 'rich_text';
		}

		const {editingLanguageId = themeDisplay.getLanguageId()} = this.props;
		const settingsContext = this.getDDMFormFieldSettingsContext(
			dataDefinitionField
		);

		const ddmFormField = {settingsContext};
		const visitor = new PagesVisitor(settingsContext.pages);

		visitor.mapFields((field) => {
			const {fieldName} = field;
			let {value} = field;

			if (fieldName === 'options' && value) {
				value = value[editingLanguageId];
			}
			else if (fieldName === 'name') {
				ddmFormField.fieldName = value;
			}

			ddmFormField[fieldName] = value;
		});

		return ddmFormField;
	}

	getDDMFormFieldSettingsContext(dataDefinitionField) {
		const {editingLanguageId = themeDisplay.getLanguageId()} = this.props;
		const fieldTypes = this.getFieldTypes();
		const {settingsContext} = fieldTypes.find(({name}) => {
			return name === dataDefinitionField.fieldType;
		});
		const visitor = new PagesVisitor(settingsContext.pages);

		return {
			...settingsContext,
			pages: visitor.mapFields((field) => {
				const {fieldName, localizable} = field;
				const propertyValue = this._getDataDefinitionfieldPropertyValue(
					dataDefinitionField,
					this._fromDDMFormToDataDefinitionPropertyName(fieldName)
				);

				let value = propertyValue || field.value;

				if (
					localizable &&
					propertyValue &&
					Object.prototype.hasOwnProperty.call(
						propertyValue,
						editingLanguageId
					)
				) {
					value = propertyValue[editingLanguageId];
				}

				let localizedValue = {};

				if (localizable) {
					localizedValue = {...propertyValue};
				}

				return {
					...field,
					localizedValue,
					value,
				};
			}),
		};
	}

	getDefaultDataLayout(dataDefinition) {
		const {dataDefinitionFields} = dataDefinition;

		return {
			dataLayoutPages: [
				{
					dataLayoutRows: dataDefinitionFields.map(({name}) => ({
						dataLayoutColumns: [
							{
								columnSize: 12,
								fieldNames: [name],
							},
						],
					})),
				},
			],
		};
	}

	getFieldTypes() {
		const {fieldTypes} = this.props;

		return fieldTypes;
	}

	getFormData() {
		const {pages} = this.getStore();

		return this.getDataDefinitionAndDataLayout(pages);
	}

	getLayoutProvider() {
		const {layoutProvider} = this.formBuilderWithLayoutProvider.refs;

		return layoutProvider;
	}

	getState() {
		const {appContext} = this.props;
		const [state] = appContext;

		return state;
	}

	getStore() {
		const layoutProvider = this.getLayoutProvider();

		return {
			...layoutProvider.state,
		};
	}

	on(eventName, listener) {
		this.eventEmitter.on(eventName, listener);
	}

	removeEventListener(eventName, listener) {
		this.eventEmitter.removeListener(eventName, listener);
	}

	render() {
		const {sidebarOpen = false} = this.getState();

		return (
			<div
				className={classNames('ddm-form-builder', {
					'ddm-form-builder--sidebar-open': sidebarOpen,
				})}
				ref={this.containerRef}
			></div>
		);
	}

	save(params = {}) {
		const {
			contentType,
			dataDefinitionId,
			dataLayoutId,
			groupId,
		} = this.props;
		const {
			definition: dataDefinition,
			layout: dataLayout,
		} = this.getFormData();

		return saveDefinitionAndLayout({
			contentType,
			dataDefinition,
			dataDefinitionId,
			dataLayout,
			dataLayoutId,
			groupId,
			params,
		});
	}

	serialize(pages) {
		const {definition, layout} = this.getDataDefinitionAndDataLayout(pages);

		return {
			definition: JSON.stringify(definition),
			layout: JSON.stringify(layout),
		};
	}

	_fromDataDefinitionToDDMFormPropertyName(propertyName) {
		const map = {
			defaultValue: 'predefinedValue',
			fieldType: 'type',
			name: 'fieldName',
			nestedDataDefinitionFields: 'nestedFields',
		};

		return map[propertyName] || propertyName;
	}

	_fromDDMFormToDataDefinitionPropertyName(propertyName) {
		const map = {
			fieldName: 'name',
			nestedFields: 'nestedDataDefinitionFields',
			predefinedValue: 'defaultValue',
			type: 'fieldType',
		};

		return map[propertyName] || propertyName;
	}

	_getDataDefinitionfieldPropertyValue(dataDefinitionField, propertyName) {
		const {customProperties} = dataDefinitionField;

		if (customProperties && this._isCustomProperty(propertyName)) {
			return customProperties[propertyName];
		}

		return dataDefinitionField[propertyName];
	}

	_isCustomProperty(name) {
		const fields = [
			'defaultValue',
			'fieldType',
			'indexable',
			'indexType',
			'label',
			'localizable',
			'name',
			'readOnly',
			'repeatable',
			'required',
			'showLabel',
			'tip',
		];

		return fields.indexOf(name) === -1;
	}

	_onLocaleChange(event) {
		const selectedLanguageId = event.item.getAttribute('data-value');
		let {availableLanguageIds = []} = this.props;

		availableLanguageIds = [
			...new Set([...availableLanguageIds, selectedLanguageId]),
		];

		this.setState({
			availableLanguageIds,
		});

		this.formBuilderWithLayoutProvider.props.layoutProviderProps = {
			...this.formBuilderWithLayoutProvider.props.layoutProviderProps,
			availableLanguageIds,
			editingLanguageId: selectedLanguageId,
		};
	}

	_setContext(context) {
		const {config, defaultLanguageId} = this.props;

		const emptyLocalizableValue = {
			[defaultLanguageId]: '',
		};

		const pages = context.pages || [];

		if (!pages.length) {
			context = {
				...context,
				pages: [
					{
						description: '',
						localizedDescription: emptyLocalizableValue,
						localizedTitle: emptyLocalizableValue,
						rows: [
							{
								columns: [
									{
										fields: [],
										size: 12,
									},
								],
							},
						],
						title: '',
					},
				],
				paginationMode: config.paginationMode || 'wizard',
				rules: context.rules || [],
			};
		}

		return {
			...context,
			pages: context.pages.map((page) => {
				let {
					description,
					localizedDescription,
					localizedTitle,
					title,
				} = page;

				if (!core.isString(description)) {
					description = description[defaultLanguageId];
					localizedDescription = {
						[defaultLanguageId]: description,
					};
				}

				if (!core.isString(title)) {
					title = title[defaultLanguageId];
					localizedTitle = {
						[defaultLanguageId]: title,
					};
				}

				return {
					...page,
					description,
					localizedDescription,
					localizedTitle,
					title,
				};
			}),
			rules: context.rules || [],
		};
	}
}

export default DataLayoutBuilder;
export {DataLayoutBuilder};
