/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {addItem, updateItem} from '../../utils/client.es';

export default ({
	dataDefinition,
	dataDefinitionId,
	dataLayout,
	dataLayoutId,
}) => {
	const normalizedDataLayout = {
		...dataLayout,
		dataLayoutPages: dataLayout.dataLayoutPages.map(dataLayoutPage => ({
			...dataLayoutPage,
			dataLayoutRows: (dataLayoutPage.dataLayoutRows || []).map(
				dataLayoutRow => ({
					...dataLayoutRow,
					dataLayoutColumns: (
						dataLayoutRow.dataLayoutColumns || []
					).map(dataLayoutColumn => ({
						...dataLayoutColumn,
						fieldNames: dataLayoutColumn.fieldNames || [],
					})),
				})
			),
			description: dataLayoutPage.description || {
				[themeDisplay.getLanguageId()]: '',
			},
			title: dataLayoutPage.title || {
				[themeDisplay.getLanguageId()]: '',
			},
		})),
	};

	const updateDefinition = () =>
		updateItem(
			`/o/data-engine/v2.0/data-definitions/${dataDefinitionId}`,
			dataDefinition
		);

	if (dataLayoutId) {
		return updateDefinition().then(() =>
			updateItem(
				`/o/data-engine/v2.0/data-layouts/${dataLayoutId}`,
				normalizedDataLayout
			)
		);
	}

	return updateDefinition().then(() =>
		addItem(
			`/o/data-engine/v2.0/data-definitions/${dataDefinitionId}/data-layouts`,
			normalizedDataLayout
		)
	);
};
