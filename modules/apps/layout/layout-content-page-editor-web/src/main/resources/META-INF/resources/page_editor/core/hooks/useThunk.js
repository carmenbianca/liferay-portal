/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {useIsMounted} from 'frontend-js-react-web';
import React from 'react';

const {useRef} = React;

/**
 * "Middleware" hook intended to wrap `useReducer` that enables you to dispatch
 * thunks (ie. functions that dispatch actions) as well as plain actions (ie.
 * objects).
 */
export default function useThunk([state, dispatch]) {
	const isMounted = useIsMounted();

	// Use a ref to ensure our `dispatch` is stable across renders, just
	// like the React-provided `dispatch` that we're wrapping.
	const thunkDispatch = useRef(action => {
		if (isMounted()) {
			if (typeof action === 'function') {
				return action(payload => {
					if (isMounted()) {
						dispatch(payload);
					}
				});
			}
			else {
				dispatch(action);
			}
		}
	});

	return [state, thunkDispatch.current];
}
