/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {useIsMounted} from 'frontend-js-react-web';
import React from 'react';

const {useCallback, useState} = React;

/**
 * Wrapper for `useState` that does an `isMounted()` check behind the scenes
 * before triggering side-effects.
 */
export default function useStateSafe(initialValue) {
	const isMounted = useIsMounted();

	const [state, setState] = useState(initialValue);

	const setStateSafe = useCallback(
		newValue => {
			if (isMounted()) {
				setState(newValue);
			}
		},
		[isMounted]
	);

	return [state, setStateSafe];
}
