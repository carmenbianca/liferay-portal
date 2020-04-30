/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {useCallback} from 'react';

import useIsMounted from './useIsMounted.es';

/**
 * Hook for delaying a function call by the specified interval (in
 * milliseconds).
 */
export default function useTimeout() {
	const isMounted = useIsMounted();

	return useCallback(
		function delay(fn, ms) {
			const handle = setTimeout(() => {
				if (isMounted()) {
					fn();
				}
			}, ms);

			return () => clearTimeout(handle);
		},
		[isMounted]
	);
}
