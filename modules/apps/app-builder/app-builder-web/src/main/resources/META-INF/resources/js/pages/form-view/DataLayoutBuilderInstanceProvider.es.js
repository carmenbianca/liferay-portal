/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {DataLayoutBuilderActions} from 'data-engine-taglib';
import React, {useContext, useEffect} from 'react';

import generateDataDefinitionFieldName from '../../utils/generateDataDefinitionFieldName.es';
import DataLayoutBuilderContext from './DataLayoutBuilderInstanceContext.es';
import FormViewContext from './FormViewContext.es';
import useDeleteDefinitionField from './useDeleteDefinitionField.es';
import useDeleteDefinitionFieldModal from './useDeleteDefinitionFieldModal.es';

export default ({children, dataLayoutBuilder}) => {
	const [{dataDefinition, dataLayout}, dispatch] = useContext(
		FormViewContext
	);
	const deleteDefinitionField = useDeleteDefinitionField({dataLayoutBuilder});
	const onDeleteDefinitionField = useDeleteDefinitionFieldModal(fieldName => {
		deleteDefinitionField(fieldName);
	});

	useEffect(() => {
		const provider = dataLayoutBuilder.getLayoutProvider();

		provider.props.fieldActions = [
			{
				action: fieldName =>
					dataLayoutBuilder.dispatch('fieldDuplicated', {fieldName}),
				label: Liferay.Language.get('duplicate'),
			},
			{
				action: fieldName => {
					dispatch({
						payload: {fieldName},
						type: DataLayoutBuilderActions.DELETE_DATA_LAYOUT_FIELD,
					});

					dataLayoutBuilder.dispatch('fieldDeleted', {fieldName});
				},
				label: Liferay.Language.get('remove'),
				separator: true,
			},
			{
				action: fieldName => {
					onDeleteDefinitionField(fieldName);
				},
				label: Liferay.Language.get('delete-from-object'),
				style: 'danger',
			},
		];

		provider.props.shouldAutoGenerateName = () => false;
	}, [dataLayout, dataLayoutBuilder, dispatch, onDeleteDefinitionField]);

	useEffect(() => {
		const provider = dataLayoutBuilder.getLayoutProvider();

		provider.props.fieldNameGenerator = desiredFieldName =>
			generateDataDefinitionFieldName(dataDefinition, desiredFieldName);
	}, [dataDefinition, dataLayoutBuilder]);

	return (
		<DataLayoutBuilderContext.Provider
			value={[dataLayoutBuilder, dataLayoutBuilder.dispatch]}
		>
			{children}
		</DataLayoutBuilderContext.Provider>
	);
};
