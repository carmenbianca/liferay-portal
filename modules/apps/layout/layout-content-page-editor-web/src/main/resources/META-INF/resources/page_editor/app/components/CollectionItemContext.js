/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import React, {useCallback, useContext} from 'react';

import InfoItemService from '../services/InfoItemService';

const defaultFromControlsId = itemId => itemId;
const defaultToControlsId = controlId => controlId;

const INITIAL_STATE = {
	canElevate: null,
	collectionFields: null,
	collectionItem: null,
	fromControlsId: defaultFromControlsId,
	toControlsId: defaultToControlsId,
};

const CollectionItemContext = React.createContext(INITIAL_STATE);

const CollectionItemContextProvider = CollectionItemContext.Provider;

const useFromControlsId = () => {
	const context = useContext(CollectionItemContext);

	return context.fromControlsId || defaultFromControlsId;
};

const useCanElevate = () => {
	const context = useContext(CollectionItemContext);

	return context.canElevate;
};

const useToControlsId = () => {
	const context = useContext(CollectionItemContext);

	return context.toControlsId || defaultToControlsId;
};

const useCollectionFields = () => {
	const context = useContext(CollectionItemContext);

	return context.collectionFields;
};

const useGetFieldValue = () => {
	const context = useContext(CollectionItemContext);

	const getFromServer = useCallback(
		({classNameId, classPK, fieldId, languageId}) =>
			InfoItemService.getAssetFieldValue({
				classNameId,
				classPK,
				fieldId,
				languageId,
				onNetworkStatus: () => {},
			}).then(response => {
				const {fieldValue = ''} = response;

				return fieldValue;
			}),
		[]
	);

	const getFromCollectionItem = useCallback(
		({collectionFieldId}) =>
			context.collectionItem[collectionFieldId] !== null &&
			context.collectionItem[collectionFieldId] !== undefined
				? Promise.resolve(context.collectionItem[collectionFieldId])
				: Promise.reject(),
		[context.collectionItem]
	);

	if (context.collectionFields !== null && context.collectionItem !== null) {
		return getFromCollectionItem;
	}
	else {
		return getFromServer;
	}
};

export {
	CollectionItemContext,
	CollectionItemContextProvider,
	useCanElevate,
	useCollectionFields,
	useFromControlsId,
	useToControlsId,
	useGetFieldValue,
};
