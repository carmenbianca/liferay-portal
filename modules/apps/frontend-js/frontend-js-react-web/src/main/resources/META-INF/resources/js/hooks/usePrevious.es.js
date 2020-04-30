/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {useEffect, useRef} from 'react';

/**
 * Hook for comparing current and previous values (of state, props or any
 * arbitrary value).
 *
 * @see https://reactjs.org/docs/hooks-faq.html#how-to-get-the-previous-props-or-state
 */
export default function usePrevious(value) {
	const ref = useRef();

	useEffect(() => {
		ref.current = value;
	});

	return ref.current;
}
