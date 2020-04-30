/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import React, {useEffect, useReducer} from 'react';

import AppContext, {createReducer, initialState} from './AppContext.es';
import {
	UPDATE_CONFIG,
	UPDATE_DATA_DEFINITION,
	UPDATE_DATA_LAYOUT,
	UPDATE_FIELDSETS,
	UPDATE_IDS,
} from './actions.es';
import {getItem} from './utils/client.es';

export default ({
	children,
	config,
	contentType,
	dataDefinitionId,
	dataLayoutBuilder,
	dataLayoutId,
	groupId,
}) => {
	const reducer = createReducer(dataLayoutBuilder);
	const [state, dispatch] = useReducer(reducer, initialState);

	useEffect(
		() =>
			dispatch({
				payload: {
					config,
				},
				type: UPDATE_CONFIG,
			}),
		[config, dispatch]
	);

	useEffect(() => {
		dispatch({
			payload: {
				dataDefinitionId,
				dataLayoutId,
			},
			type: UPDATE_IDS,
		});
	}, [dataDefinitionId, dataLayoutId, dispatch]);

	useEffect(() => {
		if (dataLayoutId) {
			getItem(`/o/data-engine/v2.0/data-layouts/${dataLayoutId}`).then(
				dataLayout =>
					dispatch({
						payload: {dataLayout},
						type: UPDATE_DATA_LAYOUT,
					})
			);
		}
	}, [dataLayoutId, dispatch]);

	useEffect(() => {
		if (dataDefinitionId) {
			getItem(
				`/o/data-engine/v2.0/data-definitions/${dataDefinitionId}`
			).then(dataDefinition =>
				dispatch({
					payload: {dataDefinition},
					type: UPDATE_DATA_DEFINITION,
				})
			);
		}
	}, [dataDefinitionId, dispatch]);

	useEffect(() => {
		if (config.allowFieldSets && contentType) {
			const globalFieldSetsPromise = getItem(
				`/o/data-engine/v2.0/sites/${groupId}/data-definitions/by-content-type/${contentType}`
			);

			const groupFieldSetsPromise = getItem(
				`/o/data-engine/v2.0/data-definitions/by-content-type/${contentType}`
			);

			Promise.all([globalFieldSetsPromise, groupFieldSetsPromise])
				.then(
					([
						{items: globalFieldSets = []},
						{items: groupFieldSets = []},
					]) => {
						dispatch({
							payload: {
								fieldSets: [
									...globalFieldSets,
									...groupFieldSets,
								],
							},
							type: UPDATE_FIELDSETS,
						});
					}
				)
				.catch(error => {
					if (process.env.NODE_ENV === 'development') {
						console.warn(
							`AppContextProvider: promise rejected: ${error}`
						);
					}
				});
		}
	}, [config.allowFieldSets, contentType, dispatch, groupId]);

	return (
		<AppContext.Provider value={[state, dispatch]}>
			{children}
		</AppContext.Provider>
	);
};
