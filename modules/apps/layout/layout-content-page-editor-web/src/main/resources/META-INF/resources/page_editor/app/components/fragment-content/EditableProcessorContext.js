/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import React, {useCallback, useContext, useReducer} from 'react';

import {useFromControlsId, useToControlsId} from '../CollectionItemContext';

const EditableProcessorContext = React.createContext(null);
const INITIAL_STATE = {editableClickPosition: null, editableUniqueId: null};
const SET_EDITABLE_UNIQUE_ID = 'SET_EDITABLE_UNIQUE_ID';

function reducer(state = INITIAL_STATE, action) {
	if (action.type === SET_EDITABLE_UNIQUE_ID) {
		return {
			editableClickPosition: action.editableClickPosition,
			editableUniqueId: action.editableUniqueId,
		};
	}

	return state;
}

export function EditableProcessorContextProvider({children}) {
	const store = useReducer(reducer, INITIAL_STATE);

	return (
		<EditableProcessorContext.Provider value={store}>
			{children}
		</EditableProcessorContext.Provider>
	);
}

export function useEditableProcessorClickPosition() {
	const [state] = useContext(EditableProcessorContext);

	return state.editableClickPosition;
}

export function useEditableProcessorUniqueId() {
	const [state] = useContext(EditableProcessorContext);
	const fromControlsId = useFromControlsId();

	return fromControlsId(state.editableUniqueId);
}

export function useIsProcessorEnabled() {
	const [state] = useContext(EditableProcessorContext);
	const toControlsId = useToControlsId();

	return useCallback(
		editableUniqueId =>
			state.editableUniqueId === toControlsId(editableUniqueId),
		[state.editableUniqueId, toControlsId]
	);
}

export function useSetEditableProcessorUniqueId() {
	const [, dispatch] = useContext(EditableProcessorContext);
	const toControlsId = useToControlsId();

	return useCallback(
		(editableUniqueIdOrNull, editableClickPosition = null) => {
			dispatch({
				editableClickPosition,
				editableUniqueId: toControlsId(editableUniqueIdOrNull),
				type: SET_EDITABLE_UNIQUE_ID,
			});
		},
		[dispatch, toControlsId]
	);
}
