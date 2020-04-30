/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {useCallback} from 'react';

import useIsMounted from './useIsMounted.es';

/**
 * Hook for scheduling a repeating function call with the specified
 * interval (in milliseconds).
 */
export default function useInterval() {
	const isMounted = useIsMounted();

	return useCallback(
		function schedule(fn, ms) {
			const handle = setInterval(() => {
				if (isMounted()) {
					fn();
				}
				else {
					clearInterval(handle);
				}
			}, ms);

			return () => clearInterval(handle);
		},
		[isMounted]
	);
}
